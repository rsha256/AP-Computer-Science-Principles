/*******************************************
 *                                         * 
 * Audio Processing starter code           *
 *                                         *
 * UTeach CSP                              *
 * Bradley Beth                            *
 * rev. 20160923                           * 
 *                                         *
 *******************************************/

import ddf.minim.spi.*;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;

Minim minim;
AudioPlayer song;
float[] oldSamp;
String songFileName = "BasicDrum.mp3";
final int BUFFERSIZE = 4096;

void setup()
{
  size(640,400);
  stroke(255);
  textSize(32);
    
  minim = new Minim(this);
  song = minim.loadFile(songFileName, BUFFERSIZE); 
  song.addEffect(new MyEffect());
  oldSamp = new float[song.bufferSize()];
  song.play(); 
}


void draw()
{
  /* Draw the Visualizer */
  background(0);
  fill(#000055);
  rect(0,0,640,200);
  fill(#550000);
  rect(0,200,640,200);
  fill(#BBBB00);
  text("Left Channel", 50, 50);
  text("Right Channel", 50, 250);
  for (int i = 0; i < song.bufferSize() - 1; i++)
  {
    line(i, 100 + song.left.get(i)*100, i+1, 100 +song.left.get(i+1)*100);
    line(i, 300 + song.right.get(i)*100, i+1, 300 +song.right.get(i+1)*100);
  }
}

class MyEffect implements AudioEffect
{
  void process(float[] samp)
  {
    float[] newSamp = samp.clone();  //create a copy to alter
    int j = 0; 
    while (j < newSamp.length)
    {
      newSamp[j] = samp[j];          /* HERE is where we alter each sample */
      j = j + 1;
    }
    oldSamp = samp.clone();          //save a copy of this for later
    // we have to copy the values back into samp for this to work
    arrayCopy(newSamp, samp);
  }
 
  void process(float[] left, float[] right) 
  //stereo has left and right channels
  {
    process(left);
    process(right);
  }
}
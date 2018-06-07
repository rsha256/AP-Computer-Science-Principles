/*******************************************
 *                                         * 
 * Indexing Julius Caesar                  *
 *                                         *
 * UTeach CSP                              *
 * Bradley Beth                            *
 * rev. 20161103                           * 
 *                                         *
 *******************************************/

String word = "the";
String algorithm = "A";

Timer t;
String lines[];
int click = 0;
int clickList[];

void setup() {
  size(680,750);
  smooth();
  noStroke();
  frameRate(60);
  rectMode(CENTER);
  t = new Timer();  
  textFont(createFont("Arial",16,true));
  lines = loadStrings("JuliusCaesar.txt");
  clickList = new int[268]; // There are 268 words in Julius Caesar
}

void draw() {
  background(200);
  textSize(24);
  text("Julius Caesar",20,30);
  drawClicks();
  fill(0);
  int idx = 0;
  while (idx < lines.length)
  {
    textSize(12);
    if (algorithm == "B" && wordOnLine(idx, word))
      fill(255,0,0);
    else
      fill(0,0,0);
    text((idx+1),20,(idx)*20+60);     // print the line number (idx + 1)
    textSize(16);
    text(lines[idx],40,(idx)*20+60);  // print the line at the current idx
    idx = idx + 1;
  }  
  drawTimer();
  textSize(32);
  text("Word: ",420,300);
  fill(#cc5500);
  text(word,520,300);
}

boolean wordOnLine(int lineNum, String word) { 
  String[] temp = new String[lines.length];
  int idx = 0;
  while (idx < lines.length)
  {
     temp[idx] = " "+(lines[idx].toUpperCase())+" ";
     idx = idx + 1; 
  }
  return temp[lineNum].matches(".*[^A-Z]+"+(word.toUpperCase())+"[^A-Z]+.*");
}

void drawClicks()
{
  fill(255,255,0);
  int idx = 0;
  while (idx < click)
  {
      rect(clickList[idx]%width,clickList[idx]/width,word.length()*8+4,20);  
      idx = idx + 1;
  }
  noFill();
}
void drawTimer()
{
  stroke(0);
  fill(255);
  rect(555,150,220,220);
  fill(230);
  rect(555,85,190,60);
  fill(0);
  textSize(42);
  t.update();
  text(nf(t.minutes(),2,0)+":"+nf(t.seconds(),2,0)+"."+nf(t.centiseconds(),2,0),470,100);
  textSize(16);
  text("CONTROLS:\n   'z' to start/stop\n   'x' to reset",500,160);   
  noStroke();
}

void mouseClicked() {
  clickList[click] = mouseY*width+mouseX;
  click = click + 1;
}

void keyPressed()
{
  if (key=='z')
    t.startstop();
  if (key=='x')
    t.reset();  
}

/********************** Timer ***********************/
class Timer 
{
  int timerStart;
  int offset;
  
  int ticks;
  int minutes;
  int seconds;
  int centiseconds;
  
  boolean paused;
  boolean continued;
  
  Timer() 
  {
    reset();
  }
  
  public void update() 
  {
    if (!paused) 
    {
      ticks = (millis()-timerStart);
      if (continued) ticks += offset;
  
      seconds = ticks / 1000;
      minutes = seconds / 60;
      seconds = seconds % 60;
      centiseconds = ticks / 10 % 100;
    }
  }
    
  void startstop() {
    paused = !paused;
    continued = true;
    timerStart = millis();
    offset = ticks;
  }
  
  void reset() {
    paused = false;
    continued = false;
    timerStart = millis();
  }
  
  int minutes() { return minutes; }
  int seconds() { return seconds; }
  int centiseconds() { return centiseconds; }
} 
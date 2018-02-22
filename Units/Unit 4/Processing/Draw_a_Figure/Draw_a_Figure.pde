int x1 = 10;
int xpos;
int value = #755075;

void setup()
{
  xpos = pmouseX;
size(600,300);
rectMode(CENTER);
fill(value);
rect(100+x1,100,20+x1,100);


ellipse(100+x1,70,60+x1,60);
ellipse(81+x1,70,16+x1,32); 
ellipse(119+x1,70,16+x1,32); 

line(90+x1,150,80+x1,160);
line(110+x1,150,120+x1,160);

line(100+x1, 100, 50+x1, 50);
line(165+x1, 125, 100+x1, 100);

// spear  
triangle(180+x1, 75, 160+x1, 50, 145+x1, 75);
line(160+x1, 75, 160+x1, 150);
}
int g =102;
int xoffset = 10;
void draw()
{
    if (mousePressed) {
      textSize(32);
      text("BUGBOY", xoffset, 30); 
      fill(0, g, 153);
    }
}

void mouseMoved() {
  if (pmouseX>xpos) {
    x1 = x1 + 1;
  }
  else if (pmouseX<xpos) {
      x1 = x1 - 1;
  }
  else {
  }
  clear();
  background(211, 211, 211);
  setup();
}

void keyPressed() {
if (value == #755075) {    
    value = #578949;
  } else {
    value = #755075;
  }
  if (keyPressed)
{
     if (key == CODED)
     {
       // space fun()
       if(keyCode == ' ') {
         if (g<255)
           g = g +1;
           else
             g = g-g;
       }
          if (keyCode == UP)
          {
            
fill(color(0,0,255));
rect(480+xoffset,180,20,20);
rect(480+xoffset, 200,20,20);

rect(440+xoffset, 180,20,20);
rect(420+xoffset, 180,20,20);
rect(420+xoffset, 200,20,20);
rect(440+xoffset, 200,20,20);
          }
          else if(keyCode== DOWN)
          {
            
fill(color(255,0,0));
rect(480+xoffset,180,20,20);
rect(480+xoffset, 200,20,20);

rect(440+xoffset, 180,20,20);
rect(420+xoffset, 180,20,20);
rect(420+xoffset, 200,20,20);
rect(440+xoffset, 200,20,20);
          }
          
           if (keyCode == RIGHT)
    {
      background(255, 255, 255);
        xoffset+=5;
    }
     else if (keyCode == LEFT)
    {
      background(255, 255, 255);
        xoffset-=5;
    }

     }
   if (key==' ')
{
 fill(color(0,255,0));
rect(pmouseX,180,20,20);
}
}}
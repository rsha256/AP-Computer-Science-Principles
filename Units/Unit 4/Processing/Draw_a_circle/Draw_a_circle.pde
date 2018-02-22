int x = 100;

void setup() {
  size(640, 480);
  frameRate(100);
}

void draw() {
  background(155);
  ellipse(x, 100, 50, 50);
  /** Move with mouse! **/
   ellipse(mouseX, mouseY, mouseX, mouseY);
  x = x + 1;
}
/*******************************************
 *                                         * 
 * Raster Image Starter Code               *
 *                                         *
 * UTeach CSP                              *
 * Bradley Beth                            *
 * rev. 20161123                           * 
 *                                         *
 * Extend this code to change pixels'      *
 * color values.                           *
 *******************************************/

String pathToImage = 
  "http://nifty.stanford.edu/2011/parlante-image-puzzle/west-puzzle.png"; //Change this to load a different image
PImage img;                         //Variable to store an image
float r, g, b;                      //red, green, blue floating point 
                                    //"decimal" variables
void setup()
{
  surface.setResizable(true);
  img = loadImage(pathToImage);              //load the image
  surface.setSize(img.width, img.height);    //set the window size to match the image
}


void draw()
{
  image(img, 0, 0);   //draw the image on the screen at position (0,0)
  loadPixels();       //'pixels' is now a list of all the pixels in img (in order)
                      //left to right, top to bottom

  int location = 0;                    //start at the first pixel
  while (location < pixels.length) 
  {
    // Get the R, G, B values from the image
    r = red  (pixels[location]);
    g = green(pixels[location]);
    b = blue (pixels[location]);
    if (b>16)
      b = 0;
    if (b<16)
      b=b*16;

    color newColor = color(b, 0, 0);   //create a new color
    pixels[location] = newColor;       //store the new color  
    location = location + 1;           //next pixel!
  }
  
    updatePixels();   //update the image
}
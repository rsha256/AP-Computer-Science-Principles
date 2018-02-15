/*******************************************
 *                                         * 
 * Warhol Grid Generator starter code      *
 *                                         *
 * UTeach CSP                              *
 * Bradley Beth                            *
 * rev. 20160831                           * 
 *                                         *
 *******************************************/

PImage imgOrig, imgVar1, imgVar2, imgVar3, imgVar4, imgVar5, imgVar6, imgVar7, imgVar8;

void setup()
{
  textSize(16);                   //set font size
  fill(240, 240, 120);            //set font color
  
  //Load image(s)
  imgOrig = loadImage("original.png");
  imgVar1 = imgOrig.get();
  imgVar2 = imgOrig.get();
  imgVar3 = imgOrig.get();
  imgVar4 = imgOrig.get() ;
  imgVar5 = imgOrig.get()  ;
  imgVar6 = imgOrig.get()  ;
  imgVar7 = imgOrig.get() ; 
  imgVar8 = imgOrig.get();  
   
  
  
  
  
  
  //Set window size
  size(1, 1);
  surface.setResizable(true);
  surface.setSize(imgOrig.width * 2, imgOrig.height * 2);
  
  /*************************
  Place STATIC filters here
  * ex: imgVar1.filter(...);
  *************************/
 imgVar1.filter(THRESHOLD); 
 imgVar2.filter(GRAY);
 imgVar3.filter(INVERT);
 imgVar4.filter(POSTERIZE,4);
 imgVar5.filter(BLUR,6);
 imgVar6.filter(DILATE);

 
  
  
  /************************/
  
}

void draw()
{
  /*************************
  Place DYNAMIC filters here
  *************************/
  

  
  
  /************************/
   
  //Draw original image
  image(imgOrig, 0, 0);
  text("original", imgOrig.width / 4, imgOrig.height - 10); 

  //Draw image variant 1
  image(imgVar1, imgVar1.width, 0);
  text("variant 1", 5 * imgVar1.width / 4, imgVar1.height - 10);
  

  //Draw image variant 2
  image(imgVar2, imgOrig.width+imgVar1.width,0);
  text("variant 2", 9*imgVar2.width / 4, imgVar2.height - 10);
  
  //Draw image variant 3
  image(imgVar3, 0, imgOrig.height);
  text("variant 3", imgVar3.width / 4,  (2 * imgVar3.height) - 10);
  
  //Draw image variant 4
  image(imgVar4, imgVar3.width, imgVar1.height);
  text("variant 4", 5 * imgVar4.width / 4, (2 * imgVar4.height) - 10);
  
  //Draw image variant 5
  image(imgVar5, imgVar3.width+imgVar4.width, imgVar2.height);
  text("variant 5", 9 * imgVar5.width / 4, (2 * imgVar5.height) - 10);
  
  //Draw image variant 6
  image(imgVar6, 0, imgOrig.height+imgVar3.height);
  text("variant 6",  imgVar6.width / 4, (3 * imgVar6.height) - 10);
  
  //Draw image variant 7
  image(imgVar7, imgVar6.width, imgVar1.height+imgVar4.height);
  text("variant 7", 5 * imgVar7.width / 4, (3 * imgVar7.height) - 10);
  
  //Draw image variant 8
  image(imgVar8, imgVar6.width+imgVar7.width, imgVar2.height+imgVar5.height);
  text("variant 8", 9 * imgVar8.width / 4, (3 * imgVar8.height) - 10);
  
 
  
  save("3x3.png");
}
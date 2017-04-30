package ImageOperations;
import org.ejml.simple.SimpleMatrix;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
/**
 * Created by Shreha on 4/29/2017.
 */


public class ImageUtil {

    public static SimpleMatrix getImagePixels(BufferedImage img) throws Exception{


        int width = img.getWidth();
        int height = img.getHeight();
        double[][] pixels = new double[width][height];
        double[][] topleftpixels = new double[width/8][height/4];
        double[][] toprightpixels = new double[width/8][height/4];
        double[][] bottomleftpixels = new double[width/8][height/4];
        double[][] bottomrightpixels = new double[width/8][height/4];

        for(int i = 0; i < width; i++){

            for(int j = 0; j < height; j++){

                DataBuffer dataBuffer = img.getRaster().getDataBuffer();
                int grayLevel = dataBuffer.getElem(i * img.getWidth() + j);

                pixels[i][j] = grayLevel * 1.0;
            }
        }

//        System.out.println("inside image utils");
        System.out.println("pixel value"+pixels);
   //segmentation of four sides using pixel values
        for (int i = 0; i <width/8 ; i++) {
            for (int j = 0; j <height/4 ; j++) {
                DataBuffer dataBuffer = img.getRaster().getDataBuffer();
                int grayLevel = dataBuffer.getElem(i * img.getWidth() + j);
//                System.out.println("greylevel: "+grayLevel);

                topleftpixels[i][j] = grayLevel * 1.0;
//                System.out.println("Topleft pixel array "+topleftpixels[i][j]);
            }
        }
        System.out.println("The top left pixels:");
        System.out.println(topleftpixels);

        System.out.println("For top right pixels try::");
        for (int i = width,k = 0; i > (7* width/8)+1; i--,k++) {
            for (int j = 0; j < (height/4)-1; j++) {
                DataBuffer dataBuffer = img.getRaster().getDataBuffer();
                int grayLevel = dataBuffer.getElem(i * img.getWidth() + j);

                toprightpixels[k][j] = grayLevel * 1.0;
            }
        }
        System.out.println("The top right pixels");
        System.out.println(toprightpixels);

        for(int i = 0; i < (width/8) -1 ; i++){

            for(int j = (3 * height / 4),k=0 ; j < height - 1; j++,k++){

                DataBuffer dataBuffer = img.getRaster().getDataBuffer();
                int grayLevel = dataBuffer.getElem(i * img.getWidth() + j);

                bottomleftpixels[i][k] = grayLevel * 1.0;
            }
        }
        System.out.println("The bottom left pixels");
        System.out.println(bottomleftpixels);

        for(int i = width - 1,k=0; i > width-(width/8) + 1; i--,k++){

            for(int j = height - 1,l=0; j > height-(height / 4) + 1; j--,l++){

                DataBuffer dataBuffer = img.getRaster().getDataBuffer();
                int grayLevel = dataBuffer.getElem(i * img.getWidth() + j);

                bottomrightpixels[k][l] = grayLevel * 1.0;

            }
        }
        System.out.println("The bottom right pixels");
        System.out.println(bottomrightpixels);

        //for merging the arrays
        System.out.println("Merging the arrays:");
        int row=topleftpixels.length+toprightpixels.length+bottomleftpixels.length+bottomrightpixels.length;
        int col=topleftpixels[0].length;

        double merge[][]=new double[row][col];

        int rowcount=0;
        for (int i=0;i<topleftpixels.length;i++){
            for (int j=0; j<topleftpixels[0].length;j++){
                merge[rowcount][j]=topleftpixels[i][j];
            }
            rowcount++;
        }
        for (int i=0;i<toprightpixels.length;i++){
            for (int j=0; j<toprightpixels[0].length;j++){
                merge[rowcount][j]=toprightpixels[i][j];
            }
            rowcount++;
        }

        for (int i=0;i<bottomleftpixels.length;i++){
            for (int j=0; j<bottomleftpixels[0].length;j++){
                merge[rowcount][j]=bottomleftpixels[i][j];
            }
            rowcount++;
        }


        for (int i=0;i<bottomrightpixels.length;i++){
            for (int j=0; j<bottomrightpixels[0].length;j++){
                merge[rowcount][j]=bottomrightpixels[i][j];
            }
            rowcount++;
        }

        System.out.println("Arrays merged");
        System.out.println("array count"+merge.length);
        System.out.println(merge[0].length);
        System.out.println(merge[1].length);
     /*   for (int i = 0; i <merge.length ; i++) {
            for (int j = 0; j <merge.length ; j++) {
                System.out.println(merge.length);
            }

        }*/
        return new SimpleMatrix(toprightpixels);
    }


}

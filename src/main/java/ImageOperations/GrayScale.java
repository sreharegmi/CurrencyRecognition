package ImageOperations;
import org.ejml.simple.SimpleMatrix;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Created by Shreha on 4/23/2017.
 */


public class GrayScale {

    BufferedImage  image;
    int width;
    int height;

    public GrayScale() {

        try {
            File input = new File("D:\\DEERWALK\\Seventh Semester\\Final Year Project - Currency\\CurrencyRecognition\\src\\main\\java\\ImageOperations\\Currency100.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for(int i=0; i<height; i++){

                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    Color newColor = new Color(red+green+blue,

                            red+green+blue,red+green+blue);

                    image.setRGB(j,i,newColor.getRGB());
                }
            }

            File ouptut = new File("grayscale.jpg");
            ImageIO.write(image, "jpg", ouptut);
            SimpleMatrix imagePixels = ImageUtil.getImagePixels(image);
         /*   int imagergbval = image.getRGB();*/
/*            System.out.println("top right pixel values");
            System.out.println(imagePixels);*/


        } catch (Exception e) {}

    }

    static public void main(String args[]) throws Exception
    {
        GrayScale obj = new GrayScale();
    }
}


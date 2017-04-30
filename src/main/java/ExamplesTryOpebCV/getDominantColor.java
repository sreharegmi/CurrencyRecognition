package ExamplesTryOpebCV;

import ImageOperations.GrayScale;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class getDominantColor {
    public static void main(String args[]) throws IOException {
        File file = new File("D:\\DEERWALK\\Seventh Semester\\Final Year Project - Currency\\CurrencyRecognition\\src\\main\\java\\ImageOperations\\100note.jpg");
        BufferedImage image = ImageIO.read(file);

        int x = 10;
        int y = 10;

        int clr = image.getRGB(x, y);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        System.out.println("Red Color value = " + red);
        System.out.println("Green Color value = " + green);
        System.out.println("Blue Color value = " + blue);

        GrayScale grayScale = new GrayScale();

    }

}




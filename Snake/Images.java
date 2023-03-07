package Snake;

import java.io.FileInputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Images {

    BufferedImage apple1; {
        try {
            File file = new File("images/apple1.png");
            FileInputStream fis = new FileInputStream(file);
            apple1 = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage headRight; {
        try {
            File file = new File("images/headRight.png");
            FileInputStream fis = new FileInputStream(file);
            headRight = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage headLeft; {
        try {
            File file = new File("images/headLeft.png");
            FileInputStream fis = new FileInputStream(file);
            headLeft = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage headUp; {
        try {
            File file = new File("images/headUp.png");
            FileInputStream fis = new FileInputStream(file);
            headUp = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage headDown; {
        try {
            File file = new File("images/headDown.png");
            FileInputStream fis = new FileInputStream(file);
            headDown = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage bodyHorizontal; {
        try {
            File file = new File("images/bodyHorizontal.png");
            FileInputStream fis = new FileInputStream(file);
            bodyHorizontal = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage bodyVertical; {
        try {
            File file = new File("images/bodyVertical.png");
            FileInputStream fis = new FileInputStream(file);
            bodyVertical = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage tailUp; {
        try {
            File file = new File("images/tailUp.png");
            FileInputStream fis = new FileInputStream(file);
            tailUp = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }


    BufferedImage tailDown; {
        try {
            File file = new File("images/tailDown.png");
            FileInputStream fis = new FileInputStream(file);
            tailDown = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage tailRight; {
        try {
            File file = new File("images/tailRight.png");
            FileInputStream fis = new FileInputStream(file);
            tailRight = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage tailLeft; {
        try {
            File file = new File("images/tailLeft.png");
            FileInputStream fis = new FileInputStream(file);
            tailLeft = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }


}

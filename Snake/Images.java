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

    BufferedImage pill; {
        try {
            File file = new File("images/pill.png");
            FileInputStream fis = new FileInputStream(file);
            pill = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

    BufferedImage mine; {
        try {
            File file = new File("images/mine.png");
            FileInputStream fis = new FileInputStream(file);
            mine = ImageIO.read(fis);
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

    BufferedImage gHeadRight; {
        try {
            File file = new File("images/gHeadRight.png");
            FileInputStream fis = new FileInputStream(file);
            gHeadRight = ImageIO.read(fis);
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

    BufferedImage gHeadLeft; {
        try {
            File file = new File("images/gHeadRight.png");
            FileInputStream fis = new FileInputStream(file);
            gHeadRight = ImageIO.read(fis);
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

    BufferedImage gHeadUp; {
        try {
            File file = new File("images/gHeadUp.png");
            FileInputStream fis = new FileInputStream(file);
            gHeadUp = ImageIO.read(fis);
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

    BufferedImage gHeadDown; {
        try {
            File file = new File("images/gHeadDown.png");
            FileInputStream fis = new FileInputStream(file);
            gHeadDown = ImageIO.read(fis);
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

    BufferedImage gBodyHorizontal; {
        try {
            File file = new File("images/gBodyHorizontal.png");
            FileInputStream fis = new FileInputStream(file);
            gBodyHorizontal = ImageIO.read(fis);
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

    BufferedImage gBodyVertical; {
        try {
            File file = new File("images/gBodyVertical.png");
            FileInputStream fis = new FileInputStream(file);
            gBodyVertical = ImageIO.read(fis);
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

    BufferedImage gTailUp; {
        try {
            File file = new File("images/gTailUp.png");
            FileInputStream fis = new FileInputStream(file);
            gTailUp = ImageIO.read(fis);
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

    BufferedImage gTailDown; {
        try {
            File file = new File("images/gTailDown.png");
            FileInputStream fis = new FileInputStream(file);
            gTailDown = ImageIO.read(fis);
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

    BufferedImage gTailRight; {
        try {
            File file = new File("images/gTailRight.png");
            FileInputStream fis = new FileInputStream(file);
            gTailRight = ImageIO.read(fis);
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

    BufferedImage gTailLeft; {
        try {
            File file = new File("images/gTailLeft.png");
            FileInputStream fis = new FileInputStream(file);
            gTailLeft = ImageIO.read(fis);
        }   catch(IOException e){
            System.err.println(e);
        }
    }

}

package Breakout;
import utilities.GDV5;
import java.awt.Graphics2D;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;





public class Breakout extends GDV5 {

    private Brick[][] bricks;

    public Breakout() {
        super();
        bricks = Brick.makeBricks();
    }

    public static void playSound(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("utilities/" + name);
		AudioInputStream audioStream  = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}


    public static void main(String[] args) {
        Breakout runner = new Breakout(); 
        runner.start();
    }

    public void update() { //60 frames per second

    }

    @Override
    public void draw(Graphics2D win) {
        for(Brick[] row:bricks){
            for(Brick b: row){
            b.draw(win);
            }
        }
    }
}
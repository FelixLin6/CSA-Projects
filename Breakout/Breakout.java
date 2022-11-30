package Breakout;
import utilities.GDV5;
import java.awt.Graphics2D;
import utilities.ColorPalettes;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;





public class Breakout extends GDV5 {

    private Brick[][] bricks;
    private Paddle pad = new Paddle(120, 15);
    private KeyboardInput game = new KeyboardInput(pad);
    private Ball ball = new Ball(12, 6);
    private int level = 1;


    public Breakout() {
        super();
        bricks = Brick.makeBricks(level);
    }

    public static void playSound(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("utilities/" + name);
		AudioInputStream audioStream  = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}

    
    public static void main(String[] args) {
        Brick.decodePalette(ColorPalettes.palette2);
        Breakout runner = new Breakout(); 
        runner.start();
    }

    public void update() { //60 frames per second
        game.updatePads(Breakout.KeysPressed);
        ball.update(ball.intersects(pad));
    }

    @Override
    public void draw(Graphics2D win) {
        for(Brick[] row:bricks){
            for(Brick b: row){
            b.draw(win);
            }
        }
        pad.draw(win);
        ball.draw(win);
    }
}
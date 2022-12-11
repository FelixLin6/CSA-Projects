package Breakout;
import java.awt.event.KeyEvent;


public class KeyboardInput {

    private Paddle pad;
    private Ball ball;
    private boolean telekinesis = false;

    KeyboardInput(Paddle pad, Ball ball){
        this.pad = pad;
        this.ball = ball;
    }

    public void activateTelekinesis(){
        this.telekinesis = true;
    }

    public void deactivateTelekinesis(){
        this.telekinesis = false;
    }
    
    public void updatePads(boolean[] keys) {
        if(keys[KeyEvent.VK_LEFT]){pad.left() ;}
        else if(keys[KeyEvent.VK_RIGHT]){pad.right();}
    }

    public void telekBall(boolean[] keys) {
        if(telekinesis){
            if(keys[KeyEvent.VK_W]){ball.up();}
            else if(keys[KeyEvent.VK_S]){ball.down();}
            else if(keys[KeyEvent.VK_A]){ball.left();}
            else if(keys[KeyEvent.VK_D]){ball.right();}
        }
    }
}

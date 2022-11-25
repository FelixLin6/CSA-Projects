package Breakout;
import java.awt.event.KeyEvent;


public class KeyboardInput {

    private Paddle pad;


    KeyboardInput(Paddle pad){
        this.pad = pad;
    }

    public void updatePads(boolean[] keys) {
        if(keys[KeyEvent.VK_LEFT]){pad.left() ;}
        else if(keys[KeyEvent.VK_RIGHT]){pad.right();}
    }
}

package Pong;
import java.awt.event.KeyEvent;


public class KeyboardInput {

    Paddle pad1;
    Paddle pad2;
    KeyEvent e;

    KeyboardInput(Paddle pad1, Paddle pad2){
        this.pad1 = pad1;
        this.pad2 = pad2;
    }

    public void updatePads(boolean[] keys) {
        if(keys[KeyEvent.VK_W]){pad1.up() ;}
        else if(keys[KeyEvent.VK_S]){pad1.down();}
        else if(keys[KeyEvent.VK_UP]){pad2.up();}
        else if(keys[KeyEvent.VK_DOWN]){pad2.down();}
    }
}

package Snake;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Snake{
    ArrayList<Tile> body;
    Game game;
    Images images;

    public Snake(Game game, Images images){
        this.game = game;
        this.images = images;
        body = new ArrayList<Tile>();
        int x = 300;
        int y = 400;
        int row = 20;
        int col = 15;
        for(int i = 0; i < 5; i++){
            body.add(new Tile(x, y, Color.green, row, col));
            x += body.get(0).getDimension();
            col++;
        }
        Board.board[row][16].setDirection(2);
        Board.board[row][17].setDirection(2);
        Board.board[row][18].setDirection(2);
        Board.board[row][19].setDirection(2);
        
    }

    public void action(){
        Tile head = body.get(0);
        for(int i = 1; i < body.size(); i++){
            if(head.intersects(body.get(i))){
                Game.lost();
            }
        } 
        if(Board.board[head.getRow()][head.getCol()].isApple()){
            Scoreboard.update();
            addBody();
            Game.upLevel();
            Board.newApple(head.getRow(), head.getCol());
        }
    }

    public void headSetDirection(){
        Tile head = body.get(0);
        int row = head.getRow();
        int col = head.getCol();
        if(Game.KeysPressed[KeyEvent.VK_UP]){
            if(head.getDirection()!=3){
                head.setDirection(1);
            }
        }
        if(Game.KeysPressed[KeyEvent.VK_DOWN]){
            if(head.getDirection()!=1){
                head.setDirection(3);
            }
        }
        if(Game.KeysPressed[KeyEvent.VK_RIGHT]){
            if(head.getDirection()!=2){
                head.setDirection(0);
            } 
        }
        if(Game.KeysPressed[KeyEvent.VK_LEFT]){
            if(head.getDirection()!=0){
                head.setDirection(2); 
            } 
        }
        Board.board[row][col].setDirection(head.getDirection());
    }

    public void bodyGetDirection(){
       int row;
       int col;
       for(int i = 1; i < body.size(); i ++){
        row = body.get(i).getRow();
        col = body.get(i).getCol();
        body.get(i).setDirection(Board.board[row][col].getDirection());
       } 
    }

    public void addBody(){
        Tile tail = body.get(body.size()-1);
        int direction = tail.getDirection();
        int row = tail.getRow();
        int col = tail.getCol();
        Color color = tail.getColor();
        int x = (int)tail.getX();
        int y = (int)tail.getY();
        if(direction == 2){
            col++;
            x+=(int)tail.getWidth();
            body.add(new Tile(x,y,color,row,col));
        }
        if(direction == 0){
            col--;
            x-=(int)tail.getWidth();
            body.add(new Tile(x,y,color,row,col));
        }
        if(direction == 1){
            row++;
            y+=(int)tail.getHeight();
            body.add(new Tile(x,y,color,row,col));
        }
        if(direction == 3){
            row--;
            y-=(int)tail.getHeight();
            body.add(new Tile(x,y,color,row,col));
        }
    }
    public void draw(Graphics2D pb){
        for(int i = 0; i < body.size(); i++){
            Tile p = body.get(i);
            int width = 60, height = 60;
            if(i==0){
                if(p.getDirection()==0){
                    pb.drawImage(images.headRight, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                else if(p.getDirection()==1){
                    pb.drawImage(images.headUp, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                else if(p.getDirection()==2){
                    pb.drawImage(images.headLeft, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                else if(p.getDirection()==3){
                    pb.drawImage(images.headDown, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                
            }
            else if(i==body.size()-1){
                if(p.getDirection()==0){
                    pb.drawImage(images.tailRight, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                else if(p.getDirection()==1){
                    pb.drawImage(images.tailUp, (int)p.getX()-(width/2-10), (int)p.getY()-(width/2-10), width, height, game);
                }
                else if(p.getDirection()==2){
                    pb.drawImage(images.tailLeft, (int)p.getX()-(width/2-10), (int)p.getY()-(width/2-10), width, height, game);
                }
                else if(p.getDirection()==3){
                    pb.drawImage(images.tailDown, (int)p.getX()-(width/2-10), (int)p.getY()-(width/2-10), width, height, game);
                }
            }
            else{
                if(p.getDirection()==0){
                    pb.drawImage(images.bodyVertical, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                else if(p.getDirection()==1){
                    pb.drawImage(images.bodyHorizontal, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                else if(p.getDirection()==2){
                    pb.drawImage(images.bodyVertical, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
                else if(p.getDirection()==3){
                    pb.drawImage(images.bodyHorizontal, (int)p.getX()-(width/2-10), (int)p.getY()-(height/2-10), width, height, game);
                }
            }
        }
    }

    public void move(){
        for(Tile t: body){
            t.move();
        }
    }
}
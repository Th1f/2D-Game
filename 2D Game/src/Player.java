import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;
public class Player extends Entity {
    Panel panel;
    KeyInputHandler keyH;

    public Player(Panel p, KeyInputHandler key){
        panel =p;
        keyH = key;
        setDefaultValues();
        getImage();
    }

    public void setDefaultValues(){
        x =100;
        y = 100;
        speed = 4; 
    }

    public void getImage(){
        try{
            up = ImageIO.read(getClass().getResourceAsStream("/PlayerAssets/up.gif"));
        } catch(IOException e){
            System.out.println("bruh");
        }
        try{
            down = ImageIO.read(getClass().getResourceAsStream("/PlayerAssets/down.gif"));
        } catch(IOException e){
            System.out.println("bruh");
        }
        try{
            left = ImageIO.read(getClass().getResourceAsStream("/PlayerAssets/left.gif"));
        } catch(IOException e){
            System.out.println("bruh");
        }
        try{
            right = ImageIO.read(getClass().getResourceAsStream("/PlayerAssets/right.gif"));
        } catch(IOException e){
            System.out.println("bruh");
        }
    }

    public void update(){
        if(keyH.up){
            y -= speed;
        }
        if(keyH.down){
            y += speed;
        }
        if(keyH.left){
            x -= speed;
        }
        if(keyH.right){
            x += speed;
        }
    }

    public void paint(Graphics2D g){
        BufferedImage image = down;
        if(keyH.up){
            image = up;
            g.drawImage(image,x,y,panel.tileSize,panel.tileSize,null);
            return;
        }
        if(keyH.down){
            image = down;
            g.drawImage(image,x,y,panel.tileSize,panel.tileSize,null);
            return;
        }
        if(keyH.left){
            image = left;
            g.drawImage(image,x,y,panel.tileSize,panel.tileSize,null);
            return;
        }
        if(keyH.right){
            image = right;
            g.drawImage(image,x,y,panel.tileSize,panel.tileSize,null);
            return;
        }
        g.drawImage(image,x,y,panel.tileSize,panel.tileSize,null);
    }
}

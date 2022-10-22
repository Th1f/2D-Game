import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class TileManager {
    Panel panel;
    Tiles[] tiles;

    public TileManager(Panel p){
        this.panel = p;
        tiles =  new Tiles[10];
    }

    public void getTileImage(){
        try {
            tiles[0] =  new Tiles();
            tiles[0].img = ImageIO.read(getClass().getResourceAsStream("\\PlayerAssets\\Grass.png"));
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public void paint(Graphics2D g){
        g.drawImage(tiles[0].img,0,0,panel.tileSize,panel.tileSize,null);
    }
}

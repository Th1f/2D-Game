import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Panel extends JPanel implements Runnable {
    final int orgTileSize=16;
    final int size =3;

    public final int tileSize = orgTileSize*size;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    final int screenWidth = tileSize*maxScreenCol;//768 Pixel
    final int screenHeight = tileSize*maxScreenRow;//576 Pixel

    final int fps =60;


    KeyInputHandler keyH = new KeyInputHandler();
    Thread gameClock;
    Player player =  new Player(this, keyH);

    public Panel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameClock = new Thread(this);
        gameClock.start();
    }

    @Override
    public void run() {

        double interval = 1000000000/fps;
        double nextDraw = System.nanoTime() + interval;

        while(gameClock != null){
            update();
            repaint();
            try{
                double timeRemain = nextDraw - System.nanoTime();
                timeRemain = timeRemain/1000000;
                if(timeRemain < 0){
                    timeRemain = 0;
                }
                Thread.sleep((long)timeRemain);
                nextDraw += interval;
            }catch(Exception e){

            }
        }
        
    }

    public void update(){
        player.update();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        player.paint(g2);
        g2.dispose();
    }
}

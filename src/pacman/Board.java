
package pacman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener, Level{ 
    int blocksize_w;
    int blocksize_h;
    final int nblocks = 15;
    int scrsize_w;
    int scrsize_h;
    short[] screen;
    Color wall;
    Color dot;
    boolean running;
      


    
    public Board(){
        addKeyListener(new TAdapter());
        screen = new short[nblocks * nblocks];
     
        wall=new Color(100, 0,0);
        dot=new Color(0,0,100);
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        running = false;
    
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        update_block();
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0,this.getWidth(),this.getHeight());
        
        DrawWalls(g2d);
        if(running){
            System.out.println("run");}
        else{
        FirstScreen(g2d);}
        Toolkit.getDefaultToolkit().sync();
        //System.out.println(scrsize_w);
        System.out.println(scrsize_h);
        //PlayGame(g2d);
    }
public void update_block(){
    blocksize_w=this.getWidth()/15;
    blocksize_h=this.getHeight()/15;
    scrsize_w= nblocks * blocksize_w;
    scrsize_h= nblocks * blocksize_h;
    
}
public void FirstScreen(Graphics2D g2d) {

        String s = "Press ENTER to start.";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (this.getWidth() - metr.stringWidth(s)) / 2,this.getHeight()  / 2);
    }
public void Init(){
    LoadMap();

}
public void LoadMap() {
        int i;
        for (i = 0; i < nblocks * nblocks; i++)
            screen[i] = leveldata[i];
        
    }
public void DrawWalls(Graphics2D g2d) {
        short i = 0;
        int x, y;

        for (y = 0; y < scrsize_h; y += blocksize_h) {
            for (x = 0; x < scrsize_w; x += blocksize_w) {
                g2d.setColor(wall);
                g2d.setStroke(new BasicStroke(2));

                if ((screen[i] & 1) != 0) // draws left
                {
                    g2d.drawLine(x, y, x, y + blocksize_h - 1);
                }
                if ((screen[i] & 2) != 0) // draws top
                {
                    g2d.drawLine(x, y, x + blocksize_w - 1, y);
                }
                if ((screen[i] & 4) != 0) // draws right
                {
                    g2d.drawLine(x + blocksize_w - 1, y, x + blocksize_w - 1,
                                 y + blocksize_h - 1);
                }
                if ((screen[i] & 8) != 0) // draws bottom
                {
                    g2d.drawLine(x, y + blocksize_h - 1, x + blocksize_w - 1,
                                 y + blocksize_h - 1);
                }
                if ((screen[i] & 16) != 0) // draws point
                {
                    g2d.setColor(dot);
                    g2d.fillRect(x + 11, y + 11, 2, 2);
                }
                i++;
            }
        }
    }

class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

          int key = e.getKeyCode();
if (running)
          {
            if (key == KeyEvent.VK_LEFT)
            {
             
            }
            else if (key == KeyEvent.VK_RIGHT)
            {
            
            }
            else if (key == KeyEvent.VK_UP)
            {
              
            }
            else if (key == KeyEvent.VK_DOWN)
            {
              
            }
            else if (key == KeyEvent.VK_ESCAPE)
            {
              running=false;
            }
            else if (key == KeyEvent.VK_PAUSE) {
             
            }
          }
          else
          {
            if (key == KeyEvent.VK_ENTER)
          {
              running=true;             
              Init();
              repaint();
            }
          }
      }
@Override
          public void keyReleased(KeyEvent e) {
              
              int key = e.getKeyCode();

              if (key == Event.LEFT || key == Event.RIGHT || 
                 key == Event.UP ||  key == Event.DOWN)
              {
                
              }
          }
}
@Override
    public void actionPerformed(ActionEvent e) {
        repaint();  
  
    }

}
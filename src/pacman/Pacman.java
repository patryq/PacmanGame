package pacman;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pacman.Board;


public class Pacman extends JFrame
{
  JPanel panel;
  public Pacman()
  {
        initComponents();
        panel = new Board();
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height; 
        this.setSize(screen_width,screen_height);       
        this.setLocation(screen_width/3, screen_height/3); 
        panel.setSize(this.getSize().width,this.getSize().height); 
        this.getContentPane().add(BorderLayout.CENTER,panel);  
  
    setTitle("..::Pacman::..");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(600, 600);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
      new Pacman();
  }

private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        this.addComponentListener(new ComponentAdapter() {
            @Override
        public void componentResized(ComponentEvent e) {
    
              int width= e.getComponent().getSize().width;
              int height = e.getComponent().getSize().height;
                   panel.setSize(width, height);
                   
                   
    }
        });
}
}

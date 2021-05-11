package _03_polymorphs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolymorphWindow extends JPanel implements ActionListener{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    
    private JFrame window;
    private Timer timer;
    
    Polymorph bluePoly;
    Polymorph redPoly;
    Polymorph movingPoly;
    
    ArrayList<Polymorph> p = new ArrayList<Polymorph>();
   
    
    
    public static void main(String[] args) {
   	 new PolymorphWindow().buildWindow();
    }
    
    public void buildWindow(){
   	 window = new JFrame("IT'S MORPHIN' TIME!");
   	 window.add(this);
   	 window.getContentPane().setPreferredSize(new Dimension(500, 500));
   	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 window.pack();
   	 window.setVisible(true);
   	 
   	 bluePoly = new BluePolymorph(100, 100);
   	 redPoly = new RedMorph(50, 50);
   	 movingPoly = new MovingMorph(150,100);
   	 
   	 p.add(bluePoly);
   	 p.add(redPoly);
   	 p.add(movingPoly);
   	 
   	 timer = new Timer(1000 / 30, this);
   	 timer.start();
    }
    
    public void paintComponent(Graphics g){
    //draw background
   	 g.setColor(Color.LIGHT_GRAY);
   	 g.fillRect(0, 0, 500, 500);
   	
   	 //draw polymorph
   	// bluePoly.draw(g);
   	// redPoly.draw(g);
   	// movingPoly.draw(g);
   	 for(int i = 0; i<p.size(); i++){
   		 p.get(i).draw(g);
   	 }
   	 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   	 repaint();
//   	 bluePoly.update();
//   	 redPoly.update();
//   	 movingPoly.update();
   	for(int i = 0; i<p.size(); i++){
  		 p.get(i).update();
  	 }
   	 
    }
}

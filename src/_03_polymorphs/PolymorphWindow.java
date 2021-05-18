package _03_polymorphs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    Polymorph circlePoly;
    Polymorph mousePoly;
    Polymorph imagePoly;
    Polymorph messagePoly;
    
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
   	 circlePoly = new CircleMorph(100, 400);
   	 mousePoly = new MouseMorph(250,250);
   	 imagePoly = new ImageMorph(400, 200);
   	 messagePoly = new MessageMorph(400,400);
   	 window.addMouseMotionListener((MouseMotionListener) mousePoly);
   	 window.addMouseListener((MouseListener) messagePoly);
   	 
   	 p.add(bluePoly);
   	 p.add(redPoly);
   	 p.add(movingPoly);
   	 p.add(circlePoly);
   	 p.add(mousePoly);
   	 p.add(imagePoly);
   	 p.add(messagePoly);
   	 
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

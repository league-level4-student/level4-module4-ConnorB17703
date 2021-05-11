package _03_polymorphs;

import java.awt.Graphics;

public abstract class Polymorph {
   private int x;
   private int y;
   
   private int height = 50;
   private int width = 50;
    
    Polymorph(int x, int y){
   	 this.x = x;
   	 this.y = y;
    }
    
    public void update(){
   	 
    }
    
    public abstract void draw(Graphics g);
    
    public int getX(){
		return x;
	}

    public void setX(int n){
    	x = n;
    }
    
    
    public int getY(){
    	return y;
    }
    
    public void setY(int n){
    	y = n;
    }
    
    
    public int getHeight(){
    	return height;
    }
    
    public void setHeight(int h){
    	height = h;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public void setWidth(int w){
    	width = w;
    }
}

	


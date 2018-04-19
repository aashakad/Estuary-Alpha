import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	Tile[][] tilemap = new Tile[columns][rows];
	Player p;
	final static int frameWidth = 700;
    final static int frameHeight = 700;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;
    final int drawDelay = 60; //msec
    static int rows = 21;
    static int columns = 24;
    
	public int getWidth(){
		return frameWidth;
	}
	public int getHeight(){
		return frameHeight;
	}
	public int getImageWidth(){
		return imgWidth;
	}
	public int getImageHeight(){
		return imgHeight;
	}
	public View() {
		add(drawPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.gray);
    	setSize(frameWidth, frameHeight);
    	setVisible(true);
    	pack();
    	for (int i = 0; i < columns; i++) {
    		for (int j = 20; j < rows; j++) {
    			tilemap[i][j] = Tile.GROUND;
    		}
    	}
    	
	}
	public void update(){
		repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private class DrawPanel extends JPanel {
    	
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.gray);
			g.setColor(Color.gray);
			for (int i = 0; i < columns ; i ++) {
				for (int j = 0; j < rows; j++) {
					if (tilemap[i][j] != null) {
						BufferedImage temp = tilemap[i][j].getImage();
						int xloc = i * temp.getWidth();
						int yloc = j * temp.getHeight();
						g.drawImage(temp, xloc, yloc, Color.gray, this);
					}
				}
			}
	    	
		}
		public Dimension getPreferredSize() {
			return new Dimension(frameWidth, frameHeight);
		}
		
}

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	TileMap layout;
	Player p;
	final static int frameWidth = 700;
    final static int frameHeight = 700;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;
    final int drawDelay = 60; //msec
    static int rows = 21;
    static int columns = 22;
    Image background;
    
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
    	
    	// this initializes the tile map's 2d array with tiles
    	layout = new TileMap("house");
    	
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
			//This draws background image
			try {
				background = ImageIO.read(new File("objects/house_background_0.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(background, 0, 0, null);
			setBackground(Color.gray);
			g.setColor(Color.gray);
			
			//this draws the tile map
			for (int i = 0; i < columns ; i++) {
				for (int j = 0; j < rows; j++) {
					Tile[][] newTileMap = layout.getTilemap();
					if (newTileMap[i][j] != null) {
						BufferedImage temp = newTileMap[i][j].getImage();
						int xloc = i * temp.getWidth();
						int yloc = j * temp.getHeight();
						g.drawImage(temp, xloc, yloc, Color.gray, this);
					}
				}
			}
	    	
		}
		//Sets Window Size 
		public Dimension getPreferredSize() {
			return new Dimension(frameWidth, frameHeight);
		}
		
}

}

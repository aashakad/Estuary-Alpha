import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame {
	Player p = new Player();
	final static int frameWidth = 700;
    final static int frameHeight = 700;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    final int drawDelay = 30; //msec
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;
    Direction d = Direction.EAST;
    int scrollX = 0; //scrolls the background as the character moves
    int xloc = 0;
    int yloc = 700;

    TileMap layout;
    static int rows = 21;
    static int columns = 22;
    Image background;
    Image tallgrass_100;
    Image shortgrass_100;
    Image lawnmower_txt;
    
    public View() {
    	setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		p = new Player();
		
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			drawPanel.repaint();
    			try {
    				Thread.sleep(50);
    			} catch (InterruptedException ie) {
    				ie.printStackTrace();
    			}
    		}
    	};
    
    	add(drawPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.gray);
    	setSize(frameWidth, frameHeight);
    	setVisible(true);
    	pack();
    	layout = new TileMap("house");
    }
    
    private class DrawPanel extends JPanel {
    	
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//This draws background image
			try {
				background = ImageIO.read(new File("images/objects/house_background_0.png"));
				tallgrass_100 = ImageIO.read(new File("images/objects/tall_grass_100.png"));
				shortgrass_100 = ImageIO.read(new File("images/objects/short_grass_100.png"));
				lawnmower_txt = ImageIO.read(new File("images/objects/lawnmower_txt.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.drawImage(background, 0, 0, null);
			for(int i = 0; i <= 150; i+= 30) {
			g.drawImage(tallgrass_100, i, 610, null);
			}
			for(int i = 0; i <= 150; i+= 30) {
				g.drawImage(shortgrass_100, i, 610, null);
			}
			if(p.getStopped()) {
				g.drawImage(lawnmower_txt, 100, 400, null);
			}
			setBackground(Color.gray);
			g.setColor(Color.gray);
			
			//this draws the tile map
			for (int i = 0; i < columns ; i ++) {
				for (int j = 0; j < rows; j++) {
					Tile[][] tilemap = layout.getTilemap();
					if (tilemap[i][j] != null) {
						BufferedImage temp = tilemap[i][j].getImage();
						int xloc = i * temp.getWidth();
						int yloc = j * temp.getHeight();
						g.drawImage(temp, xloc, yloc, Color.gray, this);
					}
				}
			}
			g.drawImage(p.getImage(), p.getXloc(), p.getYloc(), null);
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameWidth, frameHeight);
		}
	}
    
    public void update(int xloc, int yloc, Direction d, boolean move){
		//this.scrollX = scrollX;
    	p.setXloc(xloc);
    	p.setYloc(yloc);
		p.setDirect(d);
		p.setMove(move);
		
		repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
    
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
	public int getdrawDelay(){
		return drawDelay;
	}
	public Action getdrawAction(){
		return drawAction;
	}
}

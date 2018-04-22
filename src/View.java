import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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
    Player character = new Player();
    long startTime;
    
    TileMap layout;
    static int rows = 21;
    static int columns = 22;
    BufferedImage background;
    BufferedImage lawnmower_txt;
    BufferedImage shortgrass_100;
    BufferedImage tallgrass_100;
    boolean grassCut = false;
    boolean mowerEquip = false;
    BufferedImage lawnMower;
    
    public View() {
    	setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		startTime = System.currentTimeMillis();
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
				background = ImageIO.read(new File("images/objects/house_background_100.png"));
				lawnmower_txt = ImageIO.read(new File("images/objects/lawnmower_txt.png"));
				shortgrass_100 = ImageIO.read(new File("images/objects/short_grass_100.png"));
				tallgrass_100 = ImageIO.read(new File("images/objects/tall_grass_100.png"));
				lawnMower = ImageIO.read(new File("images/objects/lawnmower.png"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.drawImage(background, 0, 0, null);
			String time = "TIME LEFT:  " + (60 - (System.currentTimeMillis()-startTime)/1000) + " s";
			Image img = createImageWithText(time);
			
			g.drawImage(img, 200, 10, null);
			for(int i = 0; i <= 150; i+= 30) {
				g.drawImage(shortgrass_100, i, 610, null);
				}
				
			// removes grass when lawnmower runs over it
				if (p.mow == true && p.getXloc() <= 150 && p.getYloc() == 500) {
					grassCut = true;
					}
				
				else if (!grassCut){
					for (int i = 0; i <= 150; i+=30) {
						g.drawImage(tallgrass_100, i, 610, null);
					}
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
			
			// draws the lawnmower
			if (!mowerEquip)
			{
				g.drawImage(lawnMower, 400, 610, null);
			}
			
			// draws player
			g.drawImage(p.getImage(), p.getXloc(), p.getYloc(), null);
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameWidth, frameHeight);
		}
	}
    
    private static BufferedImage createImageWithText(String s){
    	BufferedImage b = new BufferedImage(215, 30, BufferedImage.TYPE_INT_RGB);
    	Graphics g = b.getGraphics();
    	g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
    	g.drawString(s, 2, 25);
    	return b;
    }
    
    public void update(int xloc, int yloc, Direction d, boolean move, boolean mow){
		//this.scrollX = scrollX;
    	System.out.println("");
    	
    	if(p.getStopped() && d == Direction.WEST) {
    		p.setXloc(125);
    		}
    	
    	else {
    		p.setXloc(xloc);
    	}
    	
    	p.setYloc(yloc);
		p.setDirect(d);
		p.setAction(move, mow);
    	
    	if (mow)
    	{
    		mowerEquip = true;
    	}
    	
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

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
    Player character = new Player();
    int scrollX = 0; //scrolls the background as the character moves
    Tile[][] tilemap = new Tile[columns][rows];
    static int rows = 21;
    static int columns = 24;
    Image background;
    Item i= new Item();
    //BufferedImage bkgrndImg = background image
    //BufferedImage grassImgNormal = normal grass image without any interaction done with it yet
    //BufferedImage grassImgUnhealthy = unhealthy grass if player chooses wrong action
    //BufferedImage grassImgHealthy = healthy grass if player chooses the right action, has grass clippings
    
    public View() {
    	setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		p = new Player();
		i = new Item();
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
    	for (int i = 0; i < columns; i++) {
    		for (int j = 20; j < rows; j++) {
    			tilemap[i][j] = Tile.GROUND;
    		}
    	}
    }
    
    private class DrawPanel extends JPanel {
    	
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//This draws background image
			try {
				background = ImageIO.read(new File("images/objects/house_background_0.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.drawImage(background, 0, 0, null);
			setBackground(Color.gray);
			g.setColor(Color.gray);
			
			//this draws the tile map
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
			if(p.getInteract()==false){
			g.drawImage(p.getImage(), p.getXloc(), p.getYloc(), null);
			g.drawImage(i.getImage(), i.getXloc(), i.getYloc(), null);
			}
			else{
				g.drawImage(p.getImage(), p.getXloc(), p.getYloc(), null);
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameWidth, frameHeight);
		}
	}
    
    public void update(int xloc, int yloc, Direction d, boolean move, boolean interact){
		//this.scrollX = scrollX;
    	p.setXloc(xloc);
    	p.setYloc(yloc);
		p.setDirect(d);
		p.setMove(move);
		p.setInteract(interact);
		
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
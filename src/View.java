import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
    int scrollX = 0; //scrolls the background as the character moves
    
    //BufferedImage bkgrndImg = background image
    //BufferedImage grassImgNormal = normal grass image without any interaction done with it yet
    //BufferedImage grassImgUnhealthy = unhealthy grass if player chooses wrong action
    //BufferedImage grassImgHealthy = healthy grass if player chooses the right action, has grass clippings
    
    public View() {
    	//setFocusable(true);
		//setFocusTraversalKeysEnabled(false);
		
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
    	
    	// objects as buttons?
    	
    }
    
    private class DrawPanel extends JPanel {
    	
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.gray);
			g.setColor(Color.gray);
			
			g.drawImage(null, scrollX, 0, Color.gray, this);
			
			p.paint(g);
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameWidth, frameHeight);
		}
	}
    
    public void update(int scrollX, Direction d){
		this.scrollX = scrollX;
		this.d = d;
		
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

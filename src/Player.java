import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Player {
	BufferedImage[] pics;
	BufferedImage img;
	int frameCount = 10;
	int picNum = 0;
	int xloc;
	int yloc;
	int imgSize = 165;
	int imgWidth;
	int imgHeight;
	Direction d = Direction.EAST;
	Objects players;
	boolean move;
	boolean mow;
	
	String[] adrr = new String[] {
			"images/characters/sonny_stand_east.png", "images/characters/sonny_stand_west.png",
			"images/characters/sonny_run_east.png", "images/characters/sonny_run_west.png", 
			"images/characters/sonny_mow_east.png", "images/characters/sonny_mow_west.png",
			"images/characters/sunny_stand_east.png", "images/characters/sunny_stand_west.png",
			"images/characters/sunny_run_east.png", "images/characters/sunny_run_west.png",
			"images/characters/sunny_mow_east.png", "images/characters/sunny_mow_west.png"};
	ArrayList<BufferedImage[]> playerImages = new ArrayList<BufferedImage[]>();

	public Player() {
		
		for (int i = 0; i < adrr.length; i++) {
			img = createImage(new File(adrr[i]));
			frameCount = img.getWidth() / imgSize;
			imgWidth = img.getWidth();
			imgHeight = img.getHeight();
			pics = new BufferedImage[10];
			for (int j = 0; j < frameCount; j++) {
				pics[j] = img.getSubimage(imgSize * j, 0, imgSize, imgSize);
			}
			playerImages.add(pics);
		}
	}

	private BufferedImage createImage(File f) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(f);
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getXloc() {
		return xloc;
	}

	public int getYloc() {
		return yloc;
	}
	
	public void setXloc(int x) {
		xloc = x;
	}
	
	public void setYloc(int y) {
		yloc = y;
	}

	public ArrayList<BufferedImage[]> getPlayerImages() {
		return playerImages;
	}
	
	public void setDirect(Direction d) {
		this.d = d;
	}
	
	public void setAction(boolean move, boolean mow) {
		this.move = move;
		this.mow = mow;
	}
	
	public boolean getStopped() {
		if(!mow) {
			if(xloc <= 150) {
				return true;
			}
			else {
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public boolean closeToMower() {
		
		System.out.println("players xloc: " + xloc);
		System.out.println("players yloc: " + yloc);
		//if (!mow) {
			if (xloc >= 330 && xloc <= 360)
			{
				System.out.println("Player is close to mower");
				return true;
			}
		//}
		return false;
	}

	
	public BufferedImage getImage() {
		int i = 0;
		
		if (move && !mow) {
			frameCount = 4;
			i = 2;
		}
		else if (mow) {
			frameCount = 1;
			i = 4;
		}
		else
		{
			frameCount = 1;
			i = 0;
		}
		
		pics = playerImages.get(d.getPosition() + i);
		picNum = (picNum + 1) % frameCount;
	
		return pics[picNum];
	}
	
/*
	public Rectangle getBounds() {
		return new Rectangle(xloc, yloc, imgWidth, imgHeight);
	}
*/
	
	
}
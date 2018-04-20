import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Player extends JFrame {
	BufferedImage[] pics;
	BufferedImage img;
	int frameCount = 10;
	int picNum = 0;
	int xloc = 100;
	int yloc = 500;
	int imgSize = 165;
	Direction d = Direction.EAST;
	Objects players;
	boolean move;
	
	String[] adrr = new String[] {"images/characters/sonny_stand_east.png", "images/characters/sonny_stand_west.png",
			"images/characters/sonny_run_east.png", "images/characters/sonny_run_west.png",
			"images/characters/sunny_stand_east.png", "images/characters/sunny_stand_west.png",
			"images/characters/sunny_run_east.png", "images/characters/sunny_run_west.png"};
	ArrayList<BufferedImage[]> playerImages = new ArrayList<BufferedImage[]>();

	public Player() {
		
		move = false;
		
		
		for (int i = 0; i < adrr.length; i++) {
			img = createImage(new File(adrr[i]));
			frameCount = img.getWidth() / imgSize;
			pics = new BufferedImage[10];
			for (int j = 0; j < frameCount; j++) {
				pics[j] = img.getSubimage(imgSize * j, 0, imgSize, imgSize);
			}
			playerImages.add(pics);
		}
		
		setVisible(true);
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
	
	public void setMove(boolean move) {
		this.move = move;
	}
	
	public BufferedImage getImage() {
		
		if (move)
		{
			frameCount = 4;
			 
			pics = playerImages.get(d.getPosition());
		}
		else
		{
			frameCount = 1;
			pics = playerImages.get(d.getPosition() - 2);
		}
		
		picNum = (picNum + 1) % frameCount;
		
		
		return pics[picNum];
	}
}

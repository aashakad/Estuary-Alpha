import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Player extends JFrame {
	BufferedImage[] pics;
	BufferedImage img;
	int frameCount = 10;
	int picNum = 0;
	int xloc;
	int yloc;
	int imgSize = 512;
	Direction d = Direction.EAST;
	Objects players;
	String[] adrr = new String[] {"images/characters/sonny_stand_east.png", "images/characters/sonny_stand_west.png",
			"images/characters/sonny_run_east.png", "images/characters/sonny_run_west.png",
			"images/characters/sunny_stand_east.png", "images/characters/sunny_stand_west.png",
"images/characters/sunny_run_east.png", "images/characters/sunny_run_west.png"};
	ArrayList<BufferedImage[]> playerImages = new ArrayList<BufferedImage[]>();

	public Player() {
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
	
	public void updatePlayer(int x, int y, Direction d) {
		xloc = x;
		yloc = y;
		this.d = d;
		repaint();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void drawPlayer(Graphics g) {
		pics = playerImages.get(d.getPosition());
		
		// frameCount = 
		picNum = (picNum + 1) % frameCount;
		g.drawImage(pics[picNum], xloc, yloc, null);
	}

	public int getXloc() {
		return xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public ArrayList<BufferedImage[]> getPlayerImages() {
		return playerImages;
	}

}

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Player {
	BufferedImage[] pics;
	BufferedImage img;
	int frameCount = 10;
	int picNum = 0;
	int xloc;
	int yloc;
	int imgSize = 512;
	
	String[] adrr = new String[] {"characters/sonny_stand_east", "characters/sonny_stand_west",
									"characters/sonny_run_east", "characters/sonny_run_west",
									"characters/sonny_jump_east", "characters/sonny_jump_west",
									"characters/sunny_stand_east", "characters/sunny_stand_west",
									"characters/sunny_run_east", "characters/sunny_run_west",
									"characters/sunny_jump_east", "characters/sunny_jump_west"};
	ArrayList<BufferedImage[]> playerImages = new ArrayList<BufferedImage[]>();
	
	public Player(){
		for (int i = 0; i < adrr.length; i++) {
    		img = createImage(new File(adrr[i]));
    		frameCount = img.getWidth()/imgSize;
    		pics = new BufferedImage[10];
        	for(int j = 0; j < frameCount; j++)
        	{
        		pics[j] = img.getSubimage(imgSize*j, 0, imgSize, imgSize);
        	}
        	playerImages.add(pics);
    	}
	}
	private BufferedImage createImage(File f){
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
	public ArrayList<BufferedImage[]> getPlayerImages() {
		return playerImages;
	}
	
	
}

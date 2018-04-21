import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Door {
	
	// doors should have an image file, a tile map, and a background image. Once the player interacts with the door,
	// the view should load in the new tile map and background image. 
	Tile door = Tile.DOOR;
	BufferedImage background;
	TileMap layout;
	
	public Door(BufferedImage newBackground, TileMap newLayout) {
		background = newBackground;
		layout = newLayout;
		
	}
	
	 private static BufferedImage createImage(File f){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(f);
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

}

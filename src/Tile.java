import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Tile {
	//Tiles have a 32*32 image alongside a solid variable, true if the tile cannot be 
	//walked through, false if the player can walk through it
	
	
	GROUND(createImage(new File("images/tiles/groundtile.png")), true),
	;
	
	private BufferedImage image;
	private boolean solid;
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	private Tile(BufferedImage newImage, boolean newsolid) {
		image = newImage;
		solid = newsolid;
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

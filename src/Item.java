import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Item extends Object {
	BufferedImage[] pics;
	BufferedImage img;
	BufferedImage lawnmower;
	boolean interact=false;
	int frameCount = 10;
	int picNum = 0;
	int xloc=300;
	int yloc=500;;
	int imgSize = 1500;
	Objects items;
	Objects[] adrr = new Objects[] {items.house_background_0,items.house_background_100,items.house_background_25,
			                      items.house_background_50,items.house_background_75,items.menu,
			                      items.rsz_1tall_grass_100,items.rsz_lawnmower,items.rsz_short_grass_0,
			                      items.rsz_short_grass_100,items.rsz_short_grass_50,items.rsz_tall_grass_0,items.rsz_tall_grass_50
			                        };
	
	
	ArrayList<BufferedImage[]> itemImages = new ArrayList<BufferedImage[]>();

	public Item() {
		interact=false;
		/*for (int i = 0; i < 13; i++) {
			img = createImage(new File(adrr[i].getAddr()));
			frameCount = img.getWidth() / imgSize;
			pics = new BufferedImage[10];
			for (int j = 0; j < frameCount; j++) {
				pics[j] = img.getSubimage(imgSize * j, 0, imgSize, imgSize);
			}
			itemImages.add(pics);}*/
		
		lawnmower=createImage(new File(adrr[7].getAddr()));
		
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

	public ArrayList<BufferedImage[]> getItemImages() {
		return itemImages;
	}
	public BufferedImage getImage() {
		//how does the getImage work?
	//can I get the image simply by its name? Or I have to load all the images into the hashset and then fetch the image from the hashSet
		/*if (d == Direction.EAST)
			xloc = xloc+8;
		else
			xloc = xloc-8;*/
		if(!interact)
		return lawnmower;
		else
			return null;
	}
}

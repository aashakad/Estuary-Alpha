import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Item extends Object {
	BufferedImage[] pics;
	BufferedImage img;
	int frameCount = 10;
	int picNum = 0;
	int xloc;
	int yloc;
	int imgSize = 512;
	Objects items;
	String[] adrr = new String[] {items.house_background_0.getAddr(),items.house_background_100.getAddr(),items.house_background_25.getAddr(),
			                      items.house_background_50.getAddr(),items.house_background_75.getAddr(),items.menu.getAddr(),items.rsz_1tall_grass_100.getAddr(),items.rsz_lawnmower.getAddr(),
			                      items.rsz_short_grass_0.getAddr(),items.rsz_short_grass_100.getAddr(),items.rsz_short_grass_50.getAddr(),
			                      items.rsz_tall_grass_0.getAddr(),items.rsz_tall_grass_50.getAddr()};
	ArrayList<BufferedImage[]> itemImages = new ArrayList<BufferedImage[]>();

	public Item() {
		for (int i = 0; i < 16; i++) {
			img = createImage(new File(adrr[i]));
			frameCount = img.getWidth() / imgSize;
			pics = new BufferedImage[10];
			for (int j = 0; j < frameCount; j++) {
				pics[j] = img.getSubimage(imgSize * j, 0, imgSize, imgSize);
			}
			itemImages.add(pics);
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

	public ArrayList<BufferedImage[]> getPlayerImages() {
		return itemImages;
	}

}

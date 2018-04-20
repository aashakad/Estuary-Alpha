
public class Model {
	Direction d = Direction.EAST;
	int xloc=300;
	int yloc=500;
	int xIncr = 20;
    int yIncr = 20;
    int frameWidth = 700;
    int frameHeight = 700;
    int imgWidth = 165;
    int imgHeight = 165;
    Player p = new Player();
	
	public Model(int fWidth, int fHeight, int iWidth, int iHeight) {
		frameWidth = fWidth;
		frameHeight = fHeight;
		imgWidth = iWidth;
		imgHeight = iHeight;
	}
	
	public void updateLocationAndDirection() {
		
		
		switch(d) {
		case EAST:
			xloc+=xIncr;
			//p.setXloc(xloc);
			break;
			
		case WEST:
			xloc-=xIncr; 
			//p.setYloc(yloc);
			break;
		}
	}

	public int getX() {
		return xloc;
	}

	public int getY() {
		return yloc;
	}
	
	public Direction getDirect(){
		return d;
	}
	
	public void setDirect(Direction d){
		this.d = d;
	}
}
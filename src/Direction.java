

public enum Direction {

	EAST("east", 0),
	WEST("west", 1);
	
	private String name = null;
	private int position;
	
	private Direction(String s, int i){
		name = s;
		position = i;
	}
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}


}

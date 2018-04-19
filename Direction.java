public enum Direction {

	NORTH("north", 2 ),
	NORTHEAST("northeast", 7),
	EAST("east", 1),
	SOUTHEAST("southeast", 6),
	SOUTH("south", 3),
	SOUTHWEST("southwest", 5),
	WEST("west", 0 ),
	NORTHWEST("northwest", 4);
	
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
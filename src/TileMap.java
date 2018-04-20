
public class TileMap {
	// class which builds a 2d array of tiles based on a string passed in. 
	Tile[][] tilemap; 
	
	public TileMap(String layout) {
		switch(layout) {
		case "ground": tilemap = new Tile[View.columns][View.rows];
		for (int i = 0; i < View.columns; i++) {
    		for (int j = 20; j < View.rows; j++) {
    			tilemap[i][j] = Tile.GROUND;
    		}
    	};
    	break;
    	
		case "emptytest": tilemap = new Tile[][] {
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
			};
			break;
		case "house": tilemap = new Tile[][] {
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.DOOR, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null, Tile.GROUND,},
			{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null, Tile.GROUND,}
			};
			break;
    	
    	default: tilemap = new Tile[View.columns][View.rows];
    	break;
    	
		}
			
	}

	public Tile[][] getTilemap() {
		return tilemap;
	}

}

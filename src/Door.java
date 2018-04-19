
public enum Door {
	
	EMPTY(new Tile[View.columns][View.rows]);
	
	Tile[][] tilegrid;
	
	private Door(Tile[][] newTileGrid) {
		tilegrid = newTileGrid;
	}

	public Tile[][] getTilegrid() {
		return tilegrid;
	}

	public void setTilegrid(Tile[][] tilegrid) {
		this.tilegrid = tilegrid;
	}
	
	
	
	
	

}

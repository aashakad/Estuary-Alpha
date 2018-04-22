
public enum Objects {
	
	house_background_0("images/objects/house_background_0.png",true),
	house_background_100("images/objects/house_background_100.png",true),
	house_background_25("images/objects/house_background_25.png",true),
	house_background_50("images/objects/house_background_50.png",true),
	house_background_75("images/objects/house_background_75.png",true),
	menu("images/objects/menu.png",true),
	rsz_1tall_grass_100("images/objects/rsz_1tall_grass_100.png",true),
	rsz_lawnmower("images/objects/rsz_lawnmower.png",true),
	rsz_short_grass_0("images/objects/rsz_short_grass_0.png",true),
	rsz_short_grass_100("images/objects/rsz_short_grass_100.png",true),
	rsz_short_grass_50("images/objects/rsz_short_grass_50.png",true),
	rsz_tall_grass_0("images/objects/rsz_tall_grass_0.png",true),
	rsz_tall_grass_50("images/objects/rsz_short_grass_50.png",true),
	rsz_sonny_jump_east("images/characters/rsz_sonny_jump_east.png",true),
	rsz_sonny_jump_west("images/characters/rsz_sonny_jump_west.png",true),
	rsz_sonny_mow_east("images/characters/rsz_sonny_mow_east.png",true),
	rsz_sonny_mow_west("images/characters/rsz_sonny_mow_west.png",true),
	rsz_sonny_run_east("images/characters/rsz_sonny_run_east.png",true),
	rsz_sonny_run_west("images/characters/rsz_sonny_run_west.png",true),
	rsz_sonny_stand_east("images/characters/rsz_sonny_stand_east.png",true),
	rsz_sonny_stand_west("images/characters/rsz_sonny_stand_west.png",true),
	rsz_sunny_jump_east("images/characters/rsz_sunny_jump_east.png",true),
	rsz_sunny_jump_west("images/characters/rsz_sunny_jump_west.png",true),
	rsz_sunny_mow_east("images/characters/rsz_sunny_mow_east.png",true),
	rsz_sunny_mow_west("images/characters/rsz_sunny_mow_west.png",true),
	rsz_sunny_run_east("images/characters/rsz_sunny_run_east.png",true),
	rsz_sunny_run_west("images/characters/rsz_sunny_run_west.png",true),
	rsz_sunny_stand_east("images/characters/rsz_sunny_stand_east.png",true),
	rsz_sunny_stand_west("images/characters/rsz_sunny_stand_west.png",true),
	;
	private String addr;
	private boolean interactAbility;
	private Objects(String addr, boolean interactAbility){
		this.addr=addr;
		this.interactAbility=interactAbility;
	}
	public String getAddr(){
		return this.addr;
	}
	public boolean getInteractAbility(){
		return this.interactAbility;
	}
}

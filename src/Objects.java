
public enum Objects {
	
	house_background_0("objects/house_background_0.png",true),
	house_background_100("objects/house_background_100.png",true),
	house_background_25("objects/house_background_25.png",true),
	house_background_50("objects/house_background_50.png",true),
	house_background_75("objects/house_background_75.png",true),
	menu("objects/menu.png",true),
	rsz_1tall_grass_100("objects/rsz_1tall_grass_100.png",true),
	rsz_lawnmower("objects/rsz_lawnmower.png",true),
	rsz_short_grass_0("objects/rsz_short_grass_0.png",true),
	rsz_short_grass_100("objects/rsz_short_grass_100.png",true),
	rsz_short_grass_50("objects/rsz_short_grass_50.png",true),
	rsz_tall_grass_0("objects/rsz_tall_grass_0.png",true),
	rsz_tall_grass_50("objects/rsz_short_grass_50.png",true),
	rsz_sonny_jump_east("characters/rsz_sonny_jump_east.png",true),
	rsz_sonny_jump_west("characters/rsz_sonny_jump_west.png",true),
	rsz_sonny_mow_east("characters/rsz_sonny_mow_east.png",true),
	rsz_sonny_mow_west("characters/rsz_sonny_mow_west.png",true),
	rsz_sonny_run_east("characters/rsz_sonny_run_east.png",true),
	rsz_sonny_run_west("characters/rsz_sonny_run_west.png",true),
	rsz_sonny_stand_east("characters/rsz_sonny_stand_east.png",true),
	rsz_sonny_stand_west("characters/rsz_sonny_stand_west.png",true),
	rsz_sunny_jump_east("characters/rsz_sunny_jump_east.png",true),
	rsz_sunny_jump_west("characters/rsz_sunny_jump_west.png",true),
	rsz_sunny_mow_east("characters/rsz_sunny_mow_east.png",true),
	rsz_sunny_mow_west("characters/rsz_sunny_mow_west.png",true),
	rsz_sunny_run_east("characters/rsz_sunny_run_east.png",true),
	rsz_sunny_run_west("characters/rsz_sunny_run_west.png",true),
	rsz_sunny_stand_east("characters/rsz_sunny_stand_east.png",true),
	rsz_sunny_stand_west("characters/rsz_sunny_stand_west.png",true),
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

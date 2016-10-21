package se.kungsbacka.basket.entities;

public class Player {
	
	private String name;
	private int jerseyNumber;
	private int freeThrowAttempt;
	private int freeThrowMade;
	private int twoPointAttempt;
	private int twoPointMade;
	private int threePointAttempt;
	private int threePointMade;
	private int defRebounds;
	private int offRebounds;
	private int steals;
	private int assists;
	private int fouls;
	private int blocks;
	private int deflections;
	private int turnovers;
	
	public Player() {}
	
	public Player(String name, int jerseyNumber) {
		setName(name);
		setJerseyNumber(jerseyNumber);
	}
	public Player(String name, int jerseyNumber, int freeThrowAttempt, int freeThrowMade, int twoPointAttempt, int twoPointMade, int threePointAttempt, 
			int threePointMade, int defRebounds, int offRebounds, int steals, int assists, int fouls, int blocks, int deflections, int turnovers) {
		setName(name);
		setJerseyNumber(jerseyNumber);
		setFreeThrowAttempt(freeThrowAttempt);
		setFreeThrowMade(freeThrowMade);
		setTwoPointAttempt(twoPointAttempt);
		setTwoPointMade(twoPointMade);
		setThreePointAttempt(threePointAttempt);
		setThreePointMade(threePointMade);
		setDefRebounds(defRebounds);
		setOffRebounds(offRebounds);
		setSteals(steals);
		setAssists(assists);
		setFouls(fouls);
		setBlocks(blocks);
		setDeflections(deflections);
		setTurnovers(turnovers);
	}

	//Add statistics
	public void addFreeThrowAttempt(){freeThrowAttempt++;}
	public void addFreeThrowMade(){freeThrowMade++;}
	public void addTwoPointerAttempt(){twoPointAttempt++;}
	public void addTwoPointerMade(){twoPointMade++;}
	public void addThreePointerAttempt(){threePointAttempt++;}
	public void addThreePointerMade(){threePointMade++;}
	public void addOffRebound(){offRebounds++;}
	public void addDefRebound(){defRebounds++;}
	public void addSteal(){steals++;}
	public void addAssist(){assists++;}
	public void addFoul(){fouls++;}
	public void addBlock(){blocks++;}
	public void addDeflection(){deflections++;}
	public void addTurnover(){turnovers++;}
	
	//Getters & setters
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getJerseyNumber() {return jerseyNumber;}
	public void setJerseyNumber(int jerseyNumber) {this.jerseyNumber = jerseyNumber;}
	public int getFreeThrowAttempt() {return freeThrowAttempt;}
	public void setFreeThrowAttempt(int freeThrowAttempt) {this.freeThrowAttempt = freeThrowAttempt;}
	public int getFreeThrowMade() {return freeThrowMade;}
	public void setFreeThrowMade(int freeThrowMade) {this.freeThrowMade = freeThrowMade;}
	public int getTwoPointAttempt() {return twoPointAttempt;}
	public void setTwoPointAttempt(int twoPointAttempt) {this.twoPointAttempt = twoPointAttempt;}
	public int getTwoPointMade() {return twoPointMade;}
	public void setTwoPointMade(int twoPointMade) {this.twoPointMade = twoPointMade;}
	public int getThreePointAttempt() {return threePointAttempt;}
	public void setThreePointAttempt(int threePointAttempt) {this.threePointAttempt = threePointAttempt;}
	public int getThreePointMade() {return threePointMade;}
	public void setThreePointMade(int threePointMade) {this.threePointMade = threePointMade;}
	public int getOffRebounds() {return offRebounds;}
	public void setOffRebounds(int offRebounds) {this.offRebounds = offRebounds;}
	public int getDefRebounds() {return defRebounds;}
	public void setDefRebounds(int defRebounds) {this.defRebounds = defRebounds;}
	public int getTotalRebounds() {return defRebounds + offRebounds;}
	public int getSteals() {return steals;}
	public void setSteals(int steals) {this.steals = steals;}
	public int getAssists() {return assists;}
	public void setAssists(int assists) {this.assists = assists;}
	public int getFouls() {return fouls;}
	public void setFouls(int fouls) {this.fouls = fouls;}
	public int getBlocks() {return blocks;}
	public void setBlocks(int blocks) {this.blocks = blocks;}
	public int getDeflections() {return deflections;}
	public void setDeflections(int deflections) {this.deflections = deflections;}
	public int getTurnovers() {return turnovers;}
	public void setTurnovers(int turnovers) {this.turnovers = turnovers;}
	
	@Override
	public String toString(){
		return getJerseyNumber() +
				" - " + getName();
	}
}
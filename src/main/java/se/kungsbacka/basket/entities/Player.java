package se.kungsbacka.basket.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
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
	private List<Game> games;
	
	public Player() {games = new ArrayList<Game>();}
	
	public Player(String name) {
		setName(name);
		games = new ArrayList<Game>();
	}
	public Player(String name, int freeThrowAttempt, int freeThrowMade, int twoPointAttempt, int twoPointMade, int threePointAttempt, 
			int threePointMade, int defRebounds, int offRebounds, int steals, int assists, int fouls, int blocks, int deflections, int turnovers) {
		setName(name);
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
		games = new ArrayList<Game>();
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
	public int getTotalShotsAttempt(){return twoPointAttempt + threePointAttempt;}
	public int getTotalShotsMade(){return twoPointMade + threePointMade;}
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
	public List<Game> getGames() {return games;}
	public void setGames(List<Game> games) {this.games = games;}
	
	@Override
	public String toString(){
		return getName();
	}
	
	public Player getPlayerAverage(){
		
		if(games.size() == 0){
			return null;
		}else if(games.size() == 1){
			return this;
		}
		
		Player player = new Player(getName());
		
		for (Game game : games) {
			Player player2 = game.getPlayer(getName());
			player.setFreeThrowAttempt(player.getFreeThrowAttempt() + player2.getFreeThrowAttempt());
			player.setFreeThrowMade(player.getFreeThrowMade() + player2.getFreeThrowMade());
			player.setTwoPointAttempt(player.getTwoPointAttempt() + player2.getTwoPointAttempt());
			player.setTwoPointMade(player.getTwoPointMade() + player2.getTwoPointMade());
			player.setThreePointAttempt(player.getThreePointAttempt() + player2.getThreePointAttempt());
			player.setThreePointMade(player.getThreePointMade() + player2.getThreePointMade());
			player.setDefRebounds(player.getDefRebounds() + player2.getDefRebounds());
			player.setOffRebounds(player.getOffRebounds() + player2.getOffRebounds());
			player.setSteals(player.getSteals() + player2.getSteals());
			player.setAssists(getAssists() + player2.getAssists());
			player.setFouls(player.getFouls() + player2.getFouls());
			player.setBlocks(player.getBlocks() + player2.getBlocks());
			player.setDeflections(player.getDeflections() + player2.getDeflections());
			player.setTurnovers(player.getTurnovers() + player2.getTurnovers());
		}
		player.setFreeThrowAttempt(player.getFreeThrowAttempt() / games.size());
		player.setFreeThrowMade(player.getFreeThrowMade() / games.size());
		player.setTwoPointAttempt(player.getTwoPointAttempt() / games.size());
		player.setTwoPointMade(player.getTwoPointMade() / games.size());
		player.setThreePointAttempt(player.getThreePointAttempt() / games.size());
		player.setThreePointMade(player.getThreePointMade() / games.size());
		player.setDefRebounds(player.getDefRebounds() / games.size());
		player.setOffRebounds(player.getOffRebounds() / games.size());
		player.setSteals(player.getSteals() / games.size());
		player.setAssists(getAssists() / games.size());
		player.setFouls(player.getFouls() / games.size());
		player.setBlocks(player.getBlocks() / games.size());
		player.setDeflections(player.getDeflections() / games.size());
		player.setTurnovers(player.getTurnovers() / games.size());
		
		return player;
	}
}
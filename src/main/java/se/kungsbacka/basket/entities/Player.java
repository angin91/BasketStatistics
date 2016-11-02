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
	
	public double getFreethrowProcent() {
		if(getFreeThrowAttempt() == 0 && getFreeThrowMade() == 0){
			return 0.0;
		}
		double d = (double) getFreeThrowMade() / getFreeThrowAttempt();
		return round(d*100, 1);
	}

	public double getTwoPointProcent() {
		if(getTwoPointAttempt() == 0 && getTwoPointMade() == 0){
			return 0.0;
		}
		double d = (double) getTwoPointMade() / getTwoPointAttempt();
		return round(d*100, 1);
	}
	
	public double getThreePointProcent() {
		if(getThreePointAttempt() == 0 && getThreePointMade() == 0){
			return 0.0;
		}
		double d = (double) getThreePointMade() / getThreePointAttempt();
		return round(d*100, 1);
	}
	
	public double getTotalShotProcent() {
		if(getTotalShotsAttempt() == 0 && getTotalShotsMade() == 0){
			return 0.0;
		}
		double d = (double) getTotalShotsMade() / getTotalShotsAttempt();
		return round(d*100, 1);
	}

	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	public int getTotalPoints() {
		int i = (getTwoPointMade() * 2) + (getThreePointMade() * 3) + getFreeThrowMade();
		return i;
	}
}
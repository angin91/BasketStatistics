package se.kungsbacka.basket.entities;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	private String homeTeam;
	private String awayTeam;
	
	public Game() {
		players = new ArrayList<Player>();
	}
	
	public Game(ArrayList<Player> players) {
		setPlayers(players);
	}

	public void addPlayer(Player player){players.add(player);}
	
	//Getters & setters
	public ArrayList<Player> getPlayers() {return players;}
	public void setPlayers(ArrayList<Player> players) {this.players = players;}
	public String getAwayTeam() {return awayTeam;}
	public void setAwayTeam(String awayTeam) {this.awayTeam = awayTeam;}
	public String getHomeTeam() {return homeTeam;}
	public void setHomeTeam(String homeTeam) {this.homeTeam = homeTeam;}

	@Override
	public String toString(){
		String toString = "Home Team: " + homeTeam + "\n" + "Away Team: " + awayTeam;
		for(Player player: players){
			toString += "\n\n" + player.toString();
		}
		return toString;
	}
}
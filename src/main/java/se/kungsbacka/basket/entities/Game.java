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
	public Player getPlayer(String name){
		ArrayList<Player> players2 = getPlayers();
		for (Player player : players2) {
			if(player.getName().equals(name)){
				return player;
			}
		}
		return null;
	}

	@Override
	public String toString(){
		return homeTeam + " vs " + awayTeam;
	}
}
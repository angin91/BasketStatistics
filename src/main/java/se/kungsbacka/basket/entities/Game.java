package se.kungsbacka.basket.entities;

import java.util.ArrayList;
import java.util.Date;

import se.kungsbacka.basket.helper.HelperClass;

public class Game {

	private ArrayList<Player> players;
	private String homeTeam;
	private String awayTeam;
	private Date date;

	public Game() {
		players = new ArrayList<Player>();
	}

	public Game(ArrayList<Player> players) {
		setPlayers(players);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	// Getters & setters
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public void setTeams(String teams) {
		int indexOf = teams.indexOf('-');
		setHomeTeam(teams.substring(0, indexOf).trim());
		setAwayTeam(teams.substring(indexOf + 1).trim());
	}

	public Player getPlayer(String name) {
		ArrayList<Player> players2 = getPlayers();
		for (Player player : players2) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return homeTeam + " vs " + awayTeam;
	}

	public Object[] getTotalGameStatistics() {
		Object[] total = null;
		int fouls = 0;
		int twoPointAttempt = 0;
		int twoPointMade = 0;
		int threePointAttempt = 0;
		int threePointMade = 0;
		int freeThrowAttempt = 0;
		int freeThrowMade = 0;
		int totalShotsAttempt = 0;
		int totalShotsMade = 0;
		int defRebounds = 0;
		int offRebounds = 0;
		int steals = 0;
		int blocks = 0;
		int turnovers = 0;
		int assists = 0;
		int deflections = 0;
		for (Player player : getPlayers()) {
			twoPointAttempt += player.getTwoPointAttempt();
			twoPointMade += player.getTwoPointMade();
			threePointAttempt += player.getThreePointAttempt();
			threePointMade += player.getThreePointMade();
			totalShotsAttempt += player.getTotalShotsAttempt();
			totalShotsMade += player.getTotalShotsMade();
			freeThrowAttempt += player.getFreeThrowAttempt();
			freeThrowMade += player.getFreeThrowMade();
			defRebounds += player.getDefRebounds();
			offRebounds += player.getOffRebounds();
			steals += player.getSteals();
			blocks += player.getBlocks();
			turnovers += player.getTurnovers();
			assists += player.getAssists();
			deflections += player.getDeflections();
		}
		total = new Object[] { "Total", fouls, 
				twoPointAttempt, twoPointMade, HelperClass.getTwoPointProcent(twoPointAttempt, twoPointMade),
				threePointAttempt, threePointMade, HelperClass.getThreePointProcent(threePointAttempt, threePointMade),
				totalShotsAttempt, totalShotsMade, HelperClass.getTotalShotProcent(totalShotsAttempt, totalShotsMade),
				freeThrowAttempt, freeThrowMade, HelperClass.getFreethrowProcent(freeThrowAttempt, freeThrowMade),
				HelperClass.getTotalPoints(twoPointMade, threePointMade, freeThrowMade),
				defRebounds, offRebounds, defRebounds + offRebounds,
				steals, blocks, turnovers, assists, deflections};
		return total;
	}
}
package se.kungsbacka.basket.imports;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;

public class ReadExcelTest {

	ReadExcel readExcel;
	Game game;
	List<Game> games;
	
	public void init(){
		readExcel = new ReadExcel();
		games = new ArrayList<Game>();
		games = readExcel.readExcel("files/test.xlsx", games);
	}
	
	@Test
	public void testIfGameIsReturnedCorrectly() {
		init();
//		games = readExcel.readExcel("files/test.xlsx", games);
		game = games.get(0);
		Assert.assertEquals(game.getHomeTeam(), "Kungsbacka");
		Assert.assertEquals(game.getAwayTeam(), "Trollhättan");
		Assert.assertEquals(game.getPlayers().size(), 2);
	}
	
	@Test
	public void testIfPlayersAreInformationIsCorrect(){
		init();
		game = games.get(0);
		Player player = game.getPlayers().get(1);
		Assert.assertEquals(player.getName(), "John Sundemo");
		Assert.assertEquals(player.getJerseyNumber(), 12);
		Assert.assertEquals(player.getTwoPointAttempt(), 1);
		Assert.assertEquals(player.getTwoPointMade(), 2);
		Assert.assertEquals(player.getThreePointAttempt(), 3);
		Assert.assertEquals(player.getThreePointMade(), 4);
		Assert.assertEquals(player.getFreeThrowAttempt(), 5);
		Assert.assertEquals(player.getFreeThrowMade(), 6);
		Assert.assertEquals(player.getDefRebounds(), 7);
		Assert.assertEquals(player.getOffRebounds(), 8);
		Assert.assertEquals(player.getSteals(), 9);
		Assert.assertEquals(player.getAssists(), 10);
		Assert.assertEquals(player.getFouls(), 11);
		Assert.assertEquals(player.getBlocks(), 12);
		Assert.assertEquals(player.getDeflections(), 13);
		Assert.assertEquals(player.getTurnovers(), 14);
	}
	
	@Test
	public void testIfPlayerOneGetsGameAdded(){
		init();
		games = readExcel.readExcel("files/test2.xlsx", games);
		int size = games.get(0).getPlayer("Andreas Angin").getGames().size();
		Assert.assertEquals(2, size);
		size = games.get(1).getPlayer("Andreas Angin").getGames().size();
		Assert.assertEquals(2, size);
		games = readExcel.readExcel("files/test3.xlsx", games);
		size = games.get(0).getPlayer("Andreas Angin").getGames().size();
		Assert.assertEquals(3, size);
		
		
	}
}

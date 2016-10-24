package se.kungsbacka.basket.imports;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;

public class ReadExcelTest {

	ReadExcel readExcel;
	Game game;
	
	public void init(){
		readExcel = new ReadExcel();
		game = readExcel.readExcel("files/test.xlsx");
	}
	
	@Test
	public void testIfGameIsReturnedCorrectly() {
		init();
		game = readExcel.readExcel("files/test.xlsx");
		Assert.assertEquals(game.getHomeTeam(), "Kungsbacka");
		Assert.assertEquals(game.getAwayTeam(), "Trollhättan");
		Assert.assertEquals(game.getPlayers().size(), 2);
	}
	
	@Test
	public void testIfPlayersAreInformationIsCorrect(){
		init();
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
}

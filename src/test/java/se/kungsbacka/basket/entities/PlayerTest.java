package se.kungsbacka.basket.entities;

import junit.framework.Assert;

import org.junit.Test;

public class PlayerTest {

	Player player;
	
	public void init(){
		player = new Player();
		player.setName("Andreas Angin");
		player.setFreeThrowAttempt(1);
		player.setFreeThrowMade(2);
		player.setTwoPointAttempt(3);
		player.setTwoPointMade(4);
		player.setThreePointAttempt(5);
		player.setThreePointMade(6);
		player.setDefRebounds(7);
		player.setOffRebounds(8);
		player.setSteals(9);
		player.setAssists(10);
		player.setFouls(11);
		player.setBlocks(12);
		player.setDeflections(13);
		player.setTurnovers(14);
	}

	@Test
	public void testConstructor() {
		Player player = new Player("Andreas Angin");
		Assert.assertEquals(player.getName(), "Andreas Angin");
		Assert.assertEquals(player.getFreeThrowAttempt(), 0);
		Assert.assertEquals(player.getFreeThrowMade(), 0);
	}

	@Test
	public void testSettersAndGetters(){
		init();
		Assert.assertEquals(player.getName(), "Andreas Angin");
		Assert.assertEquals(player.getFreeThrowAttempt(), 1);
		Assert.assertEquals(player.getFreeThrowMade(), 2);
		Assert.assertEquals(player.getTwoPointAttempt(), 3);
		Assert.assertEquals(player.getTwoPointMade(), 4);
		Assert.assertEquals(player.getThreePointAttempt(), 5);
		Assert.assertEquals(player.getThreePointMade(), 6);
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
	public void testTotalRebounds(){
		init();
		Assert.assertEquals(player.getTotalRebounds(), 15);
	}
	
	@Test
	public void testAdders(){
		init();
		player.addFreeThrowAttempt();
		player.addFreeThrowMade();
		player.addTwoPointerAttempt();
		player.addTwoPointerMade();
		player.addThreePointerAttempt();
		player.addThreePointerMade();
		player.addDefRebound();
		player.addOffRebound();
		player.addSteal();
		player.addAssist();
		player.addFoul();
		player.addBlock();
		player.addDeflection();
		player.addTurnover();
		
		Assert.assertEquals(player.getFreeThrowAttempt(), 2);
		Assert.assertEquals(player.getFreeThrowMade(), 3);
		Assert.assertEquals(player.getTwoPointAttempt(), 4);
		Assert.assertEquals(player.getTwoPointMade(), 5);
		Assert.assertEquals(player.getThreePointAttempt(), 6);
		Assert.assertEquals(player.getThreePointMade(), 7);
		Assert.assertEquals(player.getDefRebounds(), 8);
		Assert.assertEquals(player.getOffRebounds(), 9);
		Assert.assertEquals(player.getSteals(), 10);
		Assert.assertEquals(player.getAssists(), 11);
		Assert.assertEquals(player.getFouls(), 12);
		Assert.assertEquals(player.getBlocks(), 13);
		Assert.assertEquals(player.getDeflections(), 14);
		Assert.assertEquals(player.getTurnovers(), 15);
	}
}

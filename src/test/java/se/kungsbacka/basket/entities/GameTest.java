package se.kungsbacka.basket.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import se.kungsbacka.basket.imports.ReadExcel;

public class GameTest {

	ReadExcel readExcel;
	Game game;
	List<Game> games;
	
	public void init(){
		readExcel = new ReadExcel();
		games = new ArrayList<Game>();
		games = readExcel.readExcel("files/test.xlsx", games);
	}
	
	@Test
	public void getPlayer(){
		init();
		Player player = games.get(0).getPlayer("Andreas Angin");
		Assert.assertEquals(4, player.getAssists());
	}

}

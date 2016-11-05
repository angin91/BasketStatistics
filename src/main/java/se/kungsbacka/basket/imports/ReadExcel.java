package se.kungsbacka.basket.imports;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import se.kungsbacka.basket.GUI.Panel;
import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;

public class ReadExcel {

	private boolean newGame;
	private boolean playerWithNoStats;

	public List<Game> readExcel(String pathToFile, List<Game> games) {
		Game game = new Game();
		newGame = true;
		playerWithNoStats = false;
		try {
			File myFile = new File(pathToFile);
			FileInputStream fis = new FileInputStream(myFile);
			org.apache.poi.ss.usermodel.Workbook workbook = null;
			try {
				workbook = WorkbookFactory.create(fis);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			org.apache.poi.ss.usermodel.Sheet mySheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();

			while (rowIterator.hasNext()) {

				Player player = new Player();
				Row row = rowIterator.next();
				int counter = 0;

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					if(playerWithNoStats){
						break;
					}
					
					Cell cell = cellIterator.next();
					if (newGame) {
						if (pathToFile.endsWith(".xlsx")) {
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								game.setDate(cell.getDateCellValue());
							}
						} else {
							double ndate = cell.getNumericCellValue();
							Date date = HSSFDateUtil.getJavaDate(ndate);
							game.setDate(date);
						}
						row = rowIterator.next();
						Iterator<Cell> next = row.cellIterator();
						game.setTeams(next.next().getStringCellValue());
						row = rowIterator.next();
						newGame = false;
						break;
					}
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						if (cell.getStringCellValue().equalsIgnoreCase("Sum")) {
							returnGames(games, game);
							return games;
						}
						player.setName(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						int i = (int) cell.getNumericCellValue();
						if (counter == 1) {
							player.setFouls(i);
						}
						if (counter == 2) {
							player.setTwoPointAttempt(i);
						}
						if (counter == 3) {
							player.setTwoPointMade(i);
						}
						if (counter == 5) {
							player.setThreePointAttempt(i);
						}
						if (counter == 6) {
							player.setThreePointMade(i);
						}
						if (counter == 11) {
							player.setFreeThrowAttempt(i);
						}
						if (counter == 12) {
							player.setFreeThrowMade(i);
						}
						if (counter == 15) {
							player.setDefRebounds(i);
						}
						if (counter == 16) {
							player.setOffRebounds(i);
						}
						if (counter == 18) {
							player.setSteals(i);
						}
						if (counter == 19) {
							player.setBlocks(i);
						}
						if (counter == 20) {
							player.setTurnovers(i);
						}
						if (counter == 21) {
							player.setAssists(i);
						}
						if (counter == 22) {
							player.setDeflections(i);
						}
						counter++;

						break;
					case Cell.CELL_TYPE_BLANK:
						if (counter == 0) {
							playerWithNoStats = true;
							continue;
						}
	                    break;
					default:
						counter++;
						break;
					}
				}
				if(!playerWithNoStats){
					playerWithNoStats = false;
					addGamesIntoPlayers(games, game, player);
				}
			}
			games = returnGames(games, game);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return games;
	}

	private List<Game> returnGames(List<Game> games, Game game) {
		games.add(game);
		games = sort(games);
		newGame = true;
		return games;
	}

	private List<Game> sort(List<Game> games) {
		for (int s = 0; s <= games.size() - 1; s++) {
			for (int k = 0; k <= games.size() - 2; k++) {
				if (games.get(k).getDate().getTime() > games.get(k + 1)
						.getDate().getTime()) {

					Game tempGame = games.get(k);
					games.set(k, games.get(k + 1));
					games.set(k + 1, tempGame);

				}
			}
		}

		return games;
	}

	private void addGamesIntoPlayers(List<Game> games, Game game, Player player) {
		if (player.getName() != null) {
			game.addPlayer(player);

			for (int i = 0; i < games.size(); i++) {
				ArrayList<Player> players = games.get(i).getPlayers();
				for (int j = 0; j < players.size(); j++) {
					if (player.getName().equals(players.get(j).getName())) {
						players.get(j).getGames().add(game);
						players.get(j).setGames(sort(players.get(j).getGames()));
						player.getGames().add(games.get(i));
					}
				}
			}
			player.getGames().add(game);
			player.setGames(sort(player.getGames()));
			
			if(Panel.allPlayers.size() == 0){
				Panel.allPlayers.add(player);
			}
			boolean dontExists = true;
			for (int i = 0; i < Panel.allPlayers.size(); i++) {
				if(Panel.allPlayers.get(i).getName().equalsIgnoreCase(player.getName())){
					dontExists = false;
					break;
				}
			}
			if(dontExists){
				Panel.allPlayers.add(player);
			}
		}
	}
}

package se.kungsbacka.basket.imports;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;

public class ReadExcel {

	@SuppressWarnings("resource")
	public Game readExcel(String pathToFile) {
		Game game = new Game();
		try {
			boolean newGame = true;
			File myFile = new File(pathToFile);
			FileInputStream fis = new FileInputStream(myFile);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();

			rowIterator.next();
			while (rowIterator.hasNext()) {

				Player player = new Player();
				Row row = rowIterator.next();
				int counter = 0;

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					if (newGame) {
						rowIterator.next();
						game.setHomeTeam(cell.getStringCellValue());
						cell = cellIterator.next();
						game.setAwayTeam(cell.getStringCellValue());
						newGame = false;
						break;
					}
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						player.setName(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						int i = (int) cell.getNumericCellValue();
						if (counter == 0) {player.setJerseyNumber(i);}
						if (counter == 1) {player.setTwoPointAttempt(i);}
						if (counter == 2) {player.setTwoPointMade(i);}
						if (counter == 3) {player.setThreePointAttempt(i);}
						if (counter == 4) {player.setThreePointMade(i);}
						if (counter == 5) {player.setFreeThrowAttempt(i);}
						if (counter == 6) {player.setFreeThrowMade(i);}
						if (counter == 7) {player.setDefRebounds(i);}
						if (counter == 8) {player.setOffRebounds(i);}
						if (counter == 9) {player.setSteals(i);}
						if (counter == 10) {player.setAssists(i);}
						if (counter == 11) {player.setFouls(i);}
						if (counter == 12) {player.setBlocks(i);}
						if (counter == 13) {player.setDeflections(i);}
						if (counter == 14) {player.setTurnovers(i);}
						counter++;
						break;
					default:
					}
				}
				if(player.getName() != null){
					game.addPlayer(player);
				}
			}
			newGame = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return game;
	}
}

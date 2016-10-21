package se.kungsbacka.basket.GUI;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;
import se.kungsbacka.basket.imports.ReadExcel;

public class Frame extends JFrame{

	private JButton newGameButton;
	private JButton seeStatButton;
	private JList gameList;
	private JList playerList;
	private ArrayList<Game> games;
	private ArrayList<Player> players;
	//will remove
	private ArrayList<Player> players2;
	//Will remove
	
	public Frame(){
		super("Basket statistics");
		setLayout(new FlowLayout());
		games = new ArrayList<Game>();
		players = new ArrayList<Player>();
		
		//-----------------------Test array. Will remove----------------------------------
		ReadExcel readExcel = new ReadExcel();
		Game game = readExcel.readExcel("files/test.xlsx");
		games.add(game);
		game = readExcel.readExcel("files/test2.xlsx");
		games.add(game);
		//-----------------------Test array. Will remove----------------------------------
		
		gameList = new JList(games.toArray());
		add(new JScrollPane(gameList));
		
		playerList = new JList();
		add(new JScrollPane(playerList));
		
		newGameButton = new JButton("New game");
		newGameButton.setBounds(100, 100, 50, 50);
		add(newGameButton);
		
		seeStatButton = new JButton("See stats");
		seeStatButton.setBounds(100, 100, 50, 50);
		add(seeStatButton);
		
		gameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Game game = (Game) gameList.getSelectedValue();
				playerList.setListData(game.getPlayers().toArray());
			}
		});
	}
}

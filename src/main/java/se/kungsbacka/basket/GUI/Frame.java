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
		
		//Test array. Will remove
		players2 = new ArrayList<Player>();
		Player player = new Player();
		player.setName("Andreas Angin");
		player.setJerseyNumber(7);
		players.add(player);
		players2.add(player);
		player = new Player();
		player.setName("John Sundemo");
		player.setJerseyNumber(12);
		players.add(player);
		//Test array. Will remove
		
		//Test array. Will remove
		Game game = new Game();
		game.setHomeTeam("Kungsbacka");
		game.setAwayTeam("Trollhättan");
		game.setPlayers(players);
		games.add(game);
		game = new Game();
		game.setHomeTeam("Varberg");
		game.setAwayTeam("Kungsbacka");
		game.setPlayers(players2);
		games.add(game);
		//Test array. Will remove
		
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

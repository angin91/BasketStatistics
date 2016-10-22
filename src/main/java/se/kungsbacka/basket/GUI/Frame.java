package se.kungsbacka.basket.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;
import se.kungsbacka.basket.imports.ReadExcel;

public class Frame extends JFrame {

	private JButton newGameButton;
	private JButton seeStatButton;
	private JList<Game> gameList;
	private JList<Player> playerList;
	private DefaultListModel<Game> games;
	private DefaultListModel<Player> players;

	public Frame(){
		super("Basket statistics");
		setLayout(new FlowLayout());
		games = new DefaultListModel<Game>();
		players = new DefaultListModel<Player>();
		
		//-----------------------Test array. Will remove----------------------------------
		final ReadExcel readExcel = new ReadExcel();
		Game game = readExcel.readExcel("files/test.xlsx");
		games.addElement(game);
		game = readExcel.readExcel("files/test2.xlsx");
		games.addElement(game);
		//-----------------------Test array. Will remove----------------------------------
		
		gameList = new JList<Game>(games);
		add(new JScrollPane(gameList));
		
		playerList = new JList<Player>(players);
		add(new JScrollPane(playerList));
		
		newGameButton = new JButton("New game");
		newGameButton.setBounds(100, 100, 50, 50);
		add(newGameButton);
		
		seeStatButton = new JButton("See stats");
		seeStatButton.setBounds(100, 100, 50, 50);
		add(seeStatButton);
		
		gameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				players.clear();
				Game game = (Game) gameList.getSelectedValue();
				for(Player player : game.getPlayers()){
					players.addElement(player);
				}
			}
		});
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(Frame.this);
				String s = fc.getSelectedFile().getPath();
				Game game = readExcel.readExcel(s);
				games.addElement(game);
			}
		});
	}
}

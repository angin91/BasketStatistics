package se.kungsbacka.basket.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;
import se.kungsbacka.basket.imports.ReadExcel;

public class Panel extends JPanel {

	private JButton newGameButton;
	private JButton seeStatButton;
	private JList<Game> gameList;
	private JList<Player> playerList;
	private DefaultListModel<Game> games;
	private DefaultListModel<Player> players;

	public Panel() {
		games = new DefaultListModel<Game>();
		players = new DefaultListModel<Player>();
		
		setLayout(null);

		// -----------------------Test array. Will
		// remove----------------------------------
		final ReadExcel readExcel = new ReadExcel();
		Game game = readExcel.readExcel("files/test.xlsx");
		games.addElement(game);
		game = readExcel.readExcel("files/test2.xlsx");
		games.addElement(game);
		// -----------------------Test array. Will
		// remove----------------------------------

		gameList = new JList<Game>(games);
		JScrollPane gameListScrollPane = new JScrollPane(gameList);
		gameListScrollPane.setBounds(20, 20, 300, 300);
		add(gameListScrollPane);

		playerList = new JList<Player>(players);
		JScrollPane playerListScrollPane = new JScrollPane(playerList);
		playerListScrollPane.setBounds(340, 20, 300, 300);
		add(playerListScrollPane);

		newGameButton = new JButton("New game");
		newGameButton.setBounds(660, 20, 140, 140);
		add(newGameButton);

		seeStatButton = new JButton("See stats");
		seeStatButton.setBounds(660, 180, 140, 140);
		add(seeStatButton);

		gameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				players.clear();
				Game game = (Game) gameList.getSelectedValue();
				for (Player player : game.getPlayers()) {
					players.addElement(player);
				}
			}
		});
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(Panel.this);
				String s = fc.getSelectedFile().getPath();
				Game game = readExcel.readExcel(s);
				games.addElement(game);
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Basketball statistics");
		frame.getContentPane().add(new Panel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}
}

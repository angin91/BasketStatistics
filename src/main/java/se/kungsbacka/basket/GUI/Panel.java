package se.kungsbacka.basket.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;
import se.kungsbacka.basket.imports.ReadExcel;

public class Panel extends JPanel {

	private JButton newGameButton;
	private JButton seeTrendButton;
	private JList<Game> gameList;
	private JList<Player> playerList;
	private DefaultListModel<Game> games;
	private DefaultListModel<Player> players;
	private JTable statisticsTable;
	private DefaultTableModel statisticsModel;
	private JScrollPane statisticsScrollPane;
	private List<Game> allGames;

	public Panel() {
		allGames = new ArrayList<Game>();
		games = new DefaultListModel<Game>();
		players = new DefaultListModel<Player>();
		final ReadExcel readExcel = new ReadExcel();

		setLayout(null);

		// -----------------------Test array. Will
		// remove----------------------------------
		// allGames = readExcel.readExcel("files/test.xlsx", allGames);
		// allGames = readExcel.readExcel("files/test2.xlsx", allGames);
		// allGames = readExcel.readExcel("files/test3.xlsx", allGames);
		// games.removeAllElements();
		// for (Game game : allGames) {
		// games.addElement(game);
		// }
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

		seeTrendButton = new JButton("See player trend");
		seeTrendButton.setBounds(660, 180, 140, 140);
		add(seeTrendButton);

		statisticsModel = new DefaultTableModel();
		statisticsModel.addColumn("Name");
		statisticsModel.addColumn("Number");
		statisticsModel.addColumn("FTA");
		statisticsModel.addColumn("FTM");
		statisticsModel.addColumn("2PA");
		statisticsModel.addColumn("2PM");
		statisticsModel.addColumn("3PA");
		statisticsModel.addColumn("3PM");
		statisticsModel.addColumn("DEF");
		statisticsModel.addColumn("OFF");
		statisticsModel.addColumn("TOT");
		statisticsModel.addColumn("ST");
		statisticsModel.addColumn("AST");
		statisticsModel.addColumn("PF");
		statisticsModel.addColumn("BS");
		statisticsModel.addColumn("DEFL");
		statisticsModel.addColumn("TO");
		statisticsModel.addRow(new Object[] { "1", "2", "3", "4" });
		statisticsTable = new JTable(statisticsModel);
		statisticsScrollPane = new JScrollPane(statisticsTable);
		statisticsScrollPane.setBounds(20, 400, 800, 300);
		add(statisticsScrollPane);

		gameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				players.clear();
				Game game = (Game) gameList.getSelectedValue();
				for (Player player : game.getPlayers()) {
					players.addElement(player);
				}
				addStatistics(game);
			}
		});
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(Panel.this);
				String path = fc.getSelectedFile().getPath();

				allGames = readExcel.readExcel(path, allGames);
				games.addElement(allGames.get(allGames.size()-1));
			}
		});
		seeTrendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Player player = playerList.getSelectedValue();
						if (player == null) {
							String message = "No player selected";
							String title = "No player";
							JOptionPane.showMessageDialog(null, message, title, 2);
						} else if (player.getGames().size() <= 1) {
							String message = "Only played one game. No trends";
							String title = "No trends";
							JOptionPane.showMessageDialog(null, message, title, 2);
						} else {
							GraphPanel graphPanel = new GraphPanel(player);
							graphPanel
									.setPreferredSize(new Dimension(800, 600));
							JFrame frame = new JFrame("Trend graph");
							frame.getContentPane().add(graphPanel);
							frame.pack();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						}
					}
				});
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

	private void addStatistics(Game game) {

		// Clear statistics
		if (statisticsModel.getRowCount() > 0) {
			for (int i = statisticsModel.getRowCount() - 1; i > -1; i--) {
				statisticsModel.removeRow(i);
			}
		}

		// Add statistics
		for (Player player : game.getPlayers()) {
			statisticsModel.addRow(new Object[] { player.getName(),
					player.getJerseyNumber(), player.getFreeThrowAttempt(),
					player.getFreeThrowMade(), player.getTwoPointAttempt(),
					player.getTwoPointMade(), player.getThreePointAttempt(),
					player.getThreePointMade(), player.getDefRebounds(),
					player.getOffRebounds(),
					player.getOffRebounds() + player.getDefRebounds(),
					player.getSteals(), player.getAssists(), player.getFouls(),
					player.getBlocks(), player.getDeflections(),
					player.getTurnovers() });
		}
		statisticsTable.setModel(statisticsModel);
	}
}

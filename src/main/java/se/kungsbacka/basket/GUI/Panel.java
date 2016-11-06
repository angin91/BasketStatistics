package se.kungsbacka.basket.GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import se.kungsbacka.basket.helper.HelperClass;
import se.kungsbacka.basket.imports.ReadExcel;

@SuppressWarnings("serial")
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
	public static List<Player> allPlayers;
	private final ReadExcel readExcel;

	public Panel(JFrame frame) {
		allGames = new ArrayList<Game>();
		allPlayers = new ArrayList<Player>();
		games = new DefaultListModel<Game>();
		players = new DefaultListModel<Player>();
		readExcel = new ReadExcel();
		
		super.setLayout(new GridBagLayout());

		importGamesInFile();

		GridBagConstraints gbc = new GridBagConstraints();

		// chat box
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(10, 10, 0, 10);
		gameList = new JList<Game>(games);
		JScrollPane gameListScrollPane = new JScrollPane(gameList);
		add(gameListScrollPane, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		playerList = new JList<Player>(players);
		JScrollPane playerListScrollPane = new JScrollPane(playerList);
		add(playerListScrollPane, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.weighty = 1.0;
		newGameButton = new JButton("New game");
		add(newGameButton, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		seeTrendButton = new JButton("See player trend");
		add(seeTrendButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(10, 10, 10, 10);
		statisticsModel = new DefaultTableModel();
		statisticsModel.addColumn("Name");
		statisticsModel.addColumn("PF");
		statisticsModel.addColumn("2PA");
		statisticsModel.addColumn("2PM");
		statisticsModel.addColumn("2P%");
		statisticsModel.addColumn("3PA");
		statisticsModel.addColumn("3PM");
		statisticsModel.addColumn("3P%");
		statisticsModel.addColumn("TSA");
		statisticsModel.addColumn("TSM");
		statisticsModel.addColumn("TS%");
		statisticsModel.addColumn("FTA");
		statisticsModel.addColumn("FTM");
		statisticsModel.addColumn("FT%");
		statisticsModel.addColumn("PTS");
		statisticsModel.addColumn("DEF");
		statisticsModel.addColumn("OFF");
		statisticsModel.addColumn("TOT");
		statisticsModel.addColumn("ST");
		statisticsModel.addColumn("BS");
		statisticsModel.addColumn("TO");
		statisticsModel.addColumn("AST");
		statisticsModel.addColumn("DEFL");
		statisticsTable = new JTable(statisticsModel);
		statisticsScrollPane = new JScrollPane(statisticsTable);
		add(statisticsScrollPane, gbc);

		gameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Game game = (Game) gameList.getSelectedValue();
				addStatistics(game);
			}
		});
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int showOpenDialog = fc.showOpenDialog(Panel.this);

				if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
					String path = fc.getSelectedFile().getPath();

					allGames = readExcel.readExcel(path, allGames);
					games.clear();
					for (Game game : allGames) {
						games.addElement(game);
					}
					players.clear();
					for (Player player : allPlayers) {
						players.addElement(player);
					}
				}
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
							JOptionPane.showMessageDialog(null, message, title,
									2);
						} else if (player.getGames().size() <= 1) {
							String message = "Only played one game. No trends";
							String title = "No trends";
							JOptionPane.showMessageDialog(null, message, title,
									2);
						} else {
							GraphPanel graphPanel = new GraphPanel(player);
							graphPanel
									.setPreferredSize(new Dimension(840, 600));
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

	private void addStatistics(Game game) {

		// Clear statistics
		if (statisticsModel.getRowCount() > 0) {
			for (int i = statisticsModel.getRowCount() - 1; i > -1; i--) {
				statisticsModel.removeRow(i);
			}
		}

		// Add statistics
		for (Player player : game.getPlayers()) {
			statisticsModel.addRow(new Object[] {
					player.getName(),
					player.getFouls(),
					player.getTwoPointAttempt(),
					player.getTwoPointMade(),
					HelperClass.getTwoPointProcent(player.getTwoPointAttempt(),
							player.getTwoPointMade()),
					player.getThreePointAttempt(),
					player.getThreePointMade(),
					HelperClass.getThreePointProcent(
							player.getThreePointAttempt(),
							player.getThreePointMade()),
					player.getTotalShotsAttempt(),
					player.getTotalShotsMade(),
					HelperClass.getTotalShotProcent(
							player.getTotalShotsAttempt(),
							player.getTotalShotsMade()),
					player.getFreeThrowAttempt(),
					player.getFreeThrowMade(),
					HelperClass.getFreethrowProcent(
							player.getFreeThrowAttempt(),
							player.getFreeThrowMade()),
					HelperClass.getTotalPoints(player.getTwoPointMade(),
							player.getThreePointMade(),
							player.getFreeThrowMade()),
					player.getDefRebounds(), player.getOffRebounds(),
					player.getTotalRebounds(), player.getSteals(),
					player.getBlocks(), player.getTurnovers(),
					player.getAssists(), player.getDeflections() });
		}
		statisticsModel.addRow(game.getTotalGameStatistics());
		statisticsTable.setModel(statisticsModel);
	}

	private void importGamesInFile() {
		final List<Path> files = new ArrayList<Path>();

		Path path = Paths.get("C:\\files");
		try {
			DirectoryStream<Path> stream;
			stream = Files.newDirectoryStream(path);
			for (Path entry : stream) {
				files.add(entry);
			}
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Path entry : files) {
			allGames = readExcel.readExcel(entry.toString(), allGames);
		}
		games.removeAllElements();
		for (Game game : allGames) {
			games.addElement(game);
		}
		for (Player player : allPlayers) {
			players.addElement(player);
		}
	}
	
	private static void createAndShowGui() {

		JFrame frame = new JFrame("In Game Menu");
		Panel mainPanel = new Panel(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}

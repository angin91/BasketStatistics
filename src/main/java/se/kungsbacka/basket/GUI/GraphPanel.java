package se.kungsbacka.basket.GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kungsbacka.basket.entities.Game;
import se.kungsbacka.basket.entities.Player;
import se.kungsbacka.basket.helper.HelperClass;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {

	private int graphPadding = 120;
	private int labelPadding = 25;
	private Color lineColor = new Color(44, 102, 230, 180);
	private Color pointColor = new Color(100, 100, 100, 180);
	private Color gridColor = new Color(200, 200, 200, 200);
	private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
	private int pointWidth = 4;
	private int numberYDivisions = 10;
	private List<Integer> scores;
	private List<Game> games;
	private JButton foulsButton;
	private JButton twoPointAttemptButton;
	private JButton twoPointMadeButton;
	private JButton twoPointProcentButton;
	private JButton threePointAttemptButton;
	private JButton threePointMadeButton;
	private JButton threePointProcentButton;
	private JButton totalShotsAttemptButton;
	private JButton totalShotsMadeButton;
	private JButton totalShotsProcentButton;
	private JButton freeThrowAttemptButton;
	private JButton freeThrowMadeButton;
	private JButton freeThrowProcentButton;
	private JButton pointsButton;
	private JButton defReboundsButton;
	private JButton offReboundsButton;
	private JButton totalReboundsButton;
	private JButton stealsButton;
	private JButton blocksButton;
	private JButton turnoversButton;
	private JButton assistsButton;
	private JButton deflectionsButton;
	private JLabel playerName;
	private Player PlayerAverage;
	private JLabel playerAverageLabel;

	public GraphPanel(final Player player) {
		scores = new ArrayList<Integer>();
		games = player.getGames();
		PlayerAverage = player.getPlayerAverage();

		super.setLayout(new BorderLayout());

		JPanel jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
		add(jPanelSouth, BorderLayout.SOUTH);

		JPanel jPanelNorth = new JPanel();
		jPanelNorth.setLayout(new GridBagLayout());
		add(jPanelNorth, BorderLayout.NORTH);

		playerName = new JLabel(player.getName());
		Font font = new Font("Verdana", Font.BOLD, 20);
		playerName.setFont(font);
		jPanelSouth.add(playerName, BorderLayout.CENTER);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(2, 2, 0, 2);

		foulsButton = new JButton("FOUL");
		jPanelNorth.add(foulsButton, gbc);

		gbc.gridx = 1;
		twoPointAttemptButton = new JButton("FGA");
		jPanelNorth.add(twoPointAttemptButton, gbc);

		gbc.gridx = 2;
		twoPointMadeButton = new JButton("FGM");
		jPanelNorth.add(twoPointMadeButton, gbc);

		gbc.gridx = 3;
		twoPointProcentButton = new JButton("FG%");
		jPanelNorth.add(twoPointProcentButton, gbc);

		gbc.gridx = 4;
		threePointAttemptButton = new JButton("3PA");
		jPanelNorth.add(threePointAttemptButton, gbc);

		gbc.gridx = 5;
		threePointMadeButton = new JButton("3PM");
		jPanelNorth.add(threePointMadeButton, gbc);

		gbc.gridx = 6;
		threePointProcentButton = new JButton("3P%");
		jPanelNorth.add(threePointProcentButton, gbc);

		gbc.gridx = 7;
		totalShotsAttemptButton = new JButton("TSA");
		jPanelNorth.add(totalShotsAttemptButton, gbc);

		gbc.gridx = 8;
		totalShotsMadeButton = new JButton("TSM");
		jPanelNorth.add(totalShotsMadeButton, gbc);

		gbc.gridx = 9;
		totalShotsProcentButton = new JButton("TS%");
		jPanelNorth.add(totalShotsProcentButton, gbc);

		gbc.gridx = 10;
		freeThrowAttemptButton = new JButton("FTA");
		jPanelNorth.add(freeThrowAttemptButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		freeThrowMadeButton = new JButton("FTM");
		jPanelNorth.add(freeThrowMadeButton, gbc);

		gbc.gridx = 1;
		freeThrowProcentButton = new JButton("FT%");
		jPanelNorth.add(freeThrowProcentButton, gbc);

		gbc.gridx = 2;
		pointsButton = new JButton("PTS");
		jPanelNorth.add(pointsButton, gbc);

		gbc.gridx = 3;
		defReboundsButton = new JButton("DEFR");
		jPanelNorth.add(defReboundsButton, gbc);

		gbc.gridx = 4;
		offReboundsButton = new JButton("OFFR");
		jPanelNorth.add(offReboundsButton, gbc);

		gbc.gridx = 5;
		totalReboundsButton = new JButton("TOT");
		jPanelNorth.add(totalReboundsButton, gbc);

		gbc.gridx = 6;
		stealsButton = new JButton("STL");
		jPanelNorth.add(stealsButton, gbc);

		gbc.gridx = 7;
		blocksButton = new JButton("BLK");
		jPanelNorth.add(blocksButton, gbc);

		gbc.gridx = 8;
		turnoversButton = new JButton("TO");
		jPanelNorth.add(turnoversButton, gbc);

		gbc.gridx = 9;
		assistsButton = new JButton("ASS");
		jPanelNorth.add(assistsButton, gbc);

		gbc.gridx = 10;
		deflectionsButton = new JButton("DEFL");
		jPanelNorth.add(deflectionsButton, gbc);

		gbc.gridy = 2;
		gbc.gridx = 5;
		gbc.gridwidth = 11;
		playerAverageLabel = new JLabel("Average: ");
		font = new Font("Verdana", Font.PLAIN, 20);
		playerAverageLabel.setFont(font);
		jPanelNorth.add(playerAverageLabel, gbc);

		foulsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getFouls());
				}
				playerAverageLabel.setText("Average: "
						+ PlayerAverage.getFouls());
				setScores(scores);
			}
		});
		twoPointAttemptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getTwoPointAttempt());
				}
				playerAverageLabel.setText("Average: "
						+ PlayerAverage.getTwoPointAttempt());
				setScores(scores);
			}
		});
		twoPointMadeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getTwoPointMade());
				}
				playerAverageLabel.setText("Average: "
						+ PlayerAverage.getTwoPointMade());
				setScores(scores);
			}
		});
		twoPointProcentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add((int) HelperClass.getTwoPointProcent(
							player2.getTwoPointAttempt(),
							player2.getTwoPointMade()));
				}
				playerAverageLabel.setText("Average: "
						+ HelperClass.getTwoPointProcent(
								PlayerAverage.getTwoPointAttempt(),
								PlayerAverage.getTwoPointMade()) + "%");
				setScores(scores);
			}
		});
		threePointAttemptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getThreePointAttempt());
				}
				playerAverageLabel.setText("Average: "
						+ PlayerAverage.getThreePointAttempt());
				setScores(scores);
			}
		});
		threePointMadeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getThreePointMade());
				}
				playerAverageLabel.setText("Average: "
						+ PlayerAverage.getThreePointMade());
				setScores(scores);
			}
		});
		threePointProcentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add((int) HelperClass.getThreePointProcent(
							player2.getThreePointAttempt(),
							player2.getThreePointMade()));
				}
				playerAverageLabel.setText("Average: "
						+ HelperClass.getThreePointProcent(
								PlayerAverage.getThreePointAttempt(),
								PlayerAverage.getThreePointMade()) + "%");
				setScores(scores);
			}
		});
		totalShotsAttemptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getTotalShotsAttempt());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getTotalShotsAttempt());
				setScores(scores);
			}
		});
		totalShotsMadeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getTotalShotsMade());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getTotalShotsMade());
				setScores(scores);
			}
		});
		totalShotsProcentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add((int) HelperClass.getTotalShotProcent(
							player2.getTotalShotsAttempt(),
							player2.getTotalShotsMade()));
				}
				playerAverageLabel.setText("Average: " + HelperClass.getTotalShotProcent(
						PlayerAverage.getTotalShotsAttempt(),
						PlayerAverage.getTotalShotsMade()) + "%");
				setScores(scores);
			}
		});
		freeThrowAttemptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getFreeThrowAttempt());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getFreeThrowAttempt());
				setScores(scores);
			}
		});
		freeThrowMadeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getFreeThrowMade());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getFreeThrowMade());
				setScores(scores);

			}
		});
		freeThrowProcentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add((int) HelperClass.getFreethrowProcent(
							player2.getFreeThrowAttempt(),
							player2.getFreeThrowMade()));
				}
				playerAverageLabel.setText("Average: " + HelperClass.getFreethrowProcent(
						PlayerAverage.getFreeThrowAttempt(),
						PlayerAverage.getFreeThrowMade()) + "%");
				setScores(scores);

			}
		});
		pointsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(HelperClass.getTotalPoints(
							player2.getTwoPointMade(),
							player2.getThreePointMade(),
							player2.getFreeThrowMade()));
				}
				playerAverageLabel.setText("Average: " + HelperClass.getTotalPoints(
						PlayerAverage.getTwoPointMade(),
						PlayerAverage.getThreePointMade(),
						PlayerAverage.getFreeThrowMade()));
				setScores(scores);

			}
		});
		defReboundsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getDefRebounds());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getDefRebounds());
				setScores(scores);
			}
		});
		offReboundsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getOffRebounds());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getOffRebounds());
				setScores(scores);
			}
		});
		totalReboundsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getTotalRebounds());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getTotalRebounds());
				setScores(scores);
			}
		});
		stealsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getSteals());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getSteals());
				setScores(scores);
			}
		});
		blocksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getBlocks());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getBlocks());
				setScores(scores);
			}
		});
		turnoversButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getTurnovers());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getTurnovers());
				setScores(scores);
			}
		});
		assistsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getAssists());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getAssists());
				setScores(scores);
			}
		});
		deflectionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getDeflections());
				}
				playerAverageLabel.setText("Average: " + PlayerAverage.getDeflections());
				setScores(scores);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		int xScale = ((int) getWidth() - (2 * graphPadding) - labelPadding)
				/ (scores.size() - 1);
		int yScale = ((int) getHeight() - 2 * graphPadding - labelPadding)
				/ (getMaxScore() - getMinScore());

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < scores.size(); i++) {
			int x1 = (int) (i * xScale + graphPadding + labelPadding);
			int y1 = (int) ((getMaxScore() - scores.get(i)) * yScale + graphPadding);
			graphPoints.add(new Point(x1, y1));
		}

		// draw white background
		g2.setColor(Color.WHITE);
		g2.fillRect(graphPadding + labelPadding, graphPadding, getWidth()
				- (2 * graphPadding) - labelPadding, getHeight() - 2
				* graphPadding - labelPadding);
		g2.setColor(Color.BLACK);

		// create hatch marks and grid lines for y axis.
		for (int i = 0; i < numberYDivisions + 1; i++) {
			int x0 = graphPadding + labelPadding;
			int x1 = pointWidth + graphPadding + labelPadding;
			int y0 = getHeight()
					- ((i * (getHeight() - graphPadding * 2 - labelPadding))
							/ numberYDivisions + graphPadding + labelPadding);
			int y1 = y0;
			if (scores.size() > 0) {
				g2.setColor(gridColor);
				g2.drawLine(graphPadding + labelPadding + 1 + pointWidth, y0,
						getWidth() - graphPadding, y1);
				g2.setColor(Color.BLACK);
				String yLabel = ((int) ((getMinScore() + (getMaxScore() - getMinScore())
						* ((i * 1.0) / numberYDivisions)) * 100))
						/ 100.0 + "";
				FontMetrics metrics = g2.getFontMetrics();
				int labelWidth = metrics.stringWidth(yLabel);
				g2.drawString(yLabel, x0 - labelWidth - 5,
						y0 + (metrics.getHeight() / 2) - 3);
			}
			g2.drawLine(x0, y0, x1, y1);
		}

		// and for x axis
		for (int i = 0; i < scores.size(); i++) {
			if (scores.size() > 1) {
				int x0 = i * (getWidth() - graphPadding * 2 - labelPadding)
						/ (scores.size() - 1) + graphPadding + labelPadding;
				int x1 = x0;
				int y0 = getHeight() - graphPadding - labelPadding;
				int y1 = y0 - pointWidth;
				if ((i % ((int) ((scores.size() / 20)) + 1)) == 0) {
					g2.setColor(gridColor);
					g2.drawLine(x0, getHeight() - graphPadding - labelPadding
							- 1 - pointWidth, x1, graphPadding);
					g2.setColor(Color.BLACK);
					String xLabel = games.get(i).toString();
					FontMetrics metrics = g2.getFontMetrics();
					int labelWidth = metrics.stringWidth(xLabel);
					g2.drawString(xLabel, x0 - labelWidth / 2,
							y0 + metrics.getHeight() + 3);
				}
				g2.drawLine(x0, y0, x1, y1);
			}
		}

		// create x and y axes
		g2.drawLine(graphPadding + labelPadding, getHeight() - graphPadding
				- labelPadding, graphPadding + labelPadding, graphPadding);
		g2.drawLine(graphPadding + labelPadding, getHeight() - graphPadding
				- labelPadding, getWidth() - graphPadding, getHeight()
				- graphPadding - labelPadding);

		Stroke oldStroke = g2.getStroke();
		g2.setColor(lineColor);
		g2.setStroke(GRAPH_STROKE);
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(pointColor);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - pointWidth / 2;
			int y = graphPoints.get(i).y - pointWidth / 2;
			int ovalW = pointWidth;
			int ovalH = pointWidth;
			g2.fillOval(x, y, ovalW, ovalH);
		}
	}

	private int getMinScore() {
		return 0;
	}

	private int getMaxScore() {
		int maxScore = Integer.MIN_VALUE;
		for (Integer score : scores) {
			maxScore = Math.max(maxScore, score);
		}
		if (maxScore <= 0) {
			return 10;
		}
		return maxScore;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
		invalidate();
		this.repaint();
	}

	public List<Integer> getScores() {
		return scores;
	}
}
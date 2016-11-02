package se.kungsbacka.basket.GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	private int padding = 120;
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

	public GraphPanel(final Player player) {
		scores = new ArrayList<Integer>();
		games = player.getGames();

		setLayout(null);

		playerName = new JLabel(player.getName());
		playerName.setBounds(300, 450, 300, 100);
		Font font = new Font("Verdana", Font.BOLD, 20);
		playerName.setFont(font);
		add(playerName);

		foulsButton = new JButton("FOUL");
		foulsButton.setBounds(10, 10, 70, 40);
		add(foulsButton);

		twoPointAttemptButton = new JButton("FGA");
		twoPointAttemptButton.setBounds(85, 10, 70, 40);
		add(twoPointAttemptButton);

		twoPointMadeButton = new JButton("FGM");
		twoPointMadeButton.setBounds(160, 10, 70, 40);
		add(twoPointMadeButton);

		twoPointProcentButton = new JButton("FG%");
		twoPointProcentButton.setBounds(235, 10, 70, 40);
		add(twoPointProcentButton);

		threePointAttemptButton = new JButton("3PA");
		threePointAttemptButton.setBounds(310, 10, 70, 40);
		add(threePointAttemptButton);

		threePointMadeButton = new JButton("3PM");
		threePointMadeButton.setBounds(385, 10, 70, 40);
		add(threePointMadeButton);

		threePointProcentButton = new JButton("3P%");
		threePointProcentButton.setBounds(460, 10, 70, 40);
		add(threePointProcentButton);

		totalShotsAttemptButton = new JButton("TSA");
		totalShotsAttemptButton.setBounds(535, 10, 70, 40);
		add(totalShotsAttemptButton);

		totalShotsMadeButton = new JButton("TSM");
		totalShotsMadeButton.setBounds(610, 10, 70, 40);
		add(totalShotsMadeButton);

		totalShotsProcentButton = new JButton("TS%");
		totalShotsProcentButton.setBounds(685, 10, 70, 40);
		add(totalShotsProcentButton);

		freeThrowAttemptButton = new JButton("FTA");
		freeThrowAttemptButton.setBounds(760, 10, 70, 40);
		add(freeThrowAttemptButton);

		// ------
		freeThrowMadeButton = new JButton("FTM");
		freeThrowMadeButton.setBounds(10, 55, 70, 40);
		add(freeThrowMadeButton);

		freeThrowProcentButton = new JButton("FT%");
		freeThrowProcentButton.setBounds(85, 55, 70, 40);
		add(freeThrowProcentButton);

		pointsButton = new JButton("PTS");
		pointsButton.setBounds(160, 55, 70, 40);
		add(pointsButton);

		defReboundsButton = new JButton("DEFR");
		defReboundsButton.setBounds(235, 55, 70, 40);
		add(defReboundsButton);

		offReboundsButton = new JButton("OFFR");
		offReboundsButton.setBounds(310, 55, 70, 40);
		add(offReboundsButton);

		totalReboundsButton = new JButton("TOT");
		totalReboundsButton.setBounds(385, 55, 70, 40);
		add(totalReboundsButton);

		stealsButton = new JButton("STL");
		stealsButton.setBounds(460, 55, 70, 40);
		add(stealsButton);

		blocksButton = new JButton("BLK");
		blocksButton.setBounds(535, 55, 70, 40);
		add(blocksButton);

		turnoversButton = new JButton("TO");
		turnoversButton.setBounds(610, 55, 70, 40);
		add(turnoversButton);

		assistsButton = new JButton("ASS");
		assistsButton.setBounds(685, 55, 70, 40);
		add(assistsButton);

		deflectionsButton = new JButton("DEFL");
		deflectionsButton.setBounds(760, 55, 70, 40);
		add(deflectionsButton);

		foulsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add(player2.getFouls());
				}
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
				setScores(scores);
			}
		});
		twoPointProcentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add((int) HelperClass.getTwoPointProcent(player2.getTwoPointAttempt(), player2.getTwoPointMade()));
				}
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
				setScores(scores);
			}
		});
		threePointProcentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scores.clear();
				for (Game game : games) {
					Player player2 = game.getPlayer(player.getName());
					scores.add((int) HelperClass.getThreePointProcent(player2.getThreePointAttempt(), player2.getThreePointMade()));
				}
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

		int xScale = ((int) getWidth() - (2 * padding) - labelPadding)
				/ (scores.size() - 1);
		int yScale = ((int) getHeight() - 2 * padding - labelPadding)
				/ (getMaxScore() - getMinScore());

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < scores.size(); i++) {
			int x1 = (int) (i * xScale + padding + labelPadding);
			int y1 = (int) ((getMaxScore() - scores.get(i)) * yScale + padding);
			graphPoints.add(new Point(x1, y1));
		}

		// draw white background
		g2.setColor(Color.WHITE);
		g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding)
				- labelPadding, getHeight() - 2 * padding - labelPadding);
		g2.setColor(Color.BLACK);

		// create hatch marks and grid lines for y axis.
		for (int i = 0; i < numberYDivisions + 1; i++) {
			int x0 = padding + labelPadding;
			int x1 = pointWidth + padding + labelPadding;
			int y0 = getHeight()
					- ((i * (getHeight() - padding * 2 - labelPadding))
							/ numberYDivisions + padding + labelPadding);
			int y1 = y0;
			if (scores.size() > 0) {
				g2.setColor(gridColor);
				g2.drawLine(padding + labelPadding + 1 + pointWidth, y0,
						getWidth() - padding, y1);
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
				int x0 = i * (getWidth() - padding * 2 - labelPadding)
						/ (scores.size() - 1) + padding + labelPadding;
				int x1 = x0;
				int y0 = getHeight() - padding - labelPadding;
				int y1 = y0 - pointWidth;
				if ((i % ((int) ((scores.size() / 20)) + 1)) == 0) {
					g2.setColor(gridColor);
					g2.drawLine(x0, getHeight() - padding - labelPadding - 1
							- pointWidth, x1, padding);
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
		g2.drawLine(padding + labelPadding, getHeight() - padding
				- labelPadding, padding + labelPadding, padding);
		g2.drawLine(padding + labelPadding, getHeight() - padding
				- labelPadding, getWidth() - padding, getHeight() - padding
				- labelPadding);

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

	// @Override
	// public Dimension getPreferredSize() {
	// return new Dimension(width, heigth);
	// }

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
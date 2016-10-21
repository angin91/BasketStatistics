package se.kungsbacka.basket.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	public JPanel panel = new JPanel();
	public JButton newGameButton = new JButton("New game");
	public JList gameList;
	
	public static void main(String [] args){
		new Frame();
	}
	
	public Frame(){
		super("Basket statistics");
		setSize(1400, 1000);
		setResizable(true);
		
		newGameButton.setBounds(1150, 810, 200, 100);
		
		gameList = new JList();
		
		add(newGameButton);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToe {
	public static final int BOARD_SIDE = 444;
	public static final int SQUARE_SIDE = 148;
	public static final int WINDOW_X = 400;
	public static final int WINDOW_Y = 200;


	public static void main(String[] args) {
		JFrame mainWindow = new JFrame();
		mainWindow.setTitle("Tic Tac Toe Game");
		mainWindow.setSize(BOARD_SIDE, BOARD_SIDE);
		mainWindow.setLocation(WINDOW_X, WINDOW_Y);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color myColor = new Color(0,0,0);
		ISUBoard isuB = new ISUBoard(myColor, Color.white);

		mainWindow.add(isuB);

		mainWindow.pack();
		mainWindow.setVisible(true);
	}
}
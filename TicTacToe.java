import hsa.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToe {
    public static final int BOARD_SIDE = 444;
    public static final int SQUARE_SIDE = 148;
    public static final int WINDOW_X = 400;
    public static final int WINDOW_Y = 200;

    static Console c = new Console();
    
    public static void drawGrid() {
	c.setColor(Color.black);
	c.drawLine(SQUARE_SIDE,0,SQUARE_SIDE,BOARD_SIDE);
	c.drawLine(SQUARE_SIDE*2,0,SQUARE_SIDE*2,BOARD_SIDE);
	c.drawLine(0,SQUARE_SIDE,BOARD_SIDE,SQUARE_SIDE);
	c.drawLine(0,SQUARE_SIDE*2,BOARD_SIDE,SQUARE_SIDE*2);
    }
    
    public static void main(String[] args) {
	JFrame mainWindow = new JFrame();
	mainWindow.setTitle("Tic Tac Toe - Computer Science 11 ICS3U ACCI");
	mainWindow.setSize(BOARD_SIDE, BOARD_SIDE);
	mainWindow.setLocation(WINDOW_X, WINDOW_Y);
	mainWindow.setResizable(false);
	mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container board = mainWindow.getContentPane();
	Color myColor = new Color(0,0,0);
	ISUBoard isuB = new ISUBoard(myColor, Color.white);
	board.add(isuB);
	
	mainWindow.setContentPane(board);
	mainWindow.pack();
	mainWindow.setVisible(true);
    }

    
    public static void drawX(int x, int y) {
	final int HALF_ARM = SQUARE_SIDE / 4;
	final int ARM_LENGTH = SQUARE_SIDE / 2;
	c.setColor(Color.white);
	c.drawLine(x-HALF_ARM,y-HALF_ARM,x-HALF_ARM+ARM_LENGTH,y-HALF_ARM+ARM_LENGTH);
	c.drawLine(x+HALF_ARM,y-HALF_ARM,x+HALF_ARM-ARM_LENGTH,y-HALF_ARM+ARM_LENGTH);
    }
    
    public static void drawO(int x, int y) {
	final int CIRCLE_DIAMETER = SQUARE_SIDE / 2;
	final int CIRCLE_RADIUS = CIRCLE_DIAMETER / 2;
	c.setColor(Color.white);
	c.drawOval(x-CIRCLE_RADIUS,y-CIRCLE_RADIUS,CIRCLE_DIAMETER,CIRCLE_DIAMETER);
    }
    
    
}

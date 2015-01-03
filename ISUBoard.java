import hsa.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ISUBoard extends JPanel
{
    private int currentPlayer = 1;
    private static final int SQUARE_SIDE = TicTacToe.BOARD_SIDE / 3;
    private Color penColor = Color.black;

    private int xMouse = -1;
    private int yMouse = -1;

    public ISUBoard ()
    {
    }

    private void drawXorO(Graphics board, int player) {
	if (player == 1) {
	    drawO(board);
	}
	
	else if (player == 2) {
	    drawX(board);
	}
    }
    
    public ISUBoard (Color boardColor, Color pc)
    {
	for (int row = 0; row < ISU2DArray.ROWS; row++) {
	    for (int col = 0; col < ISU2DArray.COLUMNS; col++) {
		ISU2DArray.matrix[row][col] = 0;
	    }
	}
	this.setBackground (boardColor);
	penColor = pc;
	this.setPreferredSize (new Dimension (TicTacToe.BOARD_SIDE, TicTacToe.BOARD_SIDE));

	addMouseListener (new MoveListener ());
    }


    public void paintComponent (Graphics board)
    {
	super.paintComponent (board);
	drawGrid (board);
	
	for (int row = 0; row < ISU2DArray.ROWS; row++) {
	   for (int col = 0; col < ISU2DArray.COLUMNS; col++) {
		xMouse = col * SQUARE_SIDE + SQUARE_SIDE / 2;
		yMouse = row * SQUARE_SIDE + SQUARE_SIDE / 2;
		drawXorO(board, ISU2DArray.matrix[row][col]);
	    }
	}
    }


    private void drawGrid (Graphics c)
    {
	c.setColor (penColor.white);
	c.drawLine (SQUARE_SIDE, 0, SQUARE_SIDE, TicTacToe.BOARD_SIDE);
	c.drawLine (SQUARE_SIDE * 2, 0, SQUARE_SIDE * 2, TicTacToe.BOARD_SIDE);
	c.drawLine (0, SQUARE_SIDE, TicTacToe.BOARD_SIDE, SQUARE_SIDE);
	c.drawLine (0, SQUARE_SIDE * 2, TicTacToe.BOARD_SIDE, SQUARE_SIDE * 2);
    }


    private void drawX (Graphics c)
    {
	final int HALF_ARM = SQUARE_SIDE / 4;
	final int ARM_LENGTH = SQUARE_SIDE / 2;
	c.setColor (Color.white);
	c.drawLine (xMouse - HALF_ARM, yMouse - HALF_ARM, xMouse - HALF_ARM + ARM_LENGTH, yMouse - HALF_ARM + ARM_LENGTH);
	c.drawLine (xMouse + HALF_ARM, yMouse - HALF_ARM, xMouse + HALF_ARM - ARM_LENGTH, yMouse - HALF_ARM + ARM_LENGTH);
    }


    private void drawO (Graphics c)
    {
	final int CIRCLE_DIAMETER = SQUARE_SIDE / 2;
	final int CIRCLE_RADIUS = CIRCLE_DIAMETER / 2;
	c.setColor (penColor.white);
	c.drawOval (xMouse - CIRCLE_RADIUS, yMouse - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
    }


    private static int checkWinner ()
    {
	String gameStr = "";
	for (int row = 0 ; row < ISU2DArray.ROWS ; row++)
	{
	    for (int column = 0 ; column < ISU2DArray.COLUMNS ; column++)
	    {
		gameStr = gameStr + ISU2DArray.matrix [row] [column];
	    }
	}

	for (int column = 0 ; column < ISU2DArray.COLUMNS ; column++)
	{
	    for (int row = 0 ; row < ISU2DArray.ROWS ; row++)
	    {
		gameStr = gameStr + ISU2DArray.matrix [row] [column];
	    }
	}

	for (int i = 0 ; i < ISU2DArray.ROWS ; i++)
	{
	    gameStr = gameStr + ISU2DArray.matrix [i] [i];
	}

	for (int i = 0 ; i < ISU2DArray.ROWS ; i++)
	{
	    gameStr = gameStr + ISU2DArray.matrix [ISU2DArray.ROWS - i - 1] [i];
	}


	for (int i = 0 ; i < gameStr.length () ; i = i + 3)
	{
	    if (gameStr.substring (i, i + 3).equals ("111"))
	    {
		return (1);
	    }
	}
	for (int i = 0 ; i < gameStr.length () ; i = i + 3)
	{
	    if (gameStr.substring (i, i + 3).equals ("222"))
	    {
		return (2);
	    }
	}
	for (int i = 0 ; i < gameStr.length () ; i = i + 3)
	{
	    if (gameStr.indexOf ("0") != -1)
	    {
		return (0);
	    }
	}
	return (-1);
    }


    private class MoveListener extends MouseAdapter implements ActionListener
    {
	public MoveListener ()
	{
	}

	public void mouseClicked (MouseEvent me)
	{
	    xMouse = me.getX ();
	    yMouse = me.getY ();
	    xMouse = ((xMouse / SQUARE_SIDE) * SQUARE_SIDE) + (SQUARE_SIDE / 2);
	    yMouse = ((yMouse / SQUARE_SIDE) * SQUARE_SIDE) + (SQUARE_SIDE / 2);
	    Graphics board = getGraphics ();

	}

	public void actionPerformed (ActionEvent me)
	{
	}
	private void drawGameEnd(Graphics board, String msg){
	    board.setColor(penColor);
	    board.setFont(new Font("sansserif", Font.PLAIN, 40));
	    board.drawString(msg, 80, 200);
	}
	public void mousePressed (MouseEvent me)
	{
	    int row = -1;
	    int column = -1;
	    if (checkWinner() == 0) {
		yMouse = me.getY();
		xMouse = me.getX();
		xMouse = ((xMouse / SQUARE_SIDE) * SQUARE_SIDE) + (SQUARE_SIDE / 2);
		yMouse = ((yMouse / SQUARE_SIDE) * SQUARE_SIDE) + (SQUARE_SIDE / 2);
		if (yMouse <= 148) {
		    row = 0;
		}
		else if (yMouse <= 296) { 
		    row = 1;
		}
		else {
		    row = 2;
		}
		if (xMouse <= 148) {
		    column = 0;
		}
		else if (xMouse <= 296) {
		    column = 1;
		}
		else {
		    column = 2;
		}
	    }
	    
	    if(ISU2DArray.matrix[row][column] == 0){
		ISU2DArray.matrix[row][column] = currentPlayer;
		Graphics board = getGraphics();
		drawXorO(board, currentPlayer);
	    }
	    
	    Graphics board = getGraphics();
	    
	    int winner = checkWinner();
	    if (winner == 0) {
		if (currentPlayer == 1){
		    currentPlayer = 2;
		}
		else {
		    currentPlayer = 1;
		} 
	    }
	    else if (winner == -1) {
		drawGameEnd(board, "Game is a tie");
	    }
	    else { 
		drawGameEnd(board, "PLAYER " + winner + " WINS");
	    }
	}
	
	
	public void mouseEntered (MouseEvent me)
	{
	}
	public void mouseReleased (MouseEvent me)
	{
	}
	public void mouseExited (MouseEvent me)
	{
	}

    }
}

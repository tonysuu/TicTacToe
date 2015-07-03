public class ISU2DArray {
	public  static final int ROWS = 3;
	public  static final int COLUMNS = 3;
	public static int [][] matrix = new int[ROWS][COLUMNS];


	private static int checkWinner() {
		String gameStr = "";
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				gameStr = gameStr + matrix[row][column];
			}
		}

		for (int column = 0; column < COLUMNS; column++) {
			for (int row = 0; row < ROWS; row++) {
				gameStr = gameStr + matrix[row][column];
			}
		}

		for (int i = 0; i < ROWS; i++) {
			gameStr = gameStr + matrix[i][i];
		} 

		for (int i = 0; i < ROWS; i++) {
			gameStr = gameStr + matrix[ROWS - i - 1][i];
		}


		for (int i = 0; i < gameStr.length(); i = i + 3) {
			if (gameStr.substring(i, i + 3).equals("111")) {
				return(1);
			}
		}
		for (int i = 0; i < gameStr.length(); i = i + 3) {
			if (gameStr.substring(i, i + 3).equals("222")) {
				return (2);
			}
		}

		if (gameStr.indexOf("0") != -1) {
			return (0);
		}
		return (-1);
	}

	public static void main(String [] args) {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				matrix[row][col] = 0;
			}
		}

		System.out.println(checkWinner());
	}
	public static void clear(){
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				matrix[row][col] = 0;
			}
		}
	}

}
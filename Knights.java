
public class Knights {
	private long steps;
	private int[][] board;
	int size;
	int rows;
	int cols;
	
	public Knights( int s) {
		board = new int[s][s];
		size = s;
		rows = s;
		cols = s;
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public void displayBoard() {
		for(int []row : board) {
			for(int col : row)
				System.out.printf("%,3d", col);
			System.out.println();
		}
		System.out.println();
	}
	
	public int getSize() {
		return size;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	private boolean move(int startX, int startY) {
		return move(startX, startY, 1);
	}
	
	private boolean move(int i, int j, int moveNum) {
		steps++;
		
		if(i < 0 || j < 0 || i >= rows || j >= cols)
			return false;
		if(board[i][j] > 0)
			return false;
		board[i][j] = moveNum;
		if(moveNum == rows * cols)
			return true;
		
		int[] myHorizMove = {0, 1,1, -1, -1, 2, 2, -2 , -2}; //
		int[] myVertMove = {0, -2, 2,-2, 2,1,-1,-1,1};
		
		for(int c = 0; c < 8; c++) {
			int nextI = i + myHorizMove[c];
			int nextJ = j + myVertMove[c];
			
			displayBoard();
			
			if(move(nextI, nextJ, moveNum + 1)) {
				return true;
			}
		}
		
		board[i][j] = 0;
		displayBoard();
		return false;

	}
		
	public static void main (String[]args) {
		int size = 5;
		Knights one = new Knights(size); 
		one.move(0, 0);
		one.getBoard();
		one.displayBoard();
		System.out.println();		
	}
	
}

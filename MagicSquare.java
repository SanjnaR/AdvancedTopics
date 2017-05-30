import java.util.ArrayList;
import java.util.Random;
public class MagicSquare {

	private long steps;
	private static int[][] board;
	private int size;
	ArrayList<Integer> poss;
	private int sum;
	
	public MagicSquare(int size) {
		board = new int[size][size];
		steps = 0;
		this.size = size;
		poss = getList(size*size);
		sum = size*(size*size+1/2);
	}
	
	public static ArrayList<Integer> getList(int size) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 1; i < size; i++) {
			temp.add(i);
		}
		return temp;
	}
		
		boolean checkRowSum(int r) {
			int rSum = 0;
			for(int c = 0; c <= size; c++) {
				rSum += board[r][c];
			}
			return rSum == sum;
		}
		
		boolean checkColSum(int c) {
			int cSum = 0;
			for(int r = 0; r < size; r++) {
				cSum += board[r][c];
			}
			return cSum == sum;
		}
	
	
	void fillBoard() {
		fillBoard(0);
	}
	
	boolean fillBoard(int r) {
//		for(int r = 0; r < size; r++) {
//			for(int c = 0; c < r; c++) {
//				board[r][c] = (int) Math.random() * size;
//			}
//		}
		steps++;
		if(board[size - 1][size - 1] != 0) {
			System.out.println("DONE");
			return true;
		}
		Random gen = new Random();
		
		for(int c= 0; c < size; c++) {
			Integer next = poss.get(gen.nextInt(poss.size()));
			poss.remove(next);
			board[r][c] = next;
		}
		if(!checkRowSum(r)) {
			for(int c =0; c< size; c++) {
				poss.add(board[r][c]);
				board[r][c] = 0;
			}
			fillBoard(r);
			return false;		
		}
		
		fillBoard(r+1);
		return true;	
	}
	
	public long getSteps() {
		return steps;
	}
	
	public int[][] getBoard() {
		return board;
	}
	
//	public int[][] display() {
//		
//	}
	
	
	
}

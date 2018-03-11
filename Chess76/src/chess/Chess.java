package chess;

public class Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessBoard game= new ChessBoard();  
		game.makeBoard();
		game.printBoard();
		String[][] board= game.pboard; 
		for (String[] x : board)
		{
		   for (String y : x)
		   {
		        System.out.print(y + " ");
		   }
		   System.out.println();
		}
	}

}

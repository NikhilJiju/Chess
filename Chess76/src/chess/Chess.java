package chess;

import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ChessBoard game= new ChessBoard();  
		int counter=0; 
		game.makeBoard();
		while(true){
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
			System.out.println();
			if(counter%2==0){
				System.out.print("White's move: ");
			}
			else{
				System.out.print("Black's move: ");
			}
			String move= scanner.nextLine(); 
			System.out.println();
			counter++; 
		}
	}

}

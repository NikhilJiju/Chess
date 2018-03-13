package chess;

import java.util.Scanner;
/**
 * This is the main class in the package. It handles user inputs and creates a chess game by making a ChessBoard object. 
 * @author 
 *
 */
public class Chess {
	/**
	 * Main method. The method takes in user input based on a counter that is incremented each time a player inputs a move
	 * deemed valid within the methods. If the counter is even, then the method takes input from player white. If counter 
	 * is odd then it will take input from player black. 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ChessBoard game= new ChessBoard();  
		int counter=0; 
		boolean print= true; 
		game.makeBoard();
		String color; 
		while(true){
			if(print){ 			//only print board again if player has entered a valid move. 
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
			}
			if(counter%2==0){
				color="w"; 
				System.out.print("White's move: ");
			}
			else{
				color="b"; 
				System.out.print("Black's move: ");
			} 
			print= true; 
			String move= scanner.nextLine(); 
			if(!game.makeMove(color,move)){
				counter--; 
				print= false; // no need to print the board again. 
			}
			counter++; 
			System.out.println();
			
		}
	}

}

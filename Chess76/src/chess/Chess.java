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
		while(!game.kingCaptured){
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
				if(game.white_on_check){
					System.out.println("Check");
				}
				System.out.print("White's move: ");
			}
			else{
				color="b"; 
				if(game.black_on_check){
					System.out.println("check");
				}
				System.out.print("Black's move: ");
			} 
			print= true; 
			String move= scanner.nextLine(); 
			//implementation of resign 
			if(move.equals("resign")){
				if(color.equals("w")){
					System.out.println("Black wins");
				}
				else{
					System.out.println("White wins");
				}
				break; 
			}
			//implementation of draw 
			if(game.drawRequest){
				if (move.equals("draw")){
					break; 
				}
				else{
					game.drawRequest= false; 
				}
			}
			if(move.equals("draw")){
				System.out.println("Illegal move, try again");
				print=false;  
				continue; 
			}
			String[] moves= move.split(" ");
			if(moves.length==3){
				if (moves[2].equals("draw?")){
					game.drawRequest=true; 
				}
			}

			if(!game.makeMove(color,move)){
				counter--; 
				print= false; // no need to print the board again. 
			}
			counter++; 
			System.out.println();
			
		}
	}

}

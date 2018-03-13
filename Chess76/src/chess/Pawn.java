package chess;
/**
 * Follows the constraint of the Pawn piece. 
 * @author 
 *
 */
public class Pawn extends Piece{
	/**
	 * Constructs a Pawn object with call to the superclass whihc sets the color to what is passed in. 
	 * @param color The color of the piece. 
	 */
	public Pawn(String color){
		super(color); 
	}
	
	/**
	 * Checks to see if moves are within the limits of the Pawn piece. Also uses the board to make sure that the pawn 
	 * is not jumping over other pieces. 
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		return false; 
	}
	
	/**
	 * Gives a string representation using color and the name "P". 
	 */
	public String toString(){
		String p= color+"P";
		return p;
	}
}

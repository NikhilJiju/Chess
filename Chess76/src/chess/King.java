package chess;
/**
 * Follows the constraint of the King Piece
 * @author 
 * 
 */
public class King extends Piece{ 
	/**
	 * Constructs the class with a call to super with the given color. 
	 * @param color The color of the piece
	 */
	public King(String color){
		super(color);
	}
	
	/**
	 * Checks to see if the move is possible for the King and also if there is any piece in the way of where the king 
	 * wants to move to. 
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		return false; 
	}
	
	/**
	 * Gives the string representation using the color of the piece and the name of the piece as "K". 
	 */
	public String toString(){
		String p= color+"K";
		return p;
	}
}

package chess;
/**
 * 
 * @author 
 * This is the superclass Piece. It is the abstract definition of each Piece on the board and is further defined 
 * by its subclasses. 
 *
 */
public class Piece {
	/**
	 * The field color keeps track of the color of each piece and is represented as "w" for white and "b" for black. 
	 */
	String color; 
	/**
	 * Constructor with the color value set. 
	 * @param color the color of the piece 
	 */
	public Piece(String color){
		this.color=color; 
	}
	
	/**
	 * This is the move method which will take the start position of a piece and end position of the piece to see if 
	 * a move is possible. It is defined by each subclass based on the constraint of how each piece can move. 
	 * @param x Current x index of the piece
	 * @param y	Current y index of the piece
	 * @param a	Future x index of the piece
	 * @param b Future y index of the piece 
	 * @param board The current board is passed in to see if there are pieces in the path 
	 * @return boolean value on weather or not a move is possible 
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		return false;
	}
	
	/**
	 * Gives a string representation of the piece. This method is only here so that it will be redefined in the subclasses. 
	 */
	public String toString(){
		return ""; 
	}
	
}

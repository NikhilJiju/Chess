package chess;
/**
 * Follows the constraints of the Queen piece 
 * @author 
 */
public class Queen extends Piece{
	/**
	 * 	Constructs a Queen object with a call to super class that sets the color of the piece 
	 * @param color The color of the piece 
	 */
	public Queen(String color){
		super(color); 
	}
	
	/**
	 * Returns true if the piece is moved to a location that is allowable for a queen in a chess game. This constraints 
	 * are a combination of the Rooks and the Bishops. 
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		if(Math.abs(x-a)==Math.abs(y-b)){
			return true; 
		} 
		if(x-a==0 || y-b==0){
			return true; 
		}
		return false; 
	}
	
	/**
	 * Returns the string representation of Queen with color and name "Q". 
	 */
	public String toString(){
		String p= color+"Q";
		return p;
	}
}

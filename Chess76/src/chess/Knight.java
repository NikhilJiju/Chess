package chess;
/**
 * Follows the constraint of the Knight Class
 * @author 
 */
public class Knight extends Piece{
	/**
	 * Constructor which calls superclass and sets the value of the color to what is passed in 
	 * @param color Color of the piece 
	 */
	public Knight(String color){
		super(color); 
	}
	
	/**
	 * Checks to see if moves are within the constraints of what the Knight can move. Although board is passed in, it is not used here since the
	 * Knight can jump over pieces. 
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		if(Math.abs(Math.abs(x-a)-Math.abs(y-b))==1){
			return true; 
		}
		return false; 
	}
	
	/**
	 * Gives a string representation of Knight by using the color and name "N" 
	 */
	public String toString(){
		String p= color+"N";
		return p;
	}
}

package chess;
/**
 * Follows the constraints of the Bishop piece
 * @author 
 *
 */
public class Bishop extends Piece{
	/**
	 * 	Constructs the class with a call to super which sets which color the piece is 
	 * @param color The color of the piece
	 */
	public Bishop(String color){
		super(color); 
	}
	
	/**
	 * Checks to see if move is possible for a bishop. This means that if the bishop moves a certain amount in the 
	 * x direction it should move the same amount in the y direction. Also the board is used to see if there is a piece 
	 * in the path.  
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		if(Math.abs(x-a)==Math.abs(y-b)){
			int startx= Math.min(x, a); 
			int i= startx; 
			int endx= Math.max(x, a);
			int starty= Math.min(y, b); 
			int j= starty;  
			while(i<endx){
				if(board[i][j]!=null){
					return false; 
				}
				i++; 
				j++; 
			}
			return true; 
		}
		return false; 
	}
	
	/**
	 * Gives a string representation of the object as shown in the assignment. The color and the object type is used 
	 * in the string representation. 
	 */
	public String toString(){
		String p= color+"B";
		return p;
	}
}

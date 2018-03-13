package chess;
/**
 * Follows the constraint of the Rook Piece. 
 * @author Jiju
 *
 */
public class Rook extends Piece{
	/**
	 * Constructs Rook with a call to the superclass that sets the color to what is passed in. 	
	 * @param color The color of the piece. 
	 */
	public Rook(String color){
		super(color); 
	}
	
	/**
	 * Checks to see if the piece moves in a manner a Rook can. This means that all moves are either horizontal or vertical. 
	 * The board is used to make sure there are no pieces in the path of which the Rook has moved.  
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		if(x-a==0||y-b==0){
			if(x-a==0){ //horizontal movement
				int start= Math.min(y, b); 
				int end= Math.max(y, b); 
				for(int i=start; i<end; i++){
					if(board[x][i]!=null){
						return false; 
					}
				}
			}
			else{//vertical movement 
				int start= Math.min(x, a); 
				int end= Math.max(x, a); 
				for(int j=start; j<end; j++){
					if(board[j][y]!=null){
						return false; 
					}
				}
			}
			return true; 
		}
		return false; 
	}
	
	/**
	 * Gives a string representation of the object using color and the name "R". 
	 */
	public String toString(){
		String p= color+"R";
		return p;
	}
}

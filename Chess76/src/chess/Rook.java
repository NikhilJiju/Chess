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
			System.out.println("entered");
			if(x-a==0){ //horizontal movement
				if(Math.min(y, b)==b){ 
					for(int i=b+1; i<y; i++){
						if(board[x][i]!=null){
							return false; 
						}
					}
				}
				else if(Math.min(y, b)==y){
					for(int i=b-1; i>y; i--){
						if(board[x][i]!=null){
							return false; 
						}
					}
				}
			}
			else{//vertical movement 
				if(Math.min(x, a)==a){ 
					for(int j=a+1; j<x; j++){
						if(board[j][y]!=null){
							return false; 
						}
					}
				}
				else if(Math.min(x, a)==x){
					for(int j=a-1; j>x; j--){
						if(board[j][y]!=null){
							return false; 
						}
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

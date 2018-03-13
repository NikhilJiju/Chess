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
		if(y-b==0){
			if(x==6 && (x-a)==2 && board[5][y]==null){
				return true;
			}
			if(x==1 && (a-x)==2 && board[2][y]==null){
				return true; 
			}
			if(board[x][y].color.equals("w")){
				if((x-a)==1){
					return true; 
				}
			}
			if(board[x][y].color.equals("b")){
				if((a-x)==1){
					return true; 
				}
			}
		} 
		if(Math.abs(x-a)==1 && Math.abs(y-b)==1){ //case where the pawn is killing a piece 
			if(board[x][y].color.equals("w") && (x-a)==1){
				if(board[a][b]!=null && board[a][b].color.equals("b")){
					return true; 
				}
			}
			if(board[x][y].color.equals("b") && (a-x)==1){
				if(board[a][b]!=null && board[a][b].color.equals("w")){
					return true; 
				}
			}
		}
		
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

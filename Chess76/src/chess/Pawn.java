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
	boolean enpassant;
	int enpassantcount; 
	public Pawn(String color){
		super(color); 
		enpassant= false; 
		enpassantcount= 0; 
	}
	
	/**
	 * Checks to see if moves are within the limits of the Pawn piece. Also uses the board to make sure that the pawn 
	 * is not jumping over other pieces. 
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		if(y-b==0){
			if(x==6 && (x-a)==2 && board[5][y]==null){
				//ChessBoard.enpassant_next= true; 
				enpassant= true; 
				return true;
			}
			if(x==1 && (a-x)==2 && board[2][y]==null){
				//ChessBoard.enpassant_next= true; 
				enpassant= true; 
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
				/*else if(ChessBoard.enpassant && board[2][b]==null && board[3][b]!=null && board[3][b].toString().equals("bP")){
					board[3][b]= null; 
					return true; 
				}*/
				else if(board[2][b]==null && board[3][b]!=null && board[3][b].toString().equals("bP")){
					Pawn opp= (Pawn) board[3][b];
					if(opp.enpassant){
						System.out.println(opp.enpassantcount);
						board[3][b]= null; 
						return true;
					}
					
				}
			}
			if(board[x][y].color.equals("b") && (a-x)==1){
				if(board[a][b]!=null && board[a][b].color.equals("w")){
					return true; 
				}
				/*else if(ChessBoard.enpassant && board[a][b]==null && board[a-1][b]!=null && board[a-1][b].toString().equals("wP")){
					board[a-1][b]= null;
					return true; 
				}*/
				else if(board[a][b]==null && board[a-1][b]!=null && board[a-1][b].toString().equals("wP")){
					Pawn opp= (Pawn) board[a-1][b];
					if(opp.enpassant){
						board[a-1][b]= null; 
						return true;
					}
					
					
				}			
			}
		}
	
		return false; 
	}
	
	public boolean check(int x, int y, Piece[][] board){
		if(color.equals("b")){
			if(y+1<8 && x+1<8 && board[x+1][y+1]!=null && board[x+1][y+1].toString().equals("wK")) {
				return true;
			}
			if(y-1>=0 && x+1<8 && board[x+1][y-1]!=null && board[x+1][y-1].toString().equals("wK")) {
				return true;
			}
		}
		if(color.equals("w")){
			if(y+1<8 && x-1>=0 &&  board[x-1][y+1]!=null && board[x-1][y+1].toString().equals("bK")){
				return true; 
			}
			if(y-1>=0 && x-1>=0 &&  board[x-1][y-1]!=null && board[x-1][y-1].toString().equals("bK")){
				return true; 
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

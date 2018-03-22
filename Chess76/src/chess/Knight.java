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
		if(Math.abs(x-a)==2 && Math.abs(y-b)==1){
			return true; 
		}
		else if(Math.abs(x-a)==1 && Math.abs(y-b)==2){
			return true; 
		}
		return false; 
	}
	/**
	 *  Checks if knight piece is in position to cause a check
	 */
	public boolean check(int x, int y, Piece[][] board){
		if(color.equals("b")){
			if(x+2<8 && y+1<8 && board[x+2][y+1]!=null && board[x+2][y+1].toString().equals("wK")){
				return true; 
			}
			if(x+2<8 && y-1>=0 && board[x+2][y-1]!=null && board[x+2][y-1].toString().equals("wK")){
				return true; 
			}
			if(x-2>=0 && y+1<8 && board[x-2][y+1]!=null && board[x-2][y+1].toString().equals("wK")){
				return true; 
			}
			if(x-2>=0 && y-1>=0 && board[x-2][y-1]!=null && board[x-2][y-1].toString().equals("wK")){
				return true; 
			}
			
			if(y+2<8 && x+1<8 && board[x+1][y+2]!=null && board[x+1][y+2].toString().equals("wK")){
				return true; 
			}
			if(y+2<8 && x-1>=0 && board[x-1][y+2]!=null && board[x-1][y+2].toString().equals("wK")){
				return true; 
			}
			if(y-2>=0 && x+1<8 && board[x+1][y-2]!=null && board[x+1][y-2].toString().equals("wK")){
				return true; 
			}
			if(y-2>=0 && x-1>=0 && board[x-1][y-2]!=null && board[x-1][y-2].toString().equals("wK")){
				return true; 
			}
		}
		if(color.equals("w")){
			if(x+2<8 && y+1<8 &&  board[x+2][y+1]!=null && board[x+2][y+1].toString().equals("bK")){
				return true; 
			}
			if(x+2<8 && y-1>=0 && board[x+2][y-1]!=null && board[x+2][y-1].toString().equals("bK")){
				return true; 
			}
			if(x-2>=0 && y+1<8 && board[x-2][y+1]!=null && board[x-2][y+1].toString().equals("bK")){
				return true; 
			}
			if(x-2>=0 && y-1>=0 && board[x-2][y-1]!=null && board[x-2][y-1].toString().equals("bK")){
				return true; 
			}
			
			if(y+2<8 && x+1<8 && board[x+1][y+2]!=null && board[x+1][y+2].toString().equals("bK")){
				return true; 
			}
			if(y+2<8 && x-1>=0 && board[x-1][y+2]!=null && board[x-1][y+2].toString().equals("bK")){
				return true; 
			}
			if(y-2>=0 && x+1<8 && board[x+1][y-2]!=null && board[x+1][y-2].toString().equals("bK")){
				return true; 
			}
			if(y-2>=0 && x-1>=0 && board[x-1][y-2]!=null && board[x-1][y-2].toString().equals("bK")){
				return true; 
			}
		}
		return false; 
	}
	
	public boolean stalemate(int x, int y, Piece[][] board, String colour){
		if(x+2<8 && y+1<8 && board[x+2][y+1]==null && ChessBoard.tryMove(x,y,x+2,y+1,board,board[x][y])){
			return false; 
		}
		if(x+2<8 && y-1>=0 && board[x+2][y-1]==null && ChessBoard.tryMove(x,y,x+2,y-1,board,board[x][y])){
			return false; 
		}
		if(x-2>=0 && y+1<8 && board[x-2][y+1]==null && ChessBoard.tryMove(x,y,x-2,y+1,board,board[x][y])){
			return false; 
		}
		if(x-2>=0 && y-1>=0 && board[x-2][y-1]==null && ChessBoard.tryMove(x,y,x-2,y-1,board,board[x][y])){
			return false; 
		}
		
		if(y+2<8 && x+1<8 && board[x+1][y+2]==null && ChessBoard.tryMove(x,y,x+1,y+2,board,board[x][y])){
			return false; 
		}
		if(y+2<8 && x-1>=0 && board[x-1][y+2]==null && ChessBoard.tryMove(x,y,x-1,y+2,board,board[x][y])){
			return false; 
		}
		if(y-2>=0 && x+1<8 && board[x+1][y-2]==null && ChessBoard.tryMove(x,y,x+1,y-2,board,board[x][y])){
			return false; 
		}
		if(y-2>=0 && x-1>=0 && board[x-1][y-2]==null && ChessBoard.tryMove(x,y,x-1,y-2,board,board[x][y])){
			return false; 
		}
		////////////////////////////////////////////
		if(x+2<8 && y+1<8 && board[x+2][y+1]!=null && !board[x+2][y+1].color.equals(colour) && ChessBoard.tryMove(x,y,x+2,y+1,board,board[x][y])){
			return false; 
		}
		if(x+2<8 && y-1>=0 && board[x+2][y-1]!=null && !board[x+2][y-1].color.equals(colour) && ChessBoard.tryMove(x,y,x+2,y-1,board,board[x][y])){
			return false; 
		}
		if(x-2>=0 && y+1<8 && board[x-2][y+1]!=null && !board[x-2][y+1].color.equals(colour) && ChessBoard.tryMove(x,y,x-2,y+1,board,board[x][y])){
			return false; 
		}
		if(x-2>=0 && y-1>=0 && board[x-2][y-1]!=null && !board[x-2][y-1].color.equals(colour) && ChessBoard.tryMove(x,y,x-2,y-1,board,board[x][y])){
			return false; 
		}
		
		if(y+2<8 && x+1<8 && board[x+1][y+2]!=null && !board[x+1][y+2].color.equals(colour) && ChessBoard.tryMove(x,y,x+1,y+2,board,board[x][y])){
			return false; 
		}
		if(y+2<8 && x-1>=0 && board[x-1][y+2]!=null && !board[x-1][y+2].color.equals(colour) && ChessBoard.tryMove(x,y,x-1,y+2,board,board[x][y])){
			return false; 
		}
		if(y-2>=0 && x+1<8 && board[x+1][y-2]!=null && !board[x+1][y-2].color.equals(colour) && ChessBoard.tryMove(x,y,x+1,y-2,board,board[x][y])){
			return false; 
		}
		if(y-2>=0 && x-1>=0 && board[x-1][y-2]!=null && !board[x-1][y-2].color.equals(colour) && ChessBoard.tryMove(x,y,x-1,y-2,board,board[x][y])){
			return false; 
		}
		return true; 
	}
	
	/**
	 * Gives a string representation of Knight by using the color and name "N" 
	 */
	public String toString(){
		String p= color+"N";
		return p;
	}
}

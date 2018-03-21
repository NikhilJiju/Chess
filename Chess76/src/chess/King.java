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
		if(Math.abs(x-a)==1 && (y-b)==0){
			return true; 
		}
		if(Math.abs(y-b)==1 && (x-a)==0){
			return true; 
		}
		if(Math.abs(x-a)==1 && Math.abs(y-b)==1){
			return true; 
		}
		return false; 
	}

	public boolean check(int x, int y, Piece[][] board){
		int origX = x;
		int origY = y;
		if(color.equals("b")){
			while(x+1<8) {//front
				x++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(y-1>=0) {//left
				y--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(y+1<8) {//right
				y++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x-1>=0) {//back
				x--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x+1<8 && y+1<8) {//front-right diagonal
				x++;y++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x+1<8 && y-1>=0) {//front-left diagonal
				x++;y--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x-1>=0 && y+1<8) {//back-right diagonal
				x--;y++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x-1>=0 && y-1>=0) {//back-left diagonal
				x--;y--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("wK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
		}
		if(color.equals("w")){
			while(x+1<8) {//front
				x++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(y-1>=0) {//left
				y--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(y+1<8) {//right
				y++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x-1>=0) {//back
				x--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;	
			
			while(x+1<8 && y+1<8) {//front-right diagonal
				x++;y++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x+1<8 && y-1>=0) {//front-left diagonal
				x++;y--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x-1>=0 && y+1<8) {//back-right diagonal
				x--;y++; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
			
			while(x-1>=0 && y-1>=0) {//back-left diagonal
				x--;y--; //move to next piece
				if (board[x][y]!=null) {
					if (board[x][y].toString().equals("bK")) {
						return true;
					}else {
						break;
					}
				}
			}
			
			x = origX; y = origY;
		}
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

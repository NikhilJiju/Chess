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
		}
		return false;
	}
	
	public boolean stalemate(int x, int y, Piece[][] board, String colour){
		//move up
		if(x+1<8 && board[x+1][y]==null && ChessBoard.tryMove(x,y,x+1,y,board,board[x][y])){
			return false; 
		}
		if(x+1<8 && board[x+1][y]!=null && !board[x+1][y].color.equals(colour) && ChessBoard.tryMove(x,y,x+1,y,board,board[x][y])){
			return false; 
		}
		//move down 
		if(x-1>=0 && board[x-1][y]==null && ChessBoard.tryMove(x,y,x-1,y,board,board[x][y])){
			return false; 
		}
		if(x-1>=0 && board[x-1][y]!=null && !board[x-1][y].color.equals(colour) && ChessBoard.tryMove(x,y,x-1,y,board,board[x][y])){
			return false; 
		}
		//move left 
		if(y-1>=0 && board[x][y-1]==null && ChessBoard.tryMove(x,y,x,y-1,board,board[x][y])){
			return false; 
		}
		if(y-1>=0 && board[x][y-1]!=null && !board[x][y-1].color.equals(colour) && ChessBoard.tryMove(x,y,x,y-1,board,board[x][y])){
			return false; 
		}
		//move right
		if(y+1<8 && board[x][y+1]==null && ChessBoard.tryMove(x,y,x,y+1,board,board[x][y])){
			return false; 
		}
		if(y+1<8 && board[x][y+1]!=null && !board[x][y+1].color.equals(colour) && ChessBoard.tryMove(x,y,x,y+1,board,board[x][y])){
			return false; 
		}
		return true; 
	}
	
	/**
	 * Gives a string representation of the object using color and the name "R". 
	 */
	public String toString(){
		String p= color+"R";
		return p;
	}
}

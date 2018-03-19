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
			if(Math.min(x, a)==a && Math.min(y, b)==b){ //Movement up and left
				int i=a+1; 
				int j=b+1; 
				while(i<x){
					System.out.println(i + " " + j);
					if(board[i][j]!=null){
						return false; 
					}
					i++; 
					j++; 
				}
				return true;
			}
			else if(Math.min(x, a)==a && Math.min(y, b)==y){ //Movement up and right
				int i=a+1; 
				int j=b-1; 
				System.out.println(i + " " + j);

				while(i<x){
					System.out.println(i + " " + j);
					if(board[i][j]!=null){
						return false; 
					}
					i++; 
					j--; 
				}
				return true;
			}
			else if(Math.min(x, a)==x && Math.min(y, b)==b){ //Movement down and left
				int i=a-1; 
				int j=b+1; 
				while(i>x){
					System.out.println(i + " " + j);
					if(board[i][j]!=null){
						return false; 
					}
					i--; 
					j++; 
				}
				return true;
			}
			else if(Math.min(x, a)==x && Math.min(y, b)==y){ //Movement down and right
				int i=a-1; 
				int j=b-1; 
				while(i>x){
					System.out.println(i + " " + j);
					if(board[i][j]!=null){
						return false; 
					}
					i--; 
					j--; 
				}
				return true;
			}
		}
		return false; 
	}
	
	public boolean check(int x, int y, Piece[][] board){
		int origX = x;
		int origY = y;
		if(color.equals("b")){
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
	 * Gives a string representation of the object as shown in the assignment. The color and the object type is used 
	 * in the string representation. 
	 */
	public String toString(){
		String p= color+"B";
		return p;
	}
}

package chess;

public class ChessBoard {
	Piece[][] board= new Piece[8][8]; //contains pieces objects
	String[][] pboard= new String[9][9]; //the string representation of the above array
	/**Initializes board and pboard*/
	public void makeBoard(){
		//fill second row black pawns
		for(int j=0;j<8;j++){
			board[1][j]=new Pawn("b"); ; 
		} 
		board[0][0]= new Rook("b");
		board[0][1]= new Knight("b"); 
		board[0][2]= new Bishop("b");  
		board[0][3]= new Queen("b"); 
		board[0][4]= new King("b"); 
		board[0][5]= new Bishop("b"); 
		board[0][6]= new Knight("b");
		board[0][7]= new Rook("b");
		//fill 7th row with white pawns 
		for(int j=0; j<8; j++){ 
			board[6][j]=new Pawn("w"); 
		}
		board[7][0]= new Rook("w");
		board[7][1]= new Knight("w"); 
		board[7][2]= new Bishop("w");  
		board[7][3]= new Queen("w"); 
		board[7][4]= new King("w"); 
		board[7][5]= new Bishop("w"); 
		board[7][6]= new Knight("w");
		board[7][7]= new Rook("w");
		
		//initialize the string version 
		pboard[8][0]=" a"; 
		pboard[8][1]=" b"; 
		pboard[8][2]=" c"; 
		pboard[8][3]=" d"; 
		pboard[8][4]=" e"; 
		pboard[8][5]=" f"; 
		pboard[8][6]=" g"; 
		pboard[8][7]=" h"; 
		pboard[8][8]=" "; 
		pboard[0][8]="8"; 
		pboard[1][8]="7"; 
		pboard[2][8]="6"; 
		pboard[3][8]="5"; 
		pboard[4][8]="4"; 
		pboard[5][8]="3"; 
		pboard[6][8]="2"; 
		pboard[7][8]="1";  
	} 
	/**Updates pboard so that it can be printed from the main class. The method looks through the board and 
	 * and adds the pieces as strings in the corresponding spot on the pboard*/
	public void printBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j]==null){
					if((i+j)%2==0){
						pboard[i][j]="  "; 
					} 
					else{
						pboard[i][j]="##"; 
					}
				}
				else{
					String piece= board[i][j].toString(); 
					pboard[i][j]=piece; 
				}
			}
		}
	}
	
	public boolean makeMove(String color,String input){
		String[] moves= input.split(" ");
		String start= moves[0]; 
		String end= moves[1]; 
		int starty= str2int(start.substring(0,1)); 
		int startx= 8-Integer.parseInt(start.substring(1)); 
		int endy= str2int(end.substring(0,1));  
		int endx= 8-Integer.parseInt(end.substring(1)); 
		Piece p= board[startx][starty];  
		String pcolor= p.color; 
		System.out.println(p); 
		if(!pcolor.equals(color)){ //checks to see if the piece being moved belongs to the right player
			System.out.println("Illegal move, try again");
			return false; 
		}
		if(p.move(startx,starty,endx,endy)){
			Piece mp= board[endx][endy]; 
			if(mp==null){
				board[endx][endy]= p; 
				board[startx][starty]=null; 
				return true; //movement is made
			}
			else{
				System.out.println(mp); 
				if(mp.color.equals(p.color)){ //checks to see if another piece of the same player occupies that spot
					System.out.println("Illegal move, try again-----");
					return false;
				}
				else{
					board[endx][endy]= p; 
					board[startx][starty]=null; 
					return true; //movement is made 
				}
			}
			
		} 
		else{
			System.out.println("Illegal move, try again");
		}
		return false; 
	} 
	
	public int str2int(String str){
		int ans=-1; 
		if (str.compareTo("a")==0){
			ans=0; 
		}
		else if(str.compareTo("b")==0){
			ans=1; 
		}
		else if(str.compareTo("c")==0){
			ans=2; 
		}
		else if(str.compareTo("d")==0){
			ans=3; 
		}
		else if(str.compareTo("e")==0){
			ans=4; 
		}
		else if(str.compareTo("f")==0){
			ans=5; 
		}
		else if(str.compareTo("g")==0){
			ans=6; 
		}
		else if(str.compareTo("h")==0){
			ans=7; 
		}
		return ans; 
	}

}

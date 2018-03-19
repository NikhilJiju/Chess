package chess;
/**
 *  This class contains the chess game as an array and delegates the actions requested from the main class. 
 * @author 
 *
 *
 */
public class ChessBoard {
	/**
	 * This is an 8x8 array of Piece objects. It contains all the pieces that a chess board should contain. 
	 */
	Piece[][] board= new Piece[8][8]; 
	/**
	 * This is a 9x9 array of Strings. This is the string representation of the board array and it is used in printing.  
	 */
	String[][] pboard= new String[9][9];
	/**
	 * Keeps track of if a King piece has captured. The main class checks on this field and will keep taking inputs as long as 
	 * this field is false. 
	 */
	boolean kingCaptured= false;
	/**
	 * This is used in dealing with an enpassant movement. This is set to true if a white piece moves two spots from 
	 * start or if a black piece moves two spots from the start. This would allow for an enpassant move to be done by the opponent 
	 * on the next turn
	 */
	/*static boolean enpassant_next= false;   
	*//**
	 * This keeps track of if an enpassant move is possible on the current turn. It is set to true from the  
	 *//*
	static boolean enpassant= false;*/ 
	boolean drawRequest= false; 
	/**
	 * The method begins by first filling the 8x8 array of pieces called board in the way a chess board is filled. Each 
	 * piece is given the right rank of pawn, rook, etc. Also it is given the corresponding color. The rest of the board 
	 * is left empty. 
	 * The pboard is a string version of the board array. To initialize the 9x9 array, the 8x8 array within it is left empty 
	 * to transfer over the board array and the outer layer is filled with a-h and 1-8 as shown in assignment 
	 */
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
		board[3][7]= new Knight("w");
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
	/**
	 * This method updates the pboard so that it can be printed from the main class. The method looks through the 8x8 
	 * board and converts the pieces to strings and places it in the corresponding spot on the pboard. This is done 
	 * through the toString method in each of the Piece class. By the end of the method, there will be a string representation 
	 * of what the chess game currently looks like. 
	 */
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
	/**
	 * The pieces are actually moved in this method. The method takes the user input and then converts the input into 
	 * integer values it can use to find the location of the piece and then move the piece to that location. These
	 * integer inputs are used to find the piece at that point in the board. Once the piece is found, the move method on 
	 * it is called with the user inputs fed in. This method will return a boolean value which will tell whether or not the 
	 * move is legal. If a true value is returned, the move will be done. There are also checks within this class to see 
	 * if another one of the players piece is in the spot the user wants to move to. Also if the opponents piece is in the 
	 * spot the player wants to move his piece to, then the method will replace that spot in the array with the player's piece 
	 * thus eliminating the opponents piece. The color of the piece is also taken in to determine if the user is moving their own piece and not the opponents. T
	 * @param color The color of the piece the player is supposed to move
	 * @param input	Contains the index for the piece which is to be moved and where it will be moved to. 
	 * @return A true value if a move has been performed and a false value otherwise. 
	 */
	public boolean makeMove(String color,String input){
		String[] moves= input.split(" ");
		String start= moves[0]; 
		String end= moves[1]; 
		int starty= str2int(start.substring(0,1)); 
		if(starty<0 || starty>7){
			System.out.println("Illegal move, try again"); 
			return false;
		}
		int startx= 8-Integer.parseInt(start.substring(1)); 
		if(startx<0 || startx>7){
			System.out.println("Illegal move, try again"); 
			return false;
		}
		int endy= str2int(end.substring(0,1));  
		if(endy<0 || endy>7){
			System.out.println("Illegal move, try again"); 
			return false;
		}
		int endx= 8-Integer.parseInt(end.substring(1)); 
		if(endx<0 || endx>7){
			System.out.println("Illegal move, try again"); 
			return false;
		}
		Piece p= board[startx][starty];  
		if(p==null){	//No piece exists in the spot the user selected. 
			System.out.println("Illegal move, try again");
			return false;
		}
		String pcolor= p.color; 
		if(!pcolor.equals(color)){ //checks to see if the piece being moved belongs to the right player
			System.out.println("Illegal move, try again");
			return false; 
		}
		if(p.move(startx,starty,endx,endy,board)){
			Piece mp= board[endx][endy]; 
			if(mp==null){
				board[endx][endy]= p; 
				board[startx][starty]=null; 
			/*	if(enpassant_next){
					enpassant=true; 
				}
				else{
					enpassant=false; 
				}
				enpassant_next= false; 
				System.out.println(enpassant);*/
				updateEnpassant(); 
				if(p.check(endx,endy,board)){
					System.out.println("Check");
				} 
				return true; //movement is made
			}
			else{
				if(mp.color.equals(p.color)){ //checks to see if another piece of the same player occupies that spot
					System.out.println("Illegal move, try again");
					return false;
				}
				else{ //opposing players piece occupies the spot being moved to 
					if(mp.toString().substring(1).equalsIgnoreCase("K")){ //The piece to be captured is a King
						if(mp.color.equals("w")){
							System.out.println("Black wins");
						}
						else{
							System.out.println("White wins");
						}
						kingCaptured= true; 
					}
					board[endx][endy]= p; 
					board[startx][starty]=null; 
					updateEnpassant(); 
					if(p.check(endx,endy,board)){
						System.out.println("Check");
					} 
					return true; //movement is made 
				}
			}
			
		} 
		else{
			System.out.println("Illegal move, try again");
		}
		return false; 
	} 
	public void updateEnpassant(){
		for (int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j] instanceof Pawn) {
					Pawn a= (Pawn) board[i][j];
					if(a.enpassant){
						if(a.enpassantcount>1){
							a.enpassantcount=0; 
							a.enpassant=false; 
						}
						else{
							a.enpassantcount++; 
						}
					}
				}
			}
		}
	}
	/**
	 * This method is a helper method for the makeMove method. It simply converts the user input given in letters to 
	 * a corresponding number which can be used for indexing the board. The numbering is given with a set to 0 and 
	 * incrementing for each letter. 
	 * @param str The user input of column indexes  
	 * @return An integer version of the user input
	 */
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

package chess;

import java.util.ArrayList;

/**
 *  This class contains the chess game as an array and delegates the actions requested from the main class. 
 * @author Nikhil Jiju and Bhargav Sonani
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
	static boolean white_on_check= false; 
	static boolean black_on_check= false; 
	
	/**
	 * Keeps tracked if left black rook moved
	 */
	boolean rookLB_moved = false;
	/**
	 * Keeps tracked if right black rook moved
	 */
	boolean rookRB_moved = false;
	/**
	 * Keeps tracked if left white rook moved
	 */
	boolean rookLW_moved = false;
	/**
	 * Keeps tracked if right white rook moved
	 */
	boolean rookRW_moved = false;
	/**
	 * Keeps tracked if black king moved
	 */
	boolean kingB_moved = false;
	/**
	 * Keeps tracked if white king moved
	 */
	boolean kingW_moved = false;
	/**
	 * Keeps track of if white player is on checkmate
	 */
	boolean white_on_checkmate= false; 
	/**
	 * Keeps track of if black player is on checkmate
	 */
	boolean black_on_checkmate= false; 
//bsonani@bitbucket.org/NijuFir/chess76.git
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
		board[7][6]= new Knight("w");
		board[7][7]= new Rook("w");
		
//<<<<<<< HEAD
	 
		/*board[0][0]= new Rook("b"); 
		board[0][5]= new Rook("b"); 
		board[0][6]= new King("b"); 
		board[1][1]= new Pawn("b"); 
		board[1][2]= new Pawn("b"); 
		board[1][4]= new Bishop("b"); 
		board[1][6]= new Pawn("b"); 
		board[1][7]= new Pawn("b"); 
		board[2][0]= new Pawn("b"); 
		board[2][5]= new Pawn("b"); 
		board[3][2]= new Pawn("b"); 
		board[3][5]= new Pawn("w"); 
		board[4][0]= new Pawn("w"); 
		board[4][2]= new Pawn("w"); 
		board[5][1]= new Pawn("w"); 
		board[5][3]= new Queen("b"); 
		board[5][5]= new Knight("w"); 
		board[5][6]= new Pawn("w"); 
		board[6][5]= new Pawn("w"); 
		board[6][6]= new Pawn("w"); 
		board[7][0]= new Rook("w"); 
		board[7][2]= new Bishop("w"); 
		board[7][5]= new Rook("w"); 
		board[7][7]= new King("w"); 
		*/
		
		
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
		String promotedPiece ="";
		if (moves.length==3) {
			if(!moves[2].equals("draw?")) {
				promotedPiece = moves[2];
			}
		}
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

		
		if(p.toString().substring(1).equals("K")) { //check if piece being moved is king
			if(Math.abs(endy-starty)==2) {
				if(Math.abs(endx-startx)==0 && (endx==7||endx==0)) {
					//System.out.println("DETECTED CASTLING MOVE!");
					if(castling(startx,starty,endx,endy,pcolor)) { 
						//****have to check if castling causes king to put into check,
						//so create tryCastling method and then call allCheck
						//actually execute castling move
						if(endy>starty) { //castling to the right rook
							int rookX = startx;
							int rookY = 7;
							int newRooky = endy-1;
							Piece castledRook = board[rookX][rookY];
							board[rookX][newRooky]=castledRook;
							board[rookX][rookY]=null;
							board[endx][endy]=p;
							board[startx][starty]=null;
							if(pcolor.equals("b")){
								rookRB_moved=true;
								kingB_moved=true;
								String kingChecker = allCheck(board);
								if(kingChecker.equals("black")){
									//undo castling
									board[startx][starty]=p;
									board[rookX][newRooky]=null;
									board[rookX][rookY]=castledRook;
									board[endx][endy]=null;
									black_on_check = false;
									System.out.println("Illegal move, try again"); 
									return false;
								}else if(kingChecker.equals("white")){
									//it's ok
								}else {
									//it's ok
								}
								updateEnpassant();
								return true;
							}else{
								rookRW_moved=true;
								kingW_moved=true;
								String kingChecker = allCheck(board);
								if(kingChecker.equals("white")){
									//undo castling
									board[startx][starty]=p;
									board[rookX][newRooky]=null;
									board[rookX][rookY]=castledRook;
									board[endx][endy]=null;
									white_on_check = false;
									System.out.println("Illegal move, try again"); 
									return false;
								}else if(kingChecker.equals("black")){
									//it's ok
								}else {
									//it's ok
								}
								updateEnpassant();
								return true;
							}
						}else { //castling to left rook
							int rookX = startx;
							int rookY = 0;
							int newRooky = endy+1;
							Piece castledRook = board[rookX][rookY];
							board[rookX][newRooky]=castledRook;
							board[rookX][rookY]=null;
							board[endx][endy]=p;
							board[startx][starty]=null;
							if(pcolor.equals("b")){
								rookLB_moved=true;
								kingB_moved=true;
								String kingChecker = allCheck(board);
								if(kingChecker.equals("black")){
									//undo castling
									board[startx][starty]=p;
									board[rookX][newRooky]=null;
									board[rookX][rookY]=castledRook;
									board[endx][endy]=null;
									black_on_check = false;
									System.out.println("Illegal move, try again"); 
									return false;
								}else if(kingChecker.equals("white")){
									//it's ok
								}else {
									//it's ok
								}
								updateEnpassant();
								return true;
							}else{
								rookLW_moved=true;
								kingW_moved=true;
								String kingChecker = allCheck(board);
								if(kingChecker.equals("white")){
									//undo castling
									board[startx][starty]=p;
									board[rookX][newRooky]=null;
									board[rookX][rookY]=castledRook;
									board[endx][endy]=null;
									white_on_check = false;
									System.out.println("Illegal move, try again"); 
									return false;
								}else if(kingChecker.equals("black")){
									//it's ok
								}else {
									//it's ok
								}
								updateEnpassant();
								return true;
							}
						}
					}else {
						System.out.println("Illegal move, try again");
						return false;
					}
				}else {
					System.out.println("Illegal move, try again");
					return false;
				}
			}
		}
		
		if(p.move(startx,starty,endx,endy,board)){
			Piece mp= board[endx][endy]; 
			if(mp==null){
				if(tryMove(startx,starty,endx,endy,board,p)) {
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
					int bi=0; 
					int bj=0; 
					int wi=0; 
					int wj=0; 
					for(int i=0; i<8; i++){
						for(int j=0; j<8; j++){
							if(board[i][j]!=null){
								if(board[i][j].check(i, j, board)){
									if(board[i][j].color.equals("w")){
										black_on_check= true; 
									}
									if(board[i][j].color.equals("b")){
										white_on_check=true; 
									}
								} 
								if(board[i][j].toString().equals("wK")){
									wi= i; 
									wj= j; 
								}
								if(board[i][j].toString().equals("bK")){
									bi= i; 
									bj= j; 
								}
							}
						}
					}
					if(color.equals("w")&&black_on_check){
						//System.out.println("yoyoyoy");
						if(checkmate(bi,bj,color)){
							if(!canKill("w")){
								black_on_checkmate=true; 
								//System.out.println("Checkmate White");
							}
						} 
					}
					if(color.equals("b")&&white_on_check){
						if(checkmate(wi,wj,color)){
							if(!canKill("b")){
								white_on_checkmate=true; 
								//System.out.println("Checkmate Blac");
							}
						} 
					}
					allCheck(board);
					//checking if any of the rooks moved, set booleans accordingly
					if (startx==0 && starty==0) {
						if (p.toString().equals("bR")){
							rookLB_moved=true;
						}
					}
					if (startx==0 && starty==7) {
						if (p.toString().equals("bR")){
							rookRB_moved=true;
						}
					}
					if (startx==7 && starty==0) {
						if (p.toString().equals("wR")){
							rookLW_moved=true;
						}
					}
					if (startx==7 && starty==7) {
						if (p.toString().equals("wR")){
							rookRW_moved=true;
						}
					}
					//similarly check if kings have moved
					if (startx==0 && starty==4) {
						if (p.toString().equals("bK")){
							kingB_moved=true;
						}
					}
					if (startx==7 && starty==4) {
						if (p.toString().equals("wK")){
							kingW_moved=true;
						}
					}
					
					if(p.toString().substring(1).equalsIgnoreCase("P")) {
						if (p.toString().charAt(0)=='b'){
							if (endx==7) {
								promotePiece(endx,endy,promotedPiece,"b");
							}
						}else {
							if(endx==0) {
								promotePiece(endx,endy,promotedPiece,"w");
							}
						}
					}
					return true; //movement is made
				}else {
					System.out.println("Illegal move, try again");
					return false; 
				}
				
			}else{
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
					if(tryMove(startx,starty,endx,endy,board,p)) {
						if(p.toString().substring(1).equals("P")){
							if(endy-starty==0){
								System.out.println("Illegal move, try again");
								return false;
							}
						}
						board[endx][endy]= p; 
						board[startx][starty]=null; 
						updateEnpassant();
						int bi=0; 
						int bj=0; 
						int wi=0; 
						int wj=0;
						for(int i=0; i<8; i++){
							for(int j=0; j<8; j++){
								
								if(board[i][j]!=null){
									if(board[i][j].check(i, j, board)){
										if(board[i][j].color.equals("w")){
											black_on_check= true; 
										}
										if(board[i][j].color.equals("b")){
											white_on_check=true; 
										}
										
									} 
									if(board[i][j].toString().equals("wK")){
										wi= i; 
										wj= j; 
										
									}
									if(board[i][j].toString().equals("bK")){
										bi= i; 
										bj= j; 
									} 
								}
							}
						} 
						if(color.equals("w")&&black_on_check){
							if(checkmate(bi,bj,color)){
								if(!canKill("w")){
									black_on_checkmate=true; 
									//System.out.println("Checkmate White");
								}
							} 
						}
						if(color.equals("b")&&white_on_check){
							if(checkmate(wi,wj,color)){
								if(!canKill("b")){
									white_on_checkmate=true; 
									//System.out.println("Checkmate Blac");
								}
							} 
						}
						allCheck(board);
						return true; //movement is made 
					}else {
						System.out.println("Illegal move, try again");
						return false; 
					}
				}
			}
			
		} 
		else{
			System.out.println("Illegal move, try again");
		}
		return false; 
	} 
	
	
	/**
	 * Castling checks whether or not the move on the king is valid for castling or not. The first condition 
	 * is that it makes sure that the king and rook which the move involves, has never moved and the king is
	 * not in check. It also confirms that the king and the rook are in the correct rank, meaning either in the
	 * 7th or 1st rank. Lastly, the method checks that there are no pieces in between the king and the rook.
	 * The only exception to this rule, is when the king castles queenside, and there is allowed to be one
	 * piece next to the rook. Therefore, if all conditions are met, it returns a boolean confirming the validity
	 * of the castle move or denying its possibility. 
	 * @param startx The x-coordinate of the piece to be moved
	 * @param starty The y-coordinate of the piece to be moved
	 * @param endx The x-coordinate of where the piece will be moved to
	 * @param endy The y-coordinate of where the piece will be moved to
	 * @param color Color of the current player's turn
	 * @return True if the conditions for a valid castling move are met, false otherwise
	 */
	public boolean castling(int startx, int starty, int endx, int endy, String color) {
		Piece castleKing = board[startx][starty];
		if(color.equals("b")) {
			if (rookLB_moved||rookRB_moved||kingB_moved||black_on_check) { //one of the pieces moved
				return false;
			}else { //no pieces moved
				if (startx==0) { // should be in first rank
					if (endy>starty) { //moving black king to right
						int pos = starty+1;
						int count=0;
						while(true) {
							if(count==2) {
								return true;
							}
							if(board[startx][pos]!=null) {
								/*if(board[startx][pos].toString().equals("bR")) {
									return true; //all conditions for castling met
								}*/
								return false;
							}else {
								if(count==0) {
									if(tryMove(startx,starty,endx,starty+1,board,castleKing)) {
										pos++;
										count++;
									}else {
										return false;
									}
								}else if(count==1) {
									if(tryMove(startx,starty+1,endx,starty+2,board,castleKing)) {
										pos++;
										count++;
									}else {
										return false;
									}
								}
							}
						}
					}else { //moving black king to left
						int pos = starty-1;
						int count=0;
						while(true) {
							if(count==2) {
								return true;
							}
							if(board[startx][pos]!=null) {
								/*if(board[startx][pos].toString().equals("bR")) {
									return true; //all conditions for castling met
								}*/
								return false;
							}else {
								if(count==0) {
									if(tryMove(startx,starty,endx,starty-1,board,castleKing)) {
										pos--;
										count++;
									}else {
										return false;
									}
								}else if(count==1) {
									if(tryMove(startx,starty-1,endx,starty-2,board,castleKing)) {
										pos--;
										count++;
									}else {
										return false;
									}
								}
							}
							
						}
					}
				}else {
					return false;
				}
			}
		}else if (color.equals("w")) {
			if (rookLW_moved||rookRW_moved||kingW_moved||white_on_check) { //one of the pieces moved
				return false;
			}else { //no pieces moved
				if (startx==7) { // should be in last rank
					if (endy>starty) { //moving white king to right
						int pos = starty+1;
						int count=0;
						while(true) {
							if(count==2) {
								return true;
							}
							if(board[startx][pos]!=null) {
								/*if(board[startx][pos].toString().equals("wR")) {
									return true; //all conditions for castling met
								}*/
								return false;
							}else {
								if(count==0) {
									if(tryMove(startx,starty,endx,starty+1,board,castleKing)) {
										pos++;
										count++;
									}else {
										return false;
									}
								}else if(count==1) {
									if(tryMove(startx,starty+1,endx,starty+2,board,castleKing)) {
										pos++;
										count++;
									}else {
										return false;
									}
								}
							}
						}
						
					}else { //moving white king to left
						int pos = starty-1;
						int count=0;
						while(true) {
							if(count==2) {
								return true;
							}
							if(board[startx][pos]!=null) {
								/*if(board[startx][pos].toString().equals("wR")) {
									return true; //all conditions for castling met
								}*/
								return false;
							}else {
								if(count==0) {
									if(tryMove(startx,starty,endx,starty-1,board,castleKing)) {
										pos--;
										count++;
									}else {
										return false;
									}
								}else if(count==1) {
									if(tryMove(startx,starty-1,endx,starty-2,board,castleKing)) {
										pos--;
										count++;
									}else {
										return false;
									}
								}
							}
							
						}
					}
				}else {
					return false;
				}
			}	
		}
		return false;
	}
	/**
	 * Determines if a piece that is put on check by opponent king can be killed. If multiple are killing, the opponent piece cannot be killed
	 * @param color The color of the current player's piece
	 * @return Boolean True if can be killed, false if cannot be killed
	 */
	public boolean canKill(String color){
		//System.out.println("here i got 1");
		ArrayList<Integer[]> checkers= new ArrayList<Integer[]>(); 
		if(color.equals("w")){
			
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					if(board[i][j]!=null && board[i][j].color.equals("w") && board[i][j].check(i, j, board)){
						Integer[] position= new Integer[2]; 
						position[0]=i; 
						position[1]=j; 
						checkers.add(position);
					}
				}
			}
			if(checkers.size()==1){ 
				boolean cankill= false; 
				Integer[] position= checkers.get(0); 
				int a= position[0]; 
				int b= position[1]; 
				for(int i=0; i<8; i++){
					for(int j=0; j<8; j++){
						if(board[i][j]!=null && board[i][j].color.equals("b") && board[i][j].move(i, j, a, b, board)){
							//add condition where move does not leave king to be vulnerable 
							//System.out.println(i + " " + j);
							if(tryMove(i,j,a,b,board,board[i][j])){
								//System.out.println(i + " " + j);
								//System.out.println("black " + black_on_check); 
								//System.out.println("white " + white_on_check);
								if(board[i][j].toString().equals("bP")&&(b-j)==0){
									 
								}
								else{
									cankill=true; 
									 break; 
								}
							}
							
						}
					}
				}
				return cankill; 
			}
			else{
				return false; 
			}
		}
		else{
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					if(board[i][j]!=null && board[i][j].color.equals("b") && board[i][j].check(i, j, board)){
						Integer[] position= new Integer[2]; 
						position[0]=i; 
						position[1]=j; 
						checkers.add(position);
					}
				}
			}
			if(checkers.size()==1){ 
				boolean cankill= false; 
				Integer[] position= checkers.get(0); 
				int a= position[0]; 
				int b= position[1]; 
				for(int i=0; i<8; i++){
					for(int j=0; j<8; j++){
						if(board[i][j]!=null && board[i][j].color.equals("w") && board[i][j].move(i, j, a, b, board)){
							//add condition where move does not leave king to be vulnerable 
							if(tryMove(i,j,a,b,board,board[i][j])){
								if(board[i][j].toString().equals("wP")&&(b-j)==0){
									 
								}
								else{
									cankill=true; 
									 break; 
								}
							}
						}
					}
				}
				return cankill; 
			}
			else{
				return false; 
			}
		}
	}
	
	
	/**
	 * This method does the job of promoting a pawn into another piece.
	 * It only gets called if the player's instruction was to move a pawn 
	 * and the pawn will be moved to the correct position for promotion. If, consequently, these conditions are 
	 * met, then a pawn can successfully be promoted to another piece such as a Rook,Knight,Bishop,or a Queen.
	 * If no piece is defined by the user, then the pawn automatically gets promoted to a Queen. So the method
	 * replaces the spot of the pawn with the promoted piece. It ensures that the new piece is that same color
	 * as the player's because of the parameter that was passed. 
	 * @param endx The x-coordinate of where the pawn should be moved
	 * @param endy The y-coordinate of where the pawn should be moved
	 * @param promotedPiece The letter of the piece that the pawn should be promoted to. If blank, defaults to Queen
	 * @param color Color of the current player's turn
	 */
	public void promotePiece(int endx, int endy, String promotedPiece,String color) {
		
		if (!promotedPiece.equals("")) {
			if (promotedPiece.equalsIgnoreCase("R")) {
				board[endx][endy] = new Rook(color);
			}else if (promotedPiece.equalsIgnoreCase("N")) {
				board[endx][endy] = new Knight(color);
			}else if (promotedPiece.equalsIgnoreCase("B")) {
				board[endx][endy] = new Bishop(color);
			}else if (promotedPiece.equalsIgnoreCase("Q")) {
				board[endx][endy] = new Queen(color);
			}
		}else { //default promotion to Queen
			board[endx][endy] = new Queen(color);
		}
	}
	
	/**
	 * This method is used to identify which kings are put on check given a chess board. So it 
	 * goes through every spot on the chess board and if there is a piece present, it calls the 
	 * check method on it, which is defined individually for every type of piece. If the check 
	 * method returns to be true, then it sets the
	 * field values of the class accordingly. So if the player that caused the check was a king, it
	 * detects that this causes both kings to be put on check, and returns "both". Otherwise, 
	 * it simply checks the color of the piece causing the check. If the color is white, then it sets the 
	 * "black_on_check" field to true and returns black. Similarly, if the piece was white, it sets the
	 * "white_on_check" field to true and returns white. If none of these cases exist, then the method 
	 * sets no fields and simply returns "", indicating the chess board currently has no checks present.
	 * @param board2 Reference to the main chess board
	 * @return String indicating if the player's move causes any of the kings to be put on check.
	 * "black" for putting the black king on check, "white" for the white king on check, "both"
	 * for causing both kings to be put on check, and "" for no kings to be put on check
	 */
	public static String allCheck(Piece[][] board2) {
		//System.out.println("starting all Check");
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board2[i][j]!=null){
					if(board2[i][j].check(i, j, board2)){
						//System.out.println("got here");
						if(board2[i][j].toString().substring(1).equals("K")) {
							black_on_check=true;
							white_on_check=true;
							return "both";
						}
						if(board2[i][j].color.equals("w")){
							black_on_check= true; 
							//System.out.println("black king checked");
							return "black";
						}
						if(board2[i][j].color.equals("b")){
							white_on_check=true; 
							//System.out.println("white king checked");
							return "white";
						}
						break; 
					} 
				}
			}
		}
		return "";
	}
	
	/**
	 * This method temporarily attempts to execute the user's move and checks if it's valid. 
	 * First, the method stores the current state of the chess board. Then, it executes the player's move.
	 * It continues to call the allCheck method on the board with the executed move and stores the return
	 * value in a String. Then it checks the string to determine if the move was valid. If the string is "black",
	 * it means the king king was put on check, but if it was the black player's turn, then the move is 
	 * deemed illegal, since a player can't take a move which causes its own king to be put on check. So
	 * the "black_on_check" field is reset, the move is undone, meaning the original state of the chess board
	 * is restored, and "false" is returned. Otherwise,if it was the white player's turn,
	 * the move is valid. So the move is still undone and "true" is returned. A similar procedure occurs if
	 * the string was "white". However, if the string was "both", the move is invalid regardless of whose
	 * turn it is, so it resets both fields("black_on_check" and "white_on_check") and returns "false".
	 * It's important to note that this
	 * method is not responsible for executing a player's move, but rather just to test if the player's move is 
	 * legal or illegal. It does that by temporarily executing the move and then undoing it. 
	 * @param x The x-coordinate of the piece to be moved
	 * @param y The y-coordinate of the piece to be moved
	 * @param a The x-coordinate of where the piece will be moved to
	 * @param b The y-coordinate of where the piece will be moved to
	 * @param board3 Reference to the main chess board
	 * @param p Piece to be moved
	 * @return Boolean 
	 */
	public static boolean tryMove(int x, int y, int a, int b, Piece[][] board3,Piece p) {
		//System.out.println("starting try move");
		Piece replaced = board3[a][b];
		board3[a][b]= p;
		//System.out.println("value of x:"+a+" value of y: "+b);
		//System.out.println("value of starting x:"+x+" value of y: "+y);
		board3[x][y]=null; 
		String checker = allCheck(board3);
		if(checker.equals("black")){ //black king checked
			if(p.color.equals("b")) {
				//System.out.println("hererere");
				black_on_check= false;
				board3[x][y]=p;
				board3[a][b]=replaced;
				return false;	//can't move piece so own king is checked
			}else {
				board3[x][y]=p;
				board3[a][b]=replaced;
				return true;
			}
		}else if(checker.equals("white")) { //white king checked
			if(p.color.equals("w")) {
				white_on_check= false;
				board3[x][y]=p;
				board3[a][b]=replaced;
				return false;	//can't move piece so own king is checked
			}else {
				board3[x][y]=p;
				board3[a][b]=replaced;
				return true;
			}
		}else if(checker.equals("both")){
			white_on_check=false;
			black_on_check=false;
			board3[x][y]=p;
			board3[a][b]=replaced;
			return false;
		}else {
			board3[x][y]=p;
			board3[a][b]=replaced;
			return true;
		}				
	}
	
	/**
	 * Looks if kings can move to any of the 8 possible squares around it. Determines if it's possible for the king to make a move
	 * @param i Current x position of king
	 * @param j Current y position of king
	 * @param color Color of the current player's king
	 * @return Boolean true if no moves possible, otherwise false
	 */
	private boolean checkmate(int i, int j, String color) {
		// TODO Auto-generated method stub
		//System.out.println(board[i][j]);
			Piece king= board[i][j]; 
			if(i+1<8 && j+1<8){
				if(king.move(i,j,i+1,j+1,board)){
					//System.out.println("here 1");
					if(checkmove(i,j,i+1,j+1,color)){
						return false; 
					}	
				}
			}
			if(i+1<8 && j-1>=0){
				if(king.move(i,j,i+1,j-1,board)){
					//System.out.println("here 2");
					if(checkmove(i,j,i+1,j-1,color)){
						return false; 
					} 
				}
			}
			if(i+1<8){
				if(king.move(i,j,i+1,j,board)){
					//System.out.println("here 3");
					if(checkmove(i,j,i+1,j,color)){
						return false; 
					} 
				}
			}
			if(i-1>=0 && j+1<8){
				if(king.move(i,j,i-1,j+1,board)){
					//System.out.println("here 3.5");
					if(checkmove(i,j,i-1,j+1,color)){
						return false; 
					} 
				}
			}
			if(i-1>=0 && j-1>=0){
				if(king.move(i,j,i-1,j-1,board)){
					//System.out.println("here 4");
					if(checkmove(i,j,i-1,j-1,color)){
						return false; 
					} 
				}
			}
			System.out.println(i-1);
			if(i-1>=0){
				//System.out.println("dddddd");
				if(king.move(i,j,i-1,j,board)){
					//System.out.println("here 5");
					if(checkmove(i,j,i-1,j,color)){
						return false; 
					} 
				}
			}
			if(j+1<8){
				if(king.move(i,j,i,j+1,board)){
					//System.out.println("here 6");
					if(checkmove(i,j,i,j+1,color)){
						return false; 
					} 
				}
			}
			if(j-1>=0){
				if(king.move(i,j,i,j-1,board)){
					//System.out.println("here 7");
					if(checkmove(i,j,i,j-1,color)){
						return false;
					} 
				}
			}
			//System.out.println("here");
			return true; 
		
	}
	/**
	 * Checks to see if spot that king is being moved to will cause it to be put on check
	 * @param startx Beginning x position of piece
	 * @param starty Beginning y position of piece
	 * @param endx Ending x position of piece
	 * @param endy Ending y position of piece
	 * @param color Color of current player piece
	 * @return Boolean - True if spot being moved to will cause a check, otherwise false
	 */
	 public boolean checkmove(int startx, int starty, int endx, int endy, String color){
	    	Piece mp= board[endx][endy]; 
	    	Piece p= board[startx][starty];
			if(mp==null){
				board[endx][endy]= p; 
				board[startx][starty]=null; 
				for(int i=0; i<8; i++){
					for(int j=0; j<8; j++){
						if(board[i][j]!=null){
							if(board[i][j].check(i, j, board)){
								if((color.equals("b")&&white_on_check)||(color.equals("w")&&black_on_check)){
									board[startx][starty]=p; 
									board[endx][endy]=null; //reset move
									return false; //piece is in check 
								}
							} 
						}
					}
				}
				board[startx][starty]=p; 
				board[endx][endy]=null; //reset move
				return true; //movement is made
			}
			else{
				if(mp.color.equals(p.color)){ //checks to see if another piece of the same player occupies that spot
					return false; //movement cannot be made
				}
				else{ //opposing players piece occupies the spot being moved to 
					//System.out.println("here i got");
					Piece old= board[endx][endy]; 
					board[endx][endy]= p; 
					board[startx][starty]=null; 
					for(int i=0; i<8; i++){
						for(int j=0; j<8; j++){
							if(board[i][j]!=null){
								if(board[i][j].check(i, j, board)){
									if((color.equals("b")&&white_on_check)||(color.equals("w")&&black_on_check)){
										board[startx][starty]=p; 
										board[endx][endy]=old; //reset move
										return false; 
									}
								} 
							}
						}
					} 
					board[startx][starty]=p; 
					board[endx][endy]=old; //reset move
					return true; //movement can be made 
				}
			}
		}
	/**
	 * Goes through every piece of current player's piece and determines if piece can make a move
	 * @param colour Color of current player's piece
	 * @return Boolean - true if no moves possible, otherwise false
	 */
	public boolean inStalemate(String colour){
		boolean inStalemate=true; 
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j]!=null && board[i][j].color.equals(colour)){
					if(!board[i][j].stalemate(i, j, board, colour)){
						inStalemate= false; 
					}
				}
			}
		}
		return inStalemate; 
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

package chess;

public class ChessBoard {
	Pieces[][] board= new Pieces[8][8]; //contains pieces objects
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

}

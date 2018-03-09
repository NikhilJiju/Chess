package chess;

public class ChessBoard {
	Pieces[][] board= new Pieces[8][8]; 
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
		board[6][0]= new Rook("w");
		board[6][1]= new Knight("w"); 
		board[6][2]= new Bishop("w");  
		board[6][3]= new Queen("w"); 
		board[6][4]= new King("w"); 
		board[6][5]= new Bishop("w"); 
		board[6][6]= new Knight("w");
		board[6][7]= new Rook("w");
	}
}

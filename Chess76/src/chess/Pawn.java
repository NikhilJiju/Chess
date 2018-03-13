package chess;

public class Pawn extends Piece{
		
	public Pawn(String color){
		super(color); 
	}
	
	public boolean move(int x, int y, int a, int b){
		return false; 
	}
	
	public String toString(){
		String p= color+"P";
		return p;
	}
}

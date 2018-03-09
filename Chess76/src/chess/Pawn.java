package chess;

public class Pawn extends Pieces{
	
	String color; 
	
	public Pawn(String color){
		this.color=color; 
	}
	
	public boolean move(int x, int y, int a, int b){
		return false; 
	}
}

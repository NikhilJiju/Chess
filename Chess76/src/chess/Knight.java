package chess;

public class Knight extends Pieces{
	
	String color; 
	
	public Knight(String color){
		this.color=color; 
	}

	public boolean move(int x, int y, int a, int b){
		return false; 
	}
}

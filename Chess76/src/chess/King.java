package chess;

public class King extends Pieces{ 
	String color; 
	public King(String color){
		this.color= color; 
	}
	
	public boolean move(int x, int y, int a, int b){
		return false; 
	}
}

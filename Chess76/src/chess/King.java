package chess;

public class King extends Piece{ 
	public King(String color){
		super(color);
	}
	
	public boolean move(int x, int y, int a, int b){
		return false; 
	}
	
	public String toString(){
		String p= color+"K";
		return p;
	}
}

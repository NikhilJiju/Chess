package chess;

public class Knight extends Piece{
		
	public Knight(String color){
		super(color); 
	}

	public boolean move(int x, int y, int a, int b){
		return false; 
	}
	
	public String toString(){
		String p= color+"N";
		return p;
	}
}

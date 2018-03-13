package chess;

public class Rook extends Piece{
		
	public Rook(String color){
		super(color); 
	}
	
	public boolean move(int x, int y, int a, int b){
		if(x-a==0||y-b==0){
			return true; 
		}
		return false; 
	}
	
	public String toString(){
		String p= color+"R";
		return p;
	}
}

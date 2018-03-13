package chess;

public class Bishop extends Piece{
		
	public Bishop(String color){
		super(color); 
	}
	
	public boolean move(int x, int y, int a, int b){
		if(Math.abs(x-a)==Math.abs(y-b)){
			return true; 
		}
		return false; 
	}
	
	public String toString(){
		String p= color+"B";
		return p;
	}
}

package chess;

public class Queen extends Piece{
		
	public Queen(String color){
		super(color); 
	}
	
	public boolean move(int x, int y, int a, int b){
		if(Math.abs(x-a)==Math.abs(y-b)){
			return true; 
		} 
		if(x-a==0 || y-b==0){
			return true; 
		}
		return false; 
	}
	
	public String toString(){
		String p= color+"Q";
		return p;
	}
}

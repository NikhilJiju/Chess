package chess;

public class Bishop extends Pieces{
	
	String color; 
	
	public Bishop(String color){
		this.color= color; 
	}
	
	public boolean move(int x, int y, int a, int b){
		if(Math.abs(x-a)==Math.abs(y-b)){
			return true; 
		}
		return false; 
	}
}

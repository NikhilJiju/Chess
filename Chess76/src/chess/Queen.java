package chess;

public class Queen extends Pieces{
	
	String color; 
	
	public Queen(String color){
		this.color=color; 
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
}

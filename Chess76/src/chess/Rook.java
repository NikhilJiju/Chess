package chess;

public class Rook extends Pieces{
	
	String color; 
	
	public Rook(String color){
		this.color=color; 
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

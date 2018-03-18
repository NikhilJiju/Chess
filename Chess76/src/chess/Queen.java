package chess;
/**
 * Follows the constraints of the Queen piece 
 * @author 
 */
public class Queen extends Piece{
	/**
	 * 	Constructs a Queen object with a call to super class that sets the color of the piece 
	 * @param color The color of the piece 
	 */
	public Queen(String color){
		super(color); 
	}
	
	/**
	 * Returns true if the piece is moved to a location that is allowable for a queen in a chess game. This constraints 
	 * are a combination of the Rooks and the Bishops. 
	 */
	public boolean move(int x, int y, int a, int b, Piece[][] board){
		/*if(Math.abs(x-a)==Math.abs(y-b)){
			int startx= Math.min(x, a); 
			int i= startx; 
			int endx= Math.max(x, a);
			int starty= Math.min(y, b); 
			int j= starty;  
			while(i<endx){
				if(board[i][j]!=null){
					return false; 
				}
				i++; 
				j++; 
			}
			return true; 
		} */
		if(Math.abs(x-a)==Math.abs(y-b)){
			if(Math.min(x, a)==a && Math.min(y, b)==b){ //Movement up and left
				int i=a+1; 
				int j=b+1; 
				while(i<x){
					if(board[i][j]!=null){
						return false; 
					}
					i++; 
					j++; 
				}
				return true;
			}
			else if(Math.min(x, a)==a && Math.min(y, b)==y){ //Movement up and right
				int i=a+1; 
				int j=b-1; 

				while(i<x){
					if(board[i][j]!=null){
						return false; 
					}
					i++; 
					j--; 
				}
				return true;
			}
			else if(Math.min(x, a)==x && Math.min(y, b)==b){ //Movement down and left
				int i=a-1; 
				int j=b+1; 
				while(i>x){
					if(board[i][j]!=null){
						return false; 
					}
					i--; 
					j++; 
				}
				return true;
			}
			else if(Math.min(x, a)==x && Math.min(y, b)==y){ //Movement down and right
				int i=a-1; 
				int j=b-1; 
				while(i>x){
					if(board[i][j]!=null){
						return false; 
					}
					i--; 
					j--; 
				}
				return true;
			}
		}
		if(x-a==0||y-b==0){
			if(x-a==0){ //horizontal movement
				if(Math.min(y, b)==b){ 
					for(int i=b+1; i<y; i++){
						if(board[x][i]!=null){
							return false; 
						}
					}
				}
				else if(Math.min(y, b)==y){
					for(int i=b-1; i>y; i--){
						if(board[x][i]!=null){
							return false; 
						}
					}
				}
			}
			else{//vertical movement 
				if(Math.min(x, a)==a){ 
					for(int j=a+1; j<x; j++){
						if(board[j][y]!=null){
							return false; 
						}
					}
				}
				else if(Math.min(x, a)==x){
					for(int j=a-1; j>x; j--){
						if(board[j][y]!=null){
							return false; 
						}
					}
				}
			}
			return true; 
		}
		/*if(x-a==0 || y-b==0){
			if(x-a==0){ //horizontal movement
				int start= Math.min(y, b); 
				int end= Math.max(y, b); 
				for(int i=start; i<end; i++){
					if(board[x][i]!=null){
						return false; 
					}
				}
			}
			else{//vertical movement 
				int start= Math.min(x, a); 
				int end= Math.max(x, a); 
				for(int j=start; j<end; j++){
					if(board[j][y]!=null){
						return false; 
					}
				}
			}
			return true; 
		}*/
		return false; 
	}
	
	/**
	 * Returns the string representation of Queen with color and name "Q". 
	 */
	public String toString(){
		String p= color+"Q";
		return p;
	}
}

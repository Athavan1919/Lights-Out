
public class Solution {
	
	private int row;
	private int column;
	
	private int inital_row = 0;
	private int inital_column = 0;
	
	private boolean gameArray[][];
	
	Solution(int width, int height){
		row = width;
		column = height;
	}
	
	Solution(Solution other){
		row = other.row;
		column = other.column;
	}
	
	public void setNext(boolean nextValue) {

		gameArray = new boolean[row][column];
		gameArray[inital_row][inital_column] = nextValue;
		inital_column++;
		
		
		if(inital_column == column-1) {
			inital_column = 0;
			inital_row++;
		}
		
		else {
			System.out.println("Max column reached");
		}
		
	}
	
	public boolean isReady() {
		boolean empty = false;
		for (int i=0;i<row;i++) {
			for (int j=0;j<column;j++) {
				if (gameArray[j] == null) {
					empty = true;
					return empty;
				}
			}
		}
		return empty;
		
	}
	
	public String toString() {
		String aString = "";
		  for(int row = 0; row < gameArray.length; row++) {
		     for(int col = 0; col < gameArray[row].length; col++) {
		    	 	aString += " " + gameArray[row][col];
		     }
		  }
		  return "[" + "," + aString + "," + "]";
		
	}

}

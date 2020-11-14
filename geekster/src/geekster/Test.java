package geekster;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
	int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	
	int startRow = 0;
	int endRow = arr.length-1;
	int startColumn = 0;
	int endColumn = arr[0].length-1;
	
	while(startRow<=endRow && startColumn<=endColumn) {
		for(int i=startColumn;i<=endColumn;i++) {
			System.out.println(arr[startRow][i]);
		}
		startRow++;
		
		if(startColumn<=endColumn && startRow<=endRow) {
			for(int j=startRow;j<=endRow;j++) {
				System.out.println(arr[j][endColumn]);
			}
			endColumn--;
		}
		
		if(startColumn<=endColumn && startRow<=endRow) {
			for(int k=endColumn;k>=startColumn;k--) {
				System.out.println(arr[endRow][k]);
			}
			endRow--;
		}
		
		if(startColumn<=endColumn && startRow<=endRow) {
			for(int k=endRow;k>=startRow;k--) {
				System.out.println(arr[k][startColumn]);
			}
			startColumn++;
		}

	}

	}		
}

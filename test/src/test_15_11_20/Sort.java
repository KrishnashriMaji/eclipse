package test_15_11_20;
import java.util.*;
//---------------- https://www.hackerrank.com/contests/geekster-weekly-assessment-1605339278/challenges/simple-problem-4  ---------
public class Sort {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        int e = sc.nextInt();
        boolean hasChange = false;
        if(arr[size/2]==e){
            for(int j=0;j<size-1;j++){
                for(int k=j+1;k<size;k++){
                    if(arr[j]>arr[k]){
                        hasChange = true;
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }            

            }
        }
        
        if(!hasChange){
            System.out.println("ALL SET");
        }else{
            for(int a:arr)
            {
              System.out.print(a+" ");  
            }   
        }
    }
}

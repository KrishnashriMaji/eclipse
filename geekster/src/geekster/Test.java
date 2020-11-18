package geekster;

import java.util.*;

public class Test {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Queue<Integer> q = new LinkedList<Integer>();
//        int size = sc.nextInt();
//        for(int i=0;i<size;i++){
//            q.add(sc.nextInt());
//        }
//        minMax(q);
    	
//    	Scanner sc  =new Scanner(System.in);
//        int a1 = sc.nextInt();
        int[] arr1 = {2,4};
//        int a2 = sc.nextInt();
        int[] arr2 = {1,2,3,4};
//        for(int i=0;i<a1;i++){
//            arr1[i] = sc.nextInt();
//        }
//        for(int j=0;j<a2;j++){
//            arr2[j] = sc.nextInt();
//        }
        Arrays.sort(arr2);
        for(int a:arr2) {
        	System.out.print(a+" ");
        }
       
        for(int k=0;k<arr1.length;k++){
        	boolean temp = false;
            for(int m=0;m<arr2.length;m++){
            	System.out.println(arr2[m]);
            	 System.out.println(arr1[k]);
                if(arr2[m]>arr1[k]){
                    arr1[k] = arr2[m];
                    temp = true;
                    break;
                }
            }
            if(temp == false) {
            	arr1[k] = -1;
            }
            
        }
        for(int l=0;l<arr1.length;l++){
            System.out.print(arr1[l]+" ");
        }
        
        
    }
    
    //----------maximum element in a given queue---------------------------//
    public static void minMax(Queue<Integer> q){
        if(q.size()>0){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
             while(q.size()!=0){
                 int temp = q.remove();

                 max = Math.max(temp,max);            
                 min = Math.min(temp,min);
             }
            System.out.println(max+" "+min);
//            System.out.println(q.size());
        }
    }
}
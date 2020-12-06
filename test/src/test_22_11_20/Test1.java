package test_22_11_20;

public class Test1 {

	public static void main(String[] args) {
		String[] words = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
		System.out.println(uniqueMorseRepresentations(words));

	}
	
	public static int uniqueMorseRepresentations(String[] words) {
        String[] newArr = new String[words.length];
       
        for(int i=0;i<words.length;i++){
            String temp = words[i];
            String newStr = "";
            
            for(int j=0;j<temp.length();j++){
                String ch = temp.charAt(j)+"";
                newStr += getMorse(ch);
                
            }
            System.out.println(newStr);
            newArr[i] = newStr;
        }
        
        int count = 0;
        for(int k=0;k<newArr.length;k++){
        	for(int l=k+1;l<newArr.length;l++) {
        		 if(newArr[k].equals(newArr[l])){
                     count++;
                 }
        	}
        }
        return count;
    }
    
    public static String getMorse(String st){
        String res="";
        switch (st){
        case "a": res =  ".-";
        break;
        case "b": res = "-...";
        break;
        case "c": res = "-.-.";
        break;
        case "d": res = "-..";
        break;
        case "e": res = ".";
        break;
        case "f": res = "..-.";
        break;
        case "g": res = "--.";
        break;
        case "h": res = "....";
        break;
        case "i": res = "..";
        break;
        case "j": res = ".---";
        break;
        case "k": res = "-.-";
        break;
        case "l": res = ".-..";
        break;
        case "m": res = "--";
        break;
        case "n": res = "-.";
        break;
        case "o": res = "---";
        break;
        case "p": res = ".--.";
        break;
        case "q": res = "--.-";
        break;
        case "r": res = ".-.";
        break;
        case "s": res = "...";
        break;
        case "t": res = "-";
        break;
        case "u": res = "..-";
        break;
        case "v": res = "...-";
        break;
        case "w": res = ".--";
        break;
        case "x": res = "-..-";
        break;
        case "y": res = "-.--";
        break;
        case "z": res = "--..";
        break;
        
    }
        return res;
         
        
    }

}

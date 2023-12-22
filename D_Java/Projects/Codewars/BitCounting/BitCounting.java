package BitCounting;

public class BitCounting {

	public static int countBits(int n){
		StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n%2 == 1) sb.append("1");
            else sb.append("0");
            n/=2;
        } 
        int count = 0;
        for(char c : sb.reverse().toString().toCharArray()) 
            if(c == '1') count++;
        return count;
	}	    
}
package YourOrderPlease;

public class Order {
    public static String order(String sentence) {
        if(sentence == "") return "";
        String[] words = sentence.split(" ");
        int[] orders = new int[words.length];
        String[] newWords = new String[words.length];
        for(int i = 0; i < words.length; i++){
            for(char c : words[i].toCharArray())
                if(c >= '1' && c <= '9') 
                    orders[i] = Integer.parseInt(""+c);
            newWords[orders[i]-1] = words[i];
        }
        String result = "";
        int i = 0;
        for(String s : newWords){
            if(i == newWords.length-1) result += s;
            else result += s+" ";
            i++;
        }
        return result;
    }
}

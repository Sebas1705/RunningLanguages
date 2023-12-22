package CountingDuplicates;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        int count = 0;
        char[] characters = text.toLowerCase().toCharArray();
        for(int i = 0; i < characters.length; i++) {
            if(characters[i] != ' '){
                boolean counted = false;
                for(int j = i+1; j < characters.length; j++) {
                    if(characters[i] == characters[j]) {
                        if(!counted){ 
                            count++;
                            counted = true;
                        }
                        characters[j] = ' ';
                    }
                }
            }
        }
        return count;
    }
}

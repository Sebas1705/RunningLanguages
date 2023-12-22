package WhichAreIn;

import java.util.Arrays;

public class WhichAreIn { 
	public static String[] inArray(String[] array1, String[] array2) {
		boolean[] areSubs = new boolean[array1.length];
        for(int i = 0; i < array1.length; i++)
            for(int j = 0; j < array2.length; j++)
                if(!areSubs[i])
                    areSubs[i] = array2[j].contains(array1[i]);
        int N_length = 0;
        for(boolean b : areSubs)
            if(b)  N_length++;
        String[] array = new String[N_length];
        int i = 0;
        int j = 0;
        for(String s : array1)
            if(areSubs[i++]) array[j++] = s;
        Arrays.sort(array);
        return array;
	}
}

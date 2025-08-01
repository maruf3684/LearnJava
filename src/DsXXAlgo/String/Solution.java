package DsXXAlgo.String;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int MAX_WIDTH = 20;

    public static void main(String[] args) {
        String [] arr = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
      fullJustify(arr,MAX_WIDTH);

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int n     = words.length;
        MAX_WIDTH = maxWidth;
        int i     = 0;

        while(i < n) {
            int lettersCount = words[i].length();
            int j            = i+1;
            int spaceSlots   = 0;

            while(j < n && spaceSlots + lettersCount + words[j].length() + 1 <= maxWidth) {
                lettersCount += words[j].length();
                spaceSlots   += 1;
                j++;
            }

            int remainingSlots = maxWidth - lettersCount;


            int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots;
            int extraSpace    = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;

            if(j == n) { //Means we are on last line - Left justfied
                eachWordSpace = 1;
                extraSpace    = 0;
            }

            String kk = getFinalWord(i, j, eachWordSpace, extraSpace, words);
            System.out.println(kk);
            result.add(kk);

            i = j;
        }

        return result;
    }

    public static  String getFinalWord(int i, int j, int eachWordSpace, int extraSpace, String[] words) {
        StringBuilder s = new StringBuilder();

        for(int k = i; k < j; k++) {
            s.append(words[k]);

            if(k == j-1)
                continue;

            for(int space = 1; space <= eachWordSpace; space++)
                s.append(" ");

            if(extraSpace > 0) {
                s.append(" ");
                extraSpace--;
            }
        }

        while(s.length() < MAX_WIDTH) {
            s.append(" ");
        }

        return s.toString();
    }

}
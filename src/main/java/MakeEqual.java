/*
You are given an array of strings words (0-indexed).

In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].

Return true if you can make every string in words equal using any number of operations, and false otherwise.
 */
public class MakeEqual {
    public boolean makeEqual(String[] words) {
        int[] characterAppearence = new int[26];
        int totalLength = 0;
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            totalLength += currWord.length();
            for (int j = 0; j < currWord.length(); j++) {
               characterAppearence[(int) currWord.charAt(j) - 97] += 1;
            }
        }
        if (totalLength % words.length != 0) return false;
        for (int numberAppear: characterAppearence) {
            if (numberAppear != 0) {
                if (numberAppear % words.length != 0) return false;
            }
        }
        return true;
    }
}

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() < 2) return s.length();

        int[] countAppearing = new int[58];
        boolean isOddNumberExist = false;
        for(int i = 0; i < s.length(); i++) {
            int asciiCharS = s.charAt(i) - 65;
            countAppearing[asciiCharS]++;
        }
        int lengthOfPalindrome = 0;
        for (int count: countAppearing) {
            if (count % 2 != 0) {
                if (!isOddNumberExist) isOddNumberExist = true;
                count -= 1;
            }
            lengthOfPalindrome += count;
        }
        if (isOddNumberExist) lengthOfPalindrome += 1;
        return lengthOfPalindrome;
    }
}

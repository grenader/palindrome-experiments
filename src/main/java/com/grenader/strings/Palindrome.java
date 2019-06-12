package com.grenader.strings;

public class Palindrome {

    public String getLongestPalindrome(String str)
    {
        int longestWordLength = 0;
        int longestIndex = 0;
        for (int ii = 0; ii < str.length() - 1; ii++) {
            if (testCenter(str, ii)) // found a center
                {
                    int wordLength = getPolydrome(str, ii).length();
                    if (wordLength > longestWordLength) {
                        longestWordLength = wordLength;
                        longestIndex = ii;
                    }
                }
        }
        if (longestWordLength > 0)
            return getPolydrome(str, longestIndex);

        return str;
    }

    boolean testCenter(String str, int index) {
        if (str == null || str.length() <= 1)
            return false;
        if (index+1 >= str.length())
            return false;

        // check for two same symbols one near another
        if (str.charAt(index) == str.charAt(index+1))
            return true;
        if (index < 1)
            return false;
        // check for two same symbols staying apart form each other
        if (index+1 <= str.length()-1)
            if (str.charAt(index-1) == str.charAt(index+1))
                return true;

        return false;
    }

    public String getPolydrome(String str, int center) {
        int start = 0;
        int modifier = 1;
        if (str.charAt(center) != str.charAt(center+1)) // we assume that it's the second case
        {
            center--;
            modifier = 2;
        }
        for (int ii = 0; ii+center < str.length()-modifier && center-ii > -1; ii++)
            if (str.charAt(center-ii) == str.charAt(center+ii+modifier))
                start = ii+1;
            else
                break;

        return str.substring(center-start+1, center+start+modifier);
    }
}

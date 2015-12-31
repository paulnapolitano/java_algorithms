/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.HashMap;
/**
 *
 * @author Pablito
 */
public class StringAlgorithms {
    // 1.1 Is Unique: Implement an algorithm to determine if a string has all 
    // unique characters. What if you cannot use additional data structures?
    public static boolean hasAllUniqueChars(String myStr){
        /* Iterate through string
         * Keep hash table mapping chars to bool val indicating whether they've 
         * already been seen
         * If character is seen for a second time, return false
         * If no character is seen twice, return true
         */
        
        // Instantiate hash map for storing char data
        HashMap<Character, Boolean> charHashMap = 
                new HashMap<Character, Boolean>();
        
        // Convert String to char array, iterate through char array
        for(char c: myStr.toCharArray()){
            // Get value at key c, and if null, change to true. If not null,
            // that means the char has already appeared and we return false.
            Boolean charVal = charHashMap.get(c);
            if(charVal == null){
                charHashMap.put(c, true);
            }
            else{
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean hasAllUniqueCharsPrimitive(String myStr){
        /* Now we can't use additional data structures...
        *  Brute force: For each char str[i], check all chars after for match
        *               RUNTIME: O(n^2)
        *  Better: Sort charArray using merge sort -- O(nlg(n)), then for each
        *          char str[i] check if next char is same
        *          RUNTIME: O(nlg(n))
        */
        
        // Convert String to char array, sort using merge
        char[] charArray = myStr.toCharArray();
        charArray = Sorting.mergeSort(charArray);
        
        // Iterate through sorted char array
        for(int i=0; (i+1)<charArray.length; i++){
            // Check if character is same as next
            if(charArray[i] == charArray[i+1]){
                return false;
            }
        }
        
        return true;
    }
    
    
    // 1.2 Check Permutation: Given two strings, write a method to decide if one
    // is a permutation of the other.
    public static boolean isPermutation(String str1, String str2){
        // Immediately dismiss if strings have different length, or if either
        // has length 0
        if (str1.length() != str2.length()){
            return false;
        }
        if (str1.length() == 0){
            return false;
        }
        
        // Create array tracking number of times each char appears
        int[] charFreqTracker = new int[256];
        int i;
        
        // Populate charFreqTracker with first string's char frequencies
        for(char c : str1.toCharArray()){
            i = (int) c;
            charFreqTracker[i] += 1;
        }
        
        // Decrement charFreqTracker with second string, if any incongruencies
        // return false
        for(char c: str2.toCharArray()){
            i = (int) c;
            charFreqTracker[i] -= 1;
            if(charFreqTracker[i] < 0){
                return false;
            }
        }
        
        return true;
    }
    
    // 1.3 URLify: Write a method to replace all spaces in a string with '%20'.
    // You may assume that the string has sufficient space at the end to hold
    // the additional characters, and that you are given the "true" length of
    // the string. Use character array for Java
    // Input:  "Mr John Smith    ", 13
    // Output: "Mr%20John%20Smith"
    public static String urlify(char[] charArray, int size){
        int i;
        int j;
        int length = charArray.length;
        char[] urlCharArray = new char[length];

        j = 0;
        for (i=0; i<size; i++){
            char c = charArray[i];
            if(c == ' '){
                urlCharArray[j] = '%';
                j++;
                urlCharArray[j] = '2';
                j++;
                urlCharArray[j] = '0';
                j++;
            } else {
                urlCharArray[j] = charArray[i];
                j++;
            }
        }
        
        return new String(urlCharArray);
    }
    
    /* 1.4 Palindrome Permutation: Given a string, write a function to check if
     * it is a permutation of a palindrome. A palindrome is a word or phrase
     * that is the same forwards and backwards. A permutation is a rearrangement
     * of letters. The palindrome does not need to be limited to just dictionary
     * words.
    */
    public static boolean palindromePermutation(String inputString){
        // Convert all characters to lower case and remove spaces
        inputString = inputString.toLowerCase().replace(" ", "");

        int length = inputString.length();
        int numOdds;
        if(Integers.isOdd(length)){
            numOdds = 1;
        } else {
            numOdds = 0;
        }

        int[] charTracker = new int[256];
        for(char c : inputString.toCharArray()){
            int index = (int) c;
            charTracker[index] += 1;
        }

        for(int c : charTracker){
            if(Integers.isOdd(c)){
                numOdds -= 1;
            }
        }
        
        return (boolean) (numOdds == 0);
    }
    
    /* 1.5 One Away: There are three types of edits that can be performed on 
     * strings: insert a character, remove a character, or replace a character. 
     * Given two strings, write a function to check if they are one edit (or 
     * zero edits) away.
    */
    public static boolean oneAway(String inputString1, String inputString2){
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        
        if(inputString1.equals(inputString2)){
            return true;
        } else if(length1 == length2){
            return checkReplace(inputString1, inputString2);
        } else if(length1 - length2 == 1){
            return checkAdd(inputString2, inputString1);
        } else if(length2 - length1 == 1){
            return checkAdd(inputString1, inputString2);
        } else {
            return false;
        }
    }
    
    public static boolean checkReplace(String inString1, String inString2){
        int length = inString1.length();
        boolean flag = false;
        
        for(int i=0; i<length; i++){
            if(flag && (inString1.charAt(i)!=inString2.charAt(i))){
                return false;
            } else if(inString1.charAt(i)!=inString2.charAt(i)){
                flag = true;
            }
        }
        
        return flag;
    }
    
    public static boolean checkAdd(String inString1, String inString2){
        // inString1 always 1 shorter than inString2
        int length1 = inString1.length();
        int length2 = length1 + 1;
        int i=0;
        int j=0;
        boolean flag = false;
        
        while(i<length1){
            if (inString1.charAt(i) != inString2.charAt(j)){
                if(flag){
                    return false; 
                } else {
                    flag = true;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
      
        return true;
    }
    
    /* 1.6 String Compression: Implement a method to perform basic string 
     * compression using the counts of repeated characters. For example, the
     * string aabcccccaaa would become a2b1c5a3. If the "compressed" string 
     * would not become smaller than the original string, your method should
     * return the original string. You can assume the string has only uppercase
     * and lowercase letters (a-z).
    */
    public static String stringCompression(String inputString){
        int length = inputString.length();
        char[] inputCharArray = inputString.toCharArray();
        String outputString = new String();
        
        char lastChar = inputCharArray[0];
        char thisChar;
        int charCount = 0;
        
        for(int i=0; i<length && outputString.length()<length; i++){
            thisChar = inputCharArray[i];
            if(thisChar == lastChar){
                charCount += 1;
            } else {
                outputString += lastChar;
                outputString += ("" + charCount);
                
                lastChar = thisChar;
                charCount = 1;
            }
        }
        
        if(outputString.length()>=length){
            return inputString;
        } else {
            outputString += lastChar;
            outputString += ("" + charCount);
            return outputString;
        }
    }
    
    /* 1.9 String Rotation: Assume you have a method isSubstring which checks if
     * one word is a substring of another. Given two strings, s1 and s2, write
     * code to check if s2 is a rotation of s1 using only one call to 
     * isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").
    */
    public static boolean stringRotation(String s1, String s2){
        int length = s1.length();
        if((length == s2.length()) && (length > 0)){
            String s1s1 = s1 + s1;
            return isSubstring(s2, s1s1);
        }
        return false;
    }
    
    public static boolean isSubstring(String s1, String s2){
        return s2.contains(s1);
    }
}

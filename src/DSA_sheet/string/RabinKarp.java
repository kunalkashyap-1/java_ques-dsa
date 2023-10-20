package DSA_sheet.string;

import java.util.ArrayList;

public class RabinKarp {
    static final int PRIME = 101;

    public static void main(String[] args) {
        String text = "ABBAACAADAABAAABAA";
        String pattern = "AABA";
        ArrayList<Integer> indices = search(text, pattern);

        if (indices.isEmpty()) {
            System.out.println("Pattern not found in the text.");
        } else {
            System.out.println("Pattern found at indices: " + indices);
        }
    }

    static ArrayList<Integer> search(String text, String pattern) {
        ArrayList<Integer> indices = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();
        int patternHash = hash(pattern, m);
        int textHash = hash(text, m);

        //Iterate through the text
        for (int i = 0; i <= n - m; i++) {
            //If the current substring hash matches the patterns hash, check for an exact match
            if (textHash == patternHash && text.substring(i, i + m).equals(pattern)) {
                indices.add(i);
            }
            //Recalculate the hash for the next substring(sliding window && roling hash function)
            if (i < n - m) {
                textHash = recalculateHash(text, textHash, i, m);
            }
        }
        return indices;//return list of indices that match the pattern
    }

    static int hash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            //calculate the hash using the formula (hash *256 + character)% PRIME
            hash = (hash * 256 + str.charAt(i)) % PRIME;
        }
        return hash;
    }

    //Method to recalculate the hash when moving the sliding window i.e rolling hash
    static int recalculateHash(String str, int oldHash, int oldIndex, int length) {
        int newHash = (oldHash - str.charAt(oldIndex) * (int) Math.pow(256, length - 1) * 256);
        newHash = (newHash + str.charAt(oldIndex + length)) % PRIME;
        if (newHash < 0) {
            newHash += PRIME;
        }
        return newHash;
    }

}

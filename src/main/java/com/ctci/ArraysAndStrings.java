package com.ctci;

import java.util.Arrays;

public class ArraysAndStrings {

    public boolean hasAllUniqueCharacters(String word) {
        if (word == null) {
            return false;
        }

        word = sort(word);

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public String reverseCStyleString(String cString) {
        if (cString == null) {
            return null;
        }

        String actualWordForward = cString.substring(0, cString.length() - 1);
        String actualWordBackward = "";

        for (int i = 0; i < actualWordForward.length(); i++) {
            actualWordBackward = actualWordForward.charAt(i) + actualWordBackward;
        }

        return actualWordBackward.concat("0");
    }

    public String removeDuplicateCharacters(String word) {
        if (word == null) {
            return null;
        }

        char current = ' ';

        int i = 0;
        while (i < word.length()) {
            current = word.charAt(i);

            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(j) == current) {
                    word = word.substring(0, j) + word.substring(j + 1, word.length());
                }
            }

            i++;
        }

        return word;
    }

    public boolean areAnagrams(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return true;
        }

        if ((word1 == null && word2 != null) || (word1 != null && word2 == null)) {
            return false;
        }

        return sort(word1).equals(sort(word2));
    }

    private String sort(String word) {
        byte[] wordBytes = word.getBytes();
        Arrays.sort(wordBytes);
        return new String(wordBytes);
    }

    public String sanitizeSpaces(String word) {
        if (word == null) {
            return null;
        }

        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i) == ' ') {
                word = word.substring(0, i) + "%20" + word.substring(i + 1, word.length());
                i = i + 3;
            } else {
                i = i + 1;
            }
        }

        return word;
    }

    // Todo: do this in place
    public String[][] rotateImage(String[][] image) {
        if (image == null) {
            return null;
        }

        int N = image[0].length;
        String[][] rotatedImage = new String[N][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                rotatedImage[N - y - 1][x] = image[x][y];
            }
        }

        return rotatedImage;
    }

    public int[][] zeroOut(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] copy = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(matrix[i][j] == 0) {
                    for (int k = 0; k < N; k++) {
                        copy[i][k] = 0;
                    }

                    for (int l = 0; l < M; l++) {
                        copy[l][j] = 0;
                    }
                }
            }
        }

        return copy;
    }

    public boolean isSubstringOf(String word, String possibleSubstring) {
        if(word == null && possibleSubstring == null) {
            return true;
        }

        if(possibleSubstring.length() == 0) {
            return true;
        }

        if(possibleSubstring.length() > word.length()) {
            return false;
        }

        for (int i = 0; i < word.length() - possibleSubstring.length() + 1; i++) {
            if(possibleSubstring.equals(word.substring(i,i + possibleSubstring.length()))) {
                return true;
            }
        }

        return false;
    }

    // Todo: answer this one
    public boolean isRotationOf(String erbottlewat, String waterbottle) {
        return true;
    }
}

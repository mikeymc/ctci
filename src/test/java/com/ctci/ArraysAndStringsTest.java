package com.ctci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndStringsTest {
    ArraysAndStrings subject;
    
    @Before
    public void setUp() {
        subject = new ArraysAndStrings();
    }

    @Test
    public void hasAllUniqueCharacters() {
        assertFalse(subject.hasAllUniqueCharacters(null));
        assertFalse(subject.hasAllUniqueCharacters("dd"));
        assertFalse(subject.hasAllUniqueCharacters("ddd"));
        assertFalse(subject.hasAllUniqueCharacters("dacde"));
        assertTrue(subject.hasAllUniqueCharacters("da"));
        assertTrue(subject.hasAllUniqueCharacters("dac"));
        assertTrue(subject.hasAllUniqueCharacters("d"));
    }

    @Test
    public void reverseCStyleString() {
        assertNull(subject.reverseCStyleString(null));
        assertEquals(subject.reverseCStyleString("0"), "0");
        assertEquals(subject.reverseCStyleString("a0"), "a0");
        assertEquals(subject.reverseCStyleString("ab0"), "ba0");
        assertEquals(subject.reverseCStyleString("cat0"), "tac0");
        assertEquals(subject.reverseCStyleString("aaa0"), "aaa0");
        assertEquals(subject.reverseCStyleString("aac0"), "caa0");
        assertEquals(subject.reverseCStyleString("aca0"), "aca0");
    }

    @Test
    public void removeDuplicateCharacters() {
        assertNull(subject.removeDuplicateCharacters(null));
        assertEquals(subject.removeDuplicateCharacters("a"), "a");
        assertEquals(subject.removeDuplicateCharacters("abc"), "abc");
        assertEquals(subject.removeDuplicateCharacters("abcbe"), "abce");
        assertEquals(subject.removeDuplicateCharacters("babadjimarinov"), "badjimrnov");
    }

    @Test
    public void areAnagrams() {
        assertTrue(subject.areAnagrams(null, null));
        assertTrue(subject.areAnagrams("a", "a"));
        assertTrue(subject.areAnagrams("", ""));
        assertTrue(subject.areAnagrams("crap", "carp"));
        assertTrue(subject.areAnagrams("abcde", "edbac"));
        assertFalse(subject.areAnagrams("abcde", "edbfc"));
        assertFalse(subject.areAnagrams("abcnde", "edrbac"));
    }

    @Test
    public void sanitizeSpaces() {
        assertEquals(subject.sanitizeSpaces(null), null);
        assertEquals(subject.sanitizeSpaces(""), "");
        assertEquals(subject.sanitizeSpaces(" "), "%20");
        assertEquals(subject.sanitizeSpaces("  "), "%20%20");
        assertEquals(subject.sanitizeSpaces(" hi"), "%20hi");
        assertEquals(subject.sanitizeSpaces("h i"), "h%20i");
        assertEquals(subject.sanitizeSpaces("hi "), "hi%20");
        assertEquals(subject.sanitizeSpaces("hi there, how are you?"), "hi%20there,%20how%20are%20you?");
    }

    @Test
    public void rotateImage() {
        assertNull(subject.rotateImage(null));

        String[][] image;
        String[][] rotatedImage;

        image = new String[][]{{"ab"}};
        assertArrayEquals(subject.rotateImage(image), image);

        /*
        ab cd   ef ab
        ef gh   gh cd
         */
        image = new String[][]{{"ab", "ef"}, {"cd", "gh"}};
        rotatedImage = new String[][]{{"ef", "gh"}, {"ab", "cd"}};
        assertArrayEquals(subject.rotateImage(image), rotatedImage);

        /*
        ab cd ef   mn gh ab
        gh ij kl   op ij cd
        mn op qr   qr kl ef

        {0, 0} -> {2, 0}
        {1, 0} -> {2, 1}
        {2, 0} -> {2, 2}

        {0, 1} -> {1, 0}
        {1, 1} -> {1, 1}
        {2, 1} -> {1, 2}

        {0, 2} -> {0, 0}
        {1, 2} -> {0, 1}
        {2, 2} -> {0, 2}
         */
        image = new String[][]{{"ab", "gh", "mn"}, {"cd", "ij", "op"}, {"ef", "kl", "qr"}};
        rotatedImage = new String[][]{{"mn", "op", "qr"}, {"gh", "ij", "kl"}, {"ab", "cd", "ef"}};
        assertArrayEquals(subject.rotateImage(image), rotatedImage);

        /*
        ab cd ef gh   yz qr ij ab
        ij kl mn op   12 st kl cd
        qr st uv wx   34 uv mn ef
        yz 12 34 56   56 wx op gh
         */
        image = new String[][]{{"ab", "ij", "qr", "yz"}, {"cd", "kl", "st", "12"}, {"ef", "mn", "uv", "34"}, {"gh", "op", "wx", "56"}};
        rotatedImage = new String[][]{{"yz", "12", "34", "56"}, {"qr", "st", "uv", "wx"}, {"ij", "kl", "mn", "op"}, {"ab", "cd", "ef", "gh"}};
        assertArrayEquals(subject.rotateImage(image), rotatedImage);
    }

    @Test
    public void zeroOutRowAndColumn() {
        int[][] matrix;
        int[][] zeroedMatrix;

        matrix = new int[][]{{1}};
        assertArrayEquals(subject.zeroOut(matrix), matrix);

        matrix = new int[][]{{0}};
        assertArrayEquals(subject.zeroOut(matrix), matrix);

        /*
        1 2
        3 4
         */
        matrix = new int[][]{{1, 3}, {2, 4}};
        assertArrayEquals(subject.zeroOut(matrix), matrix);

        /*
        0 2
        3 4
         */
        matrix = new int[][]{{0, 3}, {2, 4}};
        zeroedMatrix = new int[][]{{0, 0}, {0, 4}};
        assertArrayEquals(subject.zeroOut(matrix), zeroedMatrix);

        /*
        0 0
        3 4
         */
        matrix = new int[][]{{0, 3}, {0, 4}};
        zeroedMatrix = new int[][]{{0, 0}, {0, 0}};
        assertArrayEquals(subject.zeroOut(matrix), zeroedMatrix);

        /*
        1 2 3
        4 5 6
        7 8 9
         */
        matrix = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(subject.zeroOut(matrix), matrix);

        /*
        1 2 3
        4 5 0
        7 8 9
         */
        matrix = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 0, 9}};
        zeroedMatrix = new int[][]{{1, 0, 7}, {2, 0, 8}, {0, 0, 0}};
        assertArrayEquals(subject.zeroOut(matrix), zeroedMatrix);

        /*
        1 2 3
        4 5 0
        0 8 9
         */
        matrix = new int[][]{{1, 4, 0}, {2, 5, 8}, {3, 0, 9}};
        zeroedMatrix = new int[][]{{0, 0, 0}, {2, 0, 0}, {0, 0, 0}};
        assertArrayEquals(subject.zeroOut(matrix), zeroedMatrix);

        /*
        1 2 3
        4 0 6
        7 8 9
         */
        matrix = new int[][]{{1, 4, 7}, {2, 0, 8}, {3, 6, 9}};
        zeroedMatrix = new int[][]{{1, 0, 7}, {0, 0, 0}, {3, 0, 9}};
        assertArrayEquals(subject.zeroOut(matrix), zeroedMatrix);

        /*
         1  2  3  4
         5  6  7  8
         9 10 11 12
        13 14 15 16
         */
        matrix = new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}};
        assertArrayEquals(subject.zeroOut(matrix), matrix);

        /*
         1  0  3  4
         5  6  7  8
         9 10 11 12
        13 14 15 16
         */
        matrix = new int[][]{{1, 5, 9, 13}, {0, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}};
        zeroedMatrix = new int[][]{{0, 5, 9, 13}, {0, 0, 0, 0}, {0, 7, 11, 15}, {0, 8, 12, 16}};
        assertArrayEquals(subject.zeroOut(matrix), zeroedMatrix);

        /*
         1  0  3  4
         5  6  7  8
         9 10  0 12
        13 14 15 16
         */
        matrix = new int[][]{{1, 5, 9, 13}, {0, 6, 10, 14}, {3, 7, 0, 15}, {4, 8, 12, 16}};
        zeroedMatrix = new int[][]{{0, 5, 0, 13}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 8, 0, 16}};
        assertArrayEquals(subject.zeroOut(matrix), zeroedMatrix);
    }

    @Test
    public void isSubstring() {
        assertTrue(subject.isSubstringOf(null, null));
        assertTrue(subject.isSubstringOf("", ""));
        assertTrue(subject.isSubstringOf("a", ""));
        assertTrue(subject.isSubstringOf("ab", "b"));
        assertTrue(subject.isSubstringOf("ab", "ab"));
        assertFalse(subject.isSubstringOf("ab", "cbd"));
        assertFalse(subject.isSubstringOf("ab", "c"));
        assertTrue(subject.isSubstringOf("banana", "ana"));
        assertFalse(subject.isSubstringOf("banana", "and"));
        assertTrue(subject.isSubstringOf("heroism", "ero"));
        assertTrue(subject.isSubstringOf("heroism", "is"));
        assertTrue(subject.isSubstringOf("heroism", "heroism"));
        assertTrue(subject.isSubstringOf("heroism", "hero"));
    }

    @Test
    public void isRotation() {
        assertTrue(subject.isRotationOf("erbottlewat", "waterbottle"));
    }
}
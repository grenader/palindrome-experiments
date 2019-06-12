package com.grenader.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    Palindrome service = new Palindrome();

    @Test
    public void testGetLongestPalindrome_double() {
        assertEquals("m", service.getLongestPalindrome("m"));
        assertEquals("mm", service.getLongestPalindrome("mm"));
        assertEquals("wedew", service.getLongestPalindrome("mmiwedew"));

        assertEquals("pfmmfp", service.getLongestPalindrome("ejdwedpfmmfps"));
    }

    @Test
    public void testGetLongestPalindrome_center() {
        assertEquals("mom", service.getLongestPalindrome("mom"));
        assertEquals("dmomd", service.getLongestPalindrome("dmomdasas"));
        assertEquals("dmomd", service.getLongestPalindrome("asasdmomd"));

        assertEquals("klhmomhlk", service.getLongestPalindrome("nweqinwqdindklhmomhlkasas"));
    }

    @Test
    public void testTestCenter_index0() {
        assertFalse(service.testCenter("m", 0));

        assertTrue(service.testCenter("mm", 0));
    }

    @Test
    public void testTestCenter_index1() {
        assertFalse(service.testCenter("m", 1));

        assertFalse(service.testCenter("mm", 1));
    }

    @Test
    public void testTestCenter_success() {
        assertTrue(service.testCenter("mdm", 1));


        assertTrue(service.testCenter("dmooms", 2));
        assertTrue(service.testCenter("dmogoms", 3));

        assertTrue(service.testCenter("wmdmq", 2));

    }

    @Test
    public void testTestCenter_index2() {
        assertFalse(service.testCenter("m", 2));
        assertFalse(service.testCenter("mm", 2));
        assertFalse(service.testCenter("mdm", 2));
    }

    @Test
    public void tesGetPolydrome1_two() {
        assertEquals("mm", service.getPolydrome("amm", 1));

        assertEquals("mm", service.getPolydrome("dsammdd", 3));
        assertEquals("dd", service.getPolydrome("dsammdd", 5));
    }

    @Test
    public void tesGetPolydrome1_four() {
        assertEquals("tmmt", service.getPolydrome("atmmtede", 2));
        assertEquals("tmmt", service.getPolydrome("ffatmmt", 4));

        assertEquals("ghmmhg", service.getPolydrome("dsaghmmhgdd", 5));
        assertEquals("kddk", service.getPolydrome("dsaghmmhgkddkll", 10));

    }

    @Test
    public void tesGetPolydrome2_two() {
        assertEquals("mfm", service.getPolydrome("mfm", 1));
        assertEquals("mfm", service.getPolydrome("amfm", 2));

        assertEquals("mfm", service.getPolydrome("dsamfmdd", 4));
    }

    @Test
    public void tesGetPolydrome2_four() {
        assertEquals("tmumt", service.getPolydrome("atmumtede", 3));
        assertEquals("tmumt", service.getPolydrome("ffatmumt", 5));

        assertEquals("ghmumhg", service.getPolydrome("dsaghmumhgdd", 6));
        assertEquals("kdudk", service.getPolydrome("dsaghmmhgkdudkll", 11));

    }
}
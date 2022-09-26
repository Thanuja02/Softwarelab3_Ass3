package qno_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertionsTest {

    @Test
    @DisplayName("Test Assertion ArrayEquals")
    void initializeArray() {
        Assertions test = new Assertions();
        assertArrayEquals(new int[]{0, 0, 0, 0, 0},test.initializeArray(5));
    }

    @Test
    @DisplayName("Test Assertion False and True")
    void isPalindrome() {
        Assertions test = new Assertions();
        assertFalse(test.isPalindrome("tomato"));
        assertTrue(test.isPalindrome("racecar"));
    }
}
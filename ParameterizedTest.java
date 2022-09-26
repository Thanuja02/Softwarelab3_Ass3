package qno_7;

import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.EnumSet;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;

class ParameterizedTests {

    @ParameterizedTest(name = "#{index} - Test with Integer : {0}")
    @ValueSource(ints = {-2,3,4,-5,6,17})
    void square(int n) {
        Parameterized test =  new Parameterized();
        assertEquals(n*n,test.square(n));
    }

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource({
            "Hello World!,      12",
            "Software,   8",
            ",    -1",
            "a small string, 14"
    })
    void stringLength(String s, int len) {
        Parameterized test =  new Parameterized();
        assertEquals(len,test.stringLength(s));
    }

    enum Dept {
        CSE,ECE,MEC,CME,MME,MIN,CIV,EEE;
    }

    @ParameterizedTest(name = "#{index} - Dept contains {0}?")
    @EnumSource(value = Dept.class, names = {"EEE","ECE","CIV","MEC","CSE","CME","MME","MIN"})
    void testEnumDept(Dept dept) {
        assertTrue(EnumSet.allOf(Dept.class).contains(dept));
    }

    @ParameterizedTest(name = "#{index} - isEmpty()? {0}")
    @EmptySource
    void isEmpty(String arg) {
        assertTrue(arg.length()==0);
    }

    @ParameterizedTest(name = "#{index} - isNull()? {0}")
    @NullSource
    void isNull(String arg) {
        assertNull(arg);
    }

    @ParameterizedTest(name = "#{index} - Test with Int : {0}")
    @MethodSource("IntegersRange")
    void CheckRange(int n) {
        assertTrue(n >= 90 && n < 100 );
    }

    static IntStream IntegersRange() {
        return IntStream.range(90, 100);
    }
}
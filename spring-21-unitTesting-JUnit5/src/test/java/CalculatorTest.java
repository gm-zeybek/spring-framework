

import org.example.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @BeforeAll
    static void setup(){
        System.out.println("beforeAll is executing");
    }
    @AfterAll
    static void teardownAll(){
        System.out.println("afterAll is executing");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("before each is executes");
    }
    @AfterEach
    void tearDown(){
        System.out.println("after each is executing");
    }


    @Test
    void testCase1() {

        fail("not implemented yet");
    }

    @Test
    void testCase2() {
        assertEquals("add", Calculator.operator);
//        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3() {
        assertEquals(5,Calculator.add(2,3),"should be equal");

    }

    @Test
    void testCase4() {
    String nullString = null;
        String notNullString = "cydeo";
        assertNull(nullString,"should be null");
        assertNotNull(notNullString,"should not be null");
    }

    @Test
    void testCase5() {
    Calculator c1 = new Calculator();
    Calculator c2 = c1;
    assertSame(c1,c2,"should be same");
    c2 = new Calculator();
    assertNotSame(c1,c2,"should not be same");
    }

    @Test
    void testCase6() {

        int actual = Calculator.add(2,3);
        assertEquals(5,actual,"should be equal");
    }

    @Test
    void testCase7() {
    assertThrows(IllegalAccessException.class,()->Calculator.add2(4,3));
    }


}

import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {


    // value source
    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    void testCase1(String args){
//        Assertions.assertTrue(!args.isEmpty());
        assertFalse(args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void testCase2(int num){
        assertEquals(0,num%3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
//    @NullSource
//    @EmptySource
    @NullAndEmptySource

    void testCase3(String args){

        assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("myMethodSource")
    void testCase4(int args){
        assertNotNull(args);
    }

    // source method
    static int[] myMethodSource(){
        return new int[] {1,2,3};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30","20,30,50","100,200,300"})
void testCase5(int num1,int num2, int num3){
        assertEquals(num3 , Calculator.add(num1,num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void testCase6(int num1, int num2, int num3){
        assertEquals(num3, Calculator.add(num1,num2));
    }
}

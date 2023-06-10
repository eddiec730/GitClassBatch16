package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int mulitiplication(int number1, int number2){
        return number1 * number2;
    }

    @Test
    public void validateMultiplication(){
        int actualResult=mulitiplication(3,4);
        int expectedResult=12;
//        if(actualResult==expectedResult){
//            System.out.println("Passed");
//        }else{
//            System.out.println("Failed");
//        }

        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void validateZero(){
        int actual=mulitiplication(0,9999);
        int expected=0;
        Assert.assertTrue(actual==expected);

    }
    @Test
    public void validateNegativeWithPositive(){
        int actual=mulitiplication(-1,9);
        int expected=-9;
        Assert.assertFalse(actual!=expected);

    }
    @Test
    public void validateNegativeWithNegative(){
//        int actual=multiplication(-1,-5); we won't do it this way in level 3 selenium
//        int expected=5;
        Assert.assertEquals(mulitiplication(-1,-5),5);

    }
}

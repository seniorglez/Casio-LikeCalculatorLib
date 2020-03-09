package com.seniorglez.calc;




//useful example https://examples.javacodegeeks.com/enterprise-java/maven/junit-maven-example/

import com.seniorglez.calc.model.Matrix;
import org.junit.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest extends Calc {



    @BeforeClass
    public static void instanceCalculator(){//idk if static test are ok
      System.out.println("Starting tests");
    }
    @Before
    public void beforeEachTest(){
        System.out.println("Text starting");
    }
    @After
    public void afterEachTest(){
        System.out.println("Test ending");
    }

    @Test
    public void testScientificNotationPositiveExpected(){
        int max = Integer.MAX_VALUE;
        assertTrue(Formater.formatScientificNotation(max).equals("2.147484E9"));
    }
    @Test
    public void  testScientificNotationNegativeExpected(){
        int min = Integer.MIN_VALUE;
        assertTrue(Formater.formatScientificNotation(min).equals("-2.147484E9"));
    }

    @Test
    public void testlong2Binary(){
        assertTrue(Conversion.convertDecimalToBinary(12313).equals("11000000011001"));
    }
    @Test
    public void testNegativelong2Binary(){
        assertTrue(Conversion.convertDecimalToBinary(-12313).equals("1111111111111111111111111111111111111111111111111100111111100111"));
    }

    @Test
    public void testBinary2Decimal(){
        assertEquals(12313,Conversion.convertBinaryToDecimal("11000000011001"));
    }

    @Ignore
    @Test
    public void testNegativeBinary2Decimal(){

    }



    @Test
    public void testDecimal2Hex(){
       assertTrue(Conversion.convertDecimalToHex(158).equals("9e"));
    }

    @Ignore
    @Test
    public void testNegativeDecimal2Hex(){

    }

    @Test
    public void testHex2Decimal(){
        assertEquals(158L,Conversion.convertHexToDecimal("9e"));
    }

    @Test
    public void testNegativeHex2Decimal(){
        assertEquals(-158L,Conversion.convertHexToDecimal("-9e"));
    }


    @Test
    public void testCalculate(){
        assertTrue(7.5==calculate("((4 - 2^3 + 1) * -sqrt(3*3+4*4)) / 2"));
    }

    @Test
    public void TestCalculateNumberOfDigits(){
        assertEquals(5,calculateNumberOfDigits(12345));
    }

    @Test
    public void TestDaysBetweenDates(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = "23 01 2020";
        String inputString2 = "27 01 2020";
        try {
            Date date1 = sdf.parse(inputString1);
            Date date2 = sdf.parse(inputString2);
            assertEquals(4,Delorean.calculateDaysBetweenDates(date1,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Ignore
    @Test
    public void TestExactDaysBetweenDates(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh mm ss");
        String inputString1 = "10 10 2013 11 30 10";
        String inputString2 = "13 10 2013 20 35 55";
        try {
            Date date1 = sdf.parse(inputString1);
            Date date2 = sdf.parse(inputString2);
          //  assertTrue(4==calculator.calculateExactDaysBetweenDates(date1,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestQuadraticEquation2Sol(){
        double[]sol={3,2};
        double[]result=calculateSecondGradeEquation(1,-5,6);
        Object[]arr1 ={sol};
        Object[]arr2={result};
        assertTrue(Arrays.deepEquals(arr1,arr2));
    }

    @Test
    public void  TestQuadraticEquation1Sol(){
        double[]sol={1};
        double[]result=calculateSecondGradeEquation(1,-2,1);
        Object[]arr1 ={sol};
        Object[]arr2={result};
        assertTrue(Arrays.deepEquals(arr1,arr2));
    }

    @Test
    public void TestQuadraticEquationNoRealSol(){
        assertTrue(calculateSecondGradeEquation(1,2,6)==null);
    }

    @Test
    public void DNILetterTest(){//example form the spanish gob http://www.interior.gob.es/web/servicios-al-ciudadano/dni/calculo-del-digito-de-control-del-nif-nie
        assertTrue(calculateDNILetter(12345678)=='Z');
    }

    @Test
    public void testNormalizeChar(){
       assertTrue(normalizeChar("[o]","*","Hola hola").equalsIgnoreCase("h*la h*la"));
    }
    @Test
    public void testNormalizeExpression(){
        Map p = new HashMap<String,String>();
        p.put("[o]","*");
        p.put("[a]","/");
        assertTrue(expressionNormalizer("Hola hola",p).equalsIgnoreCase("h*l/ h*l/"));
    }

    @Test
    public void testNormalizeMathExpression(){
        assertTrue(normalizeMathExpression("((4 - 2^3 + 1) · -sqrt(3·3+4*4)) ÷ 2").equals("((4 - 2^3 + 1) * -sqrt(3*3+4*4)) / 2"));
    }

    @Test
    public void calculateUnormalizeExpression(){
        assertTrue(7.5==calculate("((4 - 2^3 + 1) · -sqrt(3·3+4*4)) ÷ 2"));
    }

    @Test
    public void calculateMatrixDeterminant(){
        double[][]matrix = new double[5][5];
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=312;
        matrix[0][3]=132;
        matrix[0][4]=12;
        matrix[1][0]=132;
        matrix[1][1]=123;
        matrix[1][2]=31;
        matrix[1][3]=2;
        matrix[1][4]=3;
        matrix[2][0]=12;
        matrix[2][1]=312;
        matrix[2][2]=312;
        matrix[2][3]=4;
        matrix[2][4]=1;
        matrix[3][0]=2;
        matrix[3][1]=1;
        matrix[3][2]=2;
        matrix[3][3]=342;
        matrix[3][4]=2;
        matrix[4][0]=2;
        matrix[4][1]=2;
        matrix[4][2]=234;
        matrix[4][3]=2;
        matrix[4][4]=234;

        assertTrue(new Matrix(matrix).getDeterminant().toString().equals("948406639458.0000102756821272715293815541180399157942983916305851840"));

    }

    @Test
    public void testMatrixToString(){
        double[][]matrix = new double[5][5];
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=312;
        matrix[0][3]=132;
        matrix[0][4]=12;
        matrix[1][0]=132;
        matrix[1][1]=123;
        matrix[1][2]=31;
        matrix[1][3]=2;
        matrix[1][4]=3;
        matrix[2][0]=12;
        matrix[2][1]=312;
        matrix[2][2]=312;
        matrix[2][3]=4;
        matrix[2][4]=1;
        matrix[3][0]=2;
        matrix[3][1]=1;
        matrix[3][2]=2;
        matrix[3][3]=342;
        matrix[3][4]=2;
        matrix[4][0]=2;
        matrix[4][1]=2;
        matrix[4][2]=234;
        matrix[4][3]=2;
        matrix[4][4]=234;

       assertTrue(new Matrix(matrix).toString().equals("[[1.0, 2.0, 312.0, 132.0, 12.0], [132.0, 123.0, 31.0, 2.0, 3.0]," +
               " [12.0, 312.0, 312.0, 4.0, 1.0], [2.0, 1.0, 2.0, 342.0, 2.0], [2.0, 2.0, 234.0, 2.0, 234.0]]"));

    }

    @Test
    public void testIntBetween(){
        int r;
        for (int i=0;i<2000000;++i){
            r=generateIntBetween(0,i);
            assertTrue(r>=0&&r<=i);
        }
    }

    @Test
    public void testAverage(){
        int[]numbers={3,1,13,41,231};
        boolean testPass = (57.8f==Statistics.getAverageOf(numbers))?true:false;
        assertTrue(testPass);
    }

    @Test
    public  void testVariance(){
        int[]numbers={ 0,2,4,5,8,10,10,15,38};
        boolean testPass = (115.283966f==Statistics.getVarianceOf(numbers))?true:false;
        assertTrue(testPass);
    }


    @Test
    public  void testAbsFrequency(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");
        assertTrue(Statistics.getAbsoluteFrequency(list,"a")==4);
    }


    @Test
    public void testRelativeFrecuency(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");
        assertTrue(Statistics.getRelativeFrequency(list,"a")==(4f/9));
    }

    @Test
    public void TestMedian(){
        int[]data = {0,1,2,2,2,2,2,2,2,3,3,3,3};
        assertTrue(Statistics.getMedian(data)==2);
    }

    @Test
    public void TestPercentileKnowingPoss(){
        int[]data=new int[47];
        for (int i:data) i=1;
        assertTrue(Statistics.getPercentileOfPosition(data,12)==24.468084f);
    }
/*
    @Test
    public void TestPercentileKnowingValue(){//idk why this is does not working
        int[]data=new int[47];
        for (int i:data) i=1;
        data[11]=1999;
        System.out.print(Statistics.getPercentileOfValue(data,1999));
    }
*/
    @Test
    public void testFindFirst(){
        int[]data=new int[47];
        for (int i:data) i=1;
        data[11]=1999;
       assertTrue(findFirst(data,1999)==11);
    }
}
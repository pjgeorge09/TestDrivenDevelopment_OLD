/***********************************************************\
\	Peter J George    	|     Assignment 3					/
/	CMSC 355 		  	|	  Spring 2019					\
\***********************************************************/
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
public class FractionalNumberTest{
	
	private FractionalNumber num1;
	private FractionalNumber num2;
	
	@Before
	public void setup() throws Exception {
		//base cases
		num1 = new FractionalNumber(1,2);
		num2 = new FractionalNumber(1,4);
	}	
	
	@Test
	public void testSetDenominator() {
		//Try setting denominator to be 0
		try {
			 	num1.setDenominator(0);
		     } 
		 catch (Exception e) {
			 	assertEquals("Denominator should be ", 2, num1.getDenominator());
		 }
		 
		 //Try setting denominator standard positive number
		 num1.setDenominator(2019);
		 assertEquals("Denominator should be ", 2019, num1.getDenominator());

		 //Try setting denominator negative number
		 num1.setDenominator(-2019);
		 assertEquals("Denominator should be ", 2019, num1.getDenominator());
		 assertEquals("Numerator should be ", -1, num1.getNumerator());
		 
		 //Try with mathematical operator. Should truncate number.
		 num1.setDenominator(3/2);
		 assertEquals("Denominator should be ", 1, num1.getDenominator());
		 
	}
	
	@Test
	public void testSetNumerator() {
		
		//Try setting numerator to be 0		
		num1.setNumerator(0);
		assertEquals("Numerator should be ", 0, num1.getNumerator());
		 
		//Try setting numerator standard positive number
		num1.setNumerator(-2020);
		assertEquals("Numerator should be ", -2020, num1.getNumerator());
		 
		//Try with mathematical operator. Should truncate number.
		num1.setNumerator(7/2);
		assertEquals("Numerator should be ", 3, num1.getNumerator());
		 
	}
	
	@Test
	public void testDefaultConstructor() {	
		//Testing the default constructor
		FractionalNumber numP1P1 = new FractionalNumber();		
		assertEquals("Numerator should be", 1, numP1P1.getNumerator());
		assertEquals("Denominator should be", 1, numP1P1.getDenominator());
	}
	
	@Test
	public void testNormalizeNegativeDenominators() {	
		//Test case where numerator positive, denominator negative.
		num1.setNumerator(6); num1.setDenominator(-7);
		assertEquals("Numerator should be",-6,num1.getNumerator());
		assertEquals("Denominator should be",7,num1.getDenominator());
		
		//Test case where num/denom both negative
		num1.setNumerator(-6); num1.setDenominator(-7);
		assertEquals("Numerator should be ", 6, num1.getNumerator());
		assertEquals("Denominator should be ", 7, num1.getDenominator());
	}
	
	@Test
	public void testAddition() {
		//Testing base cases
		num1.add(num2);
		assertEquals("Numerator should be ", 6, num1.getNumerator());
		assertEquals("Denominator should be ", 8, num1.getDenominator());
		
		//Testing positive + negative
		num1.setNumerator(1); num1.setDenominator(2);
		num2.setNumerator(-1); num2.setDenominator(2);
		num1.add(num2);
		assertEquals("Numerator should be ", 0,num1.getNumerator());
		assertEquals("Denominator should be ", 2,num1.getDenominator());
	 }
	 
	@Test	 
	public void testAddVariousNegatives() {
		 //Testing with negative numbers
		 num1.setNumerator(-2); num1.setDenominator(-3);
		 num2.setNumerator(2); num2.setDenominator(3);
		 num1.add(num2);
		 assertEquals("Numerator should be ", 4, num1.getNumerator());
		 assertEquals("Denominator should be ", 3, num1.getDenominator());
		 
		 num1.setNumerator(0); num1.setDenominator(-4);
		 num2.setNumerator(5); num2.setDenominator(7);
		 num1.add(num2);
		 assertEquals("Numerator should be ", 20, num1.getNumerator());
		 assertEquals("Denominator should be ", 28, num1.getDenominator());
		 
	 }

	@Test
	public void testSubtraction() {
		//Testing standard case
		num1.subtract(num2);
		assertEquals("Numerator should be ", 2, num1.getNumerator());
		assertEquals("Denominator should be ", 8, num1.getDenominator());
		
		//testing with many negatives
		num1.setNumerator(-5); num1.setDenominator(-6);
		num2.setNumerator(-3); num2.setDenominator(4);
		num1.subtract(num2);
		assertEquals("Numerator should be ", 38, num1.getNumerator());
		assertEquals("Denominator should be ", 24, num1.getDenominator());
	}

	@Test
	public void testMultiplication() {
		//base case
		num1.multiply(num2);
		assertEquals("Numerator should be ", 1, num1.getNumerator());
		assertEquals("Denominator should be ", 8, num1.getDenominator());
		
		// should end positive
		num1.setNumerator(-2); num1.setDenominator(-3);
		num2.setNumerator(2); num2.setDenominator(3);
		num1.multiply(num2);
		assertEquals("Numerator should be ", 4, num1.getNumerator());
		assertEquals("Denominator should be ", 9, num1.getDenominator());
		
		// should have 0 numerator
		num1.setNumerator(0); num1.setDenominator(-3);
		num2.setNumerator(2); num2.setDenominator(4);
		num1.multiply(num2);
		assertEquals("Numerator should be ", 0, num1.getNumerator());
		assertEquals("Denominator should be ",12, num1.getDenominator());
	}

	@Test
	public void testDivision() {
		//base case
		num1.divide(num2);
		assertEquals("Numerator should be ", 4, num1.getNumerator());
		assertEquals("Denominator should be ", 2, num1.getDenominator());
				
		// should end positive
		num1.setNumerator(-2); num1.setDenominator(-3);
		num2.setNumerator(2); num2.setDenominator(3);
		num1.divide(num2);
		assertEquals("Numerator should be ", 6, num1.getNumerator());
		assertEquals("Denominator should be ", 6, num1.getDenominator());
				
		// should have 0 numerator
		num1.setNumerator(0); num1.setDenominator(-3);
		num2.setNumerator(2); num2.setDenominator(4);
		num1.divide(num2);
		assertEquals("Numerator should be ", 0, num1.getNumerator());
		assertEquals("Denominator should be ",6, num1.getDenominator());
		
		// negatives everywhere
		num1.setNumerator(-3); num1.setDenominator(-10);
		num2.setNumerator(-2); num2.setDenominator(5);
		num1.divide(num2);
		assertEquals("Numerator should be ", -15, num1.getNumerator());
		assertEquals("Denominator should be ", 20, num1.getDenominator());
		
		// Fail divide by 0
		try {
		 	num2.setNumerator(0);
		 	num1.divide(num2);
	     } 
	 catch (Exception e) {
		 	//Fails
	 }
		
	}
	
	@Test
	public void testEquals() {
		//test nonequal standard
		assertEquals("Should not be equal", false, num1.equals(num2));
		
		//Test equal, different values
		num1.setNumerator(-5); num1.setDenominator(-10);
		num2.setNumerator(1); num2.setDenominator(2);
		assertEquals("Should be equal", true, num1.equals(num2));
		
		//Test different denominators, zero numerator
		num1.setNumerator(0); num1.setDenominator(-10);
		num2.setNumerator(0); num2.setDenominator(2);
		assertEquals("Should be equal", true, num1.equals(num2));		
	}
	
	@Test
	public void testToString() {
		//test base case
		assertEquals("1/2", num1.toString());
		
		//test zero numerator
		num1.setNumerator(0); num1.setDenominator(-10);
		assertEquals("0/10", num1.toString());
		
		//test some negatives
		num1.setNumerator(-4); num1.setDenominator(11);
		assertEquals("-4/11", num1.toString());


	}
}
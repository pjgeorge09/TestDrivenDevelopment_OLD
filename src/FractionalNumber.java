/***********************************************************\
\	Peter J George    	|     Assignment 3					/
/	CMSC 355 		  	|	  Spring 2019					\
\***********************************************************/
public class FractionalNumber {
    private int numerator;
    private int denominator;

    /* Sets default values for numerator & denominator */      
    public FractionalNumber(){  //DONE
        numerator = 1;
        denominator = 1;
    }

    /* A method to receive two integer numbers, and convert them to a fraction view 
     * @param numberator is the first parameter, or the intended numberator
     * @param denominator is the second parameter, or the intended denominator
     */
    public FractionalNumber(int num, int denom){ //DONE
    	
        numerator = num;
        if(denom != 0) {
            denominator = denom;
        }
        else {
            throw new IllegalArgumentException("Denominator cannot be 0.");
        }
        this.normalize();
    }

    /* A method to "Normalize" a fraction, meaning to clear the denominator of negatives
     * if the denominator is negative, you simply multiply both by negative one. Works for all.
     */
    private void normalize(){  //DONE
    	if(this.getDenominator() < 0) {
    		this.setNumerator(this.getNumerator()*-1);
    		this.setDenominator(this.getDenominator()*-1);
    	}
    }

    /* A method to add two FractionalNumber items. Get common denominator, add numerators, set as this
     * @param a = this numerator
     * @param b = this denominator
     * @param c = numerator of fraction being added to a/b
     * @param d = denominator of fraction being added to a/b
     */
    public void add(FractionalNumber otherNum){  //DONE
    	this.normalize(); otherNum.normalize();
    	int a = this.getNumerator();
    	int b = this.getDenominator();
    	int c = otherNum.getNumerator();
    	int d = otherNum.getDenominator();
    	if ( b != d ) {
    		// Make Common Denominators, if not already common
    		a *= d;
    		int temp = b;
    		b *= d;
    		c *= temp;
    		d *= temp;
    	}
    	a += c;
    	// both d and b should now be the exact same
    	this.setNumerator(a);
    	this.setDenominator(b);
    	this.normalize();
    	}
   
    /* A method to subtract two FractionalNumber items. Get common denominator, subtract numerators, set as this
     * @param a = this numerator
     * @param b = this denominator
     * @param c = numerator of fraction being subtracted to a/b
     * @param d = denominator of fraction being subtracted to a/b
     */
    public void subtract(final FractionalNumber otherNum){  //DONE
    	this.normalize(); otherNum.normalize();
    	int a = this.getNumerator();
    	int b = this.getDenominator();
    	int c = otherNum.getNumerator();
    	int d = otherNum.getDenominator();
    	if ( b != d ) {
    		// Make Common Denominators, if not already common
    		a *= d;
    		int temp = b;
    		b *= d;
    		c *= temp;
    		d *= temp;
    	}
    	a -= c;
    	// both d and b should now be the exact same
    	this.setNumerator(a);
    	this.setDenominator(b);
    	this.normalize();
    }

    /* A method to multiply two FractionalNumber items. Straightforward multiplication
     * normalize before and after
     */
    public void multiply(final FractionalNumber otherNum){ //DONE
    	this.normalize(); otherNum.normalize();
    	this.numerator *= otherNum.numerator;
    	this.denominator *= otherNum.denominator;
    	this.normalize();
    }
    
    /* A method to divide a FractionalNumber by another FractionalNumber. Inverse Multiplication while ensuring no zero division
     * normalize before and after
     */
    public void divide(final FractionalNumber otherNum){ //DONE
    	this.normalize(); otherNum.normalize();
    	if (otherNum.getNumerator() != 0) {
    		this.numerator *= otherNum.denominator;
        	this.denominator *= otherNum.numerator;
        	this.normalize();
    	}
    	else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    	
    }

    /* Standard getter. Returns numerator of FractionalObject performed on. */
    public int getNumerator(){ 
        return this.numerator;
    }

    /* Standard getter. Returns denominator of FractionalObject performed on. */
    public int getDenominator(){
        return this.denominator;
    }

    /* Standard setter. Sets this FractionalObject's numerator to be parameter num*/
    public void setNumerator(int num){
    	this.numerator = num;
    }

    /* Standard setter. Sets this FractionalObject's denominator to be parameter denom. Cannot equal zero*/
    public void setDenominator(int denom){
    	if(denom != 0) {
        	this.denominator = denom;
        }
        else {
            throw new IllegalArgumentException("Denominator cannot be 0.");
        }
    	this.normalize();
    }

    /* Method that overrides super class to compare two FractionalNumber objects
     * Returns true if inverse multiplication true.
     * Returns false if other is not an instance of FractionalNumber
     */
    @Override
    public boolean equals(Object other){
    	//Code credit : Professor Duke   - - - Changed nothing as it is already fully functioning and exactly how I would have written it (Format diff maybe)
        if (this == other) return true;
        if (other == null) return false;
        if(!(other instanceof FractionalNumber)) return false;
        FractionalNumber otherNum = (FractionalNumber) other;
        return numerator * otherNum.getDenominator() == otherNum.getNumerator()
* denominator;    
        }
    
    /* Method to convert a FractionalNumber object into a string
     * @Param toReturn = converts numerator int to string, concatanates "/", concatanates denominator int in string form
     * @return returns toReturn
     */
    @Override
    public String toString(){
    	String toReturn = (this.getNumerator() + "/" + this.getDenominator());
        return toReturn;
    }
    
}

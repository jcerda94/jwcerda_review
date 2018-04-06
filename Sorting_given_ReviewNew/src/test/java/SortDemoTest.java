package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Item;
import main.java.SortAlgos;
import main.java.SortDemoData;

class SortDemoTest {

    SortDemoData data = new SortDemoData();


    /**
    * testNumber checks that the array size given is correct
    */
  @Test
    public void testNumber() {
       data.initializeArray("20");
       assertTrue(data.myArray.length == 20);
       
       data.initializeArray("30");
       assertTrue(data.myArray.length == 30);
       
       data.initializeArray("0");
       assertTrue(data.myArray.length == 0);
    }


    /**
     * negativeArraySize checks that the correct exception is thrown for a negative array size
     */
@Test
    public void negativeArraySize() {
        assertThrows(NegativeArraySizeException.class,
                ()->{
                    data.initializeArray("-3"); 
                });
    }
    
    /**
     * NonIntegerValue checks that the correct exception is thrown when a non integer value is given
     */
    @Test
    public void NonIntegerValue() {
        assertThrows(NumberFormatException.class,
                ()->{
                    data.initializeArray("5.5 7 9");
                });
    }
    
    /**
     * NoSuchElem checks that the correct exception is thrown for an empty array
     */
    @Test
    public void NoSuchElem() {
        assertThrows(java.util.NoSuchElementException.class,
                ()->{
                    data.initializeArray("");
                }); 
    }
    
    /**
     * NoNumber checks that the correct exception is thrown if a character is given
     */
    @Test
    public void NoNumber() {
        assertThrows(NumberFormatException.class,
                ()->{
                    data.initializeArray("5 8 y 4"); 
                }); 
         
    }
    
    /**
     * SameNumber checks that duplicate numbers are removed
     */
    @Test

    public void SameNumber() {
         data.initializeArray("5 5 64 4 4");  
        
         SortDemoData data2 = new SortDemoData();
         data2.initializeArray("5 64 4");
         assertTrue(data.myArray.length == 3);
         assertTrue(data.myArray[0].key == data2.myArray[0].key );
         assertTrue(data.myArray[1].key == data2.myArray[1].key );
         assertTrue(data.myArray[2].key == data2.myArray[2].key );
     }
  
   
}
/*    package test.java;


    import static org.junit.Assert.*;


    import java.util.List;
    import java.util.Objects;

    import org.junit.Before;
    import org.junit.BeforeClass;
    import org.junit.Test;

    import main.java.Item;
    import main.java.SortAlgos;
    import main.java.SortDemoData;

    public class SortDemoTest{
    	SortDemoData data = new SortDemoData();


    	/**
    	* testNumber checks that the array size given is correct
    	*/
    //	@Test
  /*  	public void testNumber() {
    	   data.initializeArray("20");
    	   assertTrue(data.myArray.length == 20);
    	   
    	   data.initializeArray("30");
    	   assertTrue(data.myArray.length == 30);
    	   
    	   data.initializeArray("0");
    	   assertTrue(data.myArray.length == 0);
    	}


    	/**
    	 * negativeArraySize checks that the correct exception is thrown for a negative array size
    	 */
/*    	@Test (expected=java.lang.NegativeArraySizeException.class)
    	public void negativeArraySize() {
    	    data.initializeArray("-3");  
    	}
    	
    	/**
    	 * NonIntegerValue checks that the correct exception is thrown when a non integer value is given
    	 */
  /*  	@Test (expected=java.lang.NumberFormatException.class)
    	public void NonIntegerValue() {
    	    data.initializeArray("5.5 7 9");  
    	}
    	
    	/**
    	 * NoSuchElem checks that the correct exception is thrown for an empty array
    	 */
    /*	@Test (expected=java.util.NoSuchElementException.class)
    	public void NoSuchElem() {
    	    data.initializeArray("");  
    	}
    	
    	/**
    	 * NoNumber checks that the correct exception is thrown if a character is given
    	 */
    	/*@Test (expected=java.lang.NumberFormatException.class)
    	public void NoNumber() {
    	    data.initializeArray("5 8 y 4");  
        }
    	
    	/**
    	 * NoNumber checks that the correct exception is thrown if a character is given
    	 */
    	/*@Test// (expected=java.lang.NullPointerException.class)
    	public void NullArgument() {
    		int testPassed = 0; 

    		try
    		{
    			SortAlgos.bubbleSort(null);
    		}
    		catch(NullPointerException npe)
    		{
    			testPassed++;
    			//System.out.println("Array cannot be empty. \n");
    		}
    		try
    		{
    			SortAlgos.selectionSort(null); 
    		}
    		catch(NullPointerException npe)
    		{
    			testPassed++;
    			//System.out.println("Array cannot be empty. \n");
    		}
    		try
    		{
    			SortAlgos.insertionSort(null); 
    		}
    		catch(NullPointerException npe)
    		{
    			testPassed++;
    			//System.out.println("Array cannot be empty. \n");
    		}
    		try
    		{
    			SortAlgos.mergeSort(null);  
    		}
    		catch(NullPointerException npe)
    		{
    			testPassed++;
    			//System.out.println("Array cannot be empty. \n");
    		}
    		try
    		{
    			SortAlgos.quickSort(null); 
    		}
    		catch(NullPointerException npe)
    		{
    			testPassed++;
    			//System.out.println("Array cannot be empty. \n");
    		}
    		try
    		{
    			SortAlgos.heapSort(null);     
    		}
    		catch(NullPointerException npe)
    		{
    			testPassed++;
    			//System.out.println("Array cannot be empty. \n");
    		}
    		assertTrue("must have 6 algorithms pass", testPassed == 6);
    		
    		
    		
        }
    	
    	/**
    	 * SameNumber checks that duplicate numbers are removed
    	 */
    	/*@Test
    	public void SameNumber() {
    	    data.initializeArray("5 5 64 4 4");  
    	    
    	    SortDemoData data2 = new SortDemoData();
    	    data2.initializeArray("5 64 4");
    		assertTrue(data.myArray.length == 3);
    		assertTrue(data.myArray[0].key == data2.myArray[0].key );
    		assertTrue(data.myArray[1].key == data2.myArray[1].key );
    		assertTrue(data.myArray[2].key == data2.myArray[2].key );

    		data.initializeArray("1 1 3 4 9 2 2 8");  
    		String expected = "1 2 3 4 8 9";
            assertTrue(data.testAllAlgos(expected));
            
            data.initializeArray("3 4 2 4 8 7 6");
            expected = "2 3 4 6 7 8";
            assertTrue(data.testAllAlgos(expected));

    	}

    	
    	
        @Test
        public void testRunAlgo()
        {
            data.initializeArray("5 1 12 -5 16");
            String expected = "-5 1 5 12 16";
            assertTrue(data.testAllAlgos(expected));

            data.initializeArray("1 2 3 4 5 6 7");
            expected = "1 2 3 4 5 6 7";
            assertTrue(data.testAllAlgos(expected));

            data.initializeArray("7 6 5 4 3 2 1");
            expected = "1 2 3 4 5 6 7";
            assertTrue(data.testAllAlgos(expected));

            data.initializeArray("8");
            expected = "1 2 3 4 5 6 7 8";
            assertTrue(data.testAllAlgos(expected));

            data.initializeArray("-8 -10 -2 -9 -3");
            expected = "-10 -9 -8 -3 -2";
            assertTrue(data.testAllAlgos(expected));
            
        }

    }
    */
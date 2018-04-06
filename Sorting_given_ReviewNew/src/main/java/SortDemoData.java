package main.java;// SortDemo.java     import java.util.*;   // for class StringTokenizerpublic class SortDemoData  {                       public Item[] myArray;        public String algo;        public String originalStr;        public SortDemoData(){        	myArray = null;        }               /*         // read numbers from input to array myArray        // duplicates should be removed        public void initializeArray(String string) throws NumberFormatException,         NoSuchElementException, NegativeArraySizeException{	        	StringTokenizer inputTokens = new StringTokenizer(string);	        	String[] result = string.split("\\s");                String str = "";                                    int n; // will be the length of myArray                        if (inputTokens.hasMoreTokens()) {                        n = inputTokens.countTokens();                 } else {                        throw new NoSuchElementException();                }                // define the array of the right length n                    if (n == 1) {                         // interpret the next number as number of entries and                         // generate a random vector with entries 1 ... n                        str = inputTokens.nextToken();                         n = Integer.valueOf(str).intValue();                         // may throw NegativeArraySizeException                        myArray = new Item[n];                        boolean[] tempArray = new boolean[n + 1];                        RandomNumber randGen = new RandomNumber();                        int randNr;                        for (int i = 0; i < n; i++) {                                do                                         randNr = randGen.nextIntRand(1, n);                                while (tempArray[randNr]);                                                  tempArray[randNr] = true;                                myArray[i] = new Item(randNr);                        }                } else {                                   Item [] array = new Item[n];                        int count =0;                        // read the n numbers into the array                        for (int i = 0; i < n; i++) {                        	                                str = result[i];                                                                array[i-count] = new Item(                                         Integer.valueOf(str).intValue());                                                        }                         myArray = new Item[n-count];                        myArray = Arrays.copyOfRange(array, 0, n-count);                                                               }         }*/                  public void initializeArray(String string) throws NumberFormatException,         NoSuchElementException, NegativeArraySizeException{                originalStr = string;	        	StringTokenizer inputTokens = new StringTokenizer(string);	        	String[] result = string.split("\\s");                String str = "";                                    int n; // will be the length of myArray                        if (inputTokens.hasMoreTokens()) {                        n = inputTokens.countTokens();                 } else {                    // if no elements, i.e. empty list, this function throws a NoSuchElementException exception                    // as it's designed to do                        throw new NoSuchElementException();                }                // define the array of the right length n                    if (n == 1) {                         // interpret the next number as number of entries and                         // generate a random vector with entries 1 ... n                        str = inputTokens.nextToken();                         n = Integer.valueOf(str).intValue();                        // may throw NegativeArraySizeException                        myArray = new Item[n];                        boolean[] tempArray = new boolean[n + 1];                        RandomNumber randGen = new RandomNumber();                        int randNr;                        for (int i = 0; i < n; i++) {                                do                                         randNr = randGen.nextIntRand(1, n);                                while (tempArray[randNr]);                                                  tempArray[randNr] = true;                                myArray[i] = new Item(randNr);                        }                } else {                                   Item[] uniqueNumbers = new Item[n];                        int uniqueNumCount =0;                        // read the n numbers into the array                        // store the unique numbers into a new array.                        // search that array for every new number to be checked                         //                        //                         for (int i = 0; i < result.length; i++){                                                    boolean dupFound = false;                        	// search from 0 to i-count                            str = result[i];                            for (int j = 0; j < uniqueNumCount;j++) {                                if (uniqueNumbers[j].key == Integer.valueOf(str).intValue()) {                                	dupFound = true;                                    break;                                }                            }                            if(!dupFound)                            {                                int a = Integer.valueOf(str).intValue();                                uniqueNumbers[uniqueNumCount] =  new Item(a);                                uniqueNumCount++;                            }                            dupFound = false;                        }                         myArray = new Item[uniqueNumCount];                        myArray = Arrays.copyOfRange(uniqueNumbers, 0, uniqueNumCount);                                                               }         }         /**    	 * All methods should have a Javadoc according to STYLE.    	 * @param choice: chosen sort algorithm, needs to be a number between 0 and 5. If the number is out of range 0 should be chosen    	 * The attribute algo should always contain the choosen algorithm as string    	 * @return String Buffer object with sorted array    	 * @throws Exception as per typical main specifications    	 */        public StringBuffer runAlgo(int choice) {                             Item[] copyOfMyArray = new Item[myArray.length];                        System.arraycopy(                                myArray, 0, copyOfMyArray, 0, myArray.length);                                                //SER 316                        //if (choice < 0 || choice > 5) choice = 0;                                                                   switch (choice) {                        case 0 : { SortAlgos.bubbleSort(myArray);                          			algo = "Bubble Sort";                                   break;                                  }                        case 1 : { SortAlgos.selectionSort(myArray);                         			algo = "Selection Sort";                                   break;                                 }                        case 2 : { SortAlgos.insertionSort(myArray);                         			algo = "Insertion Sort";                                   break;                                 }                        case 3 : { SortAlgos.mergeSort(myArray);                          			//SER 316                        			algo = "Merge Sort";                                   break;                                 }                        case 4 : { SortAlgos.quickSort(myArray);                         			algo = "Quick Sort";                                   break;                                 }                        case 5 : { SortAlgos.heapSort(myArray);                             			algo = "Heap Sort";                                   break;                                 }                        default: SortAlgos.bubbleSort(myArray);  			            			algo = "Bubble Sort";			                        break;                        		}                                                 // output initial sequence of unsorted and sorted array                         int limit = Math.min(myArray.length, 1024);                        StringBuffer outputBuf = new StringBuffer();                        outputBuf.append(algo + "\n");                        for (int i = 0; i < limit; i++) {                                outputBuf.append(                                        i + ": "                                           + Integer.toString(                                                        copyOfMyArray[i].key)                                            + " --> "                                          + Integer.toString(myArray[i].key)                                           + "\n");                        }                        outputBuf.append("\r");                        		               return outputBuf;                    }        		public boolean testAllAlgos(String the_data_str) {    SortDemoData expected_data = new SortDemoData();    expected_data.initializeArray(the_data_str);    if (expected_data.myArray == null)    {        //System.out.printf("Empty array, nothing to sort, null is not allowed");        return false;    }    //this.runAlgo(0); // this tests the bubble sort    //if (!compare(expected_data.myArray)) {    //    //System.out.printf("Choice: %d failed\n", 0);    //    return false;    //}    //this.initializeArray(this.originalStr);    this.runAlgo(1);    if (!compare(expected_data.myArray)) {        //System.out.printf("Choice: %d failed\n", 1);        return false;    }    this.initializeArray(this.originalStr);    this.runAlgo(2);    if (!compare(expected_data.myArray)) {        //System.out.printf("Choice: %d failed\n", 2);        return false;    }    this.initializeArray(this.originalStr);    this.runAlgo(3);    if (!compare(expected_data.myArray)) {        //System.out.printf("Choice: %d failed\n", 3);        return false;    }    this.initializeArray(this.originalStr);    this.runAlgo(4);    if (!compare(expected_data.myArray)) {       // System.out.printf("Choice: %d failed\n", 4);        return false;    }    this.initializeArray(this.originalStr);    this.runAlgo(5);    if (!compare(expected_data.myArray)) {        //System.out.printf("Choice: %d failed\n", 5);        return false;    }    this.initializeArray(this.originalStr);    // this will test the default bubble sort case     //this.runAlgo(7);    //if (!compare(expected_data.myArray)) {    //    //System.out.printf("Choice: %d failed\n", 5);    //    return false;    //}    return true;}	public boolean compare(Item[] array) {	    if(array.length != myArray.length) return false;	    for(int i=0; i<array.length; i++)	    {	        if(array[i].key != myArray[i].key) return false;	    }	    return true;	}}
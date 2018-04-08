package main.java;// SortDemo.java     import java.util.*;   // for class StringTokenizerpublic class SortDemoData  {                       public Item[] myArray;        public String algo;        public String originalStr;        public SortDemoData(){        	myArray = null;        }                        // Create a random array of integers, randArraySize in length that        // includes each integer only once        public void initializeArray(int randArraySize) throws NumberFormatException,         NoSuchElementException, NegativeArraySizeException{                                    if (randArraySize == 0) {                    myArray = new Item[0];                    return;                }                int n = randArraySize;                // define the array of the right length n                    myArray = new Item[n];                boolean[] tempArray = new boolean[n + 1];                RandomNumber randGen = new RandomNumber();                int randNr;                for (int i = 0; i < n; i++) {                        do                                randNr = randGen.nextIntRand(1, n);                        while (tempArray[randNr]);                                          tempArray[randNr] = true;                        myArray[i] = new Item(randNr);                }        }                 // read numbers from input to array myArray        // duplicates will be removed and ignored        public void initializeArray(String string) throws NumberFormatException,         NoSuchElementException, NegativeArraySizeException{                originalStr = string;                StringTokenizer inputTokens = new StringTokenizer(string);                String[] result = string.split("\\s");                String str = "";                                    int n = string.length(); // will be the length of myArray                        if (n <= 1) {                    // if no elements, i.e. empty list, this function throws a NoSuchElementException exception                    // as it's designed to do                    throw new NoSuchElementException();                }                Item[] unique_numbers = new Item[n];                int unique_num_count =0;                // read the n numbers into the array                // store the unique numbers into a new array.                // search that array for every new number to be checked                for (int i = 0; i < result.length; i++) // this reads all the given numbers                {                    //SER316: Task 1 Step 3                    boolean dup_found = false;                    // search from 0 to i-count                    str = result[i];                    for (int j = 0; j < unique_num_count;j++) {                        if (unique_numbers[j].key == Integer.valueOf(str).intValue()) {                            dup_found = true;                            break;                        }                    }                    if(!dup_found)                    {                        int a = Integer.valueOf(str).intValue();                        unique_numbers[unique_num_count] =  new Item(a);                        unique_num_count++;                    }                    dup_found = false;                 }                  myArray = new Item[unique_num_count];                 myArray = Arrays.copyOfRange(unique_numbers, 0, unique_num_count);        }              /**    	 * All methods should have a Javadoc according to STYLE.    	 * @param choice: chosen sort algorithm, needs to be a number between 0 and 5. If the number is out of range 0 should be chosen    	 * The attribute algo should always contain the choosen algorithm as string    	 * @return String Buffer object with sorted array    	 * @throws Exception as per typical main specifications    	 */        public StringBuffer runAlgo(int choice) {                             Item[] copyOfMyArray = new Item[myArray.length];                        System.arraycopy(                                myArray, 0, copyOfMyArray, 0, myArray.length);                                                //SER 316                        //if (choice < 0 || choice > 5) choice = 0;                                                                   switch (choice) {                        case 0 : { SortAlgos.bubbleSort(myArray);                          			algo = "Bubble Sort";                                   break;                                  }                        case 1 : { SortAlgos.selectionSort(myArray);                         			algo = "Selection Sort";                                   break;                                 }                        case 2 : { SortAlgos.insertionSort(myArray);                         			algo = "Insertion Sort";                                   break;                                 }                        case 3 : { SortAlgos.mergeSort(myArray);                          			//SER 316                        			algo = "Merge Sort";                                   break;                                 }                        case 4 : { SortAlgos.quickSort(myArray);                         			algo = "Quick Sort";                                   break;                                 }                        case 5 : { SortAlgos.heapSort(myArray);                             			algo = "Heap Sort";                                   break;                                 }                        default: SortAlgos.bubbleSort(myArray);  			            			algo = "Bubble Sort";			                        break;                        		}                                                 // output initial sequence of unsorted and sorted array                         int limit = Math.min(myArray.length, 1024);                        StringBuffer outputBuf = new StringBuffer();                        outputBuf.append(algo + "\n");                        for (int i = 0; i < limit; i++) {                                outputBuf.append(                                        i + ": "                                           + Integer.toString(                                                        copyOfMyArray[i].key)                                            + " --> "                                          + Integer.toString(myArray[i].key)                                           + "\n");                        }                        outputBuf.append("\r");                        		               return outputBuf;                    }        		}
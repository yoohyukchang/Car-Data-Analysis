import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Car Data Analysis: Project 3.
 *
 * Gateway Programming: Java
 * Johns Hopkins University
 * Fall 2022
 * @Author: Yoohyuk Chang
 * @JHED: ychang82
 * @Date: October 20th 2022
 * The purpose of the program is to parse the 'US Cars Datasets' 
 * CSV file into our program and organize the data within the 
 * file by car's brand, year, mileage, and price using arrays.
 * Then the program presents a menu allowing the users to perform 
 * several data analyzing options on the organized data of arrays.
 * 
 */
public class CarDataAnalysis {

   // menu options
   static final int BRAND_QUERY = 1;
   static final int TWO_HIGHEST_PRICES_QUERY = 2;
   static final int RANGE_QUERY = 3;
   static final int BEST_VALUE_QUERY = 4;
   static final int QUIT = 5;

   // column index constants for car data file
   static final int BRAND = 2;
   static final int YEAR = 4;
   static final int MILEAGE = 6;
   static final int PRICE = 1;

   /**
    * Counts the number of lines in a given plain-text file.
    * @param filename The file whose lines are to be counted.
    * @return the number of lines in the file.
    * @throws IOException
    */
   public static int countFileLines(String filename)
                                    throws IOException {

      FileInputStream fileInStream = new FileInputStream(filename);
      Scanner fileScanner = new Scanner(fileInStream);
      
      int lineCount = 0;
      String fileLine = "";
      while (fileScanner.hasNextLine()) {
         fileLine = fileScanner.nextLine();
         lineCount = lineCount + 1;
      }

      fileInStream.close();
      return lineCount;
   }
   
   /**
    * Helper Method 1.
    * Stores each lines in fileLineArray array.
    * @param filename The file whose lines are to be stored.
    * @return an array that contains each line of the file.
    * @throws IOException
    */
   public static String[] fileAllLinesArrayMethod(String filename)
                                                  throws IOException {
      FileInputStream fileInStream = new FileInputStream(filename);
      Scanner fileScanner = new Scanner(fileInStream);
      
      int lineCount = countFileLines(filename);
      String[] fileLineArray = new String[lineCount - 1];
      
      // Not including in the array because it is a catagory
      String catagoryLine = fileScanner.nextLine();
      
      int i = 0;
      while (fileScanner.hasNextLine()) {
         fileLineArray[i] = fileScanner.nextLine();
         i = i + 1;
      }
      
      fileInStream.close();
      
      return fileLineArray;
   }
   
   /**
    * Helper Method 2.
    * Stores each brand names from fileAllLinesArrayMethod into brandArray.
    * @param filename The file whose lines will be counted from 
    *                 countFileLines and to get each lines of data
    *                 from the fileAllLinesArrayMethod.
    * @return an array that contains the names of brands.
    * @throws IOException
    */
   public static String[] brandArrayMethod(String filename) 
                                           throws IOException {
      String[] allArrays = fileAllLinesArrayMethod(filename);
      int lineCount = countFileLines(filename);
      String[] brandArray = new String[lineCount - 1];
      String[] eachLineArray = new String[13];
      
      for (int i = 0; i < lineCount - 1; ++i) {
         eachLineArray = allArrays[i].split(",");
         brandArray[i] = eachLineArray[BRAND];
      }
      
      return brandArray;
   }
   
   /**
    * Helper Method 3.
    * Stores each year values from fileAllLinesArrayMethod into yearArray.
    * @param filename File whose lines will be counted from countFileLines 
    *                 and to get each lines of data from 
    *                 fileAllLinesArrayMethod.
    * @return an array that contains the year values.
    * @throws IOException
    */
   public static int[] yearArrayMethod(String filename) 
                                           throws IOException {
      String[] allArrays = fileAllLinesArrayMethod(filename);
      int lineCount = countFileLines(filename);
      int[] yearArray = new int[lineCount - 1];
      String[] eachLineArray = new String[13];
      
      for (int i = 0; i < lineCount - 1; ++i) {
         eachLineArray = allArrays[i].split(",");
         yearArray[i] = Integer.parseInt(eachLineArray[YEAR]);
      }
      
      return yearArray;
   }
   
   /**
    * Helper Method 4.
    * Stores each mileage values from the fileAllLinesArrayMethod 
    * into mileageArray.
    * @param filename The file whose lines will be counted 
    *                 from countFileLines and to get each lines  
    *                 of data from fileAllLinesArrayMethod.
    * @return an array that contains the mileage values.
    * @throws IOException
    */
   public static double[] mileageArrayMethod(String filename) 
                                           throws IOException {
      String[] allArrays = fileAllLinesArrayMethod(filename);
      int lineCount = countFileLines(filename);
      double[] mileageArray = new double[lineCount - 1];
      String[] eachLineArray = new String[13];
      
      for (int i = 0; i < lineCount - 1; ++i) {
         eachLineArray = allArrays[i].split(",");
         mileageArray[i] = Double.parseDouble(eachLineArray[MILEAGE]);
      }
      
      return mileageArray;
   }
   
   /**
    * Helper Method 5.
    * Stores each price values from fileAllLinesArrayMethod into priceArray.
    * @param filename The file whose lines will be counted from 
    *                 countFileLines and to get each lines of data from
    *                 fileAllLinesArrayMethod.
    * @return an array that contains the price values.
    * @throws IOException
    */
   public static int[] priceArrayMethod(String filename) 
                                           throws IOException {
      String[] allArrays = fileAllLinesArrayMethod(filename);
      int lineCount = countFileLines(filename);
      int[] priceArray = new int[lineCount - 1];
      String[] eachLineArray = new String[13];
      
      for (int i = 0; i < lineCount - 1; ++i) {
         eachLineArray = allArrays[i].split(",");
         priceArray[i] = Integer.parseInt(eachLineArray[PRICE]);
      }
      
      return priceArray;
   }
   
   /**
    * Helper Method 6.
    * Stores each number orders from fileAllLinesArrayMethod
    * into numberOrderArray.
    * @param filename The file whose lines will be counted from  
    *                 countFileLines and to get each lines of data 
    *                 from fileAllLinesArrayMethod.
    * @return an array that contains the number of order.
    * @throws IOException
    */
   public static int[] numberOrderArrayMethod(String filename) 
                                           throws IOException {
                                           
      String[] allArrays = fileAllLinesArrayMethod(filename);
      int lineCount = countFileLines(filename);
      int[] numberOrderArray = new int[lineCount - 1];
      String[] eachLineArray = new String[13];
      
      for (int i = 0; i < lineCount - 1; ++i) {
         eachLineArray = allArrays[i].split(",");
         numberOrderArray[i] = Integer.parseInt(eachLineArray[0]);
      }
      
      return numberOrderArray;
   }
   
   /**
    * Helper Method 7.
    * Method for the first option from main (case BRAND_QUERY).
    * Ask the user to type a car brand and a file name, 
    * so that the number of entries in the loaded data whose brand matches 
    * the one given and their average price. It also saves the corresponding 
    * data into a CSV file with the entered file name from the user.
    * @param numberOrderArray An array that contains the number of order values.
    * @param brandArray An array that contains the brand name values.
    * @param yearArray An array that contains the year values.
    * @param mileageArray An array that contains the mileage values.
    * @param priceArray An array that contains the price values.
    * @param filename The file whose lines will be counted from countFileLines. 
    * @param keyboard Get Scanner(System.in) from the main to get input.
    * @throws IOException
    */
   public static void caseBrand(int[] numberOrderArray, String[] brandArray, 
                                int[] yearArray, double[] mileageArray, 
                                int[] priceArray, String filename, 
                                Scanner keyboard) 
                                throws IOException {
                                
      int lineCount = countFileLines(filename);
      
      String dummyLine = keyboard.nextLine();
      
      System.out.print("Please enter a car brand: ");
      String carBrandInput = keyboard.nextLine();
      
      System.out.print("Please enter an output filename: ");
      String fileNameInput = keyboard.nextLine();
      
      int i = 0;
      int countBrand = 0;
      double priceSum = 0;
      
      while (i < lineCount - 1) {
         if (carBrandInput.equalsIgnoreCase(brandArray[i])) {
            priceSum = priceSum + priceArray[i];
            countBrand = countBrand + 1;
            i = i + 1;
         }
         else {
            i = i + 1;
         }
      }
      
      double avgPrice = priceSum / countBrand;
      
      if (countBrand > 0) {
         System.out.printf("There are %d matching entries for brand %s "
                           + "with an average price of $%.2f.", 
                           countBrand, carBrandInput, avgPrice);
      }
      else {
         System.out.printf("There are no matching entries for brand %s.", 
                           carBrandInput);
      }
      System.out.println();
      
      FileOutputStream fileOutStream = new FileOutputStream(fileNameInput);
      PrintWriter writeInFile = new PrintWriter(fileOutStream);
      
      i = 0;
      while (i < lineCount - 1) {
         if (carBrandInput.equalsIgnoreCase(brandArray[i])) {
            writeInFile.print(numberOrderArray[i] + ",");
            writeInFile.print(brandArray[i] + ",");
            writeInFile.print(yearArray[i] + ",");
            writeInFile.print(mileageArray[i] + ",");
            writeInFile.print(priceArray[i]);
            writeInFile.println("");
            i = i + 1;
         }
         else {
            i = i + 1;
         }
      }
      writeInFile.flush();
      fileOutStream.close();
      
   }
   
   /**
    * Helper Method 8.
    * Method for the second option from main (case TWO_HIGHEST_PRICES_QUERY).
    * Among the price values from the file, it will output the
    * two highest values from the file.
    * @param priceArray An array that contains the price values.
    * @param filename The file whose lines will be counted from countFileLines. 
    * @throws IOException
    */
   public static void caseTwoHighestPrices(int[] priceArray, String filename) 
                                           throws IOException {
      int lineCount = countFileLines(filename);
      double maxPrice = priceArray[0];
      int i = 0;
      while (i < lineCount - 1) {
         if (priceArray[i] > maxPrice) {
            maxPrice = priceArray[i];
            i = i + 1;
         }
         else {
            i = i + 1;
         }
      }
      
      double secondMaxPrice = priceArray[0];
      i = 0;
      while (i < lineCount - 1) {
         if (priceArray[i] > secondMaxPrice && priceArray[i] < maxPrice) {
            secondMaxPrice = priceArray[i];
         }
         else {
            i = i + 1;
         }
      }
      
      System.out.printf("The two highest prices are $%.2f and $%.2f.", 
                        maxPrice, secondMaxPrice);
      System.out.println();
   }
   
   /**
    * Helper Method 9.
    * Method for the third option from main (case RANGE_QUERY).
    * Ask the user to enter inclusive lower and upper bound values of 
    * car's year and mileage. Then the program outputs the number of entries 
    * within the range and outputs the average price.
    * @param yearArray An array that contains the year values.
    * @param mileageArray An array that contains the mileage values.
    * @param priceArray An array that contains the price values.
    * @param filename The file whose lines will be counted from countFileLines.
    * @param keyboard Get Scanner(System.in) from the main to get input.
    * @throws IOException
    */
   public static void caseRange(int[] yearArray, double[] mileageArray, 
                                int[] priceArray, String filename, 
                                Scanner keyboard) 
                                throws IOException {
      int lineCount = countFileLines(filename);
      
      System.out.print("Please enter the year lower bound: ");
      int yearLowerBound = keyboard.nextInt();
      System.out.print("Please enter the year upper bound: ");
      int yearUpperBound = keyboard.nextInt();
      
      System.out.print("Please enter the mileage lower bound: ");
      int mileageLowerBound = keyboard.nextInt();
      System.out.print("Please enter the mileage upper bound: ");
      int mileageUpperBound = keyboard.nextInt();
      
      double priceSum = 0;
      int countMatch = 0;
      int i = 0;
      while (i < lineCount - 1) {
         if (yearArray[i] >= yearLowerBound && yearArray[i] <= yearUpperBound) {
            if (mileageArray[i] >= mileageLowerBound && 
                mileageArray[i] <=  mileageUpperBound) {
               countMatch = countMatch + 1;
               priceSum = priceSum + priceArray[i];
               i = i + 1;
            }
            else {
               i = i + 1;
            }
         }
         else {
            i = i + 1;
         }
      }
      
      double avgPrice = priceSum / countMatch;
      
      System.out.printf("There are %d matching entries for year range [%d, %d] "
                        + "and mileage range [%d, %d] with an average "
                        + "price of $%.2f.", countMatch, yearLowerBound, 
                        yearUpperBound, mileageLowerBound, 
                         mileageUpperBound, avgPrice);
                        
      System.out.println("");
   }
   
   /**
    * Helper Method 10.
    * Method for the fourth option from main (case BEST_VALUE_QUERY).
    * Ask the user for non-inclusive minimum mileage and price thresholds.
    * Then calculates the best value (best value = y - m/13,500−p/1,900)
    * where y is year, m is mileage, p is price in the data.
    * Output data that has the highest best value that is above the thresholds.
    * @param brandArray An array that contains the brand name values.
    * @param yearArray An array that contains the year values.
    * @param mileageArray An array that contains the mileage values.
    * @param priceArray An array that contains the price values.
    * @param filename The file whose lines will be counted from countFileLines.
    * @param keyboard Get Scanner(System.in) from the main to get input.
    * @throws IOException
    */
   public static void caseBestValue(String[] brandArray, int[] yearArray,
                                    double[] mileageArray, int[] priceArray, 
                                    String filename, Scanner keyboard) 
                                    throws IOException {
                                    
      int lineCount = countFileLines(filename);
      
      System.out.print("Please enter lower mileage threshold: ");
      double lowerMileageThreshold = keyboard.nextDouble();
      System.out.print("Please enter lower price threshold: ");
      int lowerPriceThreshold = keyboard.nextInt();
      
      double[] bestValue = new double[lineCount - 1];
      int i = 0;
      while (i < lineCount - 1) {
         bestValue[i] = yearArray[i] - (mileageArray[i] / 13500) 
                        - (priceArray[i] / 1900.0);
         i = i + 1;
      }
      
      double maxBestVal = bestValue[0];
      i = 0;
      while (i < lineCount - 1) {
         if (mileageArray[i] > lowerMileageThreshold && 
             priceArray[i] > lowerPriceThreshold) {
            if (bestValue[i] > maxBestVal) {
               maxBestVal = bestValue[i];
               i = i + 1;
            }
            else {
               i = i + 1;
            }
         }
         else {
            i = i + 1;
         }
      }
      
      i = 0;
      int indexBestVal = 0;
      while (i < lineCount - 1) {
         if (Math.abs(maxBestVal - bestValue[i]) < 0.0001) {
            indexBestVal = i;
            break;
         }
         else {
            i = i + 1;
         }
      }
      
      System.out.printf("The best-value entry with more than %.1f miles "
                        + "and a price higher than $%d is a %d %s with "
                        + "%.1f miles for a price of $%d.", 
                        lowerMileageThreshold, lowerPriceThreshold, 
                        yearArray[indexBestVal], brandArray[indexBestVal], 
                        mileageArray[indexBestVal], 
                        priceArray[indexBestVal]);   
      
      System.out.println("");
   }
   
   /**
    * Print the program menu to the console.
    */
   public static void printMenu() {

      System.out.printf("[%d]: Average price of brand.\n", BRAND_QUERY);
      System.out.printf("[%d]: Two highest prices.\n",
             TWO_HIGHEST_PRICES_QUERY);
      System.out.printf("[%d]: Average price in year and mileage range.\n",
             RANGE_QUERY);
      System.out.printf("[%d]: Best value.\n", BEST_VALUE_QUERY);
      System.out.printf("[%d]: Quit.\n", QUIT);
      System.out.print("Please select an option: ");

   }

   /**
    * Drive the Car Data Analysis program.
    * @param args This program does not take commandline arguments.
    * @throws IOException
    */
   public static void main(String[] args) throws IOException {

      // output purpose
      System.out.println("Welcome to the car dataset analysis program.");

      // get input filename (e.g. "USA_cars_datasets.csv")
      System.out.print("Please enter input csv filename: ");
      Scanner keyboard = new Scanner(System.in);
      String filename = keyboard.nextLine();

      // count the number of rows in the file (ignore headers line)
      int rowCount = countFileLines(filename) - 1;
      System.out.println("File has " + rowCount + " entries.");
      System.out.println();
      
      // declare and allocate parallel arrays for each column of interest
      // and load columns from file using method
      int[] numberOrderArray = numberOrderArrayMethod(filename);
      String[] brandArray = brandArrayMethod(filename);
      int[] yearArray = yearArrayMethod(filename);
      double[] mileageArray = mileageArrayMethod(filename);
      int[] priceArray = priceArrayMethod(filename);

      // while the user doesn't choose to quit...
      int option = 0;
      while (option != QUIT) {

         // display the menu and get an option
         printMenu();
         option = keyboard.nextInt();

         // handle chosen option
         switch (option) {
            case BRAND_QUERY:
               caseBrand(numberOrderArray, brandArray, yearArray, 
                         mileageArray, priceArray, filename, keyboard);
               break;
            case TWO_HIGHEST_PRICES_QUERY:
               caseTwoHighestPrices(priceArray, filename);
               break;
            case RANGE_QUERY:
               caseRange(yearArray, mileageArray, 
                         priceArray, filename, keyboard);
               break;
            case BEST_VALUE_QUERY:
               caseBestValue(brandArray, yearArray, mileageArray, 
                             priceArray, filename, keyboard);
               break;
            case QUIT:
               System.out.println("Thank you for using the program!");
               break;
            default:
               System.out.println("Invalid option.");

         }

         // leave empty line for next printing of menu
         System.out.println();

      }

   }
   
}

////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// User interface to the main menu.
//
////////////////////////////////////////////////////////////////////////////////

//import java.text.DecimalFormat;
import java.io.*;
import java.io.IOException;

public class miMainMenuInterface
{
   protected boolean exit;
   protected int userInput;
   protected miMainMenuProcessing theInputProcessor;

   //
   // Constructor
   //
   public miMainMenuInterface()
   {
      exit = false;
      userInput = 0;
      theInputProcessor = new miMainMenuProcessing();
   }

   //
   // Print 79 stars, screen width assumed is 80 characters
   //
   private void printStars()
   {
      System.out.println("*******************************************************************************");
   }

   //
   // Print a single star
   //
   private void printSingleStar()
   {
      System.out.println("*");
   }

   //
   // print out 24 blank lines to clear the screen
   //
   private void clearScreen()
   {
      for (int i = 0; i < 24; i++)
      {
         System.out.println("");
      }
   }

   private void printMainMenu()
   {
      //
      // Print main menu
      //

      this.printStars();// 1
      this.printSingleStar();// 2
      NetStudy.getMenuInterface().printBanner();// 3 - 10
      this.printSingleStar();// 11
      System.out.println("*                     Network Study Tool");// 12
      this.printSingleStar();// 13
      this.printSingleStar();// 14
      System.out.println("*                          Main Menu");// 15
      this.printSingleStar();// 16
      this.printSingleStar();// 17
      System.out.println("*  Select option to continue");// 18
      System.out.println("*   1. Network Study Quiz");// 19
      System.out.println("*   2. Network Calculator");// 20
      this.printSingleStar();// 21
      this.printStars();// 22
      System.out.println("");// 23
      System.out.print("  Please enter 1, 2, or q to quit: ");// 24
   }

   //
   // Control main menu
   //
   public void mainMenu()
   {

      do
      {

         this.printMainMenu();

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         try
         {
            userInput = br.read();
         }
         catch (IOException e)
         {
            // print out user input error
            System.out.println("User input error in Main Menu Interface");
            e.printStackTrace();
         }

         exit = theInputProcessor.processInputs(userInput);

      }
      while (!exit);

      //
      // Clear the screen
      //
      this.clearScreen();
   }

}
////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// User interface to the main menu.
//
////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class miMainMenuInterface extends menuInterface
{
   private boolean exit;
   private int userInput;
   private miMainMenuProcessing theInputProcessor;

   //
   // Constructor
   //
   public miMainMenuInterface()
   {
      exit = false;
      userInput = 0;
      theInputProcessor = new miMainMenuProcessing();
   }



   private void printMainMenu()
   {
      //
      // Print main menu
      //

      this.printStars();// 1
      this.printSingleStar();// 2
      this.printBanner();// 3 - 10
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

      } while (!exit);

      //
      // Clear the screen
      //
      this.clearScreen();
   }

}
////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// User interface to the network quiz.
//
////////////////////////////////////////////////////////////////////////////////

// import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class miNetworkQuizInterface extends menuInterface
{
   private boolean exit;
   private int userInput;
   private miNetworkQuizProcessing theInputProcessor;

   //
   // Constructor
   //
   public miNetworkQuizInterface()
   {
      exit = false;
      userInput = 0;
      theInputProcessor = new miNetworkQuizProcessing();
   }

   private void printMenu()
   {
      theInputProcessor.processData();

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
      System.out.println("*                     Network Quiz Menu");// 15
      this.printSingleStar();// 16
      System.out.println("*  Select option to continue");// 17
      System.out.println("*   1. " + theInputProcessor.getTriviaMenuLabel());// 18
      System.out.println("*   2. " + theInputProcessor.getTrueFalseLabel());// 19
      System.out.println("*   3. " + theInputProcessor.getMultipleChoiceLabel());// 20
      this.printSingleStar();// 21
      this.printStars();// 22
      System.out.println("");// 23
      System.out.print("  Please enter 1, 2, 3, or q to quit: ");// 24
   }

   //
   // Control main menu
   //
   public void menu()
   {

      do
      {

         this.printMenu();

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         try
         {
            userInput = br.read();
         }
         catch (IOException e)
         {
            // print out user input error
            System.out.println("User input error in Network Quiz Menu Interface");
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
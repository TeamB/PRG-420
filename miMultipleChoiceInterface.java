////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// User interface to the Multiple Choice questions quiz.
//
////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class miMultipleChoiceInterface extends menuInterface
{
   private boolean exit;
   private int userInput;
   private miMultipleChoiceProcessing theInputProcessor;

   //
   // Constructor
   //
   public miMultipleChoiceInterface()
   {
      theInputProcessor = new miMultipleChoiceProcessing();
   }

   private void reinitialize()
   {
      theInputProcessor.reinitialize();
      theInputProcessor = null; // delete this object
   }

   public void printMenu()
   {
      theInputProcessor.processData();

      //
      // Used to format score
      //
      DecimalFormat df1 = new DecimalFormat("###,##0.00");

      //
      // Print menu
      //
      this.printStars();// 1
      this.printSingleStar();// 2
      this.printBanner();// 3 - 10
      this.printSingleStar();// 11
      System.out.println("*                  Multiple Choice Questions ");// 12
      this.printSingleStar();// 13
      System.out.println("*   " + theInputProcessor.getTextLine1());// 14
      System.out.println("*   " + theInputProcessor.getTextLine2()); // 15
      this.printSingleStar();// 16
      System.out.println("*   " + theInputProcessor.getAnswerA());// 17
      System.out.println("*   " + theInputProcessor.getAnswerB());// 18
      System.out.println("*   " + theInputProcessor.getAnswerC());// 19
      System.out.println("*   " + theInputProcessor.getAnswerD());// 20
      System.out.println("*   Answer: " + theInputProcessor.getAnswer() + "   Your Answer: " + theInputProcessor.getDisplayAnswer() + "   Your Score: " + df1.format(theInputProcessor.getScore()) + "%");// 21
      this.printStars();// 22
      System.out.println("");// 23
      if (theInputProcessor.getDisplayAnserStatus())
      {
         System.out.print("  Please press enter to continue or q to quit: ");// 24
      }
      else
      {
         if (theInputProcessor.getAskAgainFlag())
         {
            System.out.print("  Try Again! Please enter A,B,C,D or q to quit: ");// 24
         }
         else
         {
            System.out.print("  Please enter A,B,C,D or q to quit: ");// 24
         }
      }
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
            System.out.println("User input Error in Multple Choice Interface");
            e.printStackTrace();
         }

         exit = theInputProcessor.processInputs(userInput);

      } while (!exit);

      //
      // Clear the screen
      //
      this.clearScreen();
      this.reinitialize();
   }
}
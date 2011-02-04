////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// User interface to the true/false quiz.
//
////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class miTrueFalseInterface
{
   protected boolean exit;
   protected int userInput;
   miTrueFalseProcessing theInputProcessor;
   
   //
   // Constructor
   //
   public miTrueFalseInterface()
   {
      theInputProcessor = new miTrueFalseProcessing();
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

   private void reinitialize()
   {
      NetStudy.getQuestionManager().setDisplayAnser(false);
      theInputProcessor.reinitialize();
      theInputProcessor = null; //delete this object
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
      NetStudy.getMenuInterface().printBanner();// 3 - 10
      this.printSingleStar();// 11
      System.out.println("*                     Network Study Tool");// 12
      this.printSingleStar();// 13
      System.out.println("*                      Trivia Questions");// 14
      this.printSingleStar();// 15
      System.out.println("*   " + theInputProcessor.getTextLine1());// 16
      System.out.println("*   " + theInputProcessor.getTextLine2()); // 17
      this.printSingleStar();// 18
      System.out.println("*   Answer: " + theInputProcessor.getAnswer() + 
            "   Your Answer: " +  theInputProcessor.getDisplayAnswer() + 
            "   Your Score: " + df1.format(theInputProcessor.getScore()) + "%");// 19
      this.printSingleStar();// 15
      this.printSingleStar();// 21
      this.printStars();// 22
      System.out.println("");// 23
      if (theInputProcessor.getDisplayAnserStatus())
      {
         System.out.print("  Please press enter to continue or q to quit: ");// 24
      }
      else
      {
         System.out.print("  Please enter T for True and F for false or q to quit: ");// 24
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
            System.out.println("User input Error in Trivia Interface");
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

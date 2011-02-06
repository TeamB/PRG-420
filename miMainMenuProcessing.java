// //////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Process inputs to main menu.
//
// //////////////////////////////////////////////////////////////////////////////

public class miMainMenuProcessing
{
   protected miNetworkQuizInterface networkQuiz;
   protected miNetowkCalculatorInterface networkCalc;

   //
   // Constructor
   //
   public miMainMenuProcessing()
   {
   }

   //
   // Process the input and return a flag to the main menu
   // flag returned - true = exit program, false = keep program running
   //
   public boolean processInputs(int selection)
   {
      boolean exit = false;

      //
      // Idea for converting character to string was retrieved from
      // http://www.java-tips.org/java-se-tips/java.lang/conversion-from-ascii-code-to-string.html
      // on
      // 1/21/11
      //
      String input = new Character((char) selection).toString();// convert
      // input
      // to string
      input = input.toUpperCase();

      switch (input.charAt(0))
      {
      case '1':
         // call to studyQuizInterface
         networkQuiz = new miNetworkQuizInterface();
         networkQuiz.menu();
         break;

      case '2':
         // call to networkCalculatorInterface
         networkCalc = new miNetowkCalculatorInterface();
         networkCalc.menu();
         break;

      case 'Q':
         exit = true;
         break;
      // input = unknown, display main menu again
      default:
         break;
      }

      return (exit);
   }

}
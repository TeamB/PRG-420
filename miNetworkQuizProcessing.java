////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Process inputs to network quiz menu.
//
////////////////////////////////////////////////////////////////////////////////

public class miNetworkQuizProcessing
{
   private miTriviaInterface triviaMenu;
   private miTrueFalseInterface trueFalseMenu;
   private miMultipleChoiceInterface multipleChoiceMenu;
   private boolean printTriviaOption = false;
   private boolean printTrueFalseOption = false;
   private boolean printMultipleChoiceOption = false;

   //
   // Constructor
   //
   public miNetworkQuizProcessing()
   {
   }

   public String getTriviaMenuLabel()
   {
      String ret_val = "No Trivia Available";

      if (printTriviaOption)
      {
         ret_val = "Trivia";
      }

      return (ret_val);
   }

   public String getTrueFalseLabel()
   {
      String ret_val = "No True/False Available";

      if (printTrueFalseOption)
      {
         ret_val = "True/False";
      }

      return (ret_val);
   }

   public String getMultipleChoiceLabel()
   {
      String ret_val = "No Multiple Choice Available";

      if (printMultipleChoiceOption)
      {
         ret_val = "Multiple Choice";
      }

      return (ret_val);
   }

   public void processData()
   {
      questionManager qmPtr = NetStudy.getQuestionManager();
      int numMultipleChoiceQ = qmPtr.getNumMultipleChoiceQuestions();
      int numTriviaQ = qmPtr.getNumTriviaQuestions();
      int numTrueFalseQ = qmPtr.getNumTrueFalseQuestions();

      printTriviaOption = (numTriviaQ > 0);
      printTrueFalseOption = (numTrueFalseQ > 0);
      printMultipleChoiceOption = (numMultipleChoiceQ > 0);
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
            if (printTriviaOption)
            {
               // call to Trivia
               triviaMenu = new miTriviaInterface();
               triviaMenu.menu();
            }
            break;

         case '2':
            if (printTrueFalseOption)
            {
               // call to True/False
               trueFalseMenu = new miTrueFalseInterface();
               trueFalseMenu.menu();
            }
            break;

         case '3':
            if (printMultipleChoiceOption)
            {
               // call to Multiple Choice
               multipleChoiceMenu = new miMultipleChoiceInterface();
               multipleChoiceMenu.menu();
            }
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
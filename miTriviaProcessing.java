////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Process data and user inputs for Trivia Menu.
//
////////////////////////////////////////////////////////////////////////////////

public class miTriviaProcessing
{
   protected boolean theQuestionNeedsMoreLines = false;
   protected questionManager qmPtr;
   protected int theQuestionNum = 0;
   protected String questionTextLine1;
   protected String questionTextLine2;
   protected String answer;
   protected menuInterface.miState theState = menuInterface.miState.DisplayQuestion;

   //
   // Constructor
   //
   public miTriviaProcessing()
   {
   }

   public void reinitialize()
   {
      theState = menuInterface.miState.DisplayQuestion;
      NetStudy.getQuestionManager().setTriviaQuestionNum(0);
      NetStudy.getQuestionManager().setDisplayAnser(false);
   }

   public String getTextLine1()
   {
      return (questionTextLine1);
   }

   public String getTextLine2()
   {
      return (questionTextLine2);
   }

   public String getAnswer()
   {
      return (answer);
   }

   public void processData()
   {
      qmPtr = NetStudy.getQuestionManager();
      theQuestionNum = qmPtr.getTriviaQuestionNum();
      String questionText = qmPtr.getTriviaQuestion(theQuestionNum).getQuestion();

      answer = "";

      //
      // 78 characters plus the star and space at the beginning of the line
      //
      theQuestionNeedsMoreLines = questionText.length() > 76;

      if (theQuestionNeedsMoreLines)
      {
         //
         // get the first line of the question, find the last space then copy
         // the rest of the question to the next line.
         //
         int lastSpace;

         questionTextLine1 = (String) questionText.subSequence(0, 75);
         lastSpace = questionTextLine1.lastIndexOf(" ");
         questionTextLine1 = (String) questionText.subSequence(0, lastSpace);
         questionTextLine2 = (String) questionText.subSequence((lastSpace + 1), (questionText.length() - 1));
      }
      else
      {
         questionTextLine1 = questionText;
         questionTextLine2 = "";
      }

      if (theState == menuInterface.miState.DisplayAnswer)
      {
         answer = qmPtr.getTriviaQuestion(theQuestionNum).getAnswer();
      }
   }

   public void handleDefaultEntry()
   {
      if (theState == menuInterface.miState.DisplayQuestion)
      {
         theState = menuInterface.miState.DisplayAnswer;
         NetStudy.getQuestionManager().setDisplayAnser(true);
      }
      else
      {
         theState = menuInterface.miState.DisplayQuestion;
         NetStudy.getQuestionManager().setDisplayAnser(false);
         NetStudy.getQuestionManager().incrementTriviaQuestionNum();
      }
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
      String input = new Character((char) selection).toString();// convert input
                                                                // to string

      input = input.toUpperCase();

      switch (input.charAt(0))
      {
         case 'Q':
            exit = true;
            break;

         // input = unknown, display the answer to the question, then the next
         // question, etc.
         default:
            this.handleDefaultEntry();
            break;
      }

      return (exit);

   }

}

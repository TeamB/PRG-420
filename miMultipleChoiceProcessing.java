////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Process data and user inputs for Multiple Choice Menu.
//
////////////////////////////////////////////////////////////////////////////////

public class miMultipleChoiceProcessing
{
   private questionManager qmPtr;
   private int theQuestionNum = 0;
   private boolean theQuestionNeedsMoreLines = false;
   private String questionTextLine1;
   private String questionTextLine2;
   private String answerA;
   private String answerB;
   private String answerC;
   private String answerD;
   private String answerString; // used to display the answer
   private String answerData; // used to check the answer against the user input
   private String userInput; // used to display the user input answer
   private menuInterface.miState theState = menuInterface.miState.DisplayQuestion;
   private int numCorrectAnswers = 0, numQuestionsAsked = 0;
   private float score = 0;
   private boolean askAgainFlag;

   //
   // Constructor
   //
   public miMultipleChoiceProcessing()
   {
   }

   public void reinitialize()
   {
      theState = menuInterface.miState.DisplayQuestion;
      NetStudy.getQuestionManager().setMultipleChoiceQuestionNum(0);
      numCorrectAnswers = 0;
      numQuestionsAsked = 0;
      score = 0;
      askAgainFlag = false;
   }

   public Boolean getDisplayAnserStatus()
   {
      return (theState == menuInterface.miState.DisplayAnswer);
   }

   public String getTextLine1()
   {
      return (questionTextLine1);
   }

   public String getTextLine2()
   {
      return (questionTextLine2);
   }

   public String getAnswerA()
   {
      return (answerA);
   }

   public String getAnswerB()
   {
      return (answerB);
   }

   public String getAnswerC()
   {
      return (answerC);
   }

   public String getAnswerD()
   {
      return (answerD);
   }

   public String getAnswer()
   {
      return (answerString);
   }

   public float getScore()
   {
      return (score);
   }

   public String getDisplayAnswer()
   {
      String ret = " ";
      if (this.getDisplayAnserStatus())
      {
         ret = userInput;
      }
      return (ret);
   }

   public boolean getAskAgainFlag()
   {
      return (askAgainFlag);
   }

   public void processData()
   {
      qmPtr = NetStudy.getQuestionManager();
      theQuestionNum = qmPtr.getMultipleChoiceQuestionNum();
      answerA = "A. " + qmPtr.getMultipleChoiceQuestion(theQuestionNum).getChoiceA();
      answerB = "B. " + qmPtr.getMultipleChoiceQuestion(theQuestionNum).getChoiceB();
      answerC = "C. " + qmPtr.getMultipleChoiceQuestion(theQuestionNum).getChoiceC();
      answerD = "D. " + qmPtr.getMultipleChoiceQuestion(theQuestionNum).getChoiceD();
      answerData = String.valueOf(qmPtr.getMultipleChoiceQuestion(theQuestionNum).getAnswer());
      String questionText = qmPtr.getMultipleChoiceQuestion(theQuestionNum).getQuestion();

      answerString = " ";

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

      if (this.getDisplayAnserStatus())
      {
         answerString = answerData;
      }

      // check for divide by zero
      if (numQuestionsAsked > 0)
      {
         score = (float) (100.0 * ((float) numCorrectAnswers / (float) numQuestionsAsked));
      }
   }

   private boolean processAnswerEntry(String entry)
   {
      boolean result = entry.charAt(0) == answerData.charAt(0);

      return (result);
   }

   private void handleStateChange()
   {
      if (theState == menuInterface.miState.DisplayQuestion)
      {
         theState = menuInterface.miState.DisplayAnswer;
      }
      else
      {
         theState = menuInterface.miState.DisplayQuestion;
         NetStudy.getQuestionManager().incrementMultipleChoiceNum();
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

         case 'A':
         case 'B':
         case 'C':
         case 'D':
            if (!this.getDisplayAnserStatus())
            {
               // save the answer for display
               userInput = input;
               // if the answer is correct
               if (this.processAnswerEntry(input))
               {
                  numCorrectAnswers++;
               }
               numQuestionsAsked++;
            }
            this.handleStateChange();
            askAgainFlag = false;
            break;

         default:
            if (this.getDisplayAnserStatus())
            {
               this.handleStateChange();
            }
            else
            {
               // if the user did not enter a 'T' or 'F' ask for answer again
               askAgainFlag = true;
            }
            break;
      }

      return (exit);

   }
}
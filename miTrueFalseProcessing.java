////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Process data and user inputs for True/False Menu.
//
////////////////////////////////////////////////////////////////////////////////

public class miTrueFalseProcessing
{
   protected questionManager qmPtr;
   protected int theQuestionNum = 0;
   protected boolean theQuestionNeedsMoreLines = false;
   protected String questionTextLine1;
   protected String questionTextLine2;
   protected String answerString; // used to display the answer
   protected String answerData; // used to check the answer against the user input
   protected String userInput; // used to display the user input answer
   protected menuInterface.miState theState = menuInterface.miState.DisplayQuestion;
   protected int numCorrectAnswers = 0, numQuestionsAsked = 0;
   protected float score = 0;
   protected boolean askAgainFlag;

   //
   // Constructor
   //
   public miTrueFalseProcessing()
   {
   }

   public void reinitialize()
   {
      theState = menuInterface.miState.DisplayQuestion;
      NetStudy.getQuestionManager().setTrueFalseQuestionNum(0);
      NetStudy.getQuestionManager().setDisplayAnser(false);
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
      return(askAgainFlag);
   }

   public void processData()
   {
      qmPtr = NetStudy.getQuestionManager();
      theQuestionNum = qmPtr.getTrueFalseQuestionNum();
      answerData = String.valueOf(qmPtr.getTrueFalseQuestion(theQuestionNum).getAnswer());
      String questionText = qmPtr.getTrueFalseQuestion(theQuestionNum).getQuestion();

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
         NetStudy.getQuestionManager().setDisplayAnser(true);
      }
      else
      {
         theState = menuInterface.miState.DisplayQuestion;
         NetStudy.getQuestionManager().setDisplayAnser(false);
         NetStudy.getQuestionManager().incrementTrueFalseNum();
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
            
         case 'T':
         case 'F':
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
            if(this.getDisplayAnserStatus())
            {
               this.handleStateChange();
            }
            else
            {
               System.out.println("display again");
               //if the user did not enter a 'T' or 'F' ask for answer again
               askAgainFlag = true;
            }
            break;
      }

      return (exit);

   }
}
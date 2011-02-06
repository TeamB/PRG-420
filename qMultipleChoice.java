// //////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Child question class for the network study questions, multiple choice
//
// //////////////////////////////////////////////////////////////////////////////

public class qMultipleChoice extends question
{
   protected String choice1;
   protected String choice2;
   protected String choice3;
   protected String choice4;
   protected char answer;

   //
   // Constructor
   //
   public qMultipleChoice(String question, String the1stChoice,
         String the2ndChoice, String the3rdChoice, String the4thChoice,
         char theAnswer)
   {
      theQuestion = question;
      choice1 = the1stChoice;
      choice2 = the2ndChoice;
      choice3 = the3rdChoice;
      choice4 = the4thChoice;
      answer = theAnswer;
   }

   //
   // Set and Get routines
   //

   public String getChoiceA()
   {
      return (choice1);
   }

   public String getChoiceB()
   {
      return (choice2);
   }

   public String getChoiceC()
   {
      return (choice3);
   }

   public String getChoiceD()
   {
      return (choice4);
   }

   public char getAnswer()
   {
      return (answer);
   }

   public void setChoiceA(String s)
   {
      choice1 = s;
   }

   public void setChoiceB(String s)
   {
      choice2 = s;
   }

   public void setChoiceC(String s)
   {
      choice3 = s;
   }

   public void setChoiceD(String s)
   {
      choice4 = s;
   }

   public void setAnswer(char c)
   {
      answer = c;
   }
}
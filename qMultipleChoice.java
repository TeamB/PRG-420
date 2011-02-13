////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Child question class for the network study questions, multiple choice
//
////////////////////////////////////////////////////////////////////////////////

public class qMultipleChoice extends question
{
   private String choice1;
   private String choice2;
   private String choice3;
   private String choice4;
   private char answer;

   //
   // Constructor
   //
   public qMultipleChoice(String question, String the1stChoice, String the2ndChoice, String the3rdChoice, String the4thChoice, char theAnswer)
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
}
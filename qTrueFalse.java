////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Child question class for the network study questions, true/false
//
////////////////////////////////////////////////////////////////////////////////
public class qTrueFalse extends question
{
   protected char theAnswer;

   //
   // Constructor
   //
   public qTrueFalse(String question, char answer)
   {
      theQuestion = question;
      theAnswer = answer;
   }

   //
   // Set and Get routines
   //

   public char getAnswer()
   {
      return (theAnswer);
   }

   public void setAnswer(char answer)
   {
      theAnswer = answer;
   }
}
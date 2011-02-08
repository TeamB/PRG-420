////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Child question class for the network study questions, trivia
//
////////////////////////////////////////////////////////////////////////////////

public class qTrivia extends question
{

   private String theAnswer;

   //
   // Constructor
   //
   public qTrivia(String question, String answer)
   {
      theQuestion = question;
      theAnswer = answer;
   }

   public String getAnswer()
   {
      return (theAnswer);
   }

   public void setAnswer(String s)
   {
      theAnswer = s;
   }
}
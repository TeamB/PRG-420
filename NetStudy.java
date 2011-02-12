////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Main class to start program
//
////////////////////////////////////////////////////////////////////////////////

public class NetStudy
{

   private static questionManager theQuestionManager = new questionManager();
   private static menuInterface theMenu = new menuInterface();

   public static void main(String args[])
   {

      //
      // Run the user interface
      //
      theMenu.run();
   }

   public static questionManager getQuestionManager()
   {
      return (theQuestionManager);
   }
}
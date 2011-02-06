// //////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Main class to start program
//
// //////////////////////////////////////////////////////////////////////////////

public class NetStudy
{

   protected static questionManager theQuestionManager = new questionManager();
   protected static menuInterface theMenu = new menuInterface();

   public static void main(String args[])
   {
      //
      // Read XML question data
      //
      theQuestionManager.initialize();

      //
      // Run the user interface
      //

      theMenu.run();
   }

   public static questionManager getQuestionManager()
   {
      return (theQuestionManager);
   }

   public static menuInterface getMenuInterface()
   {
      return (theMenu);
   }
}
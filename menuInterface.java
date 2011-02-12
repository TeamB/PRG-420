////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Class to control the user interface and user interactions. Class also
//   holds the common print routines.
//
////////////////////////////////////////////////////////////////////////////////

public class menuInterface
{

   public enum miState
   {
      DisplayQuestion,
      DisplayAnswer
   }

   public enum miCalcState
   {
      getIP,
      getSubnetMask,
      displayOutputs
   }

   //
   // Constructor
   //
   public menuInterface()
   {
   }

   public void printBanner()
   {
      System.out.println("*    ****     **           **     ********  **                **         ");// 3
      System.out.println("*   /**/**   /**          /**   **//////   /**               /**  **   **");// 4
      System.out.println("*   /**//**  /**  *****  ******/**       ****** **   **     /** //** **  ");// 5
      System.out.println("*   /** //** /** **///**///**/ /*********///**/ /**  /**  ******  //***  ");// 6
      System.out.println("*   /**  //**/**/*******  /**  ////////**  /**  /**  /** **///**   /**   ");// 7
      System.out.println("*   /**   //****/**////   /**         /**  /**  /**  /**/**  /**   **    ");// 8
      System.out.println("*   /**    //***//******  //**  ********   //** //******//******  **     ");// 9
      System.out.println("*   //      ///  //////    //  ////////     //   //////  //////  //      ");// 10
   }
   
   public void clearScreen()
   {
      for (int i = 0; i < 24; i++)
      {
         System.out.println("");
      }
   }
   
   //
   // Print a single star
   //
   public void printSingleStar()
   {
      System.out.println("*");
   }
   
   //
   // Print 79 stars, screen width assumed is 80 characters
   //
   public void printStars()
   {
      System.out.println("*******************************************************************************");
   }

   public void run()
   {
      //
      // Present the main menu
      //
      miMainMenuInterface theMainMenu = new miMainMenuInterface();
      theMainMenu.mainMenu();
   }
}
////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// User interface to the network calculator.
//
////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class miNetowkCalculatorInterface
{
   private miNetworkCalculatorProcessing theInputProcessor = new miNetworkCalculatorProcessing();
   protected boolean exit;
   protected int userInput;

   //
   // Print 79 stars, screen width assumed is 80 characters
   //
   private void printStars()
   {
      System.out.println("*******************************************************************************");
   }

   //
   // Print a single star
   //
   private void printSingleStar()
   {
      System.out.println("*");
   }

   private void printMenu()
   {

      boolean displayAnswer = theInputProcessor.displayAnswer();
      boolean askForIP = theInputProcessor.askForIP();
      boolean askForSubnetMask = theInputProcessor.askForSubnetMask();

      this.printStars();// 1
      this.printSingleStar();// 2
      NetStudy.getMenuInterface().printBanner();// 3 - 10
      System.out.println("*                     Network Study Tool");// 11
      this.printSingleStar();// 12
      if (displayAnswer)
      {
         System.out.println("*                Network Calculator - Answer");// 13
      }
      else
      {
         this.printSingleStar();// 13
         System.out.println("*                     Network Calculator");// 14
      }
      this.printSingleStar();// 15
      if (!displayAnswer)
      {
         this.printStars();// 16
         System.out.println(" ");// 17
         System.out.println(" ");// 18
         System.out.println(" ");// 19
         System.out.println(" ");// 20
         System.out.println(" ");// 21
         System.out.println(" ");// 22
         System.out.println(" ");// 23
      }

      if (askForIP)
      {
         System.out.print("Enter an IP address (default: 192.168.0.1):  ");// 24
      }
      else if (askForSubnetMask)
      {
         System.out.print("Enter the # of bits for the subnet mask [8 - 30] or [0] for classful: ");// 24
      }
      else
      {
         //
         // Print out the answer
         //
         if (!(theInputProcessor.isCalculationNull()))
         {
            System.out.println("*     IP Address: " + theInputProcessor.getCalculation().showIp());// 14
            System.out.println("*         Subnet: " + theInputProcessor.getCalculation().showSubnet());// 15
            System.out.println("* ");// 16
            System.out.println("*        Network: " + theInputProcessor.getCalculation().showNetwork());// 17
            System.out.println("*      Broadcast: " + theInputProcessor.getCalculation().showBroadcast());// 18
            this.printSingleStar();// 19
            System.out.println("*  Hosts Avaliable: " + theInputProcessor.getCalculation().numberOfAddresses());// 20
            this.printStars();// 21
         }
         System.out.println("");// 22
         System.out.print("Enter n for a new calculation or q to quit: "); // 24
      }

   }

   public void menu()
   {

      do
      {
         if (theInputProcessor.displayAnswer())
         {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            this.printMenu();

            try
            {
               userInput = br.read();
            }
            catch (IOException e)
            {
               // print out user input error
               System.out.println("User input error in Main Menu Interface");
               e.printStackTrace();
            }
         }
         else
         {
            this.printMenu();
         }
         exit = theInputProcessor.processInputs(userInput);
      } while (!exit);

      theInputProcessor.reinitialize();

   }
}

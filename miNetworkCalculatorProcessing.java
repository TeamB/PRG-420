////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Processing for the network calculator.
//
////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class miNetworkCalculatorProcessing
{
   private menuInterface.miCalcState state = menuInterface.miCalcState.getIP;
   private String inputIP = "192.168.0.1";
   private String inputSN = "0";
   private networkCalculator myCalculation = null;

   //
   // Constructor
   //
   public void processData()
   {
      state = menuInterface.miCalcState.getIP;
   }

   public void reinitialize()
   {
      state = menuInterface.miCalcState.getIP;
      inputIP = "192.168.0.1";
      inputSN = "0";
      myCalculation = null; // let garbage collection know to free memory
   }

   public boolean processInputs(int selection)
   {
      boolean exit = false;

      if (state == menuInterface.miCalcState.displayOutputs)
      {

         String input = new Character((char) selection).toString();// convert
         // input
         // to
         // string

         input = input.toUpperCase();

         switch (input.charAt(0))
         {
            case 'N':
               this.reinitialize();
               break;

            case 'Q':
               exit = true;
               break;

            // input = unknown, display main menu again
            default:
               break;
         }
      }

      else
      {
         BufferedReader inputBR = new BufferedReader(new InputStreamReader(System.in));
         // BufferedReader snIN = new BufferedReader(new
         // InputStreamReader(System.in));

         // temp input string
         String input = null;

         try
         {
            input = inputBR.readLine();

         } catch (IOException e)
         {
            e.printStackTrace();
         }

         if ((state == menuInterface.miCalcState.getIP))
         {
            if (!(input.isEmpty()))
            {
               inputIP = input;
            }
            state = menuInterface.miCalcState.getSubnetMask;
         } else if (state == menuInterface.miCalcState.getSubnetMask)
         {
            if (!(input.isEmpty()))
            {
               inputSN = input;
            }

            if (Integer.valueOf(inputSN) > 7 && Integer.valueOf(inputSN) < 31)
            {
               myCalculation = new networkCalculator(inputIP, Integer.valueOf(inputSN));
            } else
            {
               myCalculation = new networkCalculator(inputIP);
            }
            state = menuInterface.miCalcState.displayOutputs;
         }

      }
      return (exit);
   }

   public networkCalculator getCalculation()
   {
      return (myCalculation);
   }

   public boolean isCalculationNull()
   {
      return (myCalculation == null);
   }

   public boolean askForIP()
   {
      return (state == menuInterface.miCalcState.getIP);
   }

   public boolean askForSubnetMask()
   {
      return (state == menuInterface.miCalcState.getSubnetMask);
   }

   public boolean displayAnswer()
   {
      return (state == menuInterface.miCalcState.displayOutputs);
   }

}

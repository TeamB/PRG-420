////////////////////////////////////////////////////////////////////////////////

// Team B
// PRG420
//
// Calculations for the network calculator.
//
////////////////////////////////////////////////////////////////////////////////
public class networkCalculator
{

   private short ipOctet1 = 0, ipOctet2 = 0, ipOctet3 = 0, ipOctet4 = 0;
   private short ipSubNet1 = 0, ipSubNet2 = 0, ipSubNet3 = 0, ipSubNet4 = 0;
   private String s_ipaddress = "  0.  0.  0.  0";
   private String s_subnet = "  0.  0.  0.  0";

   private short net1 = 0, net2 = 0, net3 = 0, net4 = 0;
   private String s_Network = "0.0.0.0";
   private short broad1 = 0, broad2 = 0, broad3 = 0, broad4 = 0;
   private String s_Broadcast = "0.0.0.0";

   private int NumberOfAddresses = 0;

   private String s_NetCount = "";

   //
   // Constructors
   //
   public networkCalculator(String ip)
   {

      ip2octet(ip);

      if (ipOctet1 < 128)
      {
         s_subnet = "255.0.0.0";
      }
      else if (ipOctet1 < 192)
      {
         s_subnet = "255.255.0.0";
      }
      else
      {
         s_subnet = "255.255.255.0";
      }

      sub2octet(s_subnet);
      calcNetwork();
   }

   public networkCalculator(String ip, int sub)
   {

      ip2octet(ip);

      if (sub < 9)
      {
         s_subnet = "255.0.0.0";
      }
      else if (sub == 9)
      {
         s_subnet = "255.128.0.0";
      }
      else if (sub == 10)
      {
         s_subnet = "255.192.0.0";
      }
      else if (sub == 11)
      {
         s_subnet = "255.224.0.0";
      }
      else if (sub == 12)
      {
         s_subnet = "255.240.0.0";
      }
      else if (sub == 13)
      {
         s_subnet = "255.248.0.0";
      }
      else if (sub == 14)
      {
         s_subnet = "255.252.0.0";
      }
      else if (sub == 15)
      {
         s_subnet = "255.254.0.0";
      }
      else if (sub == 16)
      {
         s_subnet = "255.255.0.0";
      }
      else if (sub == 17)
      {
         s_subnet = "255.255.128.0";
      }
      else if (sub == 18)
      {
         s_subnet = "255.255.192.0";
      }
      else if (sub == 19)
      {
         s_subnet = "255.255.224.0";
      }
      else if (sub == 20)
      {
         s_subnet = "255.255.240.0";
      }
      else if (sub == 21)
      {
         s_subnet = "255.255.248.0";
      }
      else if (sub == 22)
      {
         s_subnet = "255.255.252.0";
      }
      else if (sub == 23)
      {
         s_subnet = "255.255.254.0";
      }
      else if (sub == 24)
      {
         s_subnet = "255.255.255.0";
      }
      else if (sub == 25)
      {
         s_subnet = "255.255.255.128";
      }
      else if (sub == 26)
      {
         s_subnet = "255.255.255.192";
      }
      else if (sub == 27)
      {
         s_subnet = "255.255.255.224";
      }
      else if (sub == 28)
      {
         s_subnet = "255.255.255.240";
      }
      else if (sub == 29)
      {
         s_subnet = "255.255.255.248";
      }
      else
      {
         s_subnet = "255.255.255.252";
      }

      sub2octet(s_subnet);
      calcNetwork();
   }

   {
      java.text.DecimalFormat dd = new java.text.DecimalFormat("  0");
      s_ipaddress = dd.format(ipOctet1) + "." + dd.format(ipOctet2) + "." + dd.format(ipOctet3) + "." + dd.format(ipOctet4) + ".";
   }

   private void sub2octet(String sn)
   {
      String[] arrSn = sn.split("[.]");

      ipSubNet1 = (short) Integer.parseInt(arrSn[0]);
      ipSubNet2 = (short) Integer.parseInt(arrSn[1]);
      ipSubNet3 = (short) Integer.parseInt(arrSn[2]);
      ipSubNet4 = (short) Integer.parseInt(arrSn[3]);
   }

   private void ip2octet(String ip)
   {
      String[] arrIP = ip.split("[.]");
      s_ipaddress = ip;

      ipOctet1 = (short) Integer.parseInt(arrIP[0]);
      ipOctet2 = (short) Integer.parseInt(arrIP[1]);
      ipOctet3 = (short) Integer.parseInt(arrIP[2]);
      ipOctet4 = (short) Integer.parseInt(arrIP[3]);

   }

   public String showIp()
   {
      return s_ipaddress;
   }

   public String showSubnet()
   {
      return s_subnet;
   }

   private void calcNetwork()
   {
      net1 = (short) (ipSubNet1 & ipOctet1);
      net2 = (short) (ipSubNet2 & ipOctet2);
      net3 = (short) (ipSubNet3 & ipOctet3);
      net4 = (short) (ipSubNet4 & ipOctet4);

      s_Network = Short.toString(net1) + "." + Short.toString(net2) + "." + Short.toString(net3) + "." + Short.toString(net4);

      calcBroadcast();
      calcNumberOfAddresses();
   }

   public String showNetwork()
   {
      return s_Network;
   }

   private void calcBroadcast()
   {
      String s1, s2, s3, s4;
      int i1, i2, i3, i4;
      int howlong = 0;

      s1 = Integer.toBinaryString(~ipSubNet1);
      s2 = Integer.toBinaryString(~ipSubNet2);
      s3 = Integer.toBinaryString(~ipSubNet3);
      s4 = Integer.toBinaryString(~ipSubNet4);
      howlong = s1.length();

      s1 = s1.substring(howlong - 8, howlong);
      s2 = s2.substring(howlong - 8, howlong);
      s3 = s3.substring(howlong - 8, howlong);
      s4 = s4.substring(howlong - 8, howlong);

      i1 = Integer.parseInt(s1, 2);
      i2 = Integer.parseInt(s2, 2);
      i3 = Integer.parseInt(s3, 2);
      i4 = Integer.parseInt(s4, 2);

      broad1 = (short) (i1 | ipOctet1);
      broad2 = (short) (i2 | ipOctet2);
      broad3 = (short) (i3 | ipOctet3);
      broad4 = (short) (i4 | ipOctet4);

      s_Broadcast = Integer.toString(i1 | ipOctet1) + "." + Integer.toString(i2 | ipOctet2) + "." + Integer.toString(i3 | ipOctet3) + "." + Integer.toString(i4 | ipOctet4);

   }

   public String showBroadcast()
   {
      return s_Broadcast;
   }

   private void calcNumberOfAddresses()
   {
      int diff1 = 0, diff2 = 0, diff3 = 0, diff4 = 0;
      String sd1, sd2, sd3, sd4;

      diff1 = broad1 - net1;
      diff2 = broad2 - net2;
      diff3 = broad3 - net3;
      diff4 = broad4 - net4;

      sd1 = pad(Integer.toBinaryString(diff1));
      sd2 = pad(Integer.toBinaryString(diff2));
      sd3 = pad(Integer.toBinaryString(diff3));
      sd4 = pad(Integer.toBinaryString(diff4));

      s_NetCount = sd1 + sd2 + sd3 + sd4;

      NumberOfAddresses = (Integer.parseInt(s_NetCount, 2) + 1) - 2;

   }

   public String numberOfAddresses()
   {

      return (Integer.toString(NumberOfAddresses));
   }

   private String pad(String s)
   {
      int len;
      len = s.length();
      String s_temp = "";

      for (int x = len; x < 8; x++)
      {
         s_temp = s_temp + "0";
      }
      return s_temp + s;
   }
}

// //////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Import the questions for the network study quiz.
//
// //////////////////////////////////////////////////////////////////////////////

import java.io.File;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class questionManager
{
   protected qMultipleChoice[] multipleChoiceList;
   protected qTrueFalse[] trueFalseList;
   protected qTrivia[] triviaList;
   protected int numMultipleChoiceQ = 0;
   protected int numTrueFalseQ = 0;
   protected int numTriviaQ = 0;
   protected boolean showAnswer = false;
   protected int currentMultipleChoiceQuestion = 0;
   protected int currentTrueFalseQuestion = 0;
   protected int currentTriviaQuestion = 0;

   //
   // Constructor
   //
   public questionManager()
   {
   }

   //
   // Set and Get routines
   //
   public boolean displayAnswer()
   {
      return (showAnswer);
   }

   public void setDisplayAnser(boolean b)
   {
      showAnswer = b;
   }
   
   //
   // Multiple Choice
   //

   public int getNumMultipleChoiceQuestions()
   {
      return (numMultipleChoiceQ);
   }

   public qMultipleChoice getMultipleChoiceQuestion(int i)
   {
      return (multipleChoiceList[i]);
   }

   public void setMultipleChoiceQuestionNum(int i)
   {
      currentMultipleChoiceQuestion = i;
   }
   
   public int getMultipleChoiceQuestionNum()
   {
      return(currentMultipleChoiceQuestion);
   }
   

   //
   // True/False
   //

   public int getNumTrueFalseQuestions()
   {
      return (numTrueFalseQ);
   }

   public qTrueFalse getTrueFalseQuestion(int i)
   {
      return (trueFalseList[i]);
   }

   public void setTrueFalseQuestionNum(int i)
   {
      currentTrueFalseQuestion = i;
   }

   public int getTrueFalseQuestionNum()
   {
      return (currentTrueFalseQuestion);
   }

   //
   // Trivia
   //

   public int getNumTriviaQuestions()
   {
      return (numTriviaQ);
   }

   public qTrivia getTriviaQuestion(int i)
   {
      return (triviaList[i]);
   }

   public void setTriviaQuestionNum(int i)
   {
      currentTriviaQuestion = i;
   }

   public int getTriviaQuestionNum()
   {
      return (currentTriviaQuestion);
   }

   //
   // Control Routines
   //

   public void incrementTriviaQuestionNum()
   {
      if (currentTriviaQuestion < (numTriviaQ - 1))
      {
         currentTriviaQuestion++;
      } else
      {
         currentTriviaQuestion = 0;
      }
   }

   public void incrementTrueFalseNum()
   {
      if (currentTrueFalseQuestion < (numTrueFalseQ - 1))
      {
         currentTrueFalseQuestion++;
      } else
      {
         currentTrueFalseQuestion = 0;
      }
   }

   public void incrementMultipleChoiceNum()
   {
      if (currentMultipleChoiceQuestion < (numMultipleChoiceQ - 1))
      {
         currentMultipleChoiceQuestion++;
      } else
      {
         currentMultipleChoiceQuestion = 0;
      }
   }

   public void initialize()
   {
      parseXMLFile();
   }

   //
   // The example for this was retrieved from
   // http://www.developerfusion.com/code/2064/a-simple-way-to-read-an-xml-file-in-java/
   // on
   // 1/20/2011
   //
   public void parseXMLFile()
   {

      try
      {

         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
               .newInstance();
         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
         Document doc = docBuilder.parse(new File("Questions.xml"));

         // normalize text representation
         doc.getDocumentElement().normalize();

         NodeList listOfMPQuestions = doc
               .getElementsByTagName("MultipleChoice");
         numMultipleChoiceQ = listOfMPQuestions.getLength();
         multipleChoiceList = new qMultipleChoice[numMultipleChoiceQ];

         for (int s = 0; s < listOfMPQuestions.getLength(); s++)
         {

            //
            // Get Multiple Choice
            //
            Node firstMPQuestionNode = listOfMPQuestions.item(s);
            if (firstMPQuestionNode.getNodeType() == Node.ELEMENT_NODE)
            {

               Element firstMPQuestionElement = (Element) firstMPQuestionNode;

               // -------
               NodeList QuestionList = firstMPQuestionElement
                     .getElementsByTagName("Question");
               Element Question = (Element) QuestionList.item(0);

               NodeList textQuestion = Question.getChildNodes();

               // -------
               NodeList AnswerAList = firstMPQuestionElement
                     .getElementsByTagName("ChoiceA");
               Element answerAElement = (Element) AnswerAList.item(0);

               NodeList textAnswerAList = answerAElement.getChildNodes();

               // ----
               NodeList AnswerBList = firstMPQuestionElement
                     .getElementsByTagName("ChoiceB");
               Element answerBElement = (Element) AnswerBList.item(0);

               NodeList textAnswerBList = answerBElement.getChildNodes();

               // ----
               NodeList AnswerCList = firstMPQuestionElement
                     .getElementsByTagName("ChoiceC");
               Element answerCElement = (Element) AnswerCList.item(0);

               NodeList textAnswerCList = answerCElement.getChildNodes();

               // ----
               NodeList AnswerDList = firstMPQuestionElement
                     .getElementsByTagName("ChoiceD");
               Element answerDElement = (Element) AnswerDList.item(0);

               NodeList textAnswerDList = answerDElement.getChildNodes();

               // ----
               NodeList correctAnswerList = firstMPQuestionElement
                     .getElementsByTagName("Answer");
               Element correctAnswerElement = (Element) correctAnswerList
                     .item(0);

               NodeList textCorrectAnswerList = correctAnswerElement
                     .getChildNodes();

               multipleChoiceList[s] = new qMultipleChoice(
                     ((Node) textQuestion.item(0)).getNodeValue().trim(),
                     ((Node) textAnswerAList.item(0)).getNodeValue()
                           .trim(), ((Node) textAnswerBList.item(0))
                           .getNodeValue().trim(),
                     ((Node) textAnswerCList.item(0)).getNodeValue()
                           .trim(), ((Node) textAnswerDList.item(0))
                           .getNodeValue().trim(),
                     ((Node) textCorrectAnswerList.item(0))
                           .getNodeValue().charAt(0));

            }

         }

         //
         // Get True/False questions
         //
         NodeList listOfTFQuestions = doc.getElementsByTagName("TrueFalse");
         numTrueFalseQ = listOfTFQuestions.getLength();
         trueFalseList = new qTrueFalse[numTrueFalseQ];

         for (int s = 0; s < listOfTFQuestions.getLength(); s++)
         {

            Node firstTFQuestionNode = listOfTFQuestions.item(s);
            if (firstTFQuestionNode.getNodeType() == Node.ELEMENT_NODE)
            {

               Element firstRFQuestionElement = (Element) firstTFQuestionNode;

               // -------
               NodeList QuestionList = firstRFQuestionElement
                     .getElementsByTagName("Question");
               Element Question = (Element) QuestionList.item(0);

               NodeList textQuestion = Question.getChildNodes();

               // ----
               NodeList correctAnswerList = firstRFQuestionElement
                     .getElementsByTagName("Answer");
               Element correctAnswerElement = (Element) correctAnswerList
                     .item(0);

               NodeList textCorrectAnswerList = correctAnswerElement
                     .getChildNodes();

               // ------

               trueFalseList[s] = new qTrueFalse(
                     ((Node) textQuestion.item(0)).getNodeValue().trim(),
                     ((Node) textCorrectAnswerList.item(0))
                           .getNodeValue().charAt(0));

            }

         }

         //
         // Get Trivia Questions
         //
         NodeList listOfTQuestions = doc.getElementsByTagName("Trivia");
         numTriviaQ = listOfTQuestions.getLength();
         triviaList = new qTrivia[numTriviaQ];

         for (int s = 0; s < listOfTQuestions.getLength(); s++)
         {

            Node firstTQuestionNode = listOfTQuestions.item(s);
            if (firstTQuestionNode.getNodeType() == Node.ELEMENT_NODE)
            {

               Element firstTQuestionElement = (Element) firstTQuestionNode;

               // -------
               NodeList QuestionList = firstTQuestionElement
                     .getElementsByTagName("Question");
               Element Question = (Element) QuestionList.item(0);

               NodeList textQuestion = Question.getChildNodes();

               // ----
               NodeList correctAnswerList = firstTQuestionElement
                     .getElementsByTagName("Answer");
               Element correctAnswerElement = (Element) correctAnswerList
                     .item(0);

               NodeList textCorrectAnswerList = correctAnswerElement
                     .getChildNodes();

               triviaList[s] = new qTrivia(((Node) textQuestion.item(0))
                     .getNodeValue().trim(),
                     ((Node) textCorrectAnswerList.item(0))
                           .getNodeValue().trim());

            }

         }

      } catch (SAXParseException err)
      {
         System.out.println("** Parsing error" + ", line "
               + err.getLineNumber() + ", uri " + err.getSystemId());
         System.out.println(" " + err.getMessage());

      } catch (SAXException e)
      {
         Exception x = e.getException();
         ((x == null) ? e : x).printStackTrace();

      } catch (Throwable t)
      {
         t.printStackTrace();
      }

   }
}
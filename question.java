////////////////////////////////////////////////////////////////////////////////
// Team B
// PRG420
//
// Parent class for the network study questions
//
////////////////////////////////////////////////////////////////////////////////

public class question {
	protected String theQuestion;

	//
	// Constructor
	//
	public question() {
	}

	//
	// Constructor
	//
	public question(String inputQuestion) {
		theQuestion = inputQuestion;
	}

	//
	// Set and Get routines
	//

	public String getQuestion() {
		return (theQuestion);
	}

	public void setQuestion(String inputQuestion) {
		theQuestion = inputQuestion;
	}

	public void printQuestion() {
		System.out.println(theQuestion);
	}

}
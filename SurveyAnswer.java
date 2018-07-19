/**
 * @author yesifan
 *
 */
public class SurveyAnswer {

	private String id;
	private String shortQuestionAnswer;
	private String textChoiceAnswer;
	private String imageChoiceAnswer;
	
	public SurveyAnswer(String id, String shortQuestionAnswer, String textChoiceAnswer, String imageChoiceAnswer){
		this.id = id;
		this.shortQuestionAnswer = shortQuestionAnswer;
		this.textChoiceAnswer = textChoiceAnswer;
		this.imageChoiceAnswer = imageChoiceAnswer;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShortQuestionAnswer() {
		return shortQuestionAnswer;
	}

	public void setShortQuestionAnswer(String shortQuestionAnswer) {
		this.shortQuestionAnswer = shortQuestionAnswer;
	}

	public String getTextChoiceAnswer() {
		return textChoiceAnswer;
	}

	public void setTextChoiceAnswer(String textChoiceAnswer) {
		this.textChoiceAnswer = textChoiceAnswer;
	}

	public String getImageChoiceAnswer() {
		return imageChoiceAnswer;
	}

	public void setImageChoiceAnswer(String imageChoiceAnswer) {
		this.imageChoiceAnswer = imageChoiceAnswer;
	}
	
	public String toString(){
		return "Short Question Answer: " + this.shortQuestionAnswer + "\n" +
				"Text Choice Answer: " + this.textChoiceAnswer + "\n" + 
				"Image Choice Answer: " + this.imageChoiceAnswer + "\n";
	}
}

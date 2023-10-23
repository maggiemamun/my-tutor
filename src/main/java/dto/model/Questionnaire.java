package dto.model;

import java.util.List;

public class Questionnaire {
	private int tutorId;
	private int tutoreScore;
	private List<Question> questions;

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int getTutoreScore() {
		return tutoreScore;
	}

	public void setTutoreScore(int tutoreScore) {
		this.tutoreScore = tutoreScore;
	}

}

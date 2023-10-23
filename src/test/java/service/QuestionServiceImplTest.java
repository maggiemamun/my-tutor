package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dto.model.Questionnaire;
import service.impl.QuestionnaireServiceImpl;

class QuestionServiceImplTest {
	QuestionnaireServiceImpl questionnaireServiceImpl = new QuestionnaireServiceImpl();
	Questionnaire questionnaire = new Questionnaire();

	@Test
	@DisplayName("Test ScoreWhenMCQOption1Answered")
	void testScoreWhenMCQOption1Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireMCQ.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(1, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenMCQOption2Answered")
	void testScoreWhenMCQOption2Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireMCQ2.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(2, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenMCQOption3Answered")
	void testScoreWhenMCQOption3Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireMCQ3.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(3, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenMCQOption4Answered")
	void testScoreWhenMCQOption4Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireMCQ4.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(3, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenSCQOption1Answered")
	void testScoreWhenSCQOption1Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireSCQ.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(0, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenSCQOption2Answered")
	void testScoreWhenSCQOption2Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireSCQ2.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(1, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenSCQOption3Answered")
	void testScoreWhenSCQOption3Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireSCQ3.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(2, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenSCQOption4Answered")
	void testScoreWhenSCQOption4Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireSCQ4.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(0, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenBothOption1Answered")
	void testScoreWhenBothOption1Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireBoth.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(2, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenBothOption2Answered")
	void testScoreWhenBothOption2Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireBoth2.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(3, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenBothOption3Answered")
	void testScoreWhenBothOption3Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireBoth3.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(5, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenBothOption4Answered")
	void testScoreWhenBothOption4Answered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireBoth4.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(3, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test ScoreWhenNoneAnswered")
	void testScoreWhenNoneAnswered() {
		String filePath = "/my-tutor/src/test/resources/QuestionnaireNone.json";
		questionnaire = questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		assertEquals(0, questionnaire.getTutoreScore());

	}

	@Test
	@DisplayName("Test InvalidQuestions")
	void testinvalidQuestionnaire() {
		final String filePath = "/my-tutor/src/test/resources/QuestionnaireInvalid.json";

		assertThrows(NullPointerException.class, () -> {
			questionnaireServiceImpl.calcaulteTutorScore(getQuestionnaire(filePath));
		}, "Questionnaire is invalid");

	}

	private Questionnaire getQuestionnaire(String filePath) {
		questionnaire = questionnaireServiceImpl.readQuestionnaire(filePath);
		// TODO Auto-generated method stub
		return questionnaire;
	}

}

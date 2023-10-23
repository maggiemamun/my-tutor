package service;

import dto.model.Questionnaire;

public interface QuestionnaireService {

	public Questionnaire readQuestionnaire(String filePath);

	public Questionnaire calcaulteTutorScore(final Questionnaire questionnaire);

	public void writeQuestionnaire(Questionnaire outQuestionnaire);

}

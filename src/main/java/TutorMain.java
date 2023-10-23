import java.util.Scanner;

import dto.model.Questionnaire;
import service.QuestionnaireService;
import service.impl.QuestionnaireServiceImpl;

public class TutorMain {

	public static void main(String[] args) {

		final QuestionnaireService questionnaireservice = new QuestionnaireServiceImpl();
		// read json file to get details
		String filePath = "/my-tutor/src/main/resources/Questionnaire.json";

		Questionnaire inpQuestionnaire = questionnaireservice.readQuestionnaire(filePath);
		// calculateScore of the Tutor
		Questionnaire outQuestionnaire = questionnaireservice.calcaulteTutorScore(inpQuestionnaire);
		// write the Questionnaire object to json file
		questionnaireservice.writeQuestionnaire(outQuestionnaire);

	}

}

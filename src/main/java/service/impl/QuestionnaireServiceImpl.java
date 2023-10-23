package service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dto.model.Question;
import dto.model.Questionnaire;
import service.QuestionnaireService;

public class QuestionnaireServiceImpl implements QuestionnaireService {

	/*
	 * This Method is intended to read the Tutor Questionnaire in JSON Format and
	 * map to Questionnaire Object.
	 * 
	 * @Param inpFilePath, the fileLocation of the Questionnaire json.
	 * 
	 * @Return Questionnaire, mapped Questionnaire object
	 */

	public Questionnaire readQuestionnaire(final String inpFilePath) {
		Gson gson = new Gson();

		Questionnaire questionnaire = null;
		try {
			questionnaire = gson.fromJson(new FileReader(inpFilePath), Questionnaire.class);

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return questionnaire;

	}

	/*
	 * This method is intended to read the Questionnaire object and calculate the
	 * Tutor Scores based on the options answered. 
	 * 
	 * N.B. the Scoring points per option
	 * will be hidden to the Tutors(UI) and will only be used internally by the
	 * backend service for scoring. .
	 * 
	 * @Param Questionnaire, the Questionnaire object with Tutor details(Id) ,
	 * Questions and answers submitted by the TUtor.
	 * 
	 * @Return Questionnaire, mapped Questionnaire object with the Tutor score
	 */

	public Questionnaire calcaulteTutorScore(final Questionnaire questionnaire) {

		if (null != questionnaire.getQuestions()) {
			List<Question> questions = questionnaire.getQuestions();

			int score = 0;
			for (int i = 0; i < questions.size(); i++) {
				List<Integer> answer = questions.get(i).getAnswers();
				for (int j = 0; j < answer.size(); j++) {

					score = score + questions.get(i).getOptions().get(answer.get(j) - 1).getOptionScore();

				}
			}

			questionnaire.setTutoreScore(score);
		} else {
			throw new NullPointerException("Questionnaire is invalid");
		}

		return questionnaire;
	}

	/*
	 * This method is intended to read the Questionnaire object and write the Score
	 * to a Questionnaire Json file which would contain the original Questionnaire
	 * submitted by the Tutor along with the calculated score.
	 * 
	 * N.B. the Scoring points per option will be hidden to the Tutor(UI) and will
	 * only be used internally by the backend service for scoring. .
	 * 
	 * @Param .Questionnaire, mapped Questionnaire object with the Tutor score
	 * 
	 */

	public void writeQuestionnaire(Questionnaire outQuestionnaire) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			FileWriter writer = new FileWriter("/my-tutor/src/main/resources/OutputQuestionnaire.json");
			gson.toJson(outQuestionnaire, writer);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

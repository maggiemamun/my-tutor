# Tutor Scoring

This is a Java Application to rank Tutors based on a Questionnaire. This application takes in a tutor questionnaire(with Tutor-Id and his submitted question-answers) and returns a Tutor score with a  record of the Original submitted Questionnaire.

## Technology
Java 8, Junit 5, Maven, Git, Eclipse IDE

## Usage

1. Clone the repo [my-tutor](https://github.com/maggiemamun/my-tutor.git) to download the application.

```bash
  https://github.com/maggiemamun/my-tutor.git
```
2. Import the repo to an IDE like Eclipse or Intellij.

3. Run the Main application TutorMain.java  with any changes to the Questionnaire Json  and score will be updated to the output Questionnaire
   
```bash
  src/main/java/TutorMain.java
```
```bash
  Input Questionnaire
  src/main/resources/Questionnaire.json
```
```bash
  Output Questionnaire
  src/main/resources/OutputQuestionnaire.json
```
3. Junit tests at below.
```bash
  https://github.com/maggiemamun/my- 
  tutor/blob/main/src/test/
```

```bash
  Execution Snippet
  https://github.com/maggiemamun/my-tutor/blob/main/Junits_image.png
```
## Note
The scoring points  used in the json will b hidden to the Tutor(intended to be managed by the UI) and is intended to use purely by the backend service.

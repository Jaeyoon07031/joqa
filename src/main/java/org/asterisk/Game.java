package org.asterisk;

import org.asterisk.util.InputUtils;
import org.asterisk.util.gameutils. AnswerData;

import java.util.*;

import org.json.simple.*;

public class Game
{
    public static Scanner console;
    //TODO: change to private and instantiate Game in Main?

    public Game(Scanner console)
    {
        Game.console = console;
    }

    public static void playGame(JSONArray questionsJSON)
    {
        Integer questionCount = questionsJSON.size();

        System.out.println("You have chosen to PLAY a quiz");
        System.out.println("You have " + questionCount + " questions currently available.");

        Integer playCount = InputUtils.inputProtectedInteger("Choose how many questions to play, between 1 and " + questionCount,
                console, 1, questionCount);

        System.out.println("Alright, playing for " + playCount + " questions!");

        List<Object> questionList = Arrays.asList(questionsJSON.toArray());
        Collections.shuffle(questionList);
        questionList = questionList.subList(0, playCount);
        List<AnswerData> scoreTracker = new ArrayList<>();

        for (Object questionObject : questionList)
        {
            JSONObject question = (JSONObject)questionObject;
            JSONArray choices = (JSONArray)question.get("choices");
            JSONArray comments = (JSONArray)question.get("comments");
            List<String> commentList = new ArrayList<>();

            Integer questionId = Integer.parseInt(question.get("id").toString());
            Integer correctChoice = Integer.parseInt(question.get("correctChoice").toString());
            boolean choiceCorrect;

            System.out.println("Question ID: " + questionId);
            System.out.println("Question: " + question.get("question"));

            Integer iteratorCount = 0;
            for (Object choiceObject : choices)
            {
                JSONObject choice = (JSONObject)choiceObject;
                System.out.println("Choice " + iteratorCount  + ": " + choice.get("choice" + iteratorCount));
                iteratorCount++;
            }

            iteratorCount = 0;
            for (Object commentObject : comments)
            {
                JSONObject comment = (JSONObject)commentObject;
                commentList.add(comment.get("comment" + iteratorCount).toString());
                iteratorCount++;
            }

            Integer response = InputUtils.inputProtectedInteger("What is your choice? Answer with the choice's number.",
                    console, 0, choices.size());

            choiceCorrect = response.equals(Integer.parseInt(correctChoice.toString()));

            if (choiceCorrect)
            {
                System.out.println("You got the correct choice!");
            }
            else
            {
                System.out.println("Not quite the correct choice.");
            }

            System.out.println("Comment: " + commentList.get(response));

            scoreTracker.add(new AnswerData(questionId, choiceCorrect, response, correctChoice));
        }

        System.out.println("Quiz Over!");
        System.out.println("Your results:");
        System.out.println(" QID | YOU | COR | RES");

        Integer correct = 0;
        Integer incorrect = 0;
        for (AnswerData answer : scoreTracker)
        {
            System.out.print("  " + answer.getQuestionId() + "  |  " + answer.getGivenAnswer() + "  |  " + answer.getCorrectChoice() + "  |  ");
            if (answer.getAnswerCorrectness())
            {
                System.out.println("O");
                correct++;
            }
            else
            {
                System.out.println("X");
                incorrect++;
            }
        }

        System.out.println("Total Score: " + correct + " / " + correct + incorrect);
    }
}
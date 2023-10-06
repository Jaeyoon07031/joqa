package org.asterisk;

import org.asterisk.util.InputUtils;
import org.asterisk.util.gameutils.AnswerData;
import org.asterisk.util.gameutils.fallbackgame.*;

import java.util.*;

import org.json.simple.*;

public class Game
{
    private final Scanner console;

    public Game(Scanner console)
    {
        this.console = console;
    }

    public void playGame(JSONArray questionsJSON)
    {
        System.out.println("You have chosen to PLAY a quiz");
        for(;;)
        {
            System.out.println("Which quiz do you want to play?");
            System.out.println("DEFAULT | CUSTOM");
            String response = console.nextLine();
            if (response.equalsIgnoreCase("DEFAULT"))
            {
                playDefaultGame();
                return;
            }
            else if (response.equalsIgnoreCase("CUSTOM"))
            {
                playCustomGame(questionsJSON);
                return;
            }
            else
            {
                System.out.println("That was not a valid choice. Try again: ");
            }
        }
    }

    private void playCustomGame(JSONArray questionsJSON)
    {
        int questionCount = questionsJSON.size();
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

            int questionId = Integer.parseInt(question.get("id").toString());
            int correctChoice = Integer.parseInt(question.get("correctChoice").toString());
            boolean choiceCorrect;

            System.out.println("Question ID: " + questionId);
            System.out.println("Question: " + question.get("question"));

            int iteratorCount = 0;
            for (Object choiceObject : choices)
            {
                JSONObject choice = (JSONObject)choiceObject;
                System.out.println("Choice " + (iteratorCount + 1)  + ": " + choice.get("choice" + iteratorCount));
                iteratorCount++;
            }

            int response = InputUtils.inputProtectedInteger("What is your choice? Answer with the choice's number, which is between 1 and " + choices.size(),
                    console, 1, choices.size());

            choiceCorrect = (correctChoice == (response - 1));

            if (choiceCorrect)
            {
                System.out.println("You got the correct choice!");
            }
            else
            {
                System.out.println("Not quite the correct choice.");
            }

            scoreTracker.add(new AnswerData(questionId, choiceCorrect, response, correctChoice));
        }

        printScoreBoard(scoreTracker);
    }

    private void playDefaultGame()
    {
        System.out.println("You have opted to play the default questions!");
        System.out.println("There are 5 default questions available");
        System.out.println("Starting now!");

        List<AnswerData> scoreTracker = new ArrayList<>();
        List<String> defaultQuestionList = Arrays.asList("FirstDefaultQuestion", "SecondDefaultQuestion", "ThirdDefaultQuestion", "FourthDefaultQuestion", "FifthDefaultQuestion");
        Collections.shuffle(defaultQuestionList);

        for (String defaultQuestion : defaultQuestionList)
        {
            DefaultQuestion question = DefaultQuestionFactory.getDefaultQuestion(defaultQuestion);

            int response = question.askQuestion(console);
            boolean choiceCorrect = (question.getCorrectChoice() == (response - 1));

            if (choiceCorrect)
            {
                System.out.println("You got the correct choice!");
            }
            else
            {
                System.out.println("Not quite the correct choice.");
            }

            scoreTracker.add(new AnswerData(question.getQuestionId(), choiceCorrect, response, question.getCorrectChoice()));
        }

        printScoreBoard(scoreTracker);
    }

    private void printScoreBoard(List<AnswerData> scoreTracker)
    {
        System.out.println("Quiz Over!");
        System.out.println("Your results:");
        System.out.println(" QID | YOU | COR | RES");

        Integer correct = 0;
        Integer incorrect = 0;
        for (AnswerData answer : scoreTracker)
        {
            System.out.print("  " + answer.getQuestionId() + "  |  " + answer.getGivenAnswer() + "  |  " + (answer.getCorrectChoice() + 1) + "  |  ");
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

        System.out.println("Total Score: " + correct + " / " + (correct + incorrect));
    }
}
package org.asterisk.util.gameutils.fallbackgame;

import org.asterisk.util.InputUtils;

import java.util.*;

public class FifthDefaultQuestion implements DefaultQuestion
{
    private final int questionId = 4;
    private final int correctChoice = 0;
    private final String question = "T/F: You can share your custom question files with your friends";
    private final List<String> choices = Arrays.asList("True",
            "False");

    @Override
    public int askQuestion(Scanner console)
    {
        System.out.println("Question ID: " + questionId);
        System.out.println("Question: " + question);

        int iteratorCount = 0;
        for (String choiceObject : choices)
        {
            System.out.println("Choice " + (iteratorCount + 1)  + ": " + choiceObject);
            iteratorCount++;
        }

        return InputUtils.inputProtectedInteger("What is your choice? Answer with the choice's number, which is between 1 and " + choices.size(),
                console, 1, choices.size());
    }

    @Override
    public int getQuestionId()
    {
        return questionId;
    }

    @Override
    public int getCorrectChoice()
    {
        return correctChoice;
    }
}

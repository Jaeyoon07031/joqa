package org.asterisk.util.gameutils.fallbackgame;

import org.asterisk.util.InputUtils;

import java.util.*;

public class SecondDefaultQuestion implements DefaultQuestion
{
    private final int questionId = 1;
    private final int correctChoice = 0;
    private final String question = "";
    private final List<String> choices = Arrays.asList("Choice0",
            "Choice1",
            "Choice2");

    @Override
    public int askQuestion(Scanner console)
    {
        System.out.println("Question ID: " + questionId);
        System.out.println("Question: " + question);


        int iteratorCount = 0;
        for (String choiceObject : choices)
        {
            System.out.println("Choice " + iteratorCount  + ": " + choiceObject);
            iteratorCount++;
        }

        return InputUtils.inputProtectedInteger("What is your choice? Answer with the choice's number, which is between 0 and " + (choices.size() - 1),
                console, 0, choices.size() - 1);
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

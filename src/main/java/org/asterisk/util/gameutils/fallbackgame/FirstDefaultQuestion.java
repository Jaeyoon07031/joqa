package org.asterisk.util.gameutils.fallbackgame;

import org.asterisk.util.InputUtils;

import java.util.*;

public class FirstDefaultQuestion implements DefaultQuestion
{
    private final int questionId = 0;
    private final int correctChoice = 3;
    private final String question = "What is the theoretical limit to the number of custom questions in this program while remaining playable?";
    private final List<String> choices = Arrays.asList("Unlimited",
            "2^63 - 1",
            "2^32 - 1",
            "2^31 - 1");

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

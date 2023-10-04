package org.asterisk;

import org.asterisk.util.*;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;


public class Editor
{
    public static Scanner console;
    //TODO: change to private and instantiate Game in Main?

    public Editor(Scanner console)
    {
        Editor.console = console;
    }

    public static JSONObject addQuestion(JSONArray questionList)
    {
        JSONObject finalFile = new JSONObject();
        JSONObject newQuestion;
        List<String> choiceTexts = new ArrayList<String>();

        System.out.println("You have chosen to make a new question!");
        System.out.println("Type your question below: ");

        String question = console.nextLine();

        int choiceCount = InputUtils.inputProtectedInteger("Choose how many choices to make, between 2 and 9",
                console, 2, 9);

        for (int i = 0; i < choiceCount; i++)
        {
            System.out.println("Type choice number " + i + " below: ");
            System.out.print(i + ": ");

            String response = console.nextLine();
            choiceTexts.add(response);
        }

        int correctChoice = InputUtils.inputProtectedInteger("Which number choice should be the correct one? Enter a number between 0 and " + (choiceCount - 1),
                console, 1, choiceCount);

        newQuestion = JSONUtils.questionBuilder(questionList.size(), correctChoice, question, choiceTexts);
        questionList.add(newQuestion);
        finalFile.put("questions", questionList);

        return finalFile;
    }

    public static void openEditor()
    {

    }
}

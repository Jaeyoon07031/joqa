package org.asterisk;

import org.asterisk.util.*;

import java.util.*;

import org.json.simple.*;

public class Editor
{
    private final Scanner console;

    public Editor(Scanner console)
    {
        this.console = console;
    }

    public JSONObject addQuestion(JSONArray questionList)
    {
        JSONObject finalFile = new JSONObject();
        JSONObject newQuestion;
        List<String> choiceTexts = new ArrayList<>();

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
                console, 0, choiceCount - 1);

        newQuestion = JSONUtils.questionBuilder(questionList.size(), correctChoice, question, choiceTexts);
        questionList.add(newQuestion);
        finalFile.put("questions", questionList);

        return finalFile;
    }
}

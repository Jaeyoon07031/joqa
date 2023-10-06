package org.asterisk.util;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

/*
Questions JSON Format
"questions":
[
    {
        "id": Integer,
        "correctChoice": Integer,
        "question": String,
        "choices": [
            {"choice0": String},
            {"choice1": String},
            {"choice2": String}
        ]
    }
]
 */

//TODO: change question id to longer, random hexadecimal?

public class JSONUtils
{
    public static void writeJsonFile(JSONObject obj) throws IOException
    {
        FileWriter file = new FileWriter("questions.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
    }

    public static JSONObject readJsonFile() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("questions.json");

        Object obj = parser.parse(reader);
        return (JSONObject) obj;
    }

    public static JSONObject questionBuilder(int id, Integer correctChoice, String question, List<String> choices)
    {
        JSONObject obj = new JSONObject();
        JSONArray choiceArray = new JSONArray();
        Integer iteratorCount = 0;

        obj.put("id", id);
        obj.put("correctChoice", correctChoice);
        obj.put("question", question);

        for (String choiceString : choices)
        {
            JSONObject choice = new JSONObject();
            choice.put("choice" + iteratorCount, choiceString);
            choiceArray.add(choice);
            iteratorCount++;
        }

        obj.put("choices", choiceArray);

        return obj;
    }

    public static void checkJsonExists()
    {
        try
        {
            Reader reader = new FileReader("questions.json");
        }
        catch (IOException ignoredError)
        {
            System.out.println("Custom questions file not found, creating a default one");

            JSONObject defaultQuestions = new JSONObject();
            JSONArray defaultQuestionArray = new JSONArray();

            //TODO: make default questions actually useful???? (might make it a self-learning tutorial)

            defaultQuestionArray.add(questionBuilder(0, 1, "How much time did the author waste writing this?",
                    Arrays.asList("3 hours", "5 hours", "More than the above")));
            defaultQuestionArray.add(questionBuilder(1, 2, "How much trouble are you in if you don't properly list the licenses for libraries you use",
                    Arrays.asList("Straight to Jail", "No one cares", "Don't Know")));
            defaultQuestionArray.add(questionBuilder(2, 0, "How difficult is it to actually make good, meaningful questions for this?",
                    Arrays.asList("Incredibly", "Somewhat", "Not at all")));

            defaultQuestions.put("questions", defaultQuestionArray);

            try
            {
                writeJsonFile(defaultQuestions);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

package org.asterisk;

import java.io.*;
import java.util.*;
import org.json.simple.*;

public class Main
{
    public static void main(String[] args)
    {
        checkJsonExists();
    }

    public static void writeJsonFile(JSONObject obj) throws IOException
    {
        FileWriter file = new FileWriter("questions.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
    }

    public static JSONObject questionBuilder(Integer id, String question, Integer correctChoice, List<String> choices, List<String> comments)
    {
        JSONObject obj = new JSONObject();
        JSONArray choiceArray = new JSONArray();
        JSONArray commentArray = new JSONArray();
        Integer iteratorCount = 0;

        obj.put("id", id);
        obj.put("question", question);
        obj.put("correctChoice", correctChoice);

        for (String choiceString : choices)
        {
            JSONObject choice = new JSONObject();
            choice.put("choice" + iteratorCount, choiceString);
            choiceArray.add(choice);
            iteratorCount++;
        }

        iteratorCount = 0;
        for (String commentString : comments)
        {
            JSONObject comment = new JSONObject();
            comment.put("comment" + iteratorCount, commentString);
            commentArray.add(comment);
            iteratorCount++;
        }

        obj.put("choices", choiceArray);
        obj.put("comments", commentArray);

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
            System.out.println("Questions file not found, creating a new one");

            JSONObject defaultQuestions = new JSONObject();
            JSONArray defaultQuestionArray = new JSONArray();

            defaultQuestionArray.add(questionBuilder(0, "Question0", 0,
                    Arrays.asList("Choice0", "Choice1", "Choice2"),
                    Arrays.asList("Comment0", "Comment1", "Comment2")));
            defaultQuestionArray.add(questionBuilder(1, "Question1", 0,
                    Arrays.asList("Choice0", "Choice1", "Choice2"),
                    Arrays.asList("Comment0", "Comment1", "Comment2")));
            defaultQuestionArray.add(questionBuilder(2, "Question2", 0,
                    Arrays.asList("Choice0", "Choice1", "Choice2"),
                    Arrays.asList("Comment0", "Comment1", "Comment2")));

            defaultQuestions.put("questions", defaultQuestionArray);

            try
            {
                writeJsonFile(defaultQuestions);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            System.out.print(defaultQuestions.toJSONString());
        }
    }
}
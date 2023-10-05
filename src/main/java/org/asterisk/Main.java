package org.asterisk;

import org.asterisk.util.JSONUtils;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Main
{
    //TODO: entire thing needs better error handling
    //TODO: change indexing to be user-friendly
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        Game game = new Game(console);
        Editor editor = new Editor(console);

        JSONObject questionFile;
        JSONArray questionList;

        JSONUtils.checkJsonExists();

        try
        {
            questionFile = JSONUtils.readJsonFile();
        }
        catch (IOException | ParseException e)
        {
            throw new RuntimeException(e);
        }

        questionList = (JSONArray) questionFile.get("questions");

        System.out.println("jay's over-engineered quiz app");

        for(;;)
        {
            System.out.println("what would you like to do?");
            System.out.println("PLAY | CREATE | EDIT | EXIT");

            String response = console.nextLine();

            if (response.equalsIgnoreCase("PLAY"))
            {
                game.playGame(questionList);
            }
            else if (response.equalsIgnoreCase("CREATE"))
            {
                JSONObject newFile = editor.addQuestion(questionList);

                try
                {
                    JSONUtils.writeJsonFile(newFile);
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }

                questionList = (JSONArray) newFile.get("questions");
            }
            else if (response.equalsIgnoreCase("EDIT"))
            {
                editor.openEditor();
            }
            else if (response.equalsIgnoreCase("EXIT"))
            {
                System.out.println("Thanks for playing!");
                return;
            }
            else
            {
                System.out.println("Not a valid choice. Try again:");
            }
        }
    }
}
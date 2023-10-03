package org.asterisk;

import org.asterisk.util.JSONUtils;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        Game.console = console;
        JSONObject questionFile;
        JSONArray questionList;

        JSONUtils.checkJsonExists();

        try
        {
            questionFile = JSONUtils.readJsonFile();
        }
        catch (IOException | ParseException e)
        {
            //TODO: try to load json again?
            throw new RuntimeException(e);
        }

        questionList = (JSONArray) questionFile.get("questions");

        System.out.println("jay's over-engineered quiz app");

        for(;;)
        {
            System.out.println("what would you like to do?");
            System.out.println("PLAY | CREATE | EDIT | EXIT");

            String response = console.nextLine();
            response = response.toUpperCase();

            if (response.equals("PLAY"))
            {
                Game.playGame(questionList);
            }
            else if (response.equals("CREATE"))
            {
                Editor.createQuestion();
            }
            else if (response.equals("EDIT"))
            {
                Editor.openEditor();
            }
            else if (response.equals("EXIT"))
            {
                break;
                //TODO: change this so reynolds doesnt yell at me again
            }
        }
    }
}
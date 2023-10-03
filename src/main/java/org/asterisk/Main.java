package org.asterisk;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
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
        System.out.println("what would you like to do?");
        System.out.println("PLAY | CREATE | VIEW");

        while(true)
        {
            String response = console.nextLine();
            response = response.toUpperCase();

            if (response.equals("PLAY"))
            {
                Integer questionCount = questionList.size();

                System.out.println("You have chosen to PLAY a quiz");
                System.out.println("You have " + questionCount + " questions currently available.");
                System.out.println("Choose how many questions to play, between 1 and " + questionCount);

                Integer playCount = inputProtectedInteger(console, 1, questionCount);

                System.out.println("Alright, playing for " + playCount + " questions!");

            }
            else if (response.equals("CREATE"))
            {

            }
            else if (response.equals("VIEW"))
            {

            }
        }
    }

    public static Integer inputProtectedInteger(Scanner console, int lowerBound, int upperBound)
    {
        while (true)
        {
            String input = console.nextLine();
            if (input == null)
            {
                System.out.println("Your input was invalid; try again.");
                continue;
            }
            try
            {
                int integerInput = Integer.parseInt(input);
                if (integerInput < lowerBound || integerInput > upperBound)
                {
                    System.out.println("Your input was outside of the allowed bounds (" + lowerBound + ", " + upperBound + "); try again.");
                    continue;
                }
                return integerInput;
            }
            catch (Exception e)
            {
                System.out.println("Your input was invalid; try again. See error below:");
                e.printStackTrace();
            }
        }
    }
}
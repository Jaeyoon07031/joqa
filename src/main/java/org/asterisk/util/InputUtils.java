package org.asterisk.util;

import java.util.Scanner;

public class InputUtils
{
    public static Integer inputProtectedInteger(String message, Scanner console, int lowerBound, int upperBound)
    {
        while (true)
        {
            System.out.println(message);
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

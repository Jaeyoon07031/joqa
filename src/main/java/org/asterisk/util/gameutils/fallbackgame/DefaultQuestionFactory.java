package org.asterisk.util.gameutils.fallbackgame;

public class DefaultQuestionFactory
{
    public static DefaultQuestion getDefaultQuestion(String questionName)
    {
        switch (questionName)
        {
            case "FirstDefaultQuestion":
                return new FirstDefaultQuestion();
            case "SecondDefaultQuestion":
                return new SecondDefaultQuestion();
            case "ThirdDefaultQuestion":
                return new ThirdDefaultQuestion();
            case "FourthDefaultQuestion":
                return new FourthDefaultQuestion();
            case "FifthDefaultQuestion":
                return new FifthDefaultQuestion();
            default:
                throw new RuntimeException("Found no suitable default question to build!");
        }
    }
}

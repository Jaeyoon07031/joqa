package org.asterisk.util.gameutils;

public class AnswerData
{
    private int questionId;
    private boolean answerCorrect;
    private int givenAnswer;
    private int correctChoice;
    private int problemWeight;
    //TODO: am i going to use problemWeight or not lol

    public AnswerData(int questionId, boolean answerCorrect, int givenAnswer, int correctAnswer)
    {
        this.questionId = questionId;
        this.answerCorrect = answerCorrect;
        this.givenAnswer = givenAnswer;
        this.correctChoice = correctAnswer;
    }

    public AnswerData(int questionId, boolean answerCorrect, int givenAnswer, int correctAnswer, int problemWeight)
    {
        this.questionId = questionId;
        this.answerCorrect = answerCorrect;
        this.givenAnswer = givenAnswer;
        this.correctChoice = correctAnswer;
        this.problemWeight = problemWeight;
    }

    public int getQuestionId()
    {
        return questionId;
    }

    public boolean getAnswerCorrectness()
    {
        return answerCorrect;
    }

    public int getGivenAnswer()
    {
        return givenAnswer;
    }

    public int getCorrectChoice()
    {
        return correctChoice;
    }

    public int getProblemWeight()
    {
        return problemWeight;
    }
}

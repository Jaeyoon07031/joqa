package org.asterisk.util.gameutils;

public class AnswerData
{
    private Integer questionId;
    private boolean answerCorrect;
    private Integer givenAnswer;
    private Integer correctChoice;
    private Integer problemWeight;
    //TODO: am i going to use problemWeight or not lol

    public AnswerData(Integer questionId, boolean answerCorrect, Integer givenAnswer, Integer correctAnswer)
    {
        this.questionId = questionId;
        this.answerCorrect = answerCorrect;
        this.givenAnswer = givenAnswer;
        this.correctChoice = correctAnswer;
    }

    public AnswerData(Integer questionId, boolean answerCorrect, Integer givenAnswer, Integer correctAnswer, Integer problemWeight)
    {
        this.questionId = questionId;
        this.answerCorrect = answerCorrect;
        this.givenAnswer = givenAnswer;
        this.correctChoice = correctAnswer;
        this.problemWeight = problemWeight;
    }

    public Integer getQuestionId()
    {
        return questionId;
    }

    public boolean getAnswerCorrectness()
    {
        return answerCorrect;
    }

    public Integer getGivenAnswer()
    {
        return givenAnswer;
    }

    public Integer getCorrectChoice()
    {
        return correctChoice;
    }

    public Integer getProblemWeight()
    {
        return problemWeight;
    }
}

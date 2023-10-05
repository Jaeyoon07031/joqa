package org.asterisk.util.gameutils.fallbackgame;

import java.util.*;

public interface DefaultQuestion
{
    /*
        Steps for adding a new Default Question:
        1. Create new class extending DefaultQuestion and change the question parameters
        2. Add the new option to the DefaultQuestionFactory
        3. Add the new question to the list in Game.playDefaultGame()
     */

    int askQuestion(Scanner console);

    int getQuestionId();

    int getCorrectChoice();
}

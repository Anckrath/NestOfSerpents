package Character;

public class GeneralMethods {


    /* Function simulates dice throws */
    public int throwDice(int diceType, int numberOfThrows){
        int result = 0;
        for (int i = 0; i < numberOfThrows; i++)
        {
            result += (Math.random() * diceType) + 1;
        }
        return result;
    }

    public boolean isAttributeCheckSuccessful(int characterAttribute, int checkDifficulty, int diceThrowResult){
        return characterAttribute > diceThrowResult && checkDifficulty < diceThrowResult;
    }
}

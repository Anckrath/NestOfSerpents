package Character;

import static Character.DiceType.D6;

public class GeneralMethods {


    /* Constants */
    public static final int DOUBLE_DAMAGE = 12;

    /* Function simulates dice throws */
    public int throwDice(DiceType diceType, int numberOfThrows){
        int result = 0;
        for (int i = 0; i < numberOfThrows; i++)
        {
            result += (int) ((Math.random() * diceType.getValue()) + 1);
        }
        return result;
    }

    /* Function to check if attribute check is successful */
    public boolean isAttributeCheckSuccessful(int characterAttribute, int checkDifficulty, int diceThrowResult){
        return characterAttribute > diceThrowResult && checkDifficulty < diceThrowResult;
    }

    /* Function to calculate fight result
    * Attack    = 2k6 + Physique
    * Defense   = Mental + Physique
    */
    public void calculateFightResult(Character mainCharacter, Character enemy){

        /* Check who starts the combat */
        if (mainCharacter.getAstral() >= enemy.getAstral()){

        } else {

        }
    }


    /* Function to check if the attack was successful and how much damage it caused */
    private void calculateAttack(Character attacker, Character defender) {
        int diceThrow       = throwDice(D6, 2);
        int attackRating    = diceThrow + attacker.getPhysique();
        int defenseRating   = defender.getPhysique() + defender.getMental();


        if(attackRating >= defenseRating) {
            defender.setAstral(defender.getAstral() - 1); // Every successful attack lowers the defender astral by one.

            /* Check if normal or double damage should be applied */
            if (diceThrow == DOUBLE_DAMAGE) {
                defender.setHealthPoints(defender.getHealthPoints() - (attacker.getDamage() * 2));
            } else {
                defender.setHealthPoints(defender.getHealthPoints() - attacker.getDamage());
            }
        } else {
            /* The attack misses and nothing happens */
        }
    }
}

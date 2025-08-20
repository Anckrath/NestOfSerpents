package Character;

import static Character.DiceType.D6;

public class GeneralMethods {


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
        int attackMainChar  = 0;
        int attackEnemy     = 0;
        int attackDiceThrow = 0;
        int defenseMainChar = mainCharacter.getPhysique() + mainCharacter.getMental();
        int defenseEnemy    = enemy.getPhysique() + enemy.getMental();

        /* The main character starts the combat*/
        if (mainCharacter.getAstral() >= enemy.getAstral()){
            attackDiceThrow = throwDice(D6, 2);
            attackMainChar = mainCharacter.getPhysique() + attackDiceThrow + mainCharacter.getEquipment(0).getAttackBonus();

            /* Check if the attack was successful */
            if (attackMainChar >= defenseEnemy){
                enemy.setAstral(enemy.getAstral() - 1);
                enemy.setHealthPoints(enemy.getHealthPoints() - mainCharacter.getEquipment(0).getDamage());
            }

        }
        /* The enemy attacks */
        else {

        }
    }
}

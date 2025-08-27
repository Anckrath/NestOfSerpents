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
        /* The main character attacks first */
        if (mainCharacter.getAstral() >= enemy.getAstral()){
            calculateAttack(mainCharacter, enemy);

            if (!isDefenderCharacterFleeingFromCombat(mainCharacter, enemy) && isAlive(enemy)){
                calculateAttack(enemy, mainCharacter);
            }

        }
        /* The enemy starts the combat */
        else {

        }
    }


    /* Function to check if the attack was successful and how much damage it caused */
    private void calculateAttack(Character attacker, Character defender) {
        int diceThrow       = throwDice(D6, 2);
        int attackRating    = diceThrow + attacker.getPhysique();
        int defenseRating   = defender.getPhysique() + defender.getMental();
        int damage          = 0;

        /* Check if the attack hits */
        if(attackRating >= defenseRating) {
            defender.setAstral(defender.getAstral() - 1); // Every successful attack lowers the defender astral by one.

            /* Calculate damage */
            if (diceThrow == DOUBLE_DAMAGE) {
                damage = defender.getHealthPoints() - (attacker.getDamage() * 2);
            } else {
                damage = defender.getHealthPoints() - attacker.getDamage();
            }
            /* If the attackers mental is equal to zero the damage is reduced by one */
            if (attacker.getMental() == 0){
                damage -= 1;
            }

            defender.setHealthPoints(defender.getHealthPoints() - damage);
        } else {
            /* The attack misses and nothing happens */
        }
    }

    /* Function to check if the defender character will flee from the combat */
    private boolean isDefenderCharacterFleeingFromCombat (Character  attacker, Character defender){
        return attacker.getAstral() - 5 > defender.getAstral() || defender.getAstral() == 0;
    }

    /* Function to check if the character is alive */
    private boolean isAlive(Character character){
        return character.getHealthPoints() > 0;
    }
}

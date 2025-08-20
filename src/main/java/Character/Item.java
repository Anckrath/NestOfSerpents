package Character;

public class Item {
    private String Name;
    private int AttackBonus;
    private int Damage;


    public Item(String name, int physiqueBonus, int damage) {
        Damage = damage;
        AttackBonus = physiqueBonus;
        Name = name;
    }

    /************************************* Getters and Setters *************************************/
    /* Getter and Setter for PhysiqueBonus */
    public int getAttackBonus() {
        return AttackBonus;
    }

    public void setAttackBonus(int physiqueBonus) {
        AttackBonus = physiqueBonus;
    }

    /* Getter and Setter for Damage */
    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }




}


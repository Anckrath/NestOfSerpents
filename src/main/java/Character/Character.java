package Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Character {
    private String          Name;
    private String          Race    = "Human";
    private String          Class   = "Warrior";
    private String          Gender;
    private int             Level   = 2;
    private int             Physique;
    private int             Mental;
    private int             Astral;
    private int             HealthPoints;
    private int             Damage;
    private int             Money;
    private ArrayList<Item> Items   = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Character(String name, String race, String aClass, String gender, int level, int physique, int mental, int astral, int healthPoints) {
        Name = name;
        Race = race;
        Class = aClass;
        Gender = gender;
        Level = level;
        Physique = physique;
        Mental = mental;
        Astral = astral;
        HealthPoints = healthPoints;
    }

    public Character() {

    }

    public void CreateMainCharacter() {
        System.out.flush();
        System.out.print("Name: ");
        Name = scanner.nextLine();
        System.out.flush();
        System.out.print("Gender: ");
        Gender = scanner.nextLine();

        AttributePointDistribution();
        HealthPoints = Physique + 1;

        Items.addAll(List.of(
                new Item("LongSword", 0, 2),
                new Item("Dagger",1, 1),
                new Item("Javelin",0, 0)
        ));
    }


    /* Auxiliary function to attribute point distribution. */
    private void AttributePointDistribution() {

        int attributePoints;
        System.out.flush();

        do {
            attributePoints = 25;
            System.out.println("Distribute 25 points between your physique, mental, and astral stats.(Max 12 points per attribute)");

            do {
                System.out.print("Physique[" + attributePoints + "]: ");
                Physique = scanner.nextInt();
            } while (!isPointRangeValid(Physique, "Physique"));
            attributePoints -= Physique;

            do {
                System.out.flush();
                System.out.println("Mental[" + attributePoints + "]: ");
                Mental = scanner.nextInt();
            } while (!isPointRangeValid(Mental, "Mental"));
            attributePoints -= Mental;

            do {
                System.out.flush();
                System.out.println("Astral[" + attributePoints + "]: ");
                Astral = scanner.nextInt();
            } while (!isPointRangeValid(Astral, "Astral"));
            attributePoints -= Astral;

        } while (!isPointDistributionValid(attributePoints));
    }

    /* Auxiliary function to check if 25 attribute points were allocated. */
    private boolean isPointDistributionValid(int pointLeft) {
        if (pointLeft == 0) {
           return true;
        } else {
            System.out.flush();
            System.out.println("The points where distributed incorrectly, you need to distribute 25 points. Please try again [" + pointLeft + "].");
            return false;
        }
    }

    /* Auxiliary function to determine if the correct amount of points were allocated to an attribute */
    private boolean isPointRangeValid(int points, String attribute) {
        if(points >= 0 && points <= 12){
            return true;
        }
        else {
            System.out.flush();
            System.out.println("The " + attribute + " points where distributed incorrectly. It needs to be 12 or less, please try again [" + points + "].");
            return false;
        }
    }


    /************************************* Getters and Setters *************************************/

    /* Getter and Setter for Astral */
    public int getAstral() {
        return Astral;
    }

    public void setAstral(int astral) {
        Astral = astral;
    }

    /* Getter and Setter for Mental */
    public int getMental() {
        return Mental;
    }

    public void setMental(int mental) {
        Mental = mental;
    }

    /* Getter and Setter for Physique */
    public int getPhysique() {
        return Physique;
    }

    public void setPhysique(int physique) {
        Physique = physique;
    }

    /* Getter and Setter for HealthPoints */
    public int getHealthPoints() {
        return HealthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        HealthPoints = healthPoints;
    }

    /* Getter and Setter for Damage */
    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    /* Getter and Setter for Items list */
    public ArrayList<Item> getItems() {
        return Items;
    }

    public Item getEquipment(int number) {
        return Items.get(number);
    }

    public void setItems(ArrayList<Item> items) {
        Items = items;
    }
}

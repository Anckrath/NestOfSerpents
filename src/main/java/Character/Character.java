package Character;

import java.util.Scanner;

public class Character {
    Scanner scanner = new Scanner(System.in);
    private String Name;
    private String Race = "Human";
    private String Class = "Warrior";
    private String Gender;
    private int Level = 2;
    private int Physique;
    private int Mental;
    private int Astral;
    private int HealthPoints;

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

    public void CreateCharacter() {
        System.out.flush();
        System.out.print("Name: ");
        Name = scanner.nextLine();
        System.out.flush();
        System.out.print("Gender: ");
        Gender = scanner.nextLine();

        AttributePointDistribution();

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


}

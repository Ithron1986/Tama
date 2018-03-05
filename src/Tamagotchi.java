public class Tamagotchi {

    private int fat = 0;
    private int nutrients = 0;
    private int energie = 0;
    private int healthynesse = 0;
    private int vegetarian = 0;
    private int mood = 0;
    private int hunger = 0;
    private int thirst = 0;
    private int ichPlatzegleich = 0;
    final int maxSatiation = 100;
    Sport sport;
    public int fatValue;
    public int minimumSatusValue = 0;
    public int maximumSatusValue = 1000;
    public int doomCounter;
    public boolean awake = true;
    public double sterbewahrscheinlichkeit;


    public void essen(Food food) {

        fat += food.getFatValue();
        if ((hunger += food.getHungerValue()) > maxSatiation) {
            hunger = maxSatiation;
            ichPlatzegleich++;
            if (ichPlatzegleich == 1) {
                ichBinVoll();
            } else if (ichPlatzegleich == 2) {
                ichWillNichtsmehr(ichPlatzegleich);
            } else if (ichPlatzegleich == 3) {
                ichWillNichtsmehr(ichPlatzegleich);
            } else if (ichPlatzegleich > 3) {
                setDoomCounter(getDoomcounter() + 1);
            }


        } else {
            hunger += food.getHungerValue();
            ichPlatzegleich = 0;
        }

        thirst += food.getThirstValue();
    }


    public void ichBinVoll() {
        mood = mood + 2;
    }

    public void ichWillNichtsmehr(int ubervoll) {
        mood = mood - (1 * ubervoll);
    }

    public void setIchPlatzegleich() {
        ichPlatzegleich++;
    }

    public void setHunger(int newHunger) {
        this.hunger = newHunger;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public int getMood() {
        return this.mood;
    }

    public int getHealthynesse() {
        return this.healthynesse;
    }

    public int getEnergie() {
        return this.energie;
    }


    public boolean einschlafen() {
        if (awake == true)
            awake = false;
        //Zugriff auf Methode die eine Bildschirmanimation bring zum ins Bett gehen.

        return awake;
    }

    public boolean aufwecken() {
        return awake = true;
    }

    public int getDoomcounter() {
        return this.doomCounter;
    }

    public void setDoomCounter(int newDoomcounter) {
        this.doomCounter = newDoomcounter;
    }



   /* public void statusHunger() {

        if (nutrition.getHunger() >=

    }*/

    // während das Tamagotchi schläft können keine Aktionen ausgeführt weden
    // außer aufwecken wobei man natürlich trotzdem in die Menüs kann


    public int limitOfStatusValues(int Values) {
        int i = Values;
        if (i <= minimumSatusValue) {
            doomCounter++;
            Values = minimumSatusValue;
        }

        if (i >= maximumSatusValue) {
            doomCounter++;
            Values = maximumSatusValue;
        } else Values = Values;
        return Values;
    }

   /* public void bedürfnisseErfüllt() {
        if ()
    }*/

    /*public void sterben() {
        if (doomCounter > 10) {
            int die = Math.random();
        }
    }*/

    public void workout(Sport sport) {

    }
}

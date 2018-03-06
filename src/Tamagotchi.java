public class Tamagotchi {
    UiUtils utils;
    private int fat = 0;
    private int nutrients = 0;
    private int energie = 0;
    private int healthynesse = 0;
    public int vegetarian = 0;
    public int vegicounter;
    private int mood = 0;
    private int hunger = 0;
    private int thirst = 0;
    private double endurance = 0;
    private double strength = 0;
    private int ichPlatzegleich = 0;
    private int ichPlatzegleichDrink = 0;

    final int maxSatiation = 100;
    final int maxThirst = 100;
    public int minimumSatusValue = 0;
    public int maximumSatusValue = 1000;
    public int doomCounter;
    public boolean awake = true;

    /*public Tamagotchi(int fat,int nutrients,int energie,
                      int healthynesse,int vegetarian, int vegicounter,
                      int mood,int hunger, int thirst, double endurance,
                      double strength,int ichPlatzegleich, int ichPlatzegleichDrink){

        this.fat = fat;
        this.nutrients = nutrients;
        this.energie = energie;
        this.healthynesse = healthynesse;
        this.vegetarian = vegetarian;
        this.vegicounter = vegicounter;
        this.mood = mood;
        this.hunger = hunger;
        this.thirst = thirst;
        this.endurance = endurance;
        this.strength = strength;
        this.ichPlatzegleich = ichPlatzegleich;
        this.ichPlatzegleichDrink = ichPlatzegleichDrink;

    }*/


    public void essen(Food food) {

        fat += food.getFatValue();
        nutrients += food.getNutrientsValue();
        if (food.isVegetarian() == true) {
            this.vegetarian++;
            this.vegicounter++;
        } else {
            this.vegicounter++;
        }
        energie += food.getEnergyValue();
        healthynesse += food.getHealthynessValue();
        mood += food.getMoodLevel();

        //Hungerberechnung
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
        //Durstberechnung
        if ((thirst += food.getThirstValue()) > maxThirst) {
            thirst = maxThirst;
            ichPlatzegleichDrink++;
            if (ichPlatzegleichDrink == 1) {
                ichBinVoll();
            } else if (ichPlatzegleichDrink == 2) {
                ichWillNichtsmehr(ichPlatzegleichDrink);
            } else if (ichPlatzegleichDrink == 3) {
                ichWillNichtsmehr(ichPlatzegleichDrink);
            } else if (ichPlatzegleichDrink > 3) {
                setDoomCounter(getDoomcounter() + 1);
            }
        } else {
            thirst += food.getThirstValue();
            ichPlatzegleichDrink = 0;
        }
    }

    public void workout(Sport sport) {
        if (fat < 5) {
            fat += sport.getFatValueSport();
            healthynesse += sport.getHealthynessValueSport();
            mood += 1 / 2 * (sport.getMoodLevelSport());
            strength += 1 / 2 * (sport.getStrenghtValueSport());
            endurance += 1 / 2 * (sport.getEnduranceLevelSport());
            hunger += 2 * (sport.getHungerValueSport());
            thirst += sport.getThirstValueSport();
            energie += 2 * (sport.getEnergyValueSport());
        } else {
            fat += sport.getFatValueSport();
            healthynesse += sport.getHealthynessValueSport();
            mood += sport.getMoodLevelSport();
            strength += sport.getStrenghtValueSport();
            endurance += sport.getEnduranceLevelSport();
            hunger += sport.getHungerValueSport();
            thirst += sport.getThirstValueSport();
            energie += sport.getEnergyValueSport();
        }
    }

    public void spielen(Game game) {
        fat += game.getFatValueGame();
        healthynesse += game.getHealthynessValueGame();
        mood += game.getMoodLevelGame();
        strength += game.getStrenghtValueGame();
        endurance += game.getEnduranceLevelGame();
        hunger += game.getHungerValueGame();
        thirst += game.getThirstValueGame();
        energie += game.getEnergyValueGame();
    }

    public void hatNochEnergieFuer(Game game) {
        if (energie > 5 && thirst > 3 && hunger > 3) {
            spielen(game);
        } else {
            if (energie < 5) {
                utils.createPopup("Ich bin zu Müde zum spielen!!!\n\r lass mich Schlafen");
            }
            if (thirst < 3) {
                utils.createPopup("Ich will nicht spielen!!!\n\r Ich bin soooooooo durstig");
            }
            if (hunger < 3) {
                utils.createPopup("Ich kann nicht spielen !!!\n\r Ich bin soooooooo hungrig");
            }
        }
    }

    public void hatNochEnergieFuer(Sport sport) {
        if (energie < 5 && thirst < 3 && hunger < 3) {
            workout(sport);
        } else {
            if (energie < 5) {
                utils.createPopup("Ich bin zu Müde für Sport!!!\n\rlass mich Schlafen");
            }
            if (thirst < 3) {
                utils.createPopup("Ich kann keinen Sport treiben!!!\n\rIch bin soooooooo durstig");
            }
            if (hunger < 3) {
                utils.createPopup("Ich kann keinen Sport treiben!!!\n\rIch bin soooooooo hungrig");
            }
        }

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

    public double getEndurance() {
        return this.endurance;
    }

    public double getStrength() {
        return this.strength;
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

    public void sterben() {
        if (doomCounter > 10) {
            double die = 0;
            die = Math.random();
            if (die > 0) {
                die += die;
            }
            if (die > 1) {
                delete();
            }
        }
    }

    public void delete() {
    }
}

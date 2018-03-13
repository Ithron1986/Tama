public class Tamagotchi {
    UiUtils utils;
    private int fat = 0;
    private int nutrients = 0;
    private double energie = 0;
    private int healthynesse = 0;
    public int vegetarian = 0;
    public int vegicounter;
    private int mood = 0;
    private double hunger = 0;
    private double thirst = 0;
    private double endurance = 0;
    private double strength = 0;
    private double hygiene = 0;
    private double harndrang = 0;
    private double toilet = 0;
    private double fatigue = 0;


    private int ichPlatzegleich = 0;
    private int ichPlatzegleichDrink = 0;
    private int pflegecounter = 0;
    private double sleepCounter = 0;

    final int maxSatiation = 100;
    final int maxThirst = 100;
    private int minimumSatusValue = 0;
    private int maximumSatusValue = 1000;
    private int doomCounter;
    private boolean awake = true;

    private boolean alive = true;
    Speicher speicher;

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


    public boolean essen(Food food) {
        if (!awake) {
            return false;
        }
        fat += food.getFatValue();
        limit(fat, 1000, 0);
        nutrients += food.getNutrientsValue();
        if (food.isVegetarian() == true) {
            this.vegetarian++;
            this.vegicounter++;
        } else {
            this.vegicounter++;
        }
        energie += food.getEnergyValue();
        limit(energie, 100, 0);
        healthynesse += food.getHealthynessValue();
        limit(healthynesse, 100, 0);
        mood += food.getMoodLevel();
        limit(mood, 100, 0);

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
        return true;
    }

    public boolean workout(Sport sport) {
        if (!awake) {
            return false;
        }
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
        return true;
    }

    public boolean spielen(Game game) {
        if (!awake) {
            return false;
        }
        fat += game.getFatValueGame();
        healthynesse += game.getHealthynessValueGame();
        mood += game.getMoodLevelGame();
        strength += game.getStrenghtValueGame();
        endurance += game.getEnduranceLevelGame();
        hunger += game.getHungerValueGame();
        thirst += game.getThirstValueGame();
        energie += game.getEnergyValueGame();
        return true;
    }

    public boolean pflegen(Pflege pflege) {
        if (!awake) {
            return false;
        }
        if (speicher.getPflege("Duschen").equals(pflege)) {
            if (pflegecounter > 3) {
                return false;
            } else {
                nutrients += pflege.getNutrientsValue();
                healthynesse += pflege.getHealthynessValue();
                hygiene += pflege.getHygieneValue();
                mood += pflege.getMoodLevel();
                hunger += pflege.getHungerValue();
                thirst += pflege.getThirstValue();
                energie += pflege.getEnergyValue();
                pflegecounter++;
                return true;

            }
        }

        nutrients += pflege.getNutrientsValue();
        healthynesse += pflege.getHealthynessValue();
        hygiene += pflege.getHygieneValue();
        mood += pflege.getMoodLevel();
        hunger += pflege.getHungerValue();
        thirst += pflege.getThirstValue();
        energie += pflege.getEnergyValue();
        return true;
    }

    public int duschCounter(int pflegecounter) {

        return pflegecounter++;

    }

    public int getPflegecounter() {
        return this.pflegecounter;
    }

    public void setPflegecounter(int newPflegecounter) {
        this.pflegecounter = newPflegecounter;
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

    public double getHunger() {
        return this.hunger;
    }

    public double getThirst() {
        return this.thirst;
    }

    public int getMood() {
        return this.mood;
    }

    public int getHealthynesse() {
        return this.healthynesse;
    }

    public double getEnergie() {
        return this.energie;
    }

    public double getEndurance() {
        return this.endurance;
    }

    public double getStrength() {
        return this.strength;
    }

    public double getHygiene() {
        return hygiene;
    }

    public double getHarndrang() {
        return harndrang;
    }

    public double getToilet() {
        return toilet;
    }


    public boolean einschlafen() {
        if (awake == true)
            awake = false;
        //Zugriff auf Methode die eine Bildschirmanimation bring zum ins Bett gehen.

        return awake;
    }

    public void isAwake() {
        if (awake == true) {
            Thread t = new Thread(() -> {
                while (awake == true) {
                    try {
                        Thread.sleep(600000);
                        this.fatigue = fatigue - 0.8;
                        this.energie = energie - 0.92;
                        this.hunger = hunger - 3;
                        this.thirst = thirst - 4;
                        this.hygiene = hygiene - 1;
                        this.toilet = toilet + 1;
                        this.harndrang = harndrang + 2;
                        this.sleepCounter = sleepCounter - 2.5;
                        //pflegecounter wird hier reduziert um eine Nutzung von Duschen etc wieder zu ermöglichen
                        if (pflegecounter >= 1) {
                            pflegecounter--;
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }

    }


    public void schlafen() {
        awake = false;
        if (awake == false) {
            Thread t = new Thread(() -> {
                while (awake == false) {
                    try {
                        if (sleepCounter < 6) {
                            Thread.sleep(600000);
                            this.sleepCounter = sleepCounter++;
                            this.fatigue = fatigue + 1;
                            this.energie = energie + 4;
                            this.hunger = hunger - 0.8;
                            this.thirst = thirst - 0.9;
                            this.hygiene = hygiene - 0.5;
                            this.toilet = toilet + 0.8;
                            this.harndrang = harndrang + 0.8;

                            if (pflegecounter >= 1) {
                                pflegecounter--;
                            }
                        } else {
                            Thread.sleep(600000);
                            this.sleepCounter = sleepCounter++;
                            this.fatigue = fatigue + 2.2;
                            this.energie = energie + 2.8;
                            this.hunger = hunger - 0.8;
                            this.thirst = thirst - 0.9;
                            this.hygiene = hygiene - 0.5;
                            this.toilet = toilet + 0.8;
                            this.harndrang = harndrang + 0.8;

                            if (pflegecounter >= 1) {
                                pflegecounter--;
                            }

                            if (sleepCounter >= 60) {
                                awake = true;
                            } else {
                                awake = false;
                            }
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }

    }

    public void nickerchen() {
        awake = false;
        awake = false;
        if (awake == false) {
            Thread t = new Thread(() -> {
                while (awake == false) {
                    try {

                        Thread.sleep(600000);
                        this.sleepCounter = sleepCounter++;
                        this.fatigue = fatigue + 1;
                        this.energie = energie + 4;
                        this.hunger = hunger - 1;
                        this.thirst = thirst - 4;
                        this.hygiene = hygiene - 1;
                        this.toilet = toilet + 1;
                        this.harndrang = harndrang + 2;

                        if (pflegecounter >= 1) {
                            pflegecounter--;
                        }

                        if (sleepCounter >= 6) {
                            awake = true;
                        } else {
                            awake = false;
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }

    }

    public boolean aufwecken() {
        if (fatigue > 60 && sleepCounter < 36) {
            this.mood = mood - 10;
        }
        return awake = true;
    }

    public int getDoomcounter() {
        return this.doomCounter;
    }

    public boolean getAwake() {
        return this.awake;
    }

    public void setDoomCounter(int newDoomcounter) {
        this.doomCounter = newDoomcounter;
    }

    public void setEnergie(double newEnergie) {
        this.energie = newEnergie;
    }


    public int limitOfStatusValues(int values) {
        int i = values;
        if (i <= minimumSatusValue) {
            doomCounter++;
            values = minimumSatusValue;
        }

        if (i >= maximumSatusValue) {
            doomCounter++;
            values = maximumSatusValue;
        } else values = values;
        return values;
    }

    public int limit(int testant, int max, int min) {
        if (testant < min) {
            return min;
        }
        if (testant > max) {
            return max;
        }

        return testant;
    }

    public double limit(double testant, double max, double min) {
        if (testant < min) {
            return min;
        }
        if (testant > max) {
            return max;
        }

        return testant;
    }

    public void sterben() {
        if (doomCounter > 10) {
            double die = Math.random();
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

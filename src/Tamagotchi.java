import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Tamagotchi {
    private DoubleProperty fat = new SimpleDoubleProperty(0);

    public DoubleProperty fatProperty() {
        return this.fat;
    }

    public void setFat(double fat) {
        this.fat.setValue(fat);
    }

    public double getFat() {
        return this.fat.get();
    }

    private DoubleProperty nutrients = new SimpleDoubleProperty(0);

    public DoubleProperty nutrientsPorperty() {
        return this.nutrients;
    }

    public void setNutrients(double nutrients) {
        this.nutrients.setValue(nutrients);
    }

    public double getNutrients() {
        return this.nutrients.get();
    }

    private DoubleProperty energie = new SimpleDoubleProperty(0);

    public DoubleProperty energiePorperty() {
        return this.energie;
    }

    public void setEnergie(double energie) {
        this.energie.setValue(energie);
    }

    public double getEnergie() {
        return this.energie.get();
    }

    private DoubleProperty healthynesse = new SimpleDoubleProperty(0);

    public DoubleProperty healthynessProperty() {
        return this.healthynesse;
    }

    public void setHealthynesse(double healthynesse) {
        this.healthynesse.setValue(healthynesse);
    }

    public double getHealthynesse() {
        return this.healthynesse.get();
    }

    private DoubleProperty mood = new SimpleDoubleProperty(0);

    public DoubleProperty moodPorperty() {
        return this.mood;
    }

    public void setMood(double mood) {
        this.mood.setValue(mood);
    }

    public double getMood() {
        return this.mood.get();
    }

    private DoubleProperty hunger = new SimpleDoubleProperty(0);

    public DoubleProperty hungerPorperty() {
        return this.hunger;
    }

    public void setHunger(double hunger) {
        this.hunger.setValue(hunger);
    }

    public double getHunger() {
        return this.hunger.get();
    }

    private DoubleProperty thirst = new SimpleDoubleProperty(0);


    public DoubleProperty thirstPorperty() {
        return this.thirst;
    }

    public void setThirst(double thirst) {
        this.thirst.setValue(thirst);
    }

    public double getThirst() {
        return this.thirst.get();
    }

    private DoubleProperty endurance = new SimpleDoubleProperty(0);

    public DoubleProperty enduranceProperty() {
        return this.endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance.setValue(endurance);
    }

    public double getEndurance() {
        return this.endurance.get();
    }

    private DoubleProperty strength = new SimpleDoubleProperty(0);

    public DoubleProperty strengthProperty() {
        return this.strength;
    }

    public void setStrength(double strength) {
        this.strength.setValue(strength);
    }

    public double getStrength() {
        return this.strength.get();
    }

    private DoubleProperty hygiene = new SimpleDoubleProperty(0);

    public DoubleProperty hygieneProperty() {
        return this.hygiene;
    }

    public void setHygiene(double hygiene) {
        this.hygiene.setValue(hygiene);
    }

    public double getHygiene() {
        return this.hygiene.get();
    }

    private DoubleProperty harndrang = new SimpleDoubleProperty(0);

    public DoubleProperty harndrangProperty() {
        return this.harndrang;
    }

    public void setHarndrang(double harndrang) {
        this.harndrang.setValue(harndrang);
    }

    public double getHarndrang() {
        return this.harndrang.get();
    }

    private DoubleProperty toilet = new SimpleDoubleProperty(0);

    public DoubleProperty toiletProperty() {
        return this.toilet;
    }

    public void setToilet(double toilet) {
        this.toilet.setValue(toilet);
    }

    public double getToilet() {
        return this.toilet.get();
    }

    private DoubleProperty fatigue = new SimpleDoubleProperty(0);

    public DoubleProperty fatigueProperty() {
        return this.fatigue;
    }

    public void setFatigue(double fatigue) {
        this.fatigue.setValue(fatigue);
    }

    public double getFatigue() {
        return this.fatigue.get();
    }

    private BooleanProperty awake = new SimpleBooleanProperty(true);

    public BooleanProperty awakeProperty() {
        return this.awake;
    }

    public void setAwake(boolean awake) {
        this.awake.setValue(awake);
    }

    public boolean getAwake() {
        return this.awake.get();
    }

    private int ichPlatzegleich = 0;
    private int ichPlatzegleichDrink = 0;
    private int pflegecounter = 0;
    private double sleepCounter = 0;
    public int vegicounter;
    public int vegetarian = 0;

    final int maxSatiation = 100;
    final int maxThirst = 100;
    private int minimumSatusValue = 0;
    private int maximumSatusValue = 1000;
    private int doomCounter;


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

    public Tamagotchi() {

        this.fat.addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() > 100) {
                fat.set(100);
            }
        });
    }


    public boolean essen(Food food) {
        if (!awake.get()) {
            return false;
        }

        fat.add(food.getFatValue());
        limit(fat.get(), 1000, 0);
        nutrients.add(food.getNutrientsValue());
        if (food.isVegetarian() == true) {
            this.vegetarian++;
            this.vegicounter++;
        } else {
            this.vegicounter++;
        }
        energie.add(food.getEnergyValue());
        limit(energie.get(), 100, 0);
        healthynesse.add(food.getHealthynessValue());
        limit(healthynesse.get(), 100, 0);
        mood.add(food.getMoodLevel());
        limit(mood.get(), 100, 0);

        //Hungerberechnung
        double possibleResult = hunger.get() + food.getHungerValue();
        if (possibleResult > maxSatiation) {
            hunger.set(maxSatiation);
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
            hunger.add(food.getHungerValue());
            ichPlatzegleich = 0;
        }
        //Durstberechnung
        possibleResult = thirst.get() + food.getThirstValue();
        if (possibleResult > maxThirst) {
            thirst.set(maxThirst);
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
            thirst.add(food.getThirstValue());
            ichPlatzegleichDrink = 0;
        }
        return true;
    }

    public boolean workout(Sport sport) {
        if (!awake.get()) {
            return false;
        }
        fat.add(sport.getFatValueSport());

        if (fat.get() < 5) {
            healthynesse.add(sport.getHealthynessValueSport());
            mood.add(1 / 2 * (sport.getMoodLevelSport()));
            strength.add(1 / 2 * (sport.getStrenghtValueSport()));
            endurance.add(1 / 2 * (sport.getEnduranceLevelSport()));
            hunger.add(2 * (sport.getHungerValueSport()));
            thirst.add(sport.getThirstValueSport());
            energie.add(2 * (sport.getEnergyValueSport()));
        } else {
            healthynesse.add(sport.getHealthynessValueSport());
            mood.add(sport.getMoodLevelSport());
            strength.add(sport.getStrenghtValueSport());
            endurance.add(sport.getEnduranceLevelSport());
            hunger.add(sport.getHungerValueSport());
            thirst.add(sport.getThirstValueSport());
            energie.add(sport.getEnergyValueSport());
        }
        return true;
    }

    public boolean spielen(Game game) {
        if (!awake.get()) {
            return false;
        }
        fat.add(game.getFatValueGame());
        healthynesse.add(game.getHealthynessValueGame());
        mood.add(game.getMoodLevelGame());
        strength.add(game.getStrenghtValueGame());
        endurance.add(game.getEnduranceLevelGame());
        hunger.add(game.getHungerValueGame());
        thirst.add(game.getThirstValueGame());
        energie.add(game.getEnergyValueGame());
        return true;
    }

    public boolean pflegen(Pflege pflege) {
        if (!awake.get()) {
            return false;
        }
        if (speicher.getPflege("Duschen").equals(pflege)) {
            if (pflegecounter > 3) {
                return false;
            } else {
                nutrients.add(pflege.getNutrientsValue());
                healthynesse.add(pflege.getHealthynessValue());
                hygiene.add(pflege.getHygieneValue());
                mood.add(pflege.getMoodLevel());
                hunger.add(pflege.getHungerValue());
                thirst.add(pflege.getThirstValue());
                energie.add(pflege.getEnergyValue());
                pflegecounter++;
                return true;

            }
        }

        nutrients.add(pflege.getNutrientsValue());
        healthynesse.add(pflege.getHealthynessValue());
        hygiene.add(pflege.getHygieneValue());
        mood.add(pflege.getMoodLevel());
        hunger.add(pflege.getHungerValue());
        thirst.add(pflege.getThirstValue());
        energie.add(pflege.getEnergyValue());
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
        if (energie.get() > 5 && thirst.get() > 3 && hunger.get() > 3) {
            spielen(game);
        } else {
            if (energie.get() < 5) {
                /*utils.createPopup("Ich bin zu Müde zum spielen!!!\n\r lass mich Schlafen");*/
            }
            if (thirst.get() < 3) {
                /* utils.createPopup("Ich will nicht spielen!!!\n\r Ich bin soooooooo durstig");*/
            }
            if (hunger.get() < 3) {
                /*utils.createPopup("Ich kann nicht spielen !!!\n\r Ich bin soooooooo hungrig");*/
            }
        }
    }

    public void hatNochEnergieFuer(Sport sport) {
        if (energie.get() < 5 && thirst.get() < 3 && hunger.get() < 3) {
            workout(sport);
        } else {
            if (energie.get() < 5) {
                /*utils.createPopup("Ich bin zu Müde für Sport!!!\n\rlass mich Schlafen");*/
            }
            if (thirst.get() < 3) {
                /*utils.createPopup("Ich kann keinen Sport treiben!!!\n\rIch bin soooooooo durstig");*/
            }
            if (hunger.get() < 3) {
                /*utils.createPopup("Ich kann keinen Sport treiben!!!\n\rIch bin soooooooo hungrig");*/
            }
        }

    }


    public void ichBinVoll() {
        mood.add(2);
    }

    public void ichWillNichtsmehr(int ubervoll) {
        mood.set(mood.get() - ubervoll);
    }

    public void setIchPlatzegleich() {
        ichPlatzegleich++;
    }


    // boolean eingeschlafen = tama.einschlafen()
    // if eingegeschlafen {...}
    public boolean einschlafen() {

        if (awake.get())
            awake.set(false);
        //Zugriff auf Methode die eine Bildschirmanimation bring zum ins Bett gehen.

        return awake.get();
    }

    /*public void isAwake() {
        if (awake.get()) {
            Thread t = new Thread(() -> {
                while (awake.get()) {
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

    }*/

/*

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
*/

    public int getDoomcounter() {
        return this.doomCounter;
    }

    public void setDoomCounter(int newDoomcounter) {
        this.doomCounter = newDoomcounter;
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

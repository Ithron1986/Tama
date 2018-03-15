import javafx.beans.property.*;

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


    private void multiplyValue(double value, DoubleProperty property) {
        property.set(
                limit(
                        property.get() * value,
                        100,
                        0
                )
        );
    }

    private void addToValue(double value, DoubleProperty property) {
        double newValue = limit(property.get() + value, 100, 0);
        property.set(newValue);
    }


    public boolean essen(Food food) {
        if (!awake.get()) {
            return false;
        }

        this.addToValue(food.getFatValue(), fat);
        this.addToValue(food.getNutrientsValue(), nutrients);
        if (food.isVegetarian() == true) {
            this.vegetarian++;
            this.vegicounter++;
        } else {
            this.vegicounter++;
        }

        this.addToValue(food.getEnergyValue(), energie);
        this.addToValue(food.getHealthynessValue(), healthynesse);
        this.addToValue(food.getMoodLevel(), mood);

        //Hungerberechnung
        this.addToValue(food.getHungerValue(), hunger);
        if (hunger.get() == maxSatiation) {
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
            ichPlatzegleich = 0;
        }
        //Durstberechnung
        this.addToValue(food.getThirstValue(), thirst);
        if (thirst.get() == maxThirst) {
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
            this.addToValue(sport.getHealthynessValueSport(), healthynesse);
            this.addToValue(0.5 * sport.getMoodLevelSport(), mood);
            this.addToValue(0.5 * sport.getStrenghtValueSport(), strength);
            this.addToValue(0.5 * sport.getEnduranceLevelSport(), endurance);
            this.addToValue(2 * sport.getHungerValueSport(), hunger);
            this.addToValue(sport.getThirstValueSport(), thirst);
            this.addToValue(2 * sport.getEnergyValueSport(), energie);

        } else {
            this.addToValue(sport.getHealthynessValueSport(), healthynesse);
            this.addToValue(sport.getMoodLevelSport(), mood);
            this.addToValue(sport.getStrenghtValueSport(), strength);
            this.addToValue(sport.getEnduranceLevelSport(), endurance);
            this.addToValue(sport.getHungerValueSport(), hunger);
            this.addToValue(sport.getThirstValueSport(), thirst);
            this.addToValue(sport.getEnergyValueSport(), energie);
        }
        return true;
    }

    public boolean spielen(Game game) {
        if (!awake.get()) {
            return false;
        }
        fat.add(game.getFatValueGame());
        this.addToValue(game.getHealthynessValueGame(), healthynesse);
        this.addToValue(game.getMoodLevelGame(), mood);
        this.addToValue(game.getStrenghtValueGame(), strength);
        this.addToValue(game.getEnduranceLevelGame(), endurance);
        this.addToValue(game.getHungerValueGame(), hunger);
        this.addToValue(game.getThirstValueGame(), thirst);
        this.addToValue(game.getEnergyValueGame(), energie);
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
                this.addToValue(pflege.getNutrientsValue(), nutrients);
                this.addToValue(pflege.getHealthynessValue(), healthynesse);
                this.addToValue(pflege.getHygieneValue(), hygiene);
                this.addToValue(pflege.getMoodLevel(), mood);
                this.addToValue(pflege.getHungerValue(), hunger);
                this.addToValue(pflege.getThirstValue(), thirst);
                this.addToValue(pflege.getEnergyValue(), energie);
                pflegecounter++;
                return true;

            }
        }

        this.addToValue(pflege.getNutrientsValue(), nutrients);
        this.addToValue(pflege.getHealthynessValue(), healthynesse);
        this.addToValue(pflege.getHygieneValue(), hygiene);
        this.addToValue(pflege.getMoodLevel(), mood);
        this.addToValue(pflege.getHungerValue(), hunger);
        this.addToValue(pflege.getThirstValue(), thirst);
        this.addToValue(pflege.getEnergyValue(), energie);
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


    public void changeStatus() {
        if (awake.get()) {
            this.changeStatusvalueAwake();
        } else {
            this.changeStatusValueAsleep();
        }
    }

    private void changeStatusValueAsleep() {

        if (sleepCounter < 6) {
            this.sleepCounter = sleepCounter++;
            this.addToValue(1, fatigue);
            this.addToValue(4, energie);
            this.addToValue(-0.8, hunger);
            this.addToValue(-0.9, thirst);
            this.addToValue(-0.5, hygiene);
            this.addToValue(0.8, toilet);
            this.addToValue(0.8, harndrang);


            if (pflegecounter >= 1) {
                pflegecounter--;
            }
        } else {
            this.sleepCounter = sleepCounter++;
            this.addToValue(+2.2, fatigue);
            this.addToValue(+2.8, energie);
            this.addToValue(-0.8, hunger);
            this.addToValue(-0.9, thirst);
            this.addToValue(-0.5, hygiene);
            this.addToValue(0.8, toilet);
            this.addToValue(0.8, harndrang);

            if (pflegecounter >= 1) {
                pflegecounter--;
            }

            if (sleepCounter >= 60) {
                awake.set(true);
            }
        }
    }

    private void changeStatusvalueAwake() {
        System.out.println("change status awake");
        this.addToValue(-0.8, fatigue);
        this.addToValue(-0.92, energie);
        this.addToValue(-3, hunger);
        this.addToValue(-4, thirst);
        this.addToValue(-1, hygiene);
        this.addToValue(+1, toilet);
        this.addToValue(+2, harndrang);

        this.sleepCounter = sleepCounter - 2.5;
        //pflegecounter wird hier reduziert um eine Nutzung von Duschen etc wieder zu ermöglichen
        if (pflegecounter >= 1) {
            pflegecounter--;
        }
        System.out.println("done change status awake");

    }

    ///Methode könnte fehler haben
    public boolean aufwecken() {
        if (fatigue.get() > 60 && sleepCounter < 36) {
            this.mood.set(mood.get() - 10);
        }
        awake.set(true);
        return awake.get();
    }


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

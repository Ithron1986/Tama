public class Pflege {

    private String description;
    private int nutrientsValue;
    private int hygieneValue;
    private int healthynessValue;
    private int moodLevel;
    private int hungerValue;
    private int thirstValue;
    private int energyValue;
    private int harndrangValue;
    private int toiletValue;

    public Pflege(String description, int nutrientsValue,
                  int hygieneValue,
                  int healthynessValue, int moodLevel,
                  int hungerValue, int thirstValue,
                  int energyValue, int harndrangValue,
                  int toiletValue) {
        this.description = description;
        this.nutrientsValue = nutrientsValue;
        this.hygieneValue = hygieneValue;
        this.healthynessValue = healthynessValue;
        this.moodLevel = moodLevel;
        this.hungerValue = hungerValue;
        this.thirstValue = thirstValue;
        this.energyValue = energyValue;
        this.harndrangValue = harndrangValue;
        this.toiletValue = toiletValue;
    }

    public String getDescription() {
        return description;
    }


    public int getNutrientsValue() {
        return nutrientsValue;
    }

    public int getHygieneValue() {
        return hygieneValue;
    }

    public int getHealthynessValue() {
        return healthynessValue;
    }


    public int getMoodLevel() {
        return moodLevel;
    }

    public int getHungerValue() {
        return hungerValue;
    }

    public int getThirstValue() {
        return thirstValue;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public int getHarndrangValue() {
        return harndrangValue;
    }

    public int getToiletValue() {
        return toiletValue;
    }


    public String pflegeToString() {
        return getDescription()
                + "," + getNutrientsValue()
                + "," + getHealthynessValue()
                + "," + getMoodLevel()
                + "," + getHungerValue()
                + "," + getThirstValue()
                + "," + getEnergyValue()
                + "," + getHarndrangValue()
                + "," + getToiletValue()
                + "\n";
    }
}

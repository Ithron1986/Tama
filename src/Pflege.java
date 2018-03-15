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


    public double getNutrientsValue() {
        return nutrientsValue;
    }

    public double getHygieneValue() {
        return hygieneValue;
    }

    public double getHealthynessValue() {
        return healthynessValue;
    }


    public double getMoodLevel() {
        return moodLevel;
    }

    public double getHungerValue() {
        return hungerValue;
    }

    public double getThirstValue() {
        return thirstValue;
    }

    public double getEnergyValue() {
        return energyValue;
    }

    public double getHarndrangValue() {
        return harndrangValue;
    }

    public double getToiletValue() {
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

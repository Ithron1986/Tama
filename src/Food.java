import java.util.List;

public class Food {


    private String description;


    private double fatValue;
    private double nutrientsValue;
    private double healthynessValue;
    private boolean vegetarian;
    private double moodLevel;
    private double hungerValue;
    private double thirstValue;
    private double energyValue;
    private double hygieneValue;
    private double harndrangValue;
    private double toiletValue;

    public Food(String description, double fatValue,
                double nutrientsValue, double healthynessValue,
                boolean vegetarian, double moodLevel,
                double hungerValue, double thirstValue,
                double energyValue, double hygieneValue,
                double harndrangValue, double toiletValue
    ) {
        this.description = description;
        this.fatValue = fatValue;
        this.nutrientsValue = nutrientsValue;
        this.healthynessValue = healthynessValue;
        this.vegetarian = vegetarian;
        this.moodLevel = moodLevel;
        this.hungerValue = hungerValue;
        this.thirstValue = thirstValue;
        this.energyValue = energyValue;
        this.harndrangValue = harndrangValue;
        this.hygieneValue = hygieneValue;
        this.toiletValue = toiletValue;

    }

    public String getDescription() {
        return description;
    }

    public double getFatValue() {
        return fatValue;
    }

    public double getNutrientsValue() {
        return nutrientsValue;
    }

    public double getHealthynessValue() {
        return healthynessValue;
    }

    public boolean isVegetarian() {
        return vegetarian;
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

    public double getHygieneValue() {
        return hygieneValue;
    }


    public String foodToString() {
        return getDescription()
                + "," + getFatValue()
                + "," + getNutrientsValue()
                + "," + getHealthynessValue()
                + "," + isVegetarian()
                + "," + getMoodLevel()
                + "," + getHungerValue()
                + "," + getThirstValue()
                + "," + getEnergyValue()
                + "," + getHarndrangValue()
                + "," + getToiletValue()
                + "," + getHygieneValue()
                + "\n";
    }


}

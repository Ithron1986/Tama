import java.util.List;

public class Food {


    private String description;


    private int fatValue;
    private int nutrientsValue;
    private int healthynessValue;
    private boolean vegetarian;
    private int moodLevel;
    private int hungerValue;
    private int thirstValue;
    private int energyValue;
    private int hygieneValue;
    private int harndrangValue;
    private int toiletValue;

    public Food(String description, int fatValue,
                int nutrientsValue, int healthynessValue,
                boolean vegetarian, int moodLevel,
                int hungerValue, int thirstValue,
                int energyValue, int hygieneValue,
                int harndrangValue, int toiletValue
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

    public int getFatValue() {
        return fatValue;
    }

    public int getNutrientsValue() {
        return nutrientsValue;
    }

    public int getHealthynessValue() {
        return healthynessValue;
    }

    public boolean isVegetarian() {
        return vegetarian;
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

    public int getHygieneValue() {
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

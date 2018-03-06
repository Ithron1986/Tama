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

    public Food(String description, int fatValue,
                int nutrientsValue, int healthynessValue,
                boolean vegetarian, int moodLevel,
                int hungerValue, int thirstValue,
                int energyValue) {
        this.description = description;
        this.fatValue = fatValue;
        this.nutrientsValue = nutrientsValue;
        this.healthynessValue = healthynessValue;
        this.vegetarian = vegetarian;
        this.moodLevel = moodLevel;
        this.hungerValue = hungerValue;
        this.thirstValue = thirstValue;
        this.energyValue = energyValue;

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
                + "\n";
    }


}

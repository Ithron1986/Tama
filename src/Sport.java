public class Sport {
    private String descriptionSport;
    private int fatValueSport;
    private int healthynessValueSport;
    private int moodLevelSport;
    private double strenghtValueSport;
    private double enduranceLevelSport;
    private int hungerValueSport;
    private int thirstValueSport;


    public Sport(String descriptionSport, int fatValueSport,
                 int healthynessValueSport, int moodLevelSport,
                 double strenghtValueSport, double enduranceLevelSport,
                 int hungerValueSport, int thirstValueSport) {

        this.descriptionSport = descriptionSport;
        this.fatValueSport = fatValueSport;
        this.healthynessValueSport = healthynessValueSport;
        this.moodLevelSport = moodLevelSport;
        this.strenghtValueSport = strenghtValueSport;
        this.enduranceLevelSport = enduranceLevelSport;
        this.hungerValueSport = hungerValueSport;
        this.thirstValueSport = thirstValueSport;

    }

    public String getDescriptionSport(){
        return descriptionSport;
    }
    public int getFatValueSport(){
        return fatValueSport;
    }
    public int getHealthynessValueSport(){
        return healthynessValueSport;
    }
    public int getMoodLevelSport(){
        return moodLevelSport;
    }
    public double getStrenghtValueSport(){
        return strenghtValueSport;
    }
    public double getEnduranceLevelSport(){
        return enduranceLevelSport;
    }
    public int getHungerValueSport(){
        return hungerValueSport;
    }
    public int getThirstValueSport(){
        return thirstValueSport;
    }
    public String sportToString() {
        return getDescriptionSport()
                + "," + getFatValueSport()
                + "," + getHealthynessValueSport()
                + "," + getMoodLevelSport()
                + "," + getStrenghtValueSport()
                + "," + getEnduranceLevelSport()
                + "," + getHungerValueSport()
                + "," + getThirstValueSport()
                + "\n";
    }


}
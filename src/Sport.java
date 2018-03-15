public class Sport {
    private String descriptionSport;
    private double fatValueSport;
    private double healthynessValueSport;
    private double moodLevelSport;
    private double strenghtValueSport;
    private double enduranceLevelSport;
    private double hungerValueSport;
    private double thirstValueSport;
    private double energyValueSport;
    private double hygieneValueSport;


    public Sport(String descriptionSport, double fatValueSport,
                 double healthynessValueSport, double moodLevelSport,
                 double strenghtValueSport, double enduranceLevelSport,
                 double hungerValueSport, double thirstValueSport,
                 double energyValueSport, double hygieneValueSport
    ) {

        this.descriptionSport = descriptionSport;
        this.fatValueSport = fatValueSport;
        this.healthynessValueSport = healthynessValueSport;
        this.moodLevelSport = moodLevelSport;
        this.strenghtValueSport = strenghtValueSport;
        this.enduranceLevelSport = enduranceLevelSport;
        this.hungerValueSport = hungerValueSport;
        this.thirstValueSport = thirstValueSport;
        this.energyValueSport = energyValueSport;
        this.hygieneValueSport = hygieneValueSport;

    }

    public String getDescriptionSport() {
        return descriptionSport;
    }

    public double getFatValueSport() {
        return fatValueSport;
    }

    public double getHealthynessValueSport() {
        return healthynessValueSport;
    }

    public double getMoodLevelSport() {
        return moodLevelSport;
    }

    public double getStrenghtValueSport() {
        return strenghtValueSport;
    }

    public double getEnduranceLevelSport() {
        return enduranceLevelSport;
    }

    public double getHungerValueSport() {
        return hungerValueSport;
    }

    public double getThirstValueSport() {
        return thirstValueSport;
    }

    public double getEnergyValueSport() {
        return energyValueSport;
    }

    public double getHygieneValueSport() {
        return hygieneValueSport;
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
                + "," + getEnergyValueSport()
                + "," + getHygieneValueSport()
                + "\n";
    }


}
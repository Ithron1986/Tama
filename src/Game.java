public class Game {
    private String descriptionGame;
    private double fatValueGame;
    private double healthynessValueGame;
    private double moodLevelGame;
    private double strenghtValueGame;
    private double enduranceLevelGame;
    private double hungerValueGame;
    private double thirstValueGame;
    private double energyValueGame;
    private double hygieneValueGame;


    public Game(String descriptionGame, double fatValueGame,
                double healthynessValueGame, double moodLevelGame,
                double strenghtValueGame, double enduranceLevelGame,
                double hungerValueGame, double thirstValueGame,
                double energyValueGame, double hygieneValueGame
    ) {

        this.descriptionGame = descriptionGame;
        this.fatValueGame = fatValueGame;
        this.healthynessValueGame = healthynessValueGame;
        this.moodLevelGame = moodLevelGame;
        this.strenghtValueGame = strenghtValueGame;
        this.enduranceLevelGame = enduranceLevelGame;
        this.hungerValueGame = hungerValueGame;
        this.thirstValueGame = thirstValueGame;
        this.energyValueGame = energyValueGame;
        this.hygieneValueGame = hygieneValueGame;


    }

    public String getDescriptionGame() {
        return descriptionGame;
    }

    public double getFatValueGame() {
        return fatValueGame;
    }

    public double getHealthynessValueGame() {
        return healthynessValueGame;
    }

    public double getMoodLevelGame() {
        return moodLevelGame;
    }

    public double getStrenghtValueGame() {
        return strenghtValueGame;
    }

    public double getEnduranceLevelGame() {
        return enduranceLevelGame;
    }

    public double getHungerValueGame() {
        return hungerValueGame;
    }

    public double getThirstValueGame() {
        return thirstValueGame;
    }

    public double getEnergyValueGame() {
        return energyValueGame;
    }

    public double getHygieneValueGame() {
        return hygieneValueGame;
    }


    public String gameToString() {
        return getDescriptionGame()
                + "," + getFatValueGame()
                + "," + getHealthynessValueGame()
                + "," + getMoodLevelGame()
                + "," + getStrenghtValueGame()
                + "," + getEnduranceLevelGame()
                + "," + getHungerValueGame()
                + "," + getThirstValueGame()
                + "," + getEnergyValueGame()
                + "," + getHygieneValueGame()
                + "\n";
    }


}


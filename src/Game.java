public class Game {
    private String descriptionGame;
    private int fatValueGame;
    private int healthynessValueGame;
    private int moodLevelGame;
    private double strenghtValueGame;
    private double enduranceLevelGame;
    private int hungerValueGame;
    private int thirstValueGame;
    private int energyValueGame;


    public Game(String descriptionGame, int fatValueGame,
                int healthynessValueGame, int moodLevelGame,
                double strenghtValueGame, double enduranceLevelGame,
                int hungerValueGame, int thirstValueGame, int energyValueGame) {

        this.descriptionGame = descriptionGame;
        this.fatValueGame = fatValueGame;
        this.healthynessValueGame = healthynessValueGame;
        this.moodLevelGame = moodLevelGame;
        this.strenghtValueGame = strenghtValueGame;
        this.enduranceLevelGame = enduranceLevelGame;
        this.hungerValueGame = hungerValueGame;
        this.thirstValueGame = thirstValueGame;
        this.energyValueGame = energyValueGame;


    }

    public String getDescriptionGame() {
        return descriptionGame;
    }

    public int getFatValueGame() {
        return fatValueGame;
    }

    public int getHealthynessValueGame() {
        return healthynessValueGame;
    }

    public int getMoodLevelGame() {
        return moodLevelGame;
    }

    public double getStrenghtValueGame() {
        return strenghtValueGame;
    }

    public double getEnduranceLevelGame() {
        return enduranceLevelGame;
    }

    public int getHungerValueGame() {
        return hungerValueGame;
    }

    public int getThirstValueGame() {
        return thirstValueGame;
    }

    public int getEnergyValueGame() {
        return energyValueGame;
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
                + "\n";
    }


}


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Speicher {

    String pfadFoods = "G:/6_Datein/Unterlagen2018/Programmieren/TamagotchiEssen.csv";
    String pfadSports = "G:/6_Datein/Unterlagen2018/Programmieren/TamagotchiSports.csv";
    String pfadGames = "G:/6_Datein/Unterlagen2018/Programmieren/TamagotchiGames.csv";

    File inputFile = new File("G:/6_Datein/Unterlagen2018/Programmieren/TamagotchiEssen.csv");

    Map<String, Food> foodMap = new HashMap<>();
    Map<String, Sport> sportMap = new HashMap<>();
    Map<String, Game> gameMap = new HashMap<>();


    public Speicher() {
        //Essen das verfügbar ist
        Food speck = new Food("Speck", 8, 3, 0, false, 8, 8, -5,-1);
        foodMap.put("Speck", speck);

        //Sportarten die ausführbar sind
        Sport joggen = new Sport("Joggen", -4, 4, 2, 0.5, 1, -2, -4,-3);
        sportMap.put("Joggen", joggen);

        //Games die spielbar sind

        Game fangen = new Game("Fangen", -2, 2, 4, 0.25, 0.5, -1, -2,-2);
        gameMap.put("Fangen", fangen);
    }

    public Sport getGame(String gameString) {
        return sportMap.get(gameString);
    }

    public Map<String, Game> getAllGame() {
        return gameMap;
    }

    public Sport getSport(String sportString) {
        return sportMap.get(sportString);
    }

    public Map<String, Sport> getAllSport() {
        return sportMap;
    }

    public Food getFood(String foodString) {
        return foodMap.get(foodString);
    }

    public Map<String, Food> getAllFood() {
        return foodMap;
    }

    private void writeLine(String lineToWrite, String pfadVariabel) {
        try {
            FileWriter newFileWriter = new FileWriter(pfadVariabel, true);
            newFileWriter.append(lineToWrite);
            newFileWriter.append("\r\n");
            newFileWriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void datenSpeicherohneRedundanz(String lineToWrite, String pfadVariabel) {
        if (!istZeileVorhanden(lineToWrite, pfadVariabel)) {
            writeLine(lineToWrite, pfadVariabel);
        }
    }

    private boolean istZeileVorhanden(String lineToWrite, String pfadVariabel) {
        try {
            FileReader newFileReader = new FileReader(pfadVariabel);
            BufferedReader newBufferedReader = new BufferedReader(newFileReader);
            String line;
            while ((line = newBufferedReader.readLine()) != null) {
                line = line.replaceAll("\n", "").replaceAll("\r", "");
                lineToWrite = lineToWrite.replaceAll("\n", "").replaceAll("\r", "");
                System.out.println("src: " + line + "\r\ntarget: " + line);
                if (line.equals(lineToWrite)) {
                    System.out.println("zeile vorhanden " + lineToWrite);
                    return true;
                }
            }
            newFileReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return false;
    }

    public void saveEssen(Food food) {
        datenSpeicherohneRedundanz(food.foodToString(), pfadFoods);
    }

    public void saveSport(Sport sport) {
        datenSpeicherohneRedundanz(sport.sportToString(), pfadSports);
    }
    public void saveGame(Game game) {
        datenSpeicherohneRedundanz(game.gameToString(), pfadGames);
    }

}

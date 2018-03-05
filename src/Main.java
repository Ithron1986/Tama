import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        Speicher speicher = new Speicher();
        Food gebratenerSpeck = new Food("Speck", 8, 3, 0, false, 8, 8, -5);

        speicher.saveEssen(gebratenerSpeck);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Speicher speicher = new Speicher();
        Tamagotchi tamagotchi = new Tamagotchi();

        //tamagotchi wird irgendwann aus kontruktor genommen und aus einer datei mit einem getter gezogen


        new App(primaryStage, speicher, tamagotchi);
    }
}

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        Speicher speicher = new Speicher();
        Food eier = new Food("Eier", 1, 4, 1, false, 2, 2, -1,-1);

        speicher.saveEssen(eier);

        launch(args);
        System.out.println(Math.random());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Speicher speicher = new Speicher();
        Tamagotchi tamagotchi = new Tamagotchi();

        //tamagotchi wird irgendwann aus kontruktor genommen und aus einer datei mit einem getter gezogen


        new App(primaryStage, speicher, tamagotchi);
    }
}

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class App {
    private Speicher speicher;
    private BorderPane mainLayout;
    private Tamagotchi tamagotchi;

    private Food food;
    private Sport sportS;
    private Game game;
    private Farbe farbe;
    private Scene scene;
    private Stage stage;


    private App(Stage stage, Speicher speicher, Tamagotchi tamagotchi) {
        this.speicher = speicher;
        this.tamagotchi = tamagotchi;
        this.mainLayout = new BorderPane();
        this.stage = stage;
        farbe = Farbe.Blau;

        tamagotchi.setAwake(true);

        tamagotchi.setHunger(100);
        tamagotchi.setEnergie(100);
        tamagotchi.setThirst(100);


        TamagotchiService tamagotchiService = new TamagotchiService();

        tamagotchiService.setOnSucceeded(e -> this.tamagotchi.changeStatus());

        tamagotchiService.start();


        this.scene = new Scene(this.mainLayout, 1600, 900);
        this.stage.setScene(scene);
        this.stage.setTitle("Tamagotchi");
        mainScreen();
        this.stage.show();


    }


    private VBox creatingVBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new javafx.geometry.Insets(10));
        vBox.setSpacing(8);
        vBox.setStyle(farbe.farbe());
        return vBox;
    }

    private HBox defaultHboxOben() {
        //HBOX OBEN
        HBox hBoxOben = UiUtils.creatingHBox();
        GridPane gridHbox = new GridPane();
        UiUtils.creatingColumnsForHbox(4, gridHbox);

        Button essen = UiUtils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = UiUtils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = UiUtils.creatingButton("Sport");
        sport.setOnAction(e -> sportScreen());

        Button schlafen = UiUtils.creatingButton("Schlafen");
        schlafen.setOnAction(e -> sleepingScreen());

        gridHbox.add(essen, 0, 0, 1, 1);
        gridHbox.add(spielen, 1, 0, 1, 1);
        gridHbox.add(sport, 2, 0, 1, 1);
        gridHbox.add(schlafen, 3, 0, 1, 1);

        hBoxOben.getChildren().addAll(gridHbox);
        return hBoxOben;
    }

    private HBox defaultHboxUnten() {
        //Hbox Unten
        HBox hBoxUnten = UiUtils.creatingHBox();
        GridPane gridHBoxUntenMain = new GridPane();
        UiUtils.creatingColumnsForHbox(3, gridHBoxUntenMain);

        gridHBoxUntenMain.setGridLinesVisible(true);


        Button pflege = UiUtils.creatingButton("Pflege");
        pflege.setOnAction(e -> pflegeScreen());

        Button status = UiUtils.creatingButton("Status");
        status.setOnAction(e -> statusScreen());

        Button einstellungen = UiUtils.creatingButton("Einstellungen");
        einstellungen.setOnAction(e -> einstellungsScreen());


        gridHBoxUntenMain.add(pflege, 0, 0, 1, 1);
        gridHBoxUntenMain.add(status, 1, 0, 1, 1);
        gridHBoxUntenMain.add(einstellungen, 2, 0, 1, 1);
        hBoxUnten.getChildren().addAll(gridHBoxUntenMain);

        return hBoxUnten;
    }


    private void mainScreen() {


        //CenterStage
        GridPane grid = new GridPane();


        this.mainLayout.setTop(defaultHboxOben());
        this.mainLayout.setCenter(grid);
        this.mainLayout.setBottom(defaultHboxUnten());

    }

    private void pflegeScreen() {


        //Gridpane Center
        int maxNumberColumn = 11;
        int maxNumberRows = 7;
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);
        formbuilder = formbuilder
                .addHeader("Pflege")
                .addEmptyRow();

        for (Pflege pflege : speicher.getAllPflege().values()) {
            formbuilder.addButton(e ->
                            tamagotchi.pflegen(pflege)


                    , pflege.getDescription());

        }

        GridPane pflegePane = formbuilder.build();
        this.mainLayout.setTop(defaultHboxOben());
        this.mainLayout.setCenter(pflegePane);

    }


    private void foodScreen() {

        //HBOX OBEN
        HBox hBoxOben = UiUtils.creatingHBox();
        GridPane gridHbox = new GridPane();
        UiUtils.creatingColumnsForHbox(4, gridHbox);


        gridHbox.setGridLinesVisible(true);


        Button essen = UiUtils.creatingButton("Essen");
        essen.setStyle("-fx-background-color: #ffffff");
        essen.setOnAction(e -> mainScreen());

        Button spielen = UiUtils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = UiUtils.creatingButton("Sport");
        sport.setOnAction(ev -> sportScreen());

        Button schlafen = UiUtils.creatingButton("Schlafen");
        sport.setOnAction(ev -> sleepingScreen());


        gridHbox.add(essen, 0, 0, 1, 1);
        gridHbox.add(spielen, 1, 0, 1, 1);
        gridHbox.add(sport, 2, 0, 1, 1);
        gridHbox.add(schlafen, 3, 0, 1, 1);

        hBoxOben.getChildren().addAll(gridHbox);

        //Gridpane Center
        int maxNumberColumn = 11;
        int maxNumberRows = 7;
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);
        formbuilder = formbuilder
                .addHeader("Essen");
        for (Food food : speicher.getAllFood().values()) {
            formbuilder.addButton(e -> tamagotchi.essen(food), food.getDescription());
        }
        GridPane essensPane = formbuilder.build();

        //HboxUntenDefault


        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setCenter(essensPane);
        this.mainLayout.setBottom(defaultHboxUnten());
    }

    private void statusScreen()

    {


        int maxNumberColumn = 11;
        int maxNumberRows = 11;


        //Gridpane Center
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);

        formbuilder.addHeader("Status")
                .addEmptyRow()
                .addEmptyRow()
                /*   .addTextInputField("Laune", String.valueOf(tamagotchi.getMood()), (tamagotchi.getMood() / 100))
                   .addTextInputField("Hunger", String.valueOf(tamagotchi.getHunger()), (tamagotchi.getHunger() / 100))
                   .addTextInputField("Durst", String.valueOf(tamagotchi.getThirst()), (tamagotchi.getThirst() / 100))
                   .addTextInputField("Energie", String.valueOf(tamagotchi.getEnergie()), (tamagotchi.getEnergie() / 100))
                   .addTextInputField("Gesundheit", String.valueOf(tamagotchi.getHealthynesse()), (tamagotchi.getHealthynesse() / 100))
                   .addTextInputField("Särke", String.valueOf(tamagotchi.getStrength()), (tamagotchi.getStrength() / 100))
                   .addTextInputField("Ausdauer", String.valueOf(tamagotchi.getEndurance()), (tamagotchi.getEndurance() / 100))*/
                .addProgressBar("Laune", tamagotchi.moodPorperty())
                .addProgressBar("Sättigung", tamagotchi.hungerPorperty())
                .addProgressBar("Sitt", tamagotchi.thirstPorperty())
                .addProgressBar("Energie", tamagotchi.energiePorperty())
                .addProgressBar("Gesundheit", tamagotchi.healthynessProperty())
                .addProgressBar("Särke", tamagotchi.strengthProperty())
                .addProgressBar("Ausdauer", tamagotchi.enduranceProperty())
                .addProgressBar("Fett", tamagotchi.fatProperty());
        GridPane statusPane = formbuilder.build();



     /*    tamagotchi.einschlafen();


        tamagotchi.awakeProperty().addListener((value, old, newValue) -> {

            old.booleanValue();
            newValue.booleanValue();
            value.getValue().booleanValue();
        });*/


        statusPane.setGridLinesVisible(true);
        this.mainLayout.setTop(defaultHboxOben());
        this.mainLayout.setCenter(statusPane);
        this.mainLayout.setBottom(defaultHboxUnten());

    }

    private void sportScreen() {

        //HBOX OBEN
        HBox hBoxOben = UiUtils.creatingHBox();
        GridPane gridHbox = new GridPane();
        UiUtils.creatingColumnsForHbox(4, gridHbox);

        gridHbox.setGridLinesVisible(true);


        Button essen = UiUtils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = UiUtils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = UiUtils.creatingButton("Sport");
        sport.setStyle("-fx-background-color: #ffffff");
        sport.setOnAction(ev -> mainScreen());

        Button schlafen = UiUtils.creatingButton("Schlafen");
        schlafen.setOnAction(event -> sleepingScreen());

        gridHbox.add(essen, 0, 0, 1, 1);
        gridHbox.add(spielen, 1, 0, 1, 1);
        gridHbox.add(sport, 2, 0, 1, 1);
        gridHbox.add(schlafen, 3, 0, 1, 1);

        hBoxOben.getChildren().addAll(gridHbox);

        //Gridpane Center
        int maxNumberColumn = 11;
        int maxNumberRows = 7;
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);
        formbuilder = formbuilder
                .addHeader("Sport")
                .addEmptyRow();

        for (Sport sportS : speicher.getAllSport().values()) {
            formbuilder.addButton(e -> tamagotchi.hatNochEnergieFuer(sportS), sportS.getDescriptionSport());
        }
        GridPane sportsPane = formbuilder.build();

        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setCenter(sportsPane);
        this.mainLayout.setBottom(defaultHboxUnten());
    }

    private void gameScreen() {


        //HBOX OBEN
        HBox hBoxOben = UiUtils.creatingHBox();
        GridPane gridHbox = new GridPane();
        UiUtils.creatingColumnsForHbox(4, gridHbox);

        gridHbox.setGridLinesVisible(true);


        Button essen = UiUtils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = UiUtils.creatingButton("Spielen");
        spielen.setStyle("-fx-background-color: #ffffff");
        spielen.setOnAction(event -> mainScreen());

        Button sport = UiUtils.creatingButton("Sport");

        sport.setOnAction(ev -> sportScreen());

        Button schlafen = UiUtils.creatingButton("Schlafen");
        schlafen.setOnAction(event -> sleepingScreen());

        gridHbox.add(essen, 0, 0, 1, 1);
        gridHbox.add(spielen, 1, 0, 1, 1);
        gridHbox.add(sport, 2, 0, 1, 1);
        gridHbox.add(schlafen, 3, 0, 1, 1);
        hBoxOben.getChildren().addAll(gridHbox);

        //Gridpane Center
        int maxNumberColumn = 11;
        int maxNumberRows = 7;
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);
        formbuilder = formbuilder
                .addHeader("Game")
                .addEmptyRow();

        for (Game game : speicher.getAllGame().values()) {
            formbuilder.addButton(e -> tamagotchi.hatNochEnergieFuer(game), game.getDescriptionGame());
        }
        GridPane gamePane = formbuilder.build();


        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setCenter(gamePane);
        this.mainLayout.setBottom(defaultHboxUnten());
    }

    private void sleepingScreen() {

        //HBOX OBEN
        HBox hBoxOben = UiUtils.creatingHBox();
        GridPane gridHbox = new GridPane();
        UiUtils.creatingColumnsForHbox(4, gridHbox);

        gridHbox.setGridLinesVisible(true);


        Button essen = UiUtils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = UiUtils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = UiUtils.creatingButton("Sport");

        sport.setOnAction(ev -> sportScreen());

        Button schlafen = UiUtils.creatingButton("Schlafen");
        schlafen.setStyle("-fx-background-color: #ffffff");
        schlafen.setOnAction(event -> mainScreen());

        gridHbox.add(essen, 0, 0, 1, 1);
        gridHbox.add(spielen, 1, 0, 1, 1);
        gridHbox.add(sport, 2, 0, 1, 1);
        gridHbox.add(schlafen, 3, 0, 1, 1);

        hBoxOben.getChildren().addAll(gridHbox);

        //Gridpane Center
        int maxNumberColumn = 11;
        int maxNumberRows = 7;
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);
        formbuilder = formbuilder
                .addHeader("Schlafen")
                .addEmptyRow();

        for (Game game : speicher.getAllGame().values()) {
            formbuilder.addButton(e -> tamagotchi.hatNochEnergieFuer(game), game.getDescriptionGame());
        }
        GridPane gamePane = formbuilder.build();


        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setCenter(gamePane);
        this.mainLayout.setBottom(defaultHboxUnten());

    }

    private void einstellungsScreen() {

        this.mainLayout.setTop(defaultHboxOben());
        /*this.mainLayout.setCenter(gamePane);*/
    }
}

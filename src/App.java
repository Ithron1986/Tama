import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
    UiUtils utils = new UiUtils();

    public App(Stage stage, Speicher speicher, Tamagotchi tamagotchi) {
        this.speicher = speicher;
        this.tamagotchi = tamagotchi;
        this.mainLayout = new BorderPane();
        this.stage = stage;
        farbe = Farbe.Blau;


        this.scene = new Scene(this.mainLayout, 1600, 900);
        this.stage.setScene(scene);
        this.stage.setTitle("Tamagotchi");
        mainScreen();
        this.stage.show();


    }


    public HBox creatingHBox() {
        HBox hBox = new HBox();
        hBox.setStyle(farbe.farbe());
        return hBox;
    }

    private VBox creatingVBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new javafx.geometry.Insets(10));
        vBox.setSpacing(8);
        vBox.setStyle(farbe.farbe());
        return vBox;
    }


    // Der mainScreen zeigt das Tamagotchi mit den zu der Verfassung gehörigen Animation

    public void mainScreen() {

        //HBOX OBEN
        HBox hBoxOben = creatingHBox();
        GridPane gridHbox = new GridPane();


        for (int i = 0; i < 4; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(400);
            col.setHalignment(HPos.CENTER);
            col.setMinWidth(20);
            gridHbox.getColumnConstraints().add(col);
        }


        gridHbox.setGridLinesVisible(true);


        Button essen = utils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = utils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = utils.creatingButton("Sport");
        sport.setOnAction(ev -> sportScreen());

        Button schlafen = utils.creatingButton("Schlafen");
        schlafen.setOnAction(e -> sleepingScreen());


        gridHbox.add(essen, 0, 0, 1, 1);
        gridHbox.add(spielen, 1, 0, 1, 1);
        gridHbox.add(sport, 2, 0, 1, 1);
        gridHbox.add(schlafen, 3, 0, 1, 1);
        hBoxOben.getChildren().addAll(gridHbox);


        //Hbox Unten Main
        HBox hBoxUntenMain = creatingHBox();
        GridPane gridHBoxUntenMain = new GridPane();


        for (int i = 0; i < 3; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(400);
            col.setHalignment(HPos.CENTER);
            col.setMinWidth(20);
            gridHBoxUntenMain.getColumnConstraints().add(col);
        }


        gridHBoxUntenMain.setGridLinesVisible(true);


        Button pflege = utils.creatingButton("Pflege");
        pflege.setOnAction(e -> pflegeScreen());

        Button status = utils.creatingButton("Status");
        status.setOnAction(event -> statusScreen());

        Button einstellungen = utils.creatingButton("Einstellungen");
        einstellungen.setOnAction(ev -> einstellungsScreen());


        gridHBoxUntenMain.add(pflege, 0, 0, 1, 1);
        gridHBoxUntenMain.add(status, 1, 0, 1, 1);
        gridHBoxUntenMain.add(einstellungen, 2, 0, 1, 1);
        hBoxUntenMain.getChildren().addAll(gridHBoxUntenMain);


        //CenterStage
        GridPane grid = new GridPane();


        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setCenter(grid);
        this.mainLayout.setBottom(hBoxUntenMain);

    }

    public void pflegeScreen() {
        // TabPaneUnten
    /*    TabPane tabPanePflege = new TabPane();
        tabPanePflege.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPanePflege.setSide(Side.BOTTOM);
        tabPanePflege.setTabMaxHeight(40.0);
        tabPanePflege.setTabMaxWidth(480);
        tabPanePflege.setTabMinHeight(40.0);
        tabPanePflege.setTabMinWidth(380);

        Tab tabPflege = new Tab();
        tabPflege.setText("Pflege");
        Tab tabStatus = new Tab();
        tabStatus.setText("Status");
        Tab tabEinstellungen = new Tab();
        tabEinstellungen.setText("Einstellungen");

        tabPflege.setContent(new Rectangle(1600, 860, Color.WHITE));
        tabStatus.setContent(new Rectangle(1600, 860, Color.WHITE));
        tabEinstellungen.setContent(new Rectangle(1600, 860, Color.WHITE));
*/

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

    /*    tabPflege.setContent(pflegePane);
        tabPanePflege.getTabs().

                addAll(tabPflege, tabStatus, tabEinstellungen);

        this.mainLayout.setTop(tabPanePflege);*/
        this.mainLayout.setCenter(pflegePane);

    }


    public void foodScreen() {

        //HBOX OBEN
        HBox hBoxOben = creatingHBox();
        GridPane gridHbox = new GridPane();


        for (int i = 0; i < 4; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(800);
            col.setMaxWidth(800);
            col.setHalignment(HPos.CENTER);
            col.setMinWidth(20);
            gridHbox.getColumnConstraints().add(col);
        }


        gridHbox.setGridLinesVisible(true);


        Button essen = utils.creatingButton("Essen");
        essen.setStyle("-fx-background-color: #ffffff");
        essen.setOnAction(e -> mainScreen());

        Button spielen = utils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = utils.creatingButton("Sport");
        sport.setOnAction(ev -> sportScreen());

        Button schlafen = utils.creatingButton("Schlafen");
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

        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setCenter(essensPane);
    }

    public void statusScreen()

    {
        int maxNumberColumn = 11;
        int maxNumberRows = 11;


        //Gridpane Center
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);

        formbuilder.addHeader("Status")
                .addEmptyRow()
                .addEmptyRow()
                .addTextInputField("Laune", String.valueOf(tamagotchi.getMood()), (tamagotchi.getMood() / 100))
                .addTextInputField("Hunger", String.valueOf(tamagotchi.getHunger()), (tamagotchi.getHunger() / 100))
                .addTextInputField("Durst", String.valueOf(tamagotchi.getThirst()), (tamagotchi.getThirst() / 100))
                .addTextInputField("Energie", String.valueOf(tamagotchi.getEnergie()), (tamagotchi.getEnergie() / 100))
                .addTextInputField("Gesundheit", String.valueOf(tamagotchi.getHealthynesse()), (tamagotchi.getHealthynesse() / 100))
                .addTextInputField("Särke", String.valueOf(tamagotchi.getStrength()), (tamagotchi.getStrength() / 100))
                .addTextInputField("Ausdauer", String.valueOf(tamagotchi.getEndurance()), (tamagotchi.getEndurance() / 100))
                .addProgressBar("Fett", tamagotchi.fatProperty());
        GridPane statusPane = formbuilder.build();

        Slider slider = new Slider();

        slider.setMin(0);
        slider.setMax(1);
        slider.valueProperty().bindBidirectional(tamagotchi.fatProperty());

     /*    tamagotchi.einschlafen();


        tamagotchi.awakeProperty().addListener((value, old, newValue) -> {

            old.booleanValue();
            newValue.booleanValue();
            value.getValue().booleanValue();
        });*/

        statusPane.add(slider,5,5);

        statusPane.setGridLinesVisible(true);

        this.mainLayout.setCenter(statusPane);

    }

    public void sportScreen() {

        //HBOX OBEN
        HBox hBoxOben = creatingHBox();
        GridPane gridHbox = new GridPane();


        for (int i = 0; i < 4; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(400);
            col.setHalignment(HPos.CENTER);
            col.setMinWidth(20);
            gridHbox.getColumnConstraints().add(col);
        }


        gridHbox.setGridLinesVisible(true);


        Button essen = utils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = utils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = utils.creatingButton("Sport");
        sport.setStyle("-fx-background-color: #ffffff");
        sport.setOnAction(ev -> mainScreen());

        Button schlafen = utils.creatingButton("Schlafen");
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
    }

    public void gameScreen() {

        //HBOX OBEN
        HBox hBoxOben = creatingHBox();
        GridPane gridHbox = new GridPane();


        for (int i = 0; i < 4; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(400);
            col.setHalignment(HPos.CENTER);
            col.setMinWidth(20);
            gridHbox.getColumnConstraints().add(col);
        }


        gridHbox.setGridLinesVisible(true);


        Button essen = utils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = utils.creatingButton("Spielen");
        spielen.setStyle("-fx-background-color: #ffffff");
        spielen.setOnAction(event -> mainScreen());

        Button sport = utils.creatingButton("Sport");

        sport.setOnAction(ev -> sportScreen());

        Button schlafen = utils.creatingButton("Schlafen");
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
    }

    public void sleepingScreen() {

        //HBOX OBEN
        HBox hBoxOben = creatingHBox();
        GridPane gridHbox = new GridPane();


        for (int i = 0; i < 4; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(400);
            col.setHalignment(HPos.CENTER);
            col.setMinWidth(20);
            gridHbox.getColumnConstraints().add(col);
        }


        gridHbox.setGridLinesVisible(true);


        Button essen = utils.creatingButton("Essen");
        essen.setOnAction(e -> foodScreen());

        Button spielen = utils.creatingButton("Spielen");
        spielen.setOnAction(event -> gameScreen());

        Button sport = utils.creatingButton("Sport");

        sport.setOnAction(ev -> sportScreen());

        Button schlafen = utils.creatingButton("Schlafen");
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
                .addHeader("Game")
                .addEmptyRow();

        for (Game game : speicher.getAllGame().values()) {
            formbuilder.addButton(e -> tamagotchi.hatNochEnergieFuer(game), game.getDescriptionGame());
        }
        GridPane gamePane = formbuilder.build();


        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setCenter(gamePane);

    }

    public void einstellungsScreen() {

    }
}

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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

    public Button creatingButton(String title) {
        Button button = new Button(title);
        button.setStyle(farbe.farbe());
        return button;
    }

    public Button creatingButton() {
        Button button = new Button();
        return button;
    }

    // Der mainScreen zeigt das Tamagotchi mit den zu der Verfassung gehörigen Animation
    public void mainScreen() {

        //Hbox Oben Main
        HBox hBoxObenMain = creatingHBox();
        GridPane grid = new GridPane();
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(20.0);
        Button buttonEssen = new Button("Essen");

        buttonEssen.setOnAction(e -> {
            foodScreen();
            buttonEssen.setStyle(farbe.farbe());
        });
        Button buttonSpielen = new Button("Spielen");
        buttonSpielen.setOnAction(e -> gameScreen());
        Button buttonSport = new Button("Sport");
        buttonSport.setOnAction(e -> sportScreen());
        Button buttonSchlafen = new Button("Schlafen");
        buttonSchlafen.setOnAction(e -> sleepingScreen());

        grid.getColumnConstraints().add(col);
        grid.getChildren().addAll(buttonEssen, buttonSpielen, buttonSport, buttonSchlafen);
        hBoxObenMain.getChildren().add(grid);
        //Hbox Unten Main


/*

        // TabPaneOben
        TabPane tabPaneMainOben = new TabPane();
        tabPaneMainOben.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPaneMainOben.setSide(Side.TOP);
        tabPaneMainOben.setTabMaxHeight(40.0);
        tabPaneMainOben.setTabMaxWidth(480);
        tabPaneMainOben.setTabMinHeight(40.0);
        tabPaneMainOben.setTabMinWidth(400);

        Tab tabEssen = new Tab();
        tabEssen.setText("Essen");
        Tab tabSpielen = new Tab();
        tabSpielen.setText("Spielen");
        Tab tabSport = new Tab();
        tabSport.setText("Sport");
        Tab tabSchlafen = new Tab();
        tabSchlafen.setText("Schlafen");

        tabPaneMainOben.getTabs().addAll(tabEssen, tabSpielen, tabSport, tabSchlafen);
*/

        //Tab Essen


        /*//Tab Spielen
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
        Background b = new Background(new BackgroundFill(Color.GREEN, null, null));
        gamePane.setBackground(b);

        tabSpielen.setContent(gamePane);

        //Tab Sport
        int maxNumberColumnSport = 11;
        int maxNumberRowsSport = 7;
        Formbuilder formbuilderSport = new Formbuilder(maxNumberColumnSport, maxNumberRowsSport);
        formbuilderSport = formbuilderSport
                .addHeader("Sport")
                .addEmptyRow();

        for (Sport sportS : speicher.getAllSport().values()) {
            formbuilderSport.addButton(e -> tamagotchi.hatNochEnergieFuer(sportS), sportS.getDescriptionSport());
        }
        GridPane sportsPane = formbuilderSport.build();
        tabSport.setContent(sportsPane);


// TabPaneUnten
        TabPane tabPaneMainBott = new TabPane();
        SingleSelectionModel<Tab> selectionModel = tabPaneMainBott.getSelectionModel();
        tabPaneMainBott.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        selectionModel.clearSelection();
        tabPaneMainBott.setSide(Side.BOTTOM);
        tabPaneMainBott.setTabMaxHeight(40.0);
        tabPaneMainBott.setTabMaxWidth(480);
        tabPaneMainBott.setTabMinHeight(40.0);
        tabPaneMainBott.setTabMinWidth(380);

        Tab tabPflege = new Tab();
        tabPflege.setText("Pflege");
        Tab tabStatus = new Tab();
        tabStatus.setText("Status");
        Tab tabEinstellungen = new Tab();
        tabEinstellungen.setText("Einstellungen");


        tabPaneMainBott.getTabs().addAll(tabPflege, tabStatus, tabEinstellungen);

        //Tab Pflege
        int maxNumberColumnPflege = 11;
        int maxNumberRowsPflege = 7;
        Formbuilder formbuilderPflege = new Formbuilder(maxNumberColumnPflege, maxNumberRowsPflege);
        formbuilderPflege = formbuilderPflege
                .addHeader("Pflege")
                .addEmptyRow();

        for (Pflege pflege : speicher.getAllPflege().values()) {
            formbuilder.addButton(e -> *//*if (speicher.getPflege("Duschen").equals(pflege)) {
         *//* tamagotchi.pflegen(pflege)*//*;
            } else {tamagotchi.pflegen(pflege);}*//*


                    , pflege.getDescription());
        }

        GridPane pflegePane = formbuilderPflege.build();

        tabPflege.setContent(pflegePane);


        //Tab Status
        Formbuilder formbuilderStatus = new Formbuilder(maxNumberColumn, maxNumberRows);

        formbuilderStatus.addHeader("Status")
                .addEmptyRow()
                .addEmptyRow()
                .addTextInputField("Laune", String.valueOf(tamagotchi.getMood()), (tamagotchi.getMood() / 100))
                .addTextInputField("Hunger", String.valueOf(tamagotchi.getHunger()), (tamagotchi.getHunger() / 100))
                .addTextInputField("Durst", String.valueOf(tamagotchi.getThirst()), (tamagotchi.getThirst() / 100))
                .addTextInputField("Energie", String.valueOf(tamagotchi.getEnergie()), (tamagotchi.getEnergie() / 100))
                .addTextInputField("Gesundheit", String.valueOf(tamagotchi.getHealthynesse()), (tamagotchi.getHealthynesse() / 100))
                .addTextInputField("Särke", String.valueOf(tamagotchi.getStrength()), (tamagotchi.getStrength() / 100))
                .addTextInputField("Ausdauer", String.valueOf(tamagotchi.getEndurance()), (tamagotchi.getEndurance() / 100));

        GridPane statusPane = formbuilderStatus.build();
        tabStatus.setContent(statusPane);

        //Tab Einstellungen


        vbox.getChildren().addAll(tabPaneMainOben, tabPaneMainBott);*/

        this.mainLayout.setTop(hBoxObenMain);

    }

    public void pflegeScreen() {
        // TabPaneUnten
        TabPane tabPanePflege = new TabPane();
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


        //Gridpane Center
        int maxNumberColumn = 11;
        int maxNumberRows = 7;
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);
        formbuilder = formbuilder
                .addHeader("Pflege")
                .addEmptyRow();

        for (Pflege pflege : speicher.getAllPflege().values()) {
            formbuilder.addButton(e -> /*if (speicher.getPflege("Duschen").equals(pflege)) {
                     */ tamagotchi.pflegen(pflege)/*;
            } else {tamagotchi.pflegen(pflege);}*/


                    , pflege.getDescription());
        }

        GridPane pflegePane = formbuilder.build();

        tabPflege.setContent(pflegePane);
        tabPanePflege.getTabs().

                addAll(tabPflege, tabStatus, tabEinstellungen);

        this.mainLayout.setTop(tabPanePflege);
        this.mainLayout.setCenter(pflegePane);

    }


    public void foodScreen() {

        //HBOX OBEN
        HBox hBoxOben = creatingHBox();
        GridPane gridHbox = new GridPane();


        for (int i = 0; i < 12; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(120 / 12);
            //col.setPrefWidth(400);
            gridHbox.getColumnConstraints().add(col);
        }


        gridHbox.setPadding(new Insets(0, 10, 0, 10));

        gridHbox.setGridLinesVisible(true);


        Button essen = creatingButton("Essen");
        essen.setStyle("-fx-background-color: #ffffff");
        essen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(essen, 0, 0, 1, 1);
        //Aktion essen auf dem Button Essen
        essen.setOnAction(e -> foodScreen());


        Button spielen = creatingButton("Spielen");

        spielen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(spielen, 1, 0, 1, 1);
        spielen.setOnAction(event -> gameScreen());

        Button sport = creatingButton("Sport");

        sport.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(sport, 2, 0);
        sport.setOnAction(ev -> sportScreen());

        Button schlafen = creatingButton("Schlafen");

        schlafen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(schlafen, 3, 0);

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
                .addTextInputField("Ausdauer", String.valueOf(tamagotchi.getEndurance()), (tamagotchi.getEndurance() / 100));

        GridPane statusPane = formbuilder.build();
        statusPane.setGridLinesVisible(true);

        this.mainLayout.setCenter(statusPane);

    }

    public void sportScreen() {

        // TabPaneOben
        TabPane tabPaneSports = new TabPane();
        tabPaneSports.setSide(Side.TOP);
        tabPaneSports.setTabMaxHeight(40.0);
        tabPaneSports.setTabMaxWidth(480);
        tabPaneSports.setTabMinHeight(40.0);
        tabPaneSports.setTabMinWidth(400);

        Tab tabEssen = new Tab();
        tabEssen.setText("Essen");
        Tab tabSpielen = new Tab();
        tabSpielen.setText("Spielen");
        Tab tabSport = new Tab();
        tabSport.setText("Sport");
        Tab tabSchlafen = new Tab();
        tabSchlafen.setText("Schlafen");

        tabEssen.setContent(new Rectangle(1600, 860, Color.WHITE));
        tabSpielen.setContent(new Rectangle(1600, 860, Color.WHITE));
        tabSport.setContent(new Rectangle(1600, 860, Color.WHITE));
        tabSchlafen.setContent(new Rectangle(1600, 860, Color.WHITE));
        tabPaneSports.getTabs().addAll(tabEssen, tabSpielen, tabSport, tabSchlafen);


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

        this.mainLayout.setTop(tabPaneSports);
        this.mainLayout.setCenter(sportsPane);
    }

    public void gameScreen() {

        // TabPaneOben
        TabPane tabPaneGame = new TabPane();
        tabPaneGame.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPaneGame.setSide(Side.TOP);
        tabPaneGame.setTabMaxHeight(40.0);
        tabPaneGame.setTabMaxWidth(480);
        tabPaneGame.setTabMinHeight(40.0);
        tabPaneGame.setTabMinWidth(380);

        Tab tabEssen = new Tab("Essen");
        tabEssen.setText("Essen");
        Tab tabSpielen = new Tab("Spielen");
        tabEssen.setText("Spielen");
        Tab tabSport = new Tab("Sport");
        tabEssen.setText("Sport");
        Tab tabSchlafen = new Tab("Schlafen");
        tabEssen.setText("Schlafen");

        tabEssen.setContent(new Rectangle(1600, 860, Color.WHITE));

        tabSport.setContent(new Rectangle(1600, 860, Color.WHITE));
        tabSchlafen.setContent(new Rectangle(1600, 860, Color.WHITE));


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

        tabSpielen.setContent(gamePane);
        tabPaneGame.getTabs().addAll(tabEssen, tabSpielen, tabSport, tabSchlafen);

        this.mainLayout.setTop(tabPaneGame);
        this.mainLayout.setCenter(gamePane);
    }

    public void sleepingScreen() {

    }
}

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        //Gridpane im Zentrum
        GridPane grid = UiUtils.creatingGrid(11, 7);
        grid.setGridLinesVisible(true);


        //HBox oben
        HBox hBoxOben = creatingHBox();
        GridPane gridHbox = new GridPane();

        for (int i = 0; i < 4; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(25);
            col.setPrefWidth(400);
            gridHbox.getColumnConstraints().add(col);
        }

        gridHbox.setHgap(10);
        gridHbox.setVgap(10);
        gridHbox.setPadding(new Insets(0, 10, 0, 10));

        gridHbox.setGridLinesVisible(true);

        Button essen = creatingButton("Essen");
        essen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(essen, 0, 0, 1, 1);
        //Aktion essen auf dem Button Essen
        essen.setOnAction(e -> foodScreen());


        Button spielen = creatingButton("Spielen");
        spielen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(spielen, 1, 0, 1, 1);

        Button sport = creatingButton("Sport");
        sport.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(sport, 2, 0);
        sport.setOnAction(ev -> sportScreen());

        Button schlafen = creatingButton("Schlafen");
        schlafen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(schlafen, 3, 0);


        hBoxOben.getChildren().addAll(gridHbox);


        //HBox unten
        HBox hBoxUnten = creatingHBox();
        //hBoxUnten.setAlignment(Pos.CENTER_RIGHT);
        Button einstellungen = creatingButton("Einstellungen");
        Button status = creatingButton("Status");

        hBoxUnten.getChildren().addAll(status, einstellungen);


        //VBox links
        VBox vBoxLinks = creatingVBox();
        Button statusButton = creatingButton("Status");
        statusButton.setOnAction(e -> statusScreen());
        vBoxLinks.getChildren().add(statusButton);


        this.mainLayout.setTop(hBoxOben);
        this.mainLayout.setBottom(hBoxUnten);
        this.mainLayout.setLeft(vBoxLinks);
        this.mainLayout.setCenter(grid);
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
        gridHbox.add(essen, 1, 0, 1, 1);


        Button spielen = creatingButton("Spielen");
        spielen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(spielen, 4, 0, 1, 1);

        Button sport = creatingButton("Sport");
        sport.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(sport, 7, 0, 1, 1);

        Button schlafen = creatingButton("Schlafen");
        schlafen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(schlafen, 10, 0, 1, 1);

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
                .addTextInputField("Gesundheit", String.valueOf(tamagotchi.getMood()), (tamagotchi.getMood() / 100));
        GridPane statusPane = formbuilder.build();
        statusPane.setGridLinesVisible(true);

        this.mainLayout.setCenter(statusPane);
    }

    public void sportScreen() {

        // TabPaneOben
        TabPane tabPaneSports = new TabPane();
        tabPaneSports.setSide(Side.TOP);
        tabPaneSports.setTabMaxHeight(25.0);
        tabPaneSports.setTabMaxWidth(480);
        tabPaneSports.setTabMinHeight(25.0);
        tabPaneSports.setTabMinWidth(400);

        Tab tabEssen = new Tab();
        tabEssen.setStyle("Arial");
        tabEssen.setText("Essen");
        Tab tabSpielen = new Tab();
        tabEssen.setText("Spielen");
        Tab tabSport = new Tab();
        tabEssen.setText("Sport");
        Tab tabSchlafen = new Tab();
        tabEssen.setText("Schlafen");

        tabEssen.setContent(new Rectangle(200, 200, Color.LIGHTSTEELBLUE));
        tabPaneSports.getTabs().addAll(tabEssen,tabSpielen,tabSport,tabSchlafen);

        /*//HBOX OBEN
        HBox hBoxObenSport = creatingHBox();
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
        essen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(essen, 1, 0, 1, 1);


        Button spielen = creatingButton("Spielen");
        spielen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(spielen, 4, 0, 1, 1);

        Button sport = creatingButton("Sport");
        sport.setStyle("-fx-background-color: #ffffff");

        sport.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(sport, 7, 0, 1, 1);

        Button schlafen = creatingButton("Schlafen");
        schlafen.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridHbox.add(schlafen, 10, 0, 1, 1);

        hBoxObenSport.getChildren().addAll(gridHbox);*/

        //Gridpane Center
        int maxNumberColumn = 11;
        int maxNumberRows = 7;
        Formbuilder formbuilder = new Formbuilder(maxNumberColumn, maxNumberRows);
        formbuilder = formbuilder
                .addHeader("Sport")
                .addEmptyRow();

        for (Sport sportS : speicher.getAllSport().values()) {
            formbuilder.addButton(e -> tamagotchi.workout(sportS), sportS.getDescriptionSport());
        }
        GridPane sportsPane = formbuilder.build();

        this.mainLayout.setTop(tabPaneSports);
        this.mainLayout.setCenter(sportsPane);
    }
}

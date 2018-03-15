import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;


public class UiUtils {
    private static final int maxNumberCR = 100;

    static final Farbe farbe = Farbe.Blau;


    public static GridPane creatingGrid(int maxNumberColumn, int maxNumberRows) {
        GridPane newGrid = new GridPane();
        for (int i = 0; i < maxNumberColumn; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(maxNumberCR / maxNumberColumn);
            newGrid.getColumnConstraints().add(col);
        }
        for (int i = 0; i < maxNumberRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(8);
            newGrid.getRowConstraints().add(row);
        }
        newGrid.setHgap(10);
        newGrid.setVgap(10);
        newGrid.setPadding(new Insets(0, 10, 0, 10));
        return newGrid;
    }

    public static Button creatingButton(String title) {
        return creatingButton(title, Farbe.Blau);
    }

    public static Button creatingButton(String title, Farbe farbe) {
        Button button = new Button(title);
        button.setStyle(farbe.farbe());
        button.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        button.setPrefSize(400, 8);
        button.setMaxSize(800, 8);
        return button;
    }

    public static Button creatingButton() {
        Button button = new Button();
        return button;
    }

    public static void createPopup(String text) {
        Popup popup = new Popup();
        Text newText = new Text(text);
        popup.getContent().addAll(newText);

        //pop nicht auf weil es in keine Scene eingebettet ist

    }

    public static void creatingColumnsForHbox(int spaltenzahl, GridPane gridHbox){

        for (int i = 0; i < spaltenzahl; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(800);
            col.setMaxWidth(800);
            col.setHalignment(HPos.CENTER);
            col.setMinWidth(20);
            gridHbox.getColumnConstraints().add(col);
        }

    }
    public static HBox creatingHBox() {
        HBox hBox = new HBox();
        hBox.setStyle(farbe.farbe());
        return hBox;
    }



}

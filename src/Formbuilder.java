import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;


import java.util.HashMap;
import java.util.Map;


public class Formbuilder {

    private GridPane result;

    private int maxNumberCR = 100;

    private int currentRowIndex = 0;
    private int currentColIndex = 0;
    private int maxNumberRows;
    private int maxNumberColumns;
    private Map<String, TextInputControl> controls = new HashMap<>();

    public Formbuilder(int maxNumberColumns, int maxNumberRows) {
        this.maxNumberRows = maxNumberRows;
        this.maxNumberColumns = maxNumberColumns;
        this.result = creatingGrid();
        this.result.setGridLinesVisible(false);

    }

    public int methodCenter() {
        int centerValue;
        if (maxNumberColumns % 2 == 0) {
            centerValue = maxNumberColumns / 2;
        } else {
            centerValue = (maxNumberColumns / 2);
        }
        return centerValue;
    }

    public Formbuilder addHeader(String header) {
        Label label = new Label(header);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        this.result.add(label, methodCenter(), currentRowIndex, 6, 2);
        currentRowIndex++;
        return this;

    }

    public Formbuilder addTextInputField(String name, String numericalValue, double statuswert) {
        Label label = new Label(name);
        ProgressBar progressBar = new ProgressBar(statuswert);
        Label label2 = new Label(numericalValue);
        this.result.add(label, currentColIndex, currentRowIndex);
        this.result.add(label2, currentColIndex + 3, currentRowIndex);
        this.result.add(progressBar, currentColIndex + 1, currentRowIndex, 2, 1);
        currentRowIndex++;
        return this;
    }

    public Formbuilder addProgressBar(String name, DoubleProperty statuswert) {

        Label label = new Label(name);
        ProgressBar progressBar = new ProgressBar(0);
        progressBar.progressProperty().bind(statuswert.multiply(0.01));
        Label label2 = new Label();
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(label2.textProperty(),statuswert,converter);
        this.result.add(label, currentColIndex, currentRowIndex);
        this.result.add(label2, currentColIndex + 3, currentRowIndex);
        this.result.add(progressBar, currentColIndex + 1, currentRowIndex, 2, 1);
        currentRowIndex++;
        return this;
    }




    public Map<String, TextInputControl> getControls() {
        return this.controls;
    }

    public Formbuilder addEmptyRow() {
        currentRowIndex++;
        return this;
    }

    public Formbuilder addButton(EventHandler<ActionEvent> handler, String buttonLabel) {
        Button button = new Button(buttonLabel);
        button.setOnAction(handler);
        button.setPrefSize(300,8);
        final int finalRowIndex = 2;
        if (currentRowIndex <= maxNumberRows) {
            this.result.add(button, currentColIndex, currentRowIndex);
            currentRowIndex++;
        } else {
            this.result.add(button, ++currentColIndex, currentRowIndex = finalRowIndex);
            currentRowIndex++;
        }

        return this;
    }

    public GridPane build() {
        return result;
    }

    private GridPane creatingGrid() {
        GridPane newGrid = new GridPane();


        for (int i = 0; i < maxNumberColumns; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(maxNumberCR / maxNumberColumns);
            newGrid.getColumnConstraints().add(col);
        }
        for (int i = 0; i < maxNumberRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(8);
            newGrid.getRowConstraints().add(row);
        }
        newGrid.setHgap(10);
        newGrid.setVgap(10);
        newGrid.setPadding(new Insets(20, 20, 20, 30));
        return newGrid;
    }
}



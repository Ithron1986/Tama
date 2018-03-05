import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class UiUtils {
    private static int maxNumberCR = 100;


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
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class HW3 extends Application {
    public void start(Stage primaryStage) {
        double n = 450;
        Pane pane = new Pane();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                Rectangle cell = new Rectangle(50*i, 50*j, 50, 50);
                if ((i + j) % 2 == 0) {
                    cell.setFill(Color.WHITE);
                }
                else cell.setFill(Color.BLACK);
                pane.getChildren().add(cell);
            }
        }
        Scene scene = new Scene(pane, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
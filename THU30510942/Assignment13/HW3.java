import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HW3 extends Application {
    public void start (Stage primaryStage) {
        Pane pane = new Pane();
        Text t = new Text();
        pane.getChildren().add(t);
        Scene scene = new Scene(pane, 400, 300);
        pane.setOnMouseClicked(e -> {
            t.setX(e.getX());
            t.setY(e.getY());
            t.setText("(" + e.getX() + ", " + e.getY() + ")");
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HW1 extends Application {
    double angle = 0;
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Rectangle rec = new Rectangle(50, 150);
        rec.setFill(Color.WHITE);
        rec.setStroke(Color.BLACK);
        pane.getChildren().add(rec);
        Button but = new Button("Rotate");
        but.setOnAction(e -> {
            angle += 15;
            rec.setRotate(angle);
        });
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(pane);
        mainPane.setBottom(but);
        BorderPane.setAlignment(but, Pos.CENTER);
        Scene scene = new Scene(mainPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main (String[] args) {
        launch(args);
    }
}
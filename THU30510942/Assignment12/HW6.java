import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HW6 extends Application {
    public void start(Stage primaryStage) {
        double width = 400;
        double height = 400;
        double radius = 150;
        double x = width / 2;
        double y = height / 2;
        Pane pane = new Pane();
        Circle c = new Circle(x, y, radius);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        pane.getChildren().add(c);
        double[] angles = new double[5];
        for (int i = 0; i < 5; ++i) {
            angles[i] = Math.random() * 2 * Math.PI;
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = i + 1; j < 5; ++j) {
                if (angles[j] < angles[i]) {
                    double temp = angles[i];
                    angles[i] = angles[j];
                    angles[j] = temp;
                }
            }
        }
        Line[] lines = new Line[5];
        for (int i = 0; i < 5; ++i) {
            if (i < 4)
                lines[i] = new Line(x + radius * Math.cos(angles[i]), y + radius * Math.sin(angles[i]), x + radius * Math.cos(angles[i + 1]), y + radius * Math.sin(angles[i + 1]));
            else 
                lines[i] = new Line(x + radius * Math.cos(angles[i]), y + radius * Math.sin(angles[i]), x + radius * Math.cos(angles[0]), y + radius * Math.sin(angles[0]));
            pane.getChildren().add(lines[i]);
        }
        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
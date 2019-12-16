import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HW5 extends Application {
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Rectangle rec = new Rectangle(25, 25, 200, 200);
        rec.setFill(Color.GREEN);
        Text text = new Text("GO");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Times New Roman", 60));
        pane.getChildren().addAll(rec, text);
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
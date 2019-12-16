import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HW2 extends Application {
    public void start(Stage primaryStage) {
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        Font f = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);
        for (int i = 0; i < 5; ++i) {
            Text t = new Text("Java");
            t.setRotate(90);
            t.setFont(f);
            Color randomColor = new Color(Math.random(),Math.random(),Math.random(),Math.random());
            t.setFill(randomColor);
            pane.getChildren().add(t);
        }
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
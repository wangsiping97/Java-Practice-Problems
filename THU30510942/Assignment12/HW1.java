import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class HW1 extends Application {
    public void start(Stage primaryStage) throws Exception {
        Image X = new Image("image/x.gif");
        Image O = new Image("image/o.gif");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int label = (int)(Math.random()*3);
                if (label == 1) pane.add(new ImageView(X), i, j); 
                if (label == 2) pane.add(new ImageView(O), i, j);
            }
        }
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main (String[] args) {
        launch(args);
    }
}
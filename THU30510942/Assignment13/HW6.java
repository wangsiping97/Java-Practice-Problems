import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HW6 extends Application {
    int index = 0;
    
    public void start(Stage primaryStage) {
        Image[] imgs = new Image[25];
        for (int i = 0; i < 25; ++i) {
            imgs[i] = new Image("slides/slide" + i + ".jpg");
        }
        ImageView image = new ImageView(imgs[0]);
        StackPane pane = new StackPane();
        pane.getChildren().add(image);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            index ++;
            index = index % 25;
            image.setImage(imgs[index]);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        pane.setOnMouseClicked(e -> {
            if (timeline.getStatus() == Animation.Status.PAUSED) timeline.play();
            else timeline.pause();
        });

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}
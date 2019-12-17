import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HW5 extends Application {
    double r;
    double w;
    double h;
    double angle;
    int speed;
    public void setWidth (double _w) {
        w = _w;
    }
    public void setHeight (double _h) {
        h = _h;
    }
    public void setRadius (double _r) {
        r = _r;
    }
    public void setSpeed(int _s) {
        speed = _s;
    }

    public void start (Stage primaryStage) {
        setWidth(200);
        setHeight(200);
        setRadius(50);
        setSpeed(10);
        angle = 0;
        BorderPane pane = new BorderPane();
        
        Pane fan = new Pane();
        Circle c = new Circle(w/2, h/2, r);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        fan.getChildren().add(c);
        Arc[] arcs = new Arc[4];
        for (int i = 0; i < 4; ++i) {
            arcs[i] = new Arc(w/2, h/2, r * 0.9, r * 0.9, angle + i * 90, 30);
            arcs[i].setFill(Color.RED);
            arcs[i].setType(ArcType.ROUND);
            fan.getChildren().add(arcs[i]);
        }

        HBox butPane = new HBox(5);
        butPane.setAlignment(Pos.CENTER);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reverse");
        butPane.getChildren().addAll(pause, resume, reverse);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            angle += speed;
            for (int i = 0; i < 4; ++i) {
                arcs[i].setStartAngle(angle + i * 90);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        pause.setOnAction(e -> timeline.pause());
        resume.setOnAction(e -> timeline.play());
        reverse.setOnAction(e -> {
            setSpeed(-speed);; 
        });

        pane.setCenter(fan);
        pane.setBottom(butPane);

        Scene scene = new Scene(pane, w, h + 50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.animation.KeyFrame;
import javafx.util.Duration;


public class TableBall extends Application {
    Table table;
    int speed = 50;
    public Timeline animation;
    public void start (Stage primaryStage) {
        table = new Table(500, 300, speed);
        animation = new Timeline(new KeyFrame(Duration.millis(100), e -> table.moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        table.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                table.removeLine();
                animation.play();
            }
        });
        Scene scene = new Scene(table, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class Table extends Pane {
        public Circle ball = new Circle();
        public Circle holes[] = new Circle[6];
        public Rectangle rec;
        public Line direction = new Line();

        int theta = 0;
        int speed;
        public Table (int width, int height, int _speed) {
            speed = _speed;
            setWidth(width);
            setHeight(height);
            rec = new Rectangle(0, 0, width, height);
            rec.setFill(Color.GREEN);
            getChildren().add(rec);
            for (int i = 0; i < 3; ++i) {
                holes[i] = new Circle(i * getWidth() / 2, 0, getHeight() / 15);
                holes[i].setFill(Color.BLACK);
                getChildren().add(holes[i]);
            }
            for (int i = 3; i < 6; ++i) {
                holes[i] = new Circle((i - 3) * getWidth()/2, getHeight(), getHeight() / 15);
                holes[i].setFill(Color.BLACK);
                getChildren().add(holes[i]);
            }
            ball.setFill(Color.WHITE);
            ball.setRadius(getHeight()/20);
            ball.setCenterX(width/4);
            ball.setCenterY(height/2);
            ball.setFocusTraversable(true);
            direction.setStartX(ball.getCenterX());
            direction.setStartY(ball.getCenterY());
            direction.setEndX(ball.getCenterX() + 100);
            direction.setEndY(ball.getCenterY());
            direction.setFocusTraversable(true);
            direction.setOnKeyPressed(e -> { 
                if (e.getCode() == KeyCode.UP) {
                    this.theta = (360 + this.theta - 10) % 360;
                    direction.setEndX(width/4 + 100 * Math.cos(theta * Math.PI / 180));
                    direction.setEndY(height/2 + 100 * Math.sin(theta * Math.PI / 180));
                }
                else if (e.getCode() == KeyCode.DOWN) {
                    this.theta = (360 + this.theta + 10) % 360;
                    direction.setEndX(width/4 + 100 * Math.cos(theta * Math.PI / 180));
                    direction.setEndY(height/2 + 100 * Math.sin(theta * Math.PI / 180));
                }
            });
            direction.setStroke(Color.BLACK);
            getChildren().add(direction);
            getChildren().add(ball);
        }
        public void collide() {
            if (ball.getCenterX() >= rec.getWidth() - ball.getRadius() && (theta <= 90 || theta >= 270)) {
                theta = (360 + 180 - theta) % 360;
                speed -= 5;
            }
            if (ball.getCenterX() <= ball.getRadius() && (theta >= 90 && theta <= 270)) {
                theta = (360 + 180 - theta) % 360;
                speed -= 5;
            }
            if (ball.getCenterY() >= rec.getHeight() - ball.getRadius() && (theta <= 180)) {
                theta = (360 - theta) % 360;
                speed -= 5;
            }
            if (ball.getCenterY() <= ball.getRadius() && (theta >= 180)) {
                theta = (360 - theta) % 360;
                speed -= 5;
            }
            for (int i = 0; i < 6; ++i) {
                if (dist(ball.getCenterX(), ball.getCenterY(), holes[i].getCenterX(), holes[i].getCenterY()) <= holes[i].getRadius()) {
                    ball.setOpacity(0);
                    animation.pause();
                }
            }
        }
        public void moveBall() {
            if (speed > 0) {
                ball.setCenterX(ball.getCenterX() + speed * Math.cos(theta * Math.PI / 180));
                ball.setCenterY(ball.getCenterY() + speed * Math.sin(theta * Math.PI / 180));
                collide();
            }
        }
        public void removeLine() {
            getChildren().remove(direction);
        }
        public void removeBall() {
            getChildren().remove(ball);
        }
        public double dist(double x1, double y1, double x2, double y2) {
            return Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
        }
    }

    public static void main (String[] args) {
        launch(args);
    }
}
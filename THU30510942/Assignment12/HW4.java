import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HW4 extends Application {
    public void start(Stage primaryStage) {
        double para1 = 0.2;
        double para2 = 0.2;
        double para3 = 0.1;
        
        Pane pane = new Pane();
        Ellipse top = new Ellipse(); 
        top.centerXProperty().bind(pane.widthProperty().multiply(0.5));
		top.centerYProperty().bind(pane.heightProperty().multiply(para1));
		top.radiusXProperty().bind(pane.widthProperty().multiply(para2));
        top.radiusYProperty().bind(pane.heightProperty().multiply(para3));
        top.setFill(Color.WHITE);
		top.setStroke(Color.BLACK);
        Ellipse bot = new Ellipse();
        bot.centerXProperty().bind(top.centerXProperty());
		bot.centerYProperty().bind(pane.heightProperty().multiply(1 - para1));
		bot.radiusXProperty().bind(top.radiusXProperty());
        bot.radiusYProperty().bind(top.radiusYProperty());
        bot.setFill(Color.WHITE);
		bot.setStroke(Color.BLACK);
        Line left = new Line();	
        left.startXProperty().bind(pane.widthProperty().multiply(0.5 - para2));
		left.startYProperty().bind(top.centerYProperty());
		left.endXProperty().bind(left.startXProperty());
		left.endYProperty().bind(bot.centerYProperty());
        Line right = new Line();
        right.startXProperty().bind(pane.widthProperty().multiply(0.5 + para2));
		right.startYProperty().bind(top.centerYProperty());
		right.endXProperty().bind(right.startXProperty());
		right.endYProperty().bind(bot.centerYProperty());
		pane.getChildren().addAll(top, bot, left, right);
		Scene scene = new Scene(pane, 100, 100);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
    }
}
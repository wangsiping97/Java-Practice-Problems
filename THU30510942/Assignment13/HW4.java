import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HW4 extends Application {
    int speed;
    public void setSpeed (int _speed) {
        speed = _speed;
    }
    public void start(Stage primaryStage) {   
        setSpeed(10);  
		Pane pane = new Pane();
		Circle c = new Circle(20, 20, 20);
		pane.getChildren().add(c);
    
		c.setFocusTraversable(true);
		c.setOnKeyPressed(e -> { 
			if (e.getCode() == KeyCode.UP) {
				c.setCenterY(c.getCenterY() - speed); 
			}
			else if (e.getCode() == KeyCode.DOWN) {
				c.setCenterY(c.getCenterY() + speed); 
			}
			else if (e.getCode() == KeyCode.LEFT) {
				c.setCenterX(c.getCenterX() - speed); 
			}
			else if (e.getCode() == KeyCode.RIGHT) {
				c.setCenterX(c.getCenterX() + speed); 
			}
		});
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}

    public static void main (String[] args) {
        launch(args);
    }
}
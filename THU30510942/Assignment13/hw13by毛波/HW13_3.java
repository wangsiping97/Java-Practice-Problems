package hw13by毛波;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HW13_3 extends Application {  
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create UI
		Pane pane = new Pane();
		Text text = new Text();
		pane.getChildren().add(text);
    
		pane.setOnMousePressed(e -> {
			text.setX(e.getX());
			text.setY(e.getY());
			text.setText("(" + e.getX() + ", " + e.getY() + ")");
		});
    
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 250);
		primaryStage.setTitle("Exercise15_08"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}
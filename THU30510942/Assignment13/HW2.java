import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HW2 extends Application {
    public void start(Stage primaryStage) {
        HBox hbox = new HBox(2);
        TextField num1 = new TextField();
        TextField num2 = new TextField();
        TextField result = new TextField();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(new Label("Number1: "), num1, new Label("Number2: "), num2, new Label("Result: "), result);

        HBox buts = new HBox(5);
        Button add = new Button("Add");
        Button sub = new Button("Subtract");
        Button mul = new Button("Multiply");
        Button div = new Button("Divide");
        buts.setAlignment(Pos.CENTER);
        buts.getChildren().addAll(add, sub, mul, div);

        add.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) + Double.parseDouble(num2.getText()) + "");
        });
        sub.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) - Double.parseDouble(num2.getText()) + "");
        });
        mul.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText()) + "");
        });
        div.setOnAction(e -> {
            result.setText(Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText()) + "");
        });

        BorderPane pane = new BorderPane();
        pane.setCenter(hbox);
        pane.setBottom(buts);
        BorderPane.setAlignment(buts, Pos.CENTER);
        Scene scene = new Scene(pane, 700, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}
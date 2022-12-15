
package ElevatorGame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ElevatorMusic {
    
    public static void button() {
        
        Stage window2 = new Stage();
        VBox whole = new VBox(30);
        
        Label text = new Label("YOU CAN'T STOP THE ELEVATOR MUSIC");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 12));
        
        Button back = new Button("go back");
        back.setOnAction(e -> window2.close());
        
        whole.getChildren().addAll(text, back);
        whole.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(whole, 300, 300);
        
        window2.setScene(scene);
        window2.setTitle("Stopping the elevator music");
        window2.show();
        
    }
    
}

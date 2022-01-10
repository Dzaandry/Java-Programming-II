package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    
    public void start(Stage stage) {
        TicTacToe ticTacToe = new TicTacToe();
        Font monospaced = Font.font("Monospaced", 40);
        
        BorderPane layout = new BorderPane();
        Label gameState = new Label("Turn: " + ticTacToe.getTurn());
        gameState.setFont(monospaced);
        layout.setTop(gameState);
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                Button btn = new Button(ticTacToe.status(x, y));
                btn.setFont(monospaced);
                grid.add(btn, x, y);
                
                int rx = x;
                int ry = y;
                btn.setOnAction((event) -> {
                   ticTacToe.place(rx, ry); 
                   btn.setText(ticTacToe.status(rx, ry));
                   gameState.setText("Turn: " + ticTacToe.getTurn());
                   
                   if (ticTacToe.gameEnded()) {
                       gameState.setText("The end!");
                   }
                });
            }
        }
        layout.setCenter(grid);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}

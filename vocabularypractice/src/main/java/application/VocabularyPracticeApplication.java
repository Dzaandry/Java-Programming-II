package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {
    
    private Dictionary dictionary;
    
    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }
    
    public void start(Stage stage) {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        BorderPane layout = new BorderPane();
        HBox hbox = new HBox();
        Button enter = new Button("Enter new words");
        Button practice = new Button("Practice");
        
        hbox.setSpacing(10);
        hbox.getChildren().addAll(enter, practice);
        layout.setTop(hbox);
        
        enter.setOnAction((event) -> layout.setCenter(inputView.getView()));
        practice.setOnAction((event) -> layout.setCenter(practiceView.getView()));
        
        layout.setCenter(inputView.getView());
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}

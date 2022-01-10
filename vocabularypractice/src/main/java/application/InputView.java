package application;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private Dictionary dictionary;
    
    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    
    public Parent getView() {
        Label wordLabel = new Label("Word");
        TextField wordField = new TextField();
        Label translationLabel = new Label("Translation");
        TextField transField = new TextField();
        Button addButton = new Button("Add the word pair");
        
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.add(wordLabel, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationLabel, 0, 2);
        layout.add(transField, 0, 3);
        layout.add(addButton, 0, 4);
        
        addButton.setOnAction((event) -> {
            this.dictionary.add(wordField.getText(), transField.getText());
            wordField.clear();
            transField.clear();
        });
        
        return layout;
    }
}


package application;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private Dictionary dictionary;
    private String word;
    
    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.randomWord();
    }
    
    public Parent getView() {
        Label instruction = new Label("Translate the word '" + this.word + "'");
        TextField practiceField = new TextField();
        Button transButton = new Button("Check");
        Label feedback = new Label("");
        
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        
        layout.add(instruction, 0, 0);
        layout.add(practiceField, 0, 1);
        layout.add(transButton, 0, 2);
        layout.add(feedback, 0, 3);
        
        transButton.setOnMouseClicked((event) -> {
           String translation = practiceField.getText();
           if (translation.equals(this.dictionary.getTranslation(this.word))) {
               feedback.setText("Correct!");
               this.word = this.dictionary.randomWord();
               practiceField.clear();
               instruction.setText("Translate the word '" + this.word + "'");
           } else {
               feedback.setText("Incorrect! the correct translation for the word '" + this.word + "' is '" +
                       this.dictionary.getTranslation(this.word) + "'");
               practiceField.clear();
           }
        });
        
        return layout;
    }
}

package keypad;
/**
 * File: csci1302/keypad/KeyPadPane.java
 * Package: keypad
 * @author Tyler Oneacre
 * Created on: Nov 13, 2024
 * Last Modified:  Nov 14, 2024
 * Description:  Extended GridPane that creates a KeyPad with either an ATM or phone-esque 
 * 			Button arrangement
 * Small change to trigger update
 */

package keypad;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class KeyPadCustomPane extends KeyPadPane {
    // New UI elements
    private TextField displayField;
    private Label instructionLabel;

    public KeyPadCustomPane() {
        super();
        setupCustomLayout();
    }

    // Customize the appearance and add new elements
    private void setupCustomLayout() {
        // Create a TextField to show button presses
        displayField = new TextField();
        displayField.setPromptText("Enter Code");
        displayField.setEditable(false);
        displayField.setFont(Font.font("Arial", 18));
        displayField.setStyle("-fx-background-color: lightgray; -fx-alignment: center;");

        // Create a Label for instructions
        instructionLabel = new Label("Enter the 4-digit code:");
        instructionLabel.setFont(Font.font("Arial", 16));
        instructionLabel.setTextFill(Color.DARKBLUE);

        // Arrange components in a vertical layout
        VBox layout = new VBox(10, instructionLabel, displayField, this);
        layout.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0;");
        getChildren().add(layout);
    }

    @Override
    protected void registerEventHandlers() {
        // Override event handlers 
        for (Button btn : listButtons) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String buttonText = btn.getText();

                    // Display button text in displayField
                    if (!buttonText.trim().isEmpty()) {
                        displayField.setText(displayField.getText() + buttonText);

                     //clear field if 4 digits are entered
                        if (displayField.getText().length() == 4) {
                            System.out.println("Code Entered: " + displayField.getText());
                            displayField.setText(""); // Reset for next input
                        }
                    }
                }
            });
        }
    }
}


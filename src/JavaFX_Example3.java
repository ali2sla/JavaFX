package org.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFX_Example3 extends Application {
    // Fields
    private Button clickMeButton;
    private int numberOfClicks = 0;
    private Label myLabel;

    // Methods
    private void clickMeButton_click() {
        // Increment click counter
        numberOfClicks = numberOfClicks + 1;
        System.out.println("You clicked the ClickME button " + numberOfClicks + " times.");
        // Update the text in the button to show click count
        clickMeButton.setText("Click Me " + numberOfClicks);
        myLabel.setText("HELLO " + numberOfClicks);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Write title to window
        primaryStage.setTitle("My Second UI App in Java");

        // Create a button UI element with text "Click Me"
        clickMeButton = new Button("Click Me");
        // tell button what method will get called when it is clicked
        clickMeButton.setOnAction(e->clickMeButton_click());

        // Create text UI element
        myLabel = new Label("Hello Students!  This is Mr. Hernandez.");

        // make a layout and add both button and text to it
        HBox myBoxLayout = new HBox();
        //VBox myBoxLayout = new VBox();
        myBoxLayout.getChildren().add(clickMeButton);
        myBoxLayout.getChildren().add(myLabel);

        // Fill 400x200 window with just that frame of UI Elements
        Scene scene = new Scene(myBoxLayout, 400, 200);
        primaryStage.setScene(scene);

        // Display the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

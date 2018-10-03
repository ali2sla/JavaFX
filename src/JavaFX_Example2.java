package org.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFX_Example2 extends Application {
    // Fields
    private Button clickMeButton;
    private int numberOfClicks = 0;

    // Methods
    public void clickMeButton_click() {
        // Increment click counter
        numberOfClicks = numberOfClicks + 1;
        System.out.println("You clicked the ClickME button " + numberOfClicks + " times.");
        // Update the text in the button to show click count
        clickMeButton.setText("Click Me " + numberOfClicks);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Write title to window
        primaryStage.setTitle("My Second UI App in Java");

        // Create a button UI element with text "Click Me"
        clickMeButton = new Button("Click Me");
        // tell button what method will get called when it is clicked
        clickMeButton.setOnAction(e->clickMeButton_click());

        // make a frame and add only the button UI element to it
        StackPane myUIFrame = new StackPane();
        myUIFrame.getChildren().add(clickMeButton);

        // Fill 400x200 window with just that frame of UI Elements
        Scene scene = new Scene(myUIFrame, 400, 200);
        primaryStage.setScene(scene);

        // Display the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

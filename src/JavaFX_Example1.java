package org.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JavaFX_Example1 extends Application {

    //@Override
    public void start(Stage primaryStage) throws Exception {
        // Write window's title
        primaryStage.setTitle("My First UI App in Java");

        // Create text UI element
        Label label = new Label("Hello Students!  This is Mr. Hernandez.");

        // Put text UI element into the window
        Scene scene = new Scene(label, 800, 200);
        primaryStage.setScene(scene);

        // Display the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

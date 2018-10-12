import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javax.swing.*;
import javafx.scene.control.ToggleGroup;
import java.awt.event.ActionEvent;


public class JavaFX extends Application {

    ToggleGroup answer;
    int v = 0;
    RadioButton Bulbasaur, Squirtle, Charmander, Pikachu, Eevee;
    Scene scene;
    ImageView myImageView;

    // Adds a list of links to the VBox for the left region
    private void addVerticalListOfLinks(VBox vbox) {

        Text title = new Text("Professor Oak: What Pokemon do you want to choose?");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        answer = new ToggleGroup();
        Bulbasaur = new RadioButton("Bulbasaur");
        Bulbasaur.setUserData("bulbasaur");
        Bulbasaur.setToggleGroup(answer);

        Squirtle = new RadioButton("Squirtle");
        Squirtle.setUserData("squirtle");
        Squirtle.setToggleGroup(answer);

        Charmander = new RadioButton("Charmander");
        Charmander.setUserData("charmander");
        Charmander.setToggleGroup(answer);

        Pikachu = new RadioButton("Pikachu");
        Pikachu.setUserData("pikachu");
        Pikachu.setToggleGroup(answer);

        Eevee = new RadioButton("Eevee");
        Eevee.setUserData("eevee");
        Eevee.setToggleGroup(answer);

        vbox.getChildren().addAll(Bulbasaur, Squirtle, Charmander, Pikachu, Eevee);
    }

    // Update picture
    private void updatePicture() {
        System.out.println(answer.getSelectedToggle());
        System.out.println(answer.getSelectedToggle().getUserData().toString() + ".png");
        myImageView.setImage(new Image( answer.getSelectedToggle().getUserData().toString() + ".png"));
    }

    void selectPicture(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage).getAbsolutePath();
        // myImageView.setImage(new Image());
    }

    // Adds Save/Cancel buttons to the hbox
    private void addSaveCancelButtons(HBox hb, Stage stage) {
        Button buttonSave = new Button("Save");
        buttonSave.setOnAction(e->updatePicture());
        Button buttonSelect = new Button("Select");
        buttonSelect.setOnAction(e->selectPicture(stage));
        Button buttonCancel = new Button("Cancel");
        hb.getChildren().addAll(buttonSave, buttonSelect, buttonCancel);
    }

    // Adds 8 icons to a tile pane
    private void Pokemon(TilePane tile) {
        myImageView = new ImageView(new Image("bulbasaur.png"));
            tile.getChildren().add(myImageView);
    }

    @Override
    public void start(Stage stage) {

        // Use a BorderPane as the root for scene
        // A border pane has 5 regions to put controls: Top, Bottom, Left, Right, and Center
        BorderPane border = new BorderPane();

        //////// HBox in Top Region ///// BEGIN ///////////////////////////////////////////////
        // HBox lays out controls in a row (horizontally) in order added from left to right
        // Create an HBox for the buttons and help icon in the Top region of the BorderPane
        HBox topHBox = new HBox();
        // Configure padding and spacing of controls in this HBox
        topHBox.setPadding(new Insets(15, 12, 15, 12)); // Set all sides' padding
        topHBox.setSpacing(10);                                                // Gap between nodes
        topHBox.setStyle("-fx-background-color: #336699;");                    // Change background color


        // Set the Top region of the BorderPane to be this HBox
        border.setTop(topHBox);
        //////// HBox in Top Region ///// END ///////////////////////////////////////////////

        //////// VBox in Left Region ///// BEGIN ///////////////////////////////////////////////
        // VBox lays out controls in a column (vertically) in order added from top to bottom
        // Create a VBox for the 5 links in the Left region of the BorderPane
        VBox leftVBox = new VBox();
        // Configure padding and spacing of controls in this VBox
        leftVBox.setPadding(new Insets(10)); // Set all sides' padding to 10
        leftVBox.setSpacing(8);                               // Gap between nodes

        // Add the 5 links to the VBox
        addVerticalListOfLinks(leftVBox);

        // Set the Left region of the BorderPane to be this VBox
        border.setLeft(leftVBox);
        //////// VBox in Left Region ///// END  ///////////////////////////////////////////////

        //////// AnchorPane in Center Region /////// BEGIN  ///////////////////////////////////////////////
        // AnchorPane lays out controls in both top/bottom/right/left regions, while anchoring them in place
        // Create AnchorPane that will contain labels, pie charts and save/cancel buttons
        AnchorPane centerAnchorPane = new AnchorPane();

        // GridPane lays out controls in a grid where controls can take up 1 or multiple cells in grid
        GridPane centerTopGrid = new GridPane();
        // Configure the gaps/padding between cells in grid
        centerTopGrid.setHgap(10);
        centerTopGrid.setVgap(10);
        centerTopGrid.setPadding(new Insets(0, 10, 0, 10));
        // Tell the grid to draw its grid lines for educational purposes
        centerTopGrid.setGridLinesVisible(false);

        // HBox will layout Save/Cancel buttons horizontally
        HBox saveCancelButtonsHBox = new HBox();
        // Configure the spacing/padding between controls in HBox
        saveCancelButtonsHBox.setPadding(new Insets(0, 10, 10, 10));
        saveCancelButtonsHBox.setSpacing(10);
        // Add the Save/Cancel buttons to the hbox
        addSaveCancelButtons(saveCancelButtonsHBox, stage);

        // Add the grid and the hbox to AnchorPane
        centerAnchorPane.getChildren().addAll(centerTopGrid, saveCancelButtonsHBox);
        // Anchor grid to top
        AnchorPane.setTopAnchor(centerTopGrid, 10.0);
        // Anchor buttons to bottom right anchor
        AnchorPane.setBottomAnchor(saveCancelButtonsHBox, 8.0);
        AnchorPane.setRightAnchor(saveCancelButtonsHBox, 5.0);

        // Set the Center region of the BorderPane to be this AnchorPane
        border.setCenter(centerAnchorPane);
        //////// AnchorPane in Center Region /////// END ///////////////////////////////////////////////


        //////// TilePane in Right Region /////// BEGIN ////////////////////////////////////////////////
        // Create TilePane that lays out controls in simple grid
        TilePane rightTilePane = new TilePane();
        // Indicate to TilePane that it will have 2 columns per row
        rightTilePane.setPrefColumns(2);
        // Configure the gaps/padding between tiles in grid
        rightTilePane.setPadding(new Insets(5, 0, 5, 0));
        rightTilePane.setVgap(4);
        rightTilePane.setHgap(4);
        // Change background color of tile grid
        rightTilePane.setStyle("-fx-background-color: DAE6F3;");

        // Add 8 icons to TilePane; since column preference is 2, the 8 icons will take 4 rows
        Pokemon(rightTilePane);

        // Set the Right region of the BorderPane to be this TilePane
        border.setRight(rightTilePane);
        //////// TilePane in Right Region /////// END ///////////////////////////////////////////////

        //////// Display the Scene ///// BEGIN  ///////////////////////////////////////////////
        // Make a Scene from the BorderPane
        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("Pokemon Selection");
        stage.show();
        //////// Display the Scene ///// END  ///////////////////////////////////////////////
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

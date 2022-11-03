package keypad;

/* 
 * Author: Joseph Berrigan
 * Date: 11/2/2022
 * Assignment #7
 * Name: PAssign07.java
 * Course: CSCI 1302
 * Description: ATM with keypad with JavaFX 
 * Hello world repository is https://github.com/joeberr11/hello-world
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PAssign07 extends Application {
	public void start(Stage primaryStage) {
		BorderPane mainPane = new BorderPane();

		// create a KeyPadPane
		ATMKeyPad keyPane = new ATMKeyPad(); // using custom version

		// Top Stuff
		StackPane spTitle = new StackPane();
		Label lbTitle = new Label("CoolBank ATM");
		lbTitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 15));
		Rectangle rcTitle = new Rectangle(160, 40);
		rcTitle.setStyle("-fx-fill: lightblue; -fx-stroke: lightsteelblue; -fx-stroke-width: 8");
		spTitle.getChildren().addAll(rcTitle, lbTitle);
		spTitle.setAlignment(Pos.CENTER);
		spTitle.setPadding(new Insets(10));

		// Right Stuff
		VBox vboxRight = new VBox(10);
		Button btRight1 = new Button();
		btRight1.setPrefWidth(30);
		Button btRight2 = new Button();
		btRight2.setPrefWidth(30);
		Button btRight3 = new Button();
		btRight3.setPrefWidth(30);
		Button btRight4 = new Button();
		btRight4.setPrefWidth(30);
		vboxRight.getChildren().addAll(btRight1, btRight2, btRight3, btRight4);

		vboxRight.setStyle("-fx-alignment: center-right;");
		vboxRight.setPrefWidth(60);
		vboxRight.setPadding(new Insets(7));

		// Left Stuff
		VBox vboxLeft = new VBox(10);
		Button btLeft1 = new Button();
		btLeft1.setPrefWidth(30);
		Button btLeft2 = new Button();
		btLeft2.setPrefWidth(30);
		Button btLeft3 = new Button();
		btLeft3.setPrefWidth(30);
		Button btLeft4 = new Button();
		btLeft4.setPrefWidth(30);
		vboxLeft.getChildren().addAll(btLeft1, btLeft2, btLeft3, btLeft4);

		vboxLeft.setStyle("-fx-alignment: center-left;");
		vboxLeft.setPrefWidth(60);
		vboxLeft.setPadding(new Insets(7));

		// Center Stuff
		StackPane screen = new StackPane();
		HBox hbScreen = new HBox();
		Rectangle rcScreen = new Rectangle(450, 200);

		screen.getChildren().addAll(rcScreen, vboxLeft, vboxRight);
		screen.setAlignment(Pos.CENTER);
		hbScreen.getChildren().add(screen);
		rcScreen.setStyle("-fx-fill: gray; -fx-stroke: lightsteelblue; -fx-stroke-width: 40;");
		hbScreen.setAlignment(Pos.CENTER);
		// Bottom Stuff
		HBox hboxBottom = new HBox();
		VBox vboxBottom = new VBox(5);
		StackPane bottom = new StackPane();
		Button btGreen = new Button("O");
		Button btYellow = new Button("|");
		Button btRed = new Button("X");
		Button btBlank = new Button();

		bottom.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		bottom.setStyle("-fx-alignment: top-center");
		hboxBottom.setAlignment(Pos.CENTER);
		vboxBottom.setPadding(new Insets(0, 5, 0, 5));

		btRed.setPrefWidth(45);
		btRed.setStyle("-fx-background-color: crimson  ");
		btRed.setOnMouseMoved(e -> btRed.setStyle("-fx-background-color: tomato "));
		btRed.setOnMouseExited(e -> btRed.setStyle("-fx-background-color: crimson  "));

		btYellow.setPrefWidth(45);
		btYellow.setStyle("-fx-background-color: gold");
		btYellow.setOnMouseMoved(e -> btYellow.setStyle("-fx-background-color: YELLOW"));
		btYellow.setOnMouseExited(e -> btYellow.setStyle("-fx-background-color: gold"));

		btGreen.setPrefWidth(45);
		btGreen.setStyle("-fx-background-color: GREEN");
		btGreen.setOnMouseMoved(e -> btGreen.setStyle("-fx-background-color: darkseagreen"));
		btGreen.setOnMouseExited(e -> btGreen.setStyle("-fx-background-color: GREEN"));

		btBlank.setPrefWidth(45);
		btBlank.setStyle("-fx-background-color: gainsboro");
		btBlank.setOnMouseMoved(e -> btBlank.setStyle("-fx-background-color: darkgray"));
		btBlank.setOnMouseExited(e -> btBlank.setStyle("-fx-background-color: gainsboro"));

		vboxBottom.getChildren().add(btRed);
		vboxBottom.getChildren().add(btYellow);
		vboxBottom.getChildren().add(btGreen);
		vboxBottom.getChildren().add(btBlank);

		hboxBottom.getChildren().addAll(keyPane, vboxBottom);
		hboxBottom.setStyle("-fx-border-width: 5; -fx-border-color: lightsteelblue");
		hboxBottom.setMaxWidth(200);
		hboxBottom.setPadding(new Insets(15));
		bottom.getChildren().add(hboxBottom);

		// add KeyPane to BorderPane
		mainPane.setTop(spTitle);
		mainPane.setCenter(hbScreen);
		mainPane.setBottom(bottom);

		// create your scene (400 x 400 to clearly show KeyPadPane)
		Scene scene = new Scene(mainPane, 540, 500);

		primaryStage.setTitle("ATM CoolBank"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		// primaryStage.setResizable(false);

		screen.requestFocus();
	}

	class ATMKeyPad extends KeyPadPane {
		public ATMKeyPad() {
			btnBlank1.setText("<-");
			btnBlank2.setText("->");
			this.setVgap(5);
			this.setHgap(5);

			int counter = 0;

			// place all buttons in 1-9, blank, 0, blank order, 3 per row
			for (int i = 0; i < listButtons.size() / 3; i++) {
				for (int j = 0; j < 3; j++) {

					Button temp = listButtons.get(counter);
					temp.setOnMouseMoved(e -> temp.setStyle("-fx-background-color: darkgray"));
					temp.setOnMouseExited(e -> temp.setStyle("-fx-background-color: gainsboro"));
					temp.setStyle("-fx-background-color: gainsboro");
					temp.setPrefWidth(30);
					counter++;

				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

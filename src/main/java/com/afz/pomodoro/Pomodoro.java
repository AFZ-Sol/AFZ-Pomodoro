package com.afz.pomodoro;

import com.afz.pomodoro.constants.AppConstants;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Pomodoro extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/gui/Pomodoro.fxml").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle(AppConstants.APP_TITLE);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}

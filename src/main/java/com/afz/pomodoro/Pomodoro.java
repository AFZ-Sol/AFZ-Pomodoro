package com.afz.pomodoro;

import com.afz.pomodoro.constants.AppConstants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pomodoro extends Application {

    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Pomodoro.fxml"));

            Scene scene = new Scene(root, 450, 300);

            primaryStage.setTitle(AppConstants.APP_TITLE);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}

package xyz.yuxiangz.jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirm");
            alert.setHeaderText("logout");
            alert.setContentText("Are you sure");
            Optional<ButtonType> buttonType = alert.showAndWait();
            buttonType.ifPresent(consumer -> {
                if (ButtonType.OK == buttonType.get()) {
                    System.exit(1);
                } else {
                    event.consume(); // stop propagation
                }
            });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

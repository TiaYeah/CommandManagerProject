package ru.tiayeah.commandmanagerproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    IMatrix startMatrix;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        startMatrix = new OrdinaryMatrix(3, 3);
        ICommand initCommand = new initCommand(startMatrix);
        initCommand.execute();

        HelloController controller = fxmlLoader.getController();
        controller.setMatrix(startMatrix);
    }

    public IMatrix getStartMatrix() {
        return startMatrix;
    }

    public static void main(String[] args) {
        launch();
    }
}
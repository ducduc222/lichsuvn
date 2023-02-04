package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Tạo vùng trên
        HBox top = new HBox();
        top.setMinHeight(50);
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-background-color: lightgray;");
        root.setTop(top);

        // Tạo vùng dưới
        HBox bottom = new HBox();
        bottom.setMinHeight(50);
        bottom.setAlignment(Pos.CENTER);
        bottom.setStyle("-fx-background-color: lightgray;");
        root.setBottom(bottom);

        // Tạo vùng trái
        VBox left = new VBox();
        left.setMinWidth(100);
        left.setAlignment(Pos.CENTER);
        left.setStyle("-fx-background-color: lightgray;");
        root.setLeft(left);

        // Tạo vùng phải
        VBox right = new VBox();
        right.setMinWidth(100);
        right.setAlignment(Pos.CENTER);
        right.setStyle("-fx-background-color: lightgray;");
        root.setRight(right);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

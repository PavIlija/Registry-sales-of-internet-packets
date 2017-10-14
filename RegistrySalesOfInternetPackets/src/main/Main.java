
package main;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    private double dragOffsetX;
    private double dragOffsetY;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlUrl=getClass().getClassLoader().getResource("view/choose_packet.fxml");
        GridPane root =FXMLLoader.<GridPane>load(fxmlUrl);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene= new Scene(root);
        
        scene.getStylesheets().add("view/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //pomeranje cele applikacije na ekranu
        
        scene.setOnMousePressed((MouseEvent event) -> {
            dragOffsetX=event.getScreenX()-primaryStage.getX();
            dragOffsetY=event.getScreenY()-primaryStage.getY();
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX()-dragOffsetX);
            primaryStage.setY(event.getScreenY()-dragOffsetY);
        });
    }
 
}

package application;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

 
public class Main extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
    	final String appName = "Szyfr Vigenere'a";
        Parent parent = (Parent)FXMLLoader.load(getClass().getResource("/view/MainPane.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle(appName);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
}

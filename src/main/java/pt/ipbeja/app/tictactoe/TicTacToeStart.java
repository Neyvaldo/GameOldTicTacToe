package pt.ipbeja.app.tictactoe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeStart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TicTacToeBoard board = new TicTacToeBoard();

        Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


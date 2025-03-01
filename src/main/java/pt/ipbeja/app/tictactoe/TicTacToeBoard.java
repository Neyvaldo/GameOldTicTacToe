package pt.ipbeja.app.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javax.lang.model.util.ElementScanner6;

public class TicTacToeBoard extends GridPane {

    static public final int SIZE = 3;
    //static boolean isX = true;

    public TicTacToeBoard()
    {
        this.createBoard();

    }

    private void createBoard ()
    {
        ImageView view  = new ImageView(new Image("/resources/noplaze.png"));
        ButtonHandler bHandler = new ButtonHandler();
        for (int line = 0; line < SIZE ; line++)
        {
            for (int col = 0; col < SIZE; col++)
            {
                Button btt = new Button();
                btt.setPrefSize(100,100);
                btt.setGraphic(view);
                btt.setOnAction(bHandler);
                this.add(btt, col, line);
            }
        }

    }
     static class ButtonHandler implements EventHandler<ActionEvent> {

         @Override
         public void handle(ActionEvent actionEvent)
         {
             Button getButtonClick = (Button) (actionEvent.getSource());
             String buttonClick = getButtonClick.getText();

             if (buttonClick.equals("X"))
             {
                 getButtonClick.setText("O");

             } else {
                 getButtonClick.setText("X");

             }
         }
     }
}

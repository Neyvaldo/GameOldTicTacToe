package pt.ipbeja.app.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.nio.file.Paths;

public class TicTacToeBoard extends GridPane {


     public final int SIZE = 3;     // Size fix grade 3x3

    static boolean isTurnX = true;

     /* Image of Player X  */
     static String urlX = Paths.get("/Users/neyvaldo/IdeaProjects/GameOldTicTacToe/src/main/resources/src/player1.png").toUri().toString();
     static Image imageX = new Image(urlX);

    /* Image of Player O  */
    static String urlO = Paths.get("/Users/neyvaldo/IdeaProjects/GameOldTicTacToe/src/main/resources/src/player2.png").toUri().toString();
    static Image imageO = new Image(urlO);

    /* Image Empty */
    static String urlEmpy = Paths.get("/Users/neyvaldo/IdeaProjects/GameOldTicTacToe/src/main/resources/src/noplayer.png").toUri().toString();
    static Image imageEmpty = new Image(urlEmpy);


    static int count = 0;

    public TicTacToeBoard()  // Constructor
    {
        this.createBoard();
    }

    /*
    * Create table of game tic-tac-toe with in grade of button
    * */
    private void createBoard ()
    {
        ButtonHandler bHandler = new ButtonHandler();
        for (int line = 0; line < SIZE ; line++)
        {
            for (int col = 0; col < SIZE; col++)
            {
                TicTacToeButton ticTacToeButton = new TicTacToeButton();
                ticTacToeButton.setPrefSize(200,200); // Size of button
                ticTacToeButton.setOnAction(bHandler);
                ImageView viewEmpty= new ImageView(imageEmpty);
                ticTacToeButton.setGraphic(viewEmpty);
                //this.add(ticTacToeButton, col, line); // Add button in grade
            }
        }
    }
    /*
    * Button que, despara ação quando é clicado
    * */
     static class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
         public void handle(ActionEvent actionEvent)
         {
             TicTacToeButton getButtonClick = (TicTacToeButton) (actionEvent.getSource());
             count++;
             //String buttonClick = getButtonClick.getText();

            if( !getButtonClick.isCancelButton())
            {
                if (isTurnX)
                {
                    ImageView viewX = new ImageView(imageX);
                    getButtonClick.setGraphic(viewX);

                } else
                {

                    ImageView viewO = new ImageView(imageO);
                    getButtonClick.setGraphic(viewO);
                }

                isTurnX = !isTurnX;
                getButtonClick.setDisable(true); // Desativa o botão quando ele é clicado

            }
            if(count == 9) // Verifica se todos os botoes foram clicados
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Over Game");
                alert.showAndWait();// Alerta a informar o termino do jogo
            }

         }
     }
}

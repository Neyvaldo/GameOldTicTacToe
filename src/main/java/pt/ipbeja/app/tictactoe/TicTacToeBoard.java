package pt.ipbeja.app.tictactoe;

import javafx.application.Platform;
import javafx.css.Size;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TicTacToeBoard extends GridPane {

    public static final int SIZE = 3;     // Size fix grade 3x3

    static boolean isTurnX = true;

    static int count = 0;

    public TicTacToeBoard()  // Constructor
    {
        this.createBoard();
    }

    /*
     * Create table of game tic-tac-toe with in grade of button
     * */
    private void createBoard() {
        getChildren().clear();
        ButtonHandler bHandler = new ButtonHandler();
        for (int line = 0; line < SIZE; line++) {
            for (int col = 0; col < SIZE; col++) {
                TicTacToeButton ticTacToeButton = new TicTacToeButton();
                ticTacToeButton.setOnAction(bHandler);
                this.add(ticTacToeButton, col, line); // Add button in grade
            }
        }
    }

    /**
     * Faz o Reset o tabuleiro do jogo Tic-Tac-Toe para seu estado inicial.
<<<<<<< HEAD
     * Limpa os child de GridPane, redefine o contador para 0
     *  restaura o turno para `X` e recria o tabuleiro.
=======
     * Reativa todos os botões, redefine as imagens para Empty,
     * zera o contador de cliques e restaura o turno inicial.
>>>>>>> 03a786f839503508b1c4e9d79749570226020a75
     */
    public void resetGame() {
        getChildren().clear();
        count = 0;
        isTurnX = true;
        createBoard();
    }

    /*
     * Button que, despara ação quando é clicado
     * Alterna entre os jogadores "X" e "O", incrementa o contador de cliques,
     * desativa botões clicados, e exibe a mensagem de fim de jogo quando todos são usados.
     * */

    class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            TicTacToeButton getButtonClick = (TicTacToeButton) (actionEvent.getSource());
            count++;

            if (!getButtonClick.isCancelButton()) {
                if (isTurnX == true) {
                    getButtonClick.setPlayerX();
                } else {
                    getButtonClick.setPlayerO();
                }
                // OU
                //getButtonClick.setGraphic(isTurnX ? new ImageView(TicTacToeButton.imageX): new ImageView(TicTacToeButton.imageO));

                isTurnX = !isTurnX;

                getButtonClick.setDisable(true);

            }

            if (count == SIZE * SIZE) // Verifica se todos os botoes foram clicados
            {
                showOverGameAlert();
                resetGame();
            }
        }

        /**
         * Exibe a menssagem de fim de jogo usando Alert com DialogPane
         * Inclui um Label com a mensagem "O jogo terminou" e um botão "Reset" para reiniciar o jogo.
         * O botao OK, encerra o Aplicativo
         */
        private void showOverGameAlert() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("END GAME");

            DialogPane dialogPane = alert.getDialogPane();

            Button resetBtt = new Button("Reset");
            resetBtt.setOnAction(actionEvent -> {
                resetGame();
                alert.close();
            });


            Label label = new Label("O jogo terminou");
            VBox alertLayout = new VBox();
            alertLayout.getChildren().addAll(label, resetBtt);
            alertLayout.setSpacing(15);

            dialogPane.setContent(alertLayout);


            alert.showAndWait().ifPresent(buttonType ->
            {
                if (buttonType==ButtonType.OK)
                {
                    Platform.exit();
                }
            });

        }
    }
}

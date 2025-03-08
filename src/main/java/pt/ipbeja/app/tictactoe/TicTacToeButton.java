package pt.ipbeja.app.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.nio.file.Paths;

public class TicTacToeButton extends Button
{

    /* Image of Player X  */
    public static String urlX = Paths.get("/Users/neyvaldo/IdeaProjects/GameOldTicTacToe/src/main/resources/src/player1.png").toUri().toString();
    static Image imageX = new Image(urlX);

    /* Image of Player O  */
    public static String urlO = Paths.get("/Users/neyvaldo/IdeaProjects/GameOldTicTacToe/src/main/resources/src/player2.png").toUri().toString();
    public static Image imageO = new Image(urlO);

    /* Image Empty */
    public static String urlEmpy = Paths.get("/Users/neyvaldo/IdeaProjects/GameOldTicTacToe/src/main/resources/src/noplayer.png").toUri().toString();
    public  Image imageEmpty = new Image(urlEmpy);

    private final ImageView imageView;

    public TicTacToeButton() {
        this.imageView = new ImageView(imageEmpty);
        this.setGraphic(imageView);
        this.setPrefSize(150,150); // Size of button
    }

    /**
     * Define a imagem do botão como a do jogador "X".
     * Atualiza o ImageView associado ao botão para exibir a imagem de "X".
     */
    public void setPlayerX()
    {
        this.imageView.setImage(imageX);
    }

    /**
     * Define a imagem do botão como a do jogador "O".
     * Atualiza o ImageView associado ao botão para exibir a imagem de "O".
     */
    public void setPlayerO()
    {
        this.imageView.setImage(imageO);
    }

}

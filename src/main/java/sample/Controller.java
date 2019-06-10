package sample;

import javafx.fxml.FXML;

import javafx.geometry.HPos;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Controller {

    @FXML
    public GridPane gridpane;

    @FXML
    public AnchorPane anchorpane;

    private Moves moves;

    @FXML
    void initialize() {
        moves = new Moves();
        gridpane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            int y = (int) (event.getX() / 50);
            int x = (int) (event.getY() / 50);
            if (moves.emptyPoint(x, y)) {
                moves.point(x,y);
                addImage(moves.getFirstPlayer(), x, y);
                moves.winGame(x, y);
                if (moves.isVictory()) {
                    JOptionPane.showMessageDialog(null, " Победа");
                    System.exit(0);
                }
                moves.changePlayer();
                for (int i = 0; i < moves.getBoard().length; i++){
                    for (int j = 0; j < moves.getBoard()[i].length; j++) {
                        System.out.print(moves.getBoard()[i][j] + "");
                    }
                    System.out.println();
                }
            }
        });
    }

    private void addImage(int firstPlayer, int x, int y) {
        if (firstPlayer == 1) {
            try {
                FileInputStream image = new FileInputStream("Images/Black1.png");
                ImageView imageView = new ImageView();
                imageView.setImage(new Image(image));
                gridpane.add(imageView, y, x);
                GridPane.setHalignment(imageView, HPos.CENTER);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileInputStream image = new FileInputStream("Images/White1.png");
                ImageView imageView = new ImageView();
                imageView.setImage(new Image(image));
                gridpane.add(imageView, y, x);
                GridPane.setHalignment(imageView, HPos.CENTER);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
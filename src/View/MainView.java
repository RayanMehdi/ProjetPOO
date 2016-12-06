/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Model.*;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Rayan Mehdi
 */
public class MainView extends Application {

    private Jeu jeu;

    @Override
    public void start(Stage primaryStage) {
        jeu = new Jeu("#5 #3 0 0 #7 0 0 0 0 #6 0 0 #1 #9 #5 0 0 0 0 #9 #8 0 0 0 0 #6 0 #8 0 0 0 #6 0 0 0 #3 #4 0 0 #8 0 #3 0 0 #1 #7 0 0 0 #2 0 0 0 #6 0 #6 0 0 0 0 #2 #8 0 0 0 0 #4 #1 #9 0 0 #5 0 0 0 0 #8 0 0 #7 #9");

        GridPane gPane = new GridPane();
        int column = 0;
        int row = 0;

        gPane.setGridLinesVisible(true);
        StackPane s = new StackPane();

        Scene scene = new Scene(gPane, 300, 300);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                

                
               /* final Text t = new Text(jeu.getValeurCase(i, j));
                t.setWrappingWidth(scene.getWidth() / 9);
               
                t.setFont(Font.font("Verdana", 20));
                t.setTextAlignment(TextAlignment.CENTER);*/
                TextField tf = new TextField(jeu.getValeurCase(i, j));
                tf.setPrefSize(scene.getWidth()/9, scene.getHeight()/9);
                
                gPane.add(tf, column++, row);
                

                if (column > 8) {
                    column = 0;
                    row++;
                }
                
            }

            primaryStage.setTitle("Sudoku");
            primaryStage.setScene(scene);
            primaryStage.show();

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

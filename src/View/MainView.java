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
import com.sun.javafx.charts.ChartLayoutAnimator;
import java.util.Observable;
import java.util.Observer;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Rayan Mehdi
 */
public class MainView extends Application {

    private Jeu jeu;

    GridPane gPane;
    Stage stage;
    Scene scene;
    MenuBar menu;
    Menu fichier;
    Menu aide;
    MenuItem save;
    MenuItem load;
    MenuItem exit;

    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        jeu = new Jeu("0 #6 4 3 #5 #1 9 2 8 8 3 #5 9 6 #2 #7 1 #4 1 2 #9 #8 7 4 5 3 6 4 #1 2 5 9 7 6 8 3 #5 #7 6 1 #3 #8 #2 4 9 3 9 8 #4 2 6 1 5 7 2 #8 3 7 1 9 4 6 #5 6 5 #7 2 #4 3 #8 9 1 9 4 1 #6 8 5 3 7 2");
        jeu.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("PB");
                reload();

            }

        });
        initGrille();

        initMenuListeners();

        stage.setTitle("Sudoku");
        stage.setScene(scene);

        stage.show();

    }

    public void initGrille() {

        menu = new MenuBar();
        fichier = new Menu("Fichier");
        aide = new Menu("Aide");
        save = new MenuItem("Enregister");
        load = new MenuItem("Charger");
        exit = new MenuItem("Quitter");
        fichier.getItems().addAll(save, load, exit);
        menu.getMenus().addAll(fichier, aide);

        gPane = new GridPane();
        int column = 0;
        int row = 0;

        gPane.setGridLinesVisible(true);
        BorderPane border = new BorderPane();
        border.setTop(menu);

        scene = new Scene(border, 330, 330);
        scene.getStylesheets().add("style.css");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final TextField tf = new TextField(jeu.getValeurCase(i, j));

                if (jeu.getCase(i, j) instanceof caseBloquee) {
                    tf.setEditable(false);
                    tf.getStyleClass().add("bloque");
                } else {
                    tf.textProperty().addListener(new ChangeListener<String>() {

                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                            if (!"".equals(newValue)) {
                                if (Integer.valueOf(newValue) <= 9 && Integer.valueOf(newValue) >= 0) {
                                    //System.out.println("Début");
                                    jeu.getCase(GridPane.getRowIndex(tf), GridPane.getColumnIndex(tf)).update(Valeurs.fromString(newValue));
                                    //System.out.println("FIN");

                                    // FIN
                                    if (jeu.fin()) {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("Félicitation");
                                        alert.setHeaderText(null);
                                        alert.setContentText("Vous avez complété cette grille de Sudoku avec succès !");

                                        alert.showAndWait();
                                        System.exit(0);
                                    }
                                }
                            }

                        }

                    }
                    );
                    caseNonBloquee c = (caseNonBloquee) jeu.getCase(i, j);
                    if (c.getConflit()) {
                        tf.getStyleClass().add("conflit");
                    } else {
                        tf.getStyleClass().add("nonBloque");
                    }
                }

                tf.setPrefSize(scene.getWidth() / 9, scene.getHeight() / 9);

                gPane.add(tf, column++, row);

                if (column > 8) {
                    column = 0;
                    row++;
                }

            }

        }
        border.setCenter(gPane);

    }

    public void initMenuListeners() {
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jeu.sauvegarder("test");

            }
        });

        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jeu.charger("test.txt");
                System.out.println(jeu);
            }
        });

    }

    public void reload() {

        initGrille();
        initMenuListeners();
        stage.setTitle("Sudoku");
        stage.setScene(scene);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

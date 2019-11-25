/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul6pbo;

import javafx.scene.control.TextArea;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Asus
 */
public class Modul6PBO extends Application {

    public String jk;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Mohon Diisi");
        scenetitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label nim = new Label("NIM:");
        grid.add(nim, 0, 1);
        TextField ni = new TextField();
        ni.setText("Ex: 201810370311111");
        grid.add(ni, 1, 1);

        Label name = new Label("Nama:");
        grid.add(name, 0, 2);
        TextField na = new TextField();
        na.setPromptText("Ex: Bejo");
        grid.add(na, 1, 2);

        Label Jk = new Label("Jenis Kelamin:");
        grid.add(Jk, 0, 3);
        RadioButton lk = new RadioButton("Laki-laki");
        RadioButton pr = new RadioButton("Perempuan");
        ToggleGroup kelaminGroup = new ToggleGroup();
        lk.setToggleGroup(kelaminGroup);
        pr.setToggleGroup(kelaminGroup);
        HBox hRadio = new HBox(50, lk, pr);
        grid.add(hRadio, 1, 3);

        Label omah = new Label("Alamat:");
        grid.add(omah, 0, 4);
        TextArea al = new TextArea();
        al.setPromptText("Ex: Perumahan Antartika");
        al.setPrefHeight(75);
        al.setPrefWidth(150);
        grid.add(al, 1, 4);

        Button del = new Button("Delete");
        HBox size1 = new HBox(10);
        size1.setAlignment(Pos.BOTTOM_RIGHT);
        size1.getChildren().add(del);
        grid.add(size1, 1, 7);

        Button NEW = new Button("New");
        HBox size2 = new HBox(10);
        size2.setAlignment(Pos.BOTTOM_RIGHT);
        size2.getChildren().add(NEW);
        grid.add(size2, 2, 7);

        Button edit = new Button("EDIT");
        HBox size3 = new HBox(10);
        size3.setAlignment(Pos.BOTTOM_RIGHT);
        size3.getChildren().add(edit);
        grid.add(size3, 3, 7);

        NEW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (kelaminGroup.getSelectedToggle() == lk) {
                    jk = lk.getText();
                } else {
                    jk = pr.getText();
                }
                if ((ni.getText() == null) || (name.getText() == null)
                        || (kelaminGroup.getSelectedToggle() == null)
                        || (al.getText() == null)) {
                    newStage newWindow = new newStage(ni.getText(), na.getText(), "Jenis Kelamin Belum Dipilih",
                            al.getText());
                } else {
                    newStage newWindow = new newStage(ni.getText(), na.getText(), jk,
                            al.getText());
                }

                ni.setDisable(true);
                na.setDisable(true);
                lk.setDisable(true);
                pr.setDisable(true);
                al.setDisable(true);

            }
        });

        del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ni.setText(" ");
                na.setText(" ");
                kelaminGroup.selectToggle(null);
                al.setText(" ");
            }
        });

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ni.setDisable(false);
                na.setDisable(false);
                lk.setDisable(false);
                pr.setDisable(false);
                al.setDisable(false);
            }
        });

        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

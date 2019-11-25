/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul6pbo;

/**
 *
 * @author Asus
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class newStage {
    public newStage(String nim, String nama, String jk, String alamat) {
        GridPane gridBaru = new GridPane();
        gridBaru.setHgap(10);
        gridBaru.setVgap(10);
        gridBaru.setPadding(new Insets(10, 10, 10, 10));
        gridBaru.setAlignment(Pos.CENTER);
        Scene scene = new Scene(gridBaru, 300, 250);
        Stage secondStage = new Stage();
        secondStage.setResizable(false);
        secondStage.setTitle("Anda sukses mendaftar");
        secondStage.setScene(scene);
        
        Text hom = new Text("Data Diri");
        hom.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridBaru.add(hom, 0, 0);
        
        Text niM = new Text(nim);
        gridBaru.add(niM, 0, 1);
        
        Text nam = new Text(nama);
        gridBaru.add(nam, 0, 2);
        
        Text jK = new Text(jk);
        gridBaru.add(jK, 0, 3);
        
        Text mat = new Text(alamat);
        gridBaru.add(mat, 0, 4);
        
        secondStage.show();
    }
}

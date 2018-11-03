/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Omar
 */

public class Minesweeper extends Application {


    private static final Player ConstPlayer=new ConsolePlayer("Flan");
    /**
     */

    public static void main(String[] args) {
        // TODO code application logic here
       launch(args);
       List<Player> Players=new ArrayList<Player>();
       Players.add(ConstPlayer);
       Game ConstGame=new ConsoleGame(Players);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("MineSweeper");
        primaryStage.setScene(new Scene(root, 400, 275));
        primaryStage.show();
    }

    
}

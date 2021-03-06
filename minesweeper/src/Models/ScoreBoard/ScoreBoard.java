package Models.ScoreBoard;

import GUIGame.GUIGame;
import Models.Player.Player;
import SaveLoad.Directories;
import SaveLoad.SaveLoad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public abstract class ScoreBoard implements Serializable {
    protected ObservableList<PlayerBoard> scoreboard = FXCollections.observableArrayList();

    public ScoreBoard() {
        if (!Directories.scoreboard.exists()) { Directories.scoreboard.mkdirs();}
        for (String name : Directories.scoreboard.list()) {
            PlayerBoard _board = SaveLoad.loadObject(Directories.scoreboard,name);
            if (_board != null) { scoreboard.add(_board); }
        }
    }

    public void AddBoard(GUIGame game, Player winner) {
        PlayerBoard _board = new PlayerBoard(winner.getName(),game.getGameTime(),winner.getCurrentScore().getScore(),game.getGrid().getWidth(),game.getGrid().getHeight(),game.getMinesNumber(), game.getGrid().getShieldsCount());
        SaveLoad.saveObject(Directories.replay,_board.ReplayedGame,game);
        scoreboard.add(_board);
        UpdateView();
    }
    public abstract void UpdateView();


}

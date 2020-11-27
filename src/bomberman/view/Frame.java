package bomberman.view;

import bomberman.Game;
import javafx.application.Application;
import javafx.stage.Stage;

//import javax.swing.*;
import javax.swing.*;
import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;

public class Frame extends JFrame {

    public GamePanel _gamepane;
    private JPanel _containerpane;
    private InfoPanel _infopanel;

    private Game _game;

    public Frame() {

        _containerpane = new JPanel(new BorderLayout());
        _gamepane = new GamePanel(this);
        _infopanel = new InfoPanel(_gamepane.getGame());

        _containerpane.add(_infopanel, BorderLayout.PAGE_START);
        _containerpane.add(_gamepane, BorderLayout.PAGE_END);

        _game = _gamepane.getGame();

        add(_containerpane);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        _game.start();
    }


    public void setTime(int time) {
        _infopanel.setTime(time);
    }

    public void setPoints(int points) {
        _infopanel.setPoints(points);
    }

}
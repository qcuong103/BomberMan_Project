package bomberman.view;

import bomberman.entities.CreateMap;
import bomberman.entities.EntityArr;
import bomberman.entities.blocks.Brick;
import bomberman.entities.bomb.Bomb;
import bomberman.entities.enemy.Enemy;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class GameViewManager {
    public static int WIDTH = 50;
    public static int HEIGHT = 15;

    private Stage stage = new Stage();
    private GraphicsContext gc;
    private Canvas canvas;

    boolean up, down, left, right;

    public static boolean gameOver = false;

    public static int level = 1;

    public GameViewManager() {
        // Tao Canvas
        CreateMap.createMapByLevel(1);
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

//        Sound.play("soundtrack");
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (up) {
                    EntityArr.bomberman.goUp();
                }
                else if (down) {
                    EntityArr.bomberman.goDown();
                }
                else if (left) {
                    EntityArr.bomberman.goLeft();
                }
                else if (right) {
                    EntityArr.bomberman.goRight();
                }
                render();
                update();
            }
        };
        timer.start();


        /**
         * Hanh dong cua bomber
         */
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    up = true;
                    break;
                case DOWN:
                    down = true;
                    break;
                case LEFT:
                    left = true;
                    break;
                case RIGHT:
                    right = true;
                    break;
            }
            if (e.getCode() == KeyCode.SPACE) {
                EntityArr.bomberman.putBomb();
            }

            if (e.getCode() == KeyCode.A) {
                EntityArr.enemies.clear();
            }
        });

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case UP:
                    up = false;
                    break;
                case DOWN:
                    down = false;
                    break;
                case LEFT:
                    left = false;
                    break;
                case RIGHT:
                    right = false;
                    break;
            }
        });
    }

    // update
    public void update() {
        EntityArr.bomberman.update();
        EntityArr.enemies.forEach(Enemy::update);
        EntityArr.bomberman.bombs.forEach(Bomb::update);
        EntityArr.bricks.forEach(Brick::update);
        // update flame
        EntityArr.bomberman.bombs.forEach(g -> g.getfUp().forEach(g1 -> g1.update()));
        EntityArr.bomberman.bombs.forEach(g -> g.getfDown().forEach(g1 -> g1.update()));
        EntityArr.bomberman.bombs.forEach(g -> g.getfLeft().forEach(g1 -> g1.update()));
        EntityArr.bomberman.bombs.forEach(g -> g.getfRight().forEach(g1 -> g1.update()));
        // Update item
        EntityArr.items.forEach(g -> {
            if (g.isVisible()) g.update();
        });
        EntityArr.portals.forEach(g -> g.update());
    }

    // vẽ
    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        EntityArr.grasses.forEach(g -> g.render(gc));
        EntityArr.portals.forEach(g -> g.render(gc));
        EntityArr.items.forEach(g -> {
            if (g.isVisible()) g.render(gc);
        });
        EntityArr.walls.forEach(g -> g.render(gc));
        EntityArr.bricks.forEach(g -> g.render(gc));
        EntityArr.bomberman.bombs.forEach(g -> g.flames.forEach(g1 -> g1.render(gc)));
        EntityArr.bomberman.bombs.forEach(g -> g.render(gc));
        EntityArr.enemies.forEach(g -> {
            if (g.isVisible()) g.render(gc);
        });
        EntityArr.bombers.forEach(g -> g.render(gc));
    }

    public void showGame() {
        stage.show();
    }
}

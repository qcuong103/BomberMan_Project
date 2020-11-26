package bomberman.entities.tile.item;

import bomberman.Game;
import bomberman.entities.Entity;
import bomberman.entities.character.Bomber;
import bomberman.view.Sprite;

public class SpeedItem extends Item {

    public SpeedItem(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean collide(Entity e) {
        // TODO: xử lý Bomber ăn Item
        if (e instanceof Bomber) {

//                Sound.play("Item");
            Game.addBomberSpeed(0.5);
            remove();
        }
        return false;
    }
}

package bomberman.entities.item;

import javafx.scene.image.Image;
import bomberman.entities.EntityArr;
import bomberman.view.Sprite;
//import bomberman.sound.Sound;

public class SpeedItem extends Item {
    public SpeedItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        super.update();
        if (this.used == 1) {
            EntityArr.bomberman.setSpeed(EntityArr.bomberman.getSpeed() + Sprite.DEFAULT_SIZE / 12);
//            Sound.play("Item1");
        }
    }
}

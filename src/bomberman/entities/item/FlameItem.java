package bomberman.entities.item;

import javafx.scene.image.Image;
import bomberman.entities.EntityArr;
//import bomberman.sound.Sound;

public class FlameItem extends Item {
    public FlameItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        super.update();
        if (this.used == 1) {
            EntityArr.bomberman.setFlameLength(EntityArr.bomberman.getFlameLength() + 1);
//            Sound.play("Item1");
        }
    }
}

package bomberman.entities.item;

import javafx.scene.image.Image;
import bomberman.entities.EntityArr;
//import bomberman.sound.Sound;

public class BombPassItem extends Item {
    public BombPassItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        super.update();
        if (this.used == 1) {
            EntityArr.bomberman.setBombPass(true);
//            Sound.play("Item1");
        }
    }
}

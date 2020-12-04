package bomberman.entities.item;

import javafx.scene.image.Image;
import bomberman.entities.EntityArr;
//import bomberman.sound.Sound;

public class BombItem extends Item {
    public BombItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        super.update();
        if (this.used == 1) {
            EntityArr.bombers.forEach(g -> g.setNumBombs(g.getNumBombs() + 1));
//            Sound.play("Item1");
        }
    }
}

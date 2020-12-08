package bomberman.entities.item;

import javafx.scene.image.Image;
import bomberman.entities.Entity;
import bomberman.entities.EntityArr;

public abstract class Item extends Entity {
    protected int used = 0;
    public Item(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (this.isVisible() && this.checkBoundBomber()) {
                this.setVisible(false);
                this.used++;
        }
    }


    protected boolean checkBoundBomber() {
        return this.intersects(EntityArr.bomberman);
    }
}

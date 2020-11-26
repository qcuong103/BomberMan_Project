package bomberman.entities.tile.destroyable;

import bomberman.level.Coordinates;
import bomberman.view.Screen;
import bomberman.view.Sprite;


public class Brick extends DestroyableTile {

    public Brick(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Screen screen) {
        int x = Coordinates.tileToPixel(_x);
        int y = Coordinates.tileToPixel(_y);

        if(_destroyed) {
            _sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);

            screen.renderEntityWithBelowSprite(x, y, this, _belowSprite);
        }
        else
            screen.renderEntity( x, y, this);
    }

}


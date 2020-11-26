package bomberman.entities.tile.item;

import bomberman.entities.tile.Tile;
import bomberman.view.Sprite;

public abstract class Item extends Tile {
    protected int _duration = -1; //thoi gian cua item ,-1 la vo han
    protected boolean _active = false;
    protected int _level;
    public Item(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

}

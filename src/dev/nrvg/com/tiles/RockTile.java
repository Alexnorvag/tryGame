package dev.nrvg.com.tiles;

import dev.nrvg.com.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by norvag on 18.07.2017.
 */
public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

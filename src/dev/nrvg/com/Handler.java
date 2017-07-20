package dev.nrvg.com;

import dev.nrvg.com.gfx.GameCamera;
import dev.nrvg.com.input.KeyManager;
import dev.nrvg.com.input.MouseManager;
import dev.nrvg.com.worlds.World;

/**
 * Created by norvag on 18.07.2017.
 */
public class Handler {

    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return  game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() { return game.getMouseManager(); }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}

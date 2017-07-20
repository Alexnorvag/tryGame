package dev.nrvg.com.states;

import dev.nrvg.com.Handler;
import dev.nrvg.com.entities.creatures.Player;
import dev.nrvg.com.worlds.World;

import java.awt.*;

/**
 * Created by norvag on 17.07.2017.
 */
public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
        player = new Player(handler,0, 0);
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}

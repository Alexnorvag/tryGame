package dev.nrvg.com.entities.creatures;

import dev.nrvg.com.Handler;
import dev.nrvg.com.gfx.Animation;
import dev.nrvg.com.gfx.Assets;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by norvag on 17.07.2017.
 */
public class Player extends Creature{

    private Animation animDown, animUp, animLeft, animRight;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        animDown = new Animation(400, Assets.player_down);
        animUp = new Animation(400, Assets.player_up);
        animLeft = new Animation(400, Assets.player_left);
        animRight = new Animation(400, Assets.player_right);
    }

    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up)
            yMove = -speed;
        if (handler.getKeyManager().down)
            yMove = speed;
        if (handler.getKeyManager().left)
            xMove = -speed;
        if (handler.getKeyManager().right)
            xMove = speed;
        if (handler.getMouseManager().mousePressed) {
            /*if (y >= handler.getMouseManager().y)
                yMove = -speed;
            if (y < handler.getMouseManager().y)
                yMove = speed;
            if (x >= handler.getMouseManager().x)
                xMove = -speed;
            if (x < handler.getMouseManager().x)
                xMove = speed;*/
            /*x = handler.getMouseManager().x;
            y = handler.getMouseManager().y;*/

            System.out.printf("coord: x = " + x + ", y = " + y + "\n");
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else {
            return animDown.getCurrentFrame();
        }
    }
}

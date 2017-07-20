package dev.nrvg.com;


import dev.nrvg.com.display.Display;
import dev.nrvg.com.gfx.Assets;
import dev.nrvg.com.gfx.GameCamera;
import dev.nrvg.com.input.KeyManager;
import dev.nrvg.com.input.MouseManager;
import dev.nrvg.com.states.GameState;
import dev.nrvg.com.states.MenuState;
import dev.nrvg.com.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by norvag on 16.07.2017.
 */
public class Game implements Runnable{

    private Display display;
    private int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    private GameCamera gameCamera;

    private Handler handler;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getFrame().addMouseListener(mouseManager);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0,0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setCurrentState(gameState);
    }

    private void tick() {
        keyManager.tick();
        mouseManager.tick();

        if (State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0, width, height);

        //draw here
        if (State.getCurrentState() != null) {
            State.getCurrentState().render(g);
        }
        //end here

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

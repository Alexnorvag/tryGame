package dev.nrvg.com.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by norvag on 18.07.2017.
 */
public class MouseManager implements MouseListener {

    public int x, y;
    public boolean mousePressed;

    public MouseManager() {
        mousePressed = false;
    }

    public void tick() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
        System.out.printf("MousePressed at coord: x = " + x + ", y = " + y + "\n");
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

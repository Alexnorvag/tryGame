package dev.nrvg.com.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by norvag on 17.07.2017.
 */
public class Assets {

    private static final int width = 64, height = 64;

    public static BufferedImage grass, stone, dirt;
    public static BufferedImage[] player_down, player_up, player_left, player_right;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));

        player_down = new BufferedImage[6];
        player_up = new BufferedImage[6];
        player_left = new BufferedImage[6];
        player_right = new BufferedImage[6];

        player_down[0] = playerSheet.crop(0, 0, width / 2, height);
        player_down[1] = playerSheet.crop(width / 2, 0, width / 2, height);
        player_down[2] = playerSheet.crop(width, 0, width / 2, height);
        player_down[3] = playerSheet.crop(width * 3 / 2, 0, width / 2, height);
        player_down[4] = playerSheet.crop(width * 2, 0, width / 2, height);
        player_down[5] = playerSheet.crop(width * 5 / 2, 0, width / 2, height);
        player_up[0] = playerSheet.crop(0, height * 2, width / 2, height);
        player_up[1] = playerSheet.crop(width / 2, height * 2, width / 2, height);
        player_up[2] = playerSheet.crop(width, height * 2, width / 2, height);
        player_up[3] = playerSheet.crop(width * 3 / 2, height * 2, width / 2, height);
        player_up[4] = playerSheet.crop(width * 2, height * 2, width / 2, height);
        player_up[5] = playerSheet.crop(width * 5 / 2, height * 2, width / 2, height);
        player_right[0] = playerSheet.crop(0, height * 3, width / 2, height);
        player_right[1] = playerSheet.crop(width / 2, height * 3, width / 2, height);
        player_right[2] = playerSheet.crop(width, height * 3, width / 2, height);
        player_right[3] = playerSheet.crop(width * 3 / 2, height * 3, width / 2, height);
        player_right[4] = playerSheet.crop(width * 2, height * 3, width / 2, height);
        player_right[5] = playerSheet.crop(width * 5 / 2, height * 3, width / 2, height);
        player_left[0] = playerSheet.crop(0, height, width / 2, height);
        player_left[1] = playerSheet.crop(width / 2, height, width / 2, height);
        player_left[2] = playerSheet.crop(width, height, width / 2, height);
        player_left[3] = playerSheet.crop(width * 3 / 2, height, width / 2, height);
        player_left[4] = playerSheet.crop(width * 2, height, width / 2, height);
        player_left[5] = playerSheet.crop(width * 5 / 2, height, width / 2, height);

        stone = sheet.crop(0, 0, width, height);
        grass = sheet.crop(width, 0, width, height);
        //player = sheet.crop(2 * width, 0, width, height);
        dirt = sheet.crop(3 * width, 0, width, height);
    }
}

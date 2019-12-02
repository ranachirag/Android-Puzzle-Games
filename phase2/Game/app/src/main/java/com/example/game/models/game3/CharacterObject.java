package com.example.game.models.game3;

import android.graphics.Bitmap;

/**
 * Character Object class. Subclass of abstract class Game3Object.
 */
class CharacterObject extends Game3Object {

    /**
     * The physical appearance of the Character as a Bitmap.
     */
    private Bitmap sprite;

    /**
     * The Bitmaps representing each frame of the Character when Animated.
     */
    private Bitmap[] spriteAnimate = new Bitmap[4];

    /**
     * Setter for spriteAnimate.
     *
     * @param spriteAnimate The Bitmaps representing each frame of the Character when Animated.
     */
    void setSpriteAnimate(Bitmap[] spriteAnimate) {
        this.spriteAnimate = spriteAnimate;
    }

    /**
     * The current frame the animation is on.
     */
    private int spriteFrame = 0;

    /**
     * Getter for the Character sprite.
     *
     * @return sprite : The physical appearance of the Character.
     */
    Bitmap getSprite() {
        return sprite;
    }

    /**
     * Setter for the Character sprite.
     *
     * @param sprite The physical appearance of the Character.
     */
    void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    /**
     * Overrides update for the CharacterObject from GameObject class. Changes the frame of the
     * animation.
     */
    @Override
    void update() {
        if (spriteFrame == 4) {
            spriteFrame = 0;
        } else {
            spriteFrame++;
        }
        sprite = spriteAnimate[spriteFrame];
    }
}

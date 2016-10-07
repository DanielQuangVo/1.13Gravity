package Movement;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class spritemovement extends ApplicationAdapter implements InputProcessor {

    SpriteBatch batch;
    Texture img;
    Sprite sprite;
    boolean isRight = false, isLeft = false, isUp = false;
    float fgravity;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("Dinosaur.png");
        sprite = new Sprite(img);
        sprite.setPosition(Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
        sprite.setScale(.75f);
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render() {
        if (isRight) {
            sprite.translateX(3f);
        } else if (isLeft) {
            sprite.translateX(-3f);
        } else if (isUp) {
            fgravity = sprite.getY();
            sprite.translateY(3f);
            Gravity(fgravity);
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getWidth() / 2, sprite.getHeight() / 2,
                sprite.getWidth(), sprite.getHeight(), sprite.getScaleX(), sprite.getScaleY(), sprite.getRotation());
        batch.end();
    }

    public void Gravity(float fgravity) {
        while (sprite.getY() > fgravity) {
        sprite.translateY(-.03f);
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            isLeft = true;
        } else if (keycode == Input.Keys.RIGHT) {
            isRight = true;
        } else if (keycode == Input.Keys.UP) {
            isUp = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.RIGHT) {
            isRight = false;
        } else if (keycode == Input.Keys.LEFT) {
            isLeft = false;
        } else if (keycode == Input.Keys.UP) {
            isUp = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {

        return false;
    }

    @Override
    public boolean mouseMoved(int nScreenX, int nScreenY) {

        return false;
    }

    @Override
    public boolean scrolled(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }
}

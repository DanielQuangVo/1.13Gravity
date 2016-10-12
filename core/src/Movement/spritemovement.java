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
    boolean bJump, isRight, isLeft;
    float fX, fY, fGrav, fGravAcel, fJump, fXSpeed;

    @Override
    public void create() {
        bJump = false;
        isRight = false;
        isLeft = false;
        fGrav = 5f;
        fGravAcel = 1f;
        fXSpeed = 10f;
        batch = new SpriteBatch();
        img = new Texture("Dinosaur.png");
        sprite = new Sprite(img);
        sprite.setScale(.75f);
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render() {
        if (bJump) {
            fJump = 30f;
            bJump = false;
        }
        if (fJump > 0) {
            fJump--;
        } else {
            fJump = 0;
        }
        fGrav += fGravAcel;
        if (fY > 0) {
            fY -= fGrav;
        } else {
            fGrav = 5f;
            fY = 0;
        }
        fY += fJump;
        if (isLeft) {
            fX -= fXSpeed;
        }
        if (isRight) {
            fX += fXSpeed;
        }
        sprite.setPosition(fX, fY);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getWidth() / 2, sprite.getHeight() / 2,
                sprite.getWidth(), sprite.getHeight(), sprite.getScaleX(), sprite.getScaleY(), sprite.getRotation());
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
            bJump = true;
        }
        if (keycode == Input.Keys.A) {
            isLeft = true;

        }
        if (keycode == Input.Keys.D) {
            isRight = true;

        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            isLeft = false;
        }
        else if (keycode == Input.Keys.D) {
            isRight = false;
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

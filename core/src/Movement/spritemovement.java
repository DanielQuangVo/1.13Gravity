package Movement;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.Vector;

public class spritemovement extends ApplicationAdapter implements InputProcessor {

    SpriteBatch batch;
    Texture img;
    Sprite sprite;
    boolean bJump;
    int nJumpTime = 10;
    Vector2 vPos, vDir, vGrav;

    @Override
    public void create() {

        batch = new SpriteBatch();
        img = new Texture("Dinosaur.png");
        sprite = new Sprite(img);
        sprite.setScale(.75f);
        vPos = new Vector2(sprite.getX(), sprite.getY());
        vDir = new Vector2(0, 0);
        vGrav = new Vector2(0, 0);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        System.out.println(vDir);
        if (bJump) {
            vGrav.set(0, (float) (vGrav.y * 1.1));
        }
        if (vPos.y < 0) {
            vDir.set(vDir.x, 0);
            vGrav.set(0,0);
            vPos.set(vPos.x, 0);
            bJump = false;
        }
        vDir.add(vGrav);
        vPos.add(vDir);
        sprite.setPosition(vPos.x, vPos.y);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getWidth() / 2, sprite.getHeight() / 2,
                sprite.getWidth(), sprite.getHeight(), sprite.getScaleX(), sprite.getScaleY(), sprite.getRotation());
        batch.end();
        
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE && bJump == false) {
            vDir.set(0, 25);
            vGrav.set(0,(float) -0.5);
            bJump = true;
        }
        if (keycode == Input.Keys.A) {
            vDir.set(-10, 0);

        }
        if (keycode == Input.Keys.D) {
            vDir.set(10, 0);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            vDir.set(0, 0);
        } else if (keycode == Input.Keys.D) {
            vDir.set(0, 0);
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

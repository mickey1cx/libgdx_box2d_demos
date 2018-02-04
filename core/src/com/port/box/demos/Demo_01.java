package com.port.box.demos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.port.box.utils.BodyBulder;

import java.util.Random;

/**
 * Created by mickey.1cx on 02.02.2018.
 * http://www.emanueleferonato.com/2008/03/21/playing-with-box2dflashas3/
 */

public class Demo_01 extends DemoConstructor {

    public Demo_01() {

        gravity = new Vector2(0, -100);

    }

    @Override
    public void init(World world) {

        super.init(world);

        BodyBulder.createBox(world, widthScr /2, 0, 500, 20, true, false); // floor

    }

    @Override
    public void inputListener() {

        if (Gdx.input.justTouched()) {

            //createRandomBox();
            createMouseRandom();

        }

    }

    private void createMouseRandom() {

        Random r = new Random();

        float x = Gdx.input.getX();
        float y = heightScr - Gdx.input.getY();

        if (r.nextBoolean()) {
            BodyBulder.createBox(world, x, y,
                    r.nextInt(15) + 15, r.nextInt(15) + 15, false, false);
        } else {
            BodyBulder.createCircle(world, x, y, r.nextInt(15) + 15, false);
        }


    }

    private void createRandomBox() {
        Random r = new Random();
        BodyBulder.createBox(world, r.nextInt(400) + 50, 400,
                r.nextInt(15) + 15, r.nextInt(15) + 15, false, false);
    }


}

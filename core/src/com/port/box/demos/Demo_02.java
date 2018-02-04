package com.port.box.demos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.World;
import com.port.box.utils.BodyBulder;
import com.badlogic.gdx.physics.box2d.BodyDef;

/**
 * Created by mickey.1cx on 03.02.2018.
 */

public class Demo_02 extends DemoConstructor {

    public Demo_02() {

        gravity = new Vector2(0, -10);
        widthScr = Gdx.graphics.getWidth();
        heightScr = Gdx.graphics.getHeight();

       BodyBulder.setPPM(scale);

    }

    @Override
    public void init(World world) {

        this.world = world;

        BodyBulder.createBox(world, widthScr /2, 0, 500, 20, true, false); // floor

        BodyBulder.createBox(world, 200, 20, 20, 20, false, false);
        BodyBulder.createBox(world, 200, 40, 20, 20, false, false);
        BodyBulder.createBox(world, 200, 60, 20, 20, false, false);

        BodyBulder.createBox(world, 300, 20, 20, 20, false, false);
        BodyBulder.createBox(world, 300, 40, 20, 20, false, false);
        BodyBulder.createBox(world, 300, 60, 20, 20, false, false);

        BodyBulder.createBox(world, 250, 80, 140, 20, false, false);

        BodyBulder.createCircle(world, 250, 100, 10, false);

    }

    @Override
    public void inputListener() {

        if (Gdx.input.justTouched()) {

            float _x = Gdx.input.getX() / scale;
            float _y = (heightScr - Gdx.input.getY()) / scale;

            QueryCallback _q = new QueryCallback() {
                @Override
                public boolean reportFixture(Fixture fixture) {

                    System.out.println(fixture.getUserData());

                    Body _b = fixture.getBody();

                    if (_b.getType() == BodyDef.BodyType.DynamicBody) {
                        world.destroyBody(_b);
                    }

                    return false;
                }
            };
            world.QueryAABB(_q, _x, _y, _x, _y);

        }

    }
}

package com.port.box.demos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.port.box.utils.BodyBulder;

/**
 * Created by mickey.1cx on 04.02.2018.
 */

public class Demo_03 extends DemoConstructor {

    private Body player;

    private Texture tBox, tPlayer, tGround;

    public Demo_03() {

        gravity = new Vector2(0, -10);
        BodyBulder.setPPM(scale);

    }

    @Override
    public void init(World world) {

        super.init(world);

        tBox = new Texture("Demo_03/box.png");
        tPlayer = new Texture("Demo_03/player.png");
        tGround = new Texture("Demo_03/tex.png");

        Body _b;

        BodyBulder.createBox(world, 275, 0, 600, 50, true, false);
        BodyBulder.createCircle(world, 270, 75, 50, false);
        BodyBulder.createBox(world, 500, 75,200,100,true,false);

        for (int ix = 0; ix <3 ; ix++) {
            for (int iy = 0; iy < 11; iy++) {
                BodyBulder.createBox(world, 340 + 20*ix, 35 + 20 * iy, 20,20,false, true);
            }
        }

        player = BodyBulder.createBox(world,150, 40, 20, 20, false, true);

    }

    @Override
    public void inputListener() {

        Vector2 currentV = player.getLinearVelocity();
        Vector2 currentPos = player.getWorldCenter();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            currentV.x = -3;
            player.setLinearVelocity(currentV);

        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            currentV.x = 3;
            player.setLinearVelocity(currentV);

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && Math.abs(currentV.y) < .1f) {

            System.out.println(currentV.y);
            player.applyLinearImpulse(new Vector2(0, .75F), currentPos, true);

        }

    }
}

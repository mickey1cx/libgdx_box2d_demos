package com.port.box.demos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.port.box.utils.GameActor;

import java.util.ArrayList;

/**
 * Created by mickey.1cx on 02.02.2018.
 */

public class DemoConstructor {

    protected World world;
    public Vector2 gravity;

    public float scale = 60f;
    public int iterations = 10;

    public ArrayList<GameActor> actors;

    public float widthScr, heightScr;

    public DemoConstructor() {

    }

    public void init(World world){

        this.world = world;
        widthScr = Gdx.graphics.getWidth();
        heightScr = Gdx.graphics.getHeight();

    }

    public void inputListener() {

    }

}

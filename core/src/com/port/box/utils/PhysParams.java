package com.port.box.utils;

/**
 * Created by mickey.1cx on 04.02.2018.
 */

public final class PhysParams {

    //body def
    public float x;
    public float y;
    public boolean isStatic = false;
    public boolean fixedRotation = false;

    //shape
    public float width;
    public float height;
    public float radius;

    //fixture
    public float density = 1.0f;
    public float friction = 0;
    public float restitution = 0;

    public PhysParams(float x, float y) {

        this.x = x;
        this.y = y;

    }

}

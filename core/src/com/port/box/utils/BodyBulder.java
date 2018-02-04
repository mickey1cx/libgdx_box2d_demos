package com.port.box.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


/**
 * Created by mickey.1cx on 01.02.2018.
 */

public class BodyBulder {

    private static float PPM = 1;

    public static void setPPM(float scale) {
        PPM = scale;
    }

    public static Body createBox(World world, float x, float y, int width, int height, boolean isStatic, boolean fixedRotation) {

        Body pBody;
        BodyDef def = new BodyDef();
        def.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        def.position.set(new Vector2(x / PPM, y / PPM));
        def.fixedRotation = fixedRotation;

        pBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        Fixture f = pBody.createFixture(shape, 1.0f);
        f.setFriction(1);
        f.setRestitution(.2f);

        f.setUserData(world.getBodyCount());
        shape.dispose();

        return pBody;

    }

    public static Body createCollideBox(World world, float x, float y, int width, int height,
                                        boolean isStatic, boolean fixedRotation,
                                        short cBits, short mBits, short gIndex) {

        Body pBody;
        BodyDef def = new BodyDef();
        def.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        def.position.set(new Vector2(x / PPM, y / PPM));
        def.fixedRotation = fixedRotation;

        pBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        FixtureDef fix = new FixtureDef();
        fix.shape = shape;
        fix.density = 1.0f;
        fix.filter.categoryBits = cBits;
        fix.filter.maskBits = mBits;
        fix.filter.groupIndex = gIndex;

        pBody.createFixture(fix);

        shape.dispose();

        return pBody;

    }

    public static Body createCircle(World world, float x, float y, int radius, boolean isStatic) {

        Body pBody;
        BodyDef def = new BodyDef();
        def.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        def.position.set(new Vector2(x / PPM, y / PPM));
        //def.fixedRotation = true;

        pBody = world.createBody(def);

        CircleShape shape = new CircleShape();
        shape.setRadius(radius / PPM);

        Fixture f = pBody.createFixture(shape, 1.0f);
        f.setUserData(world.getBodyCount());
        shape.dispose();

        return pBody;

    }


}

package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CollisionControlSystemTest {

    @Test
    void testEntitiesDoNotCollide() {
        Entity e1 = new Entity();
        Entity e2 = new Entity();

        World world = new World();
        GameData gameData = new GameData();
        CollisionControlSystem collisionControlSystem = new CollisionControlSystem();

        world.addEntity(e1);
        world.addEntity(e2);

        e1.setSize(10);
        e1.setHealth(20);
        e1.setX(50);
        e1.setY(50);

        e2.setSize(10);
        e2.setHealth(20);
        e2.setX(100);
        e2.setY(100);

        collisionControlSystem.process(gameData, world);

        // Two entities has not collided
        Assertions.assertEquals(20, e1.getHealth());
        Assertions.assertEquals(20, e2.getHealth());
    }

    @Test
    void testEntitiesCollide() {
        Entity e1 = new Entity();
        Entity e2 = new Entity();

        World world = new World();
        GameData gameData = new GameData();
        CollisionControlSystem collisionControlSystem = new CollisionControlSystem();

        world.addEntity(e1);
        world.addEntity(e2);

        e1.setSize(10);
        e1.setHealth(20);
        e1.setX(100);
        e1.setY(100);

        e2.setSize(10);
        e2.setHealth(20);
        e2.setX(100);
        e2.setY(100);

        collisionControlSystem.process(gameData, world);

        // Two entities has collided
        Assertions.assertEquals(10, e1.getHealth());
        Assertions.assertEquals(10, e2.getHealth());
    }
}
package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import javafx.scene.paint.Paint;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            if(bullet.getHealth() <= 0) {
                bullet.setDead(true);
            }
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 3);
            bullet.setY(bullet.getY() + changeY * 3);
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        // Instance of the bullet
        Bullet bullet = new Bullet();

        bullet.setX(shooter.getX());
        bullet.setY(shooter.getY());

        bullet.setSize(10);

        bullet.setPolygonCoordinates(0,0,0,5,5,1,0,0);

        bullet.setRotation(shooter.getRotation());

        bullet.setHealth(1);

        bullet.setPaint(shooter.getPaint());

        return bullet;
    }

    private void setShape(Entity entity) {
    }

}

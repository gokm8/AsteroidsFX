import dk.sdu.mmmi.cbse.asteroid.AsteroidCreate;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Asteroid {
    exports dk.sdu.mmmi.cbse.asteroid;
    requires Common;
    requires CommonAsteroid;
    requires javafx.graphics;

    provides IGamePluginService with dk.sdu.mmmi.cbse.asteroid.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.asteroid.AsteroidProcessor;
    provides IPostEntityProcessingService with AsteroidCreate;
}
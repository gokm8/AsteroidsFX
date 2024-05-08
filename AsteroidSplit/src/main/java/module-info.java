import dk.sdu.mmmi.cbse.asteroid.AsteroidCreate;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module AsteroidSplit {
    requires Common;
    requires javafx.graphics;

    provides IPostEntityProcessingService with AsteroidCreate;
}
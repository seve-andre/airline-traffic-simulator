package alt.sim.model.plane;

/**
 * Enum describing the states a Plane can have during the game.
 */
public enum State {

    /**
     * (0) Plane is Spawned.
     */
    SPAWNING,

    /**
     * (1) Plane waiting to Move.
     */
    WAITING,

    /**
     * (2) Plane is moving in random Path.
     */
    RANDOM_MOVEMENT,

    /**
     * (3) Plane is moving following User Path. 
     */
    USER_MOVEMENT
}

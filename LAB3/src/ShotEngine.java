//package CustomAssaultRifle;

//Інтерфейс "ShotEngine" містить в собі прототипи розширених методів
/**
 * The ShotEngine interface defines prototypes for extended shooting methods.
 * Classes implementing this interface should provide implementations for these methods.
 *
 * @author Khmilovskiy Stanislaw
 * @version 1.0
 * @since 1.0
 */
public interface ShotEngine {
    /**
     * Prototype for an automatic fire method.
     *
     * @param bullets The number of bullets to fire automatically
     */
    void automaticFire(int bullets);

    /**
     * Prototype for a burst fire method.
     *
     * @param bullets The number of bullets to fire in bursts
     */
    void burstFire(int bullets);

    /**
     * Prototype for a single shot method.
     *
     * @param bullets The number of single shots to fire
     */
    void singleFire(int bullets);
}

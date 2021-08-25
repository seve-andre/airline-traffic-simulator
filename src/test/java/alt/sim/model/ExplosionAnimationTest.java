package alt.sim.model;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExplosionAnimationTest {
    private final static int N_SPRITES = 50;

    @Test
    public void loadImageTest() {
        try {
            String urlImage;
            for (int k = 1; k < N_SPRITES; k++) {
                Image img = new Image("images/animations/explosion_" + k + ".png");
            }
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
            Assertions.assertEquals(re.getMessage(), "Internal graphics not initialized yet");
        }

    }
}
package alt.sim.view.pages;

import alt.sim.Main;
import alt.sim.view.mapchoice.GameMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public final class PageLoader {

    private PageLoader() { }

    /**
     * Loads page given as argument.
     *  @param page to load
     * @param gameMap to load
     */
    public static void loadPage(final Page page, final GameMap gameMap) {

        if (page.getName().equals(Page.GAME.getName())) {
            page.setName(gameMap.getName());
        }
        Parent root = null;

        try {
            root = FXMLLoader.load(ClassLoader.
                    getSystemResource("layouts/" + page.getName() + ".fxml"));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        if (root != null) {
            Main.getStage().setScene(new Scene(root));
        }
    }

    /**
     * Method overloading.
     *
     * @param page to load
     */
    public static void loadPage(final Page page) {
        loadPage(page, null);
    }
}

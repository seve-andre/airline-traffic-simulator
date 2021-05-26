package alt.sim.view.mapchoice;

import java.util.List;

import alt.sim.Main;
import alt.sim.model.user.validation.NameQuality;
import alt.sim.model.user.validation.NameValidation;
import alt.sim.view.CommonView;
import alt.sim.view.pages.Page;
import alt.sim.view.pages.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class MapChoiceView {

    @FXML
    private TextField nameTextField = new TextField();
    @FXML
    private Button seasideBtn = new Button();
    @FXML
    private Button riversideBtn = new Button();
    @FXML
    private Button citysideBtn = new Button();
    @FXML
    private Button countrysideBtn = new Button();
    @FXML
    private Button playBtn = new Button();
    @FXML
    private TextField infoTextField = new TextField();
    @FXML
    private Tooltip infoTooltip = new Tooltip();

    private GameMap mapToPlay = GameMap.getRandomMap();
    private final List<Button> buttons = List.of(seasideBtn, riversideBtn, citysideBtn, countrysideBtn);

    @FXML
    public void initialize() {
        infoTooltip.setShowDelay(Duration.millis(100));
    }

    @FXML
    public void onGoBackClick(final ActionEvent event) {
        CommonView.goBack();
    }

    /**
     * If ENTER key is pressed, name quality will be checked.
     * @param event
     */
    @FXML
    public void onNameEnter(final KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            final NameValidation result = new NameQuality().checkName(nameTextField.getText());
            if (!result.equals(NameValidation.CORRECT)) {
                infoTextField.setText("NAME IS " + result.getResult().toUpperCase() + "!");
            } else {
                infoTextField.setText("");
            }
        }
    }

    /**
     * Loads GameMap fxml when button is clicked.
     * @param event
     */
    @FXML
    public void onPlayClick(final ActionEvent event) {
        final NameValidation result = new NameQuality().checkName(nameTextField.getText());
        if (result.equals(NameValidation.CORRECT)) {
            new PageLoader().loadPage(Main.getStage(), Page.GAME, this.mapToPlay);
        } else {
            infoTextField.setText("NAME IS " + result.getResult().toUpperCase() + "!");
        }
    }

    @FXML
    public void onSeasideClick(final ActionEvent event) {
        this.playBtn.setText("PLAY SEASIDE");
        this.mapToPlay = GameMap.SEASIDE;
    }

    @FXML
    public void onRiversideClick(final ActionEvent event) {
        this.playBtn.setText("PLAY RIVERSIDE");
        this.mapToPlay = GameMap.RIVERSIDE;
    }

    @FXML
    public void onCitysideClick(final ActionEvent event) {
        this.playBtn.setText("PLAY CITYSIDE");
        this.mapToPlay = GameMap.CITYSIDE;
    }

    @FXML
    public void onCountrysideClick(final ActionEvent event) {
        this.playBtn.setText("PLAY COUNTRYSIDE");
        this.mapToPlay = GameMap.COUNTRYSIDE;
    }

}

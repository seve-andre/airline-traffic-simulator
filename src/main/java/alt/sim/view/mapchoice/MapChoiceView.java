package alt.sim.view.mapchoice;

import java.util.ArrayList;

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
    private final Button seasideBtn = new Button();
    @FXML
    private final Button riversideBtn = new Button();
    @FXML
    private final Button citysideBtn = new Button();
    @FXML
    private final Button countrysideBtn = new Button();
    @FXML
    private Button playBtn = new Button();
    @FXML
    private TextField infoTextField = new TextField();
    @FXML
    private Tooltip infoTooltip = new Tooltip();

    private GameMap mapToPlay = GameMap.getRandomMap();
    private final ArrayList<Button> buttons = new ArrayList<> (4);

    @FXML
    public void initialize() {
        this.buttons.add(seasideBtn);
        this.buttons.add(riversideBtn);
        this.buttons.add(citysideBtn);
        this.buttons.add(countrysideBtn);
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
        this.seasideBtn.requestFocus();
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

    /**
     * Could be generic method for all maps?
     * NEED TO CHANGE LINE 97!!
     */
    public void onMapClick() {
        for (final Button b : this.buttons) {
            if (b.isPressed()) {
                this.playBtn.setText("PLAY " + b.getText().toUpperCase());
                if (GameMap.getNamesList().contains(b.getText())) {
                    this.mapToPlay = GameMap.SEASIDE;
                }
            }
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

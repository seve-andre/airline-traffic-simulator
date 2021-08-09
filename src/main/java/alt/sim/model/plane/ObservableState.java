package alt.sim.model.plane;

import alt.sim.view.seaside.Seaside;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.util.Duration;

public class ObservableState {
    private final ObjectProperty<State> stateProperty;
    private Timeline timeline;
    private Plane planeObserved;

    private final ChangeListener<? super State> listener;

    public ObservableState(final Plane planeObserved, final State state) {
        double timelineDuration = 4000;
        stateProperty = new SimpleObjectProperty<>(state);
        this.planeObserved = planeObserved;

        System.out.println("create Plane: " + planeObserved.hashCode() + " State = " + state);

        listener = (observable, oldValue, newValue) -> {

            if (newValue == State.TERMINATED && this.timeline != null) {
                this.timeline.stop();
            }

            this.planeObserved.stopPlaneMovementAnimation();
            this.planeObserved.stopRandomTransition();

            this.timeline = new Timeline(new KeyFrame(Duration.millis(timelineDuration),
                    e -> { }));

            timeline.setCycleCount(1);
            timeline.play();
            timeline.setOnFinished(finish -> {
                if (planeObserved.getState().equals(State.WAITING)) {
                    this.planeObserved.loadRandomTransition(Seaside.getScreenWidth(), Seaside.getScreenHeight());
                }
            });
        };

        //Add Listener in State
        stateProperty.addListener(listener);
    }

    public void setState(final State state) {
        stateProperty.setValue(state);
    }

    public State getState() {
        return stateProperty.getValue();
    }

    public ObjectProperty<State> getStateProperty() {
        return stateProperty;
    }

    public void removeListener() {
        this.timeline.stop();
        stateProperty.removeListener(listener);
    }
}

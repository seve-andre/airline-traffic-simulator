package alt.sim.model.airstrip;

public enum AirStripType {

    /**
     * Represents a standard airstrip for classic planes.
     */
    CLASSIC("Classic AirStrip"),

    /**
     * Represents a helipad airstrip for helicopters.
     */
    HELIPAD("Helipad Airstrip");

    private final String type;

    /**
     *
     * @param type of the airstrip
     */
    AirStripType(final String type) {
        this.type = type;
    }

    /**
     *
     * @return type of the airstrip
     */
    public String getType() {
        return this.type;
    }
}
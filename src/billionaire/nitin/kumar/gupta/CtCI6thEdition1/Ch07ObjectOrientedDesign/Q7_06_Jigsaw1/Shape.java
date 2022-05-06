package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch07ObjectOrientedDesign.Q7_06_Jigsaw1;

public enum Shape {
    INNER, OUTER, FLAT;

    public Shape getOpposite() {
        switch (this) {
            case INNER:
                return OUTER;
            case OUTER:
                return INNER;
            default:
                return null;
        }
    }
}

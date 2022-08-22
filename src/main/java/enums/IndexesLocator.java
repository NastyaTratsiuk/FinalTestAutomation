package enums;

public enum IndexesLocator {

    TEST_NAME (1),
    METHOD_NAME (2),
    STATUS (3),
    START_TIME_STRING (4),
    END_TIME_STRING (5),
    SID (6);

    int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    IndexesLocator(int index) {
        this.index = index;
    }
}

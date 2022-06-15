package rinat.isangulov.stolovka.entity;

public enum Status {
    NEW, PROCESSED, PREPARED, FINISHED, CLOSE;

    public String getStatus() {
        return name();
    }
}

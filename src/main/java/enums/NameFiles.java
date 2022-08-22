package enums;

public enum NameFiles {

    CONFIG("config.json"),
    TESTING("testing.json");

    String nameFile;

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    NameFiles(String nameFile) {
        this.nameFile = nameFile;
    }
}
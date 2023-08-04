package by.training.module3.entity;

public enum PortType {
    NONE("NONE"),COM("COM"),USB("USB"),LPT("LPT");

    String value;

    PortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

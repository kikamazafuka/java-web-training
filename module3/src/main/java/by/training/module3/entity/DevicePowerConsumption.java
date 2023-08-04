package by.training.module3.entity;

public class DevicePowerConsumption {

    private String unit="wt";
    private int value = 3;

    public DevicePowerConsumption() {
    }

    public DevicePowerConsumption(String unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "DevicePowerConsumption{" +
                "unit= '" + unit + '\'' +
                ", value= " + value +
                '}';
    }
}

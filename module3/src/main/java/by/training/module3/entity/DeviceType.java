package by.training.module3.entity;

import java.util.Objects;

public class DeviceType {

    private boolean isPeripheral;
    private String cooling;
    private String group;
    private PortType port;
    private DevicePowerConsumption devicePowerConsumption;

   /* public DeviceType(boolean isPeripheral, String cooling,
                      String group, PortType port,
                      DevicePowerConsumption devicePowerConsumption) {
        this.isPeripheral = isPeripheral;
        this.cooling = cooling;
        this.group = group;
        this.port = port;
        this.devicePowerConsumption = devicePowerConsumption;
    }*/

    public boolean isPeripheral() {
        return isPeripheral;
    }

    public void setPeripheral(boolean peripheral) {
        isPeripheral = peripheral;
    }

    public String getCooling() {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public PortType getPort() {
        return port;
    }

    public void setPort(PortType port) {
        this.port = port;
    }

    public DevicePowerConsumption getDevicePowerConsumption() {
        return devicePowerConsumption;
    }

    public void setDevicePowerConsumption(DevicePowerConsumption devicePowerConsumption) {
        this.devicePowerConsumption = devicePowerConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceType that = (DeviceType) o;
        return isPeripheral == that.isPeripheral &&
                Objects.equals(cooling, that.cooling) &&
                Objects.equals(group, that.group) &&
                port == that.port &&
                Objects.equals(devicePowerConsumption, that.devicePowerConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPeripheral, cooling, group, port, devicePowerConsumption);
    }

    @Override
    public String toString() {
        return "DeviceType{" +
                "isPeripheral= " + isPeripheral +
                ", cooling= '" + cooling + '\'' +
                ", group= '" + group + '\'' +
                ", port= " + port +
                ", devicePowerConsumption = " + devicePowerConsumption +
                '}';
    }
}

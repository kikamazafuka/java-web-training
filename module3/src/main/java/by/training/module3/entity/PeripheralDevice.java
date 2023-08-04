package by.training.module3.entity;


public class PeripheralDevice extends Device {

    PortType port;

    public PeripheralDevice(long id, String name, String origin, Price price, String critical, DeviceType deviceType) {
        super(id, name, origin, price, critical, deviceType);
    }

    public PeripheralDevice(long id, String name, String origin, Price price, String critical, DeviceType deviceType, PortType port) {
        super(id, name, origin, price, critical, deviceType);
        this.port = port;
    }

    @Override
    public String toString() {
        return "PeripheralDevice{" +
                "port=" + port +
                "} " + super.toString();
    }
}

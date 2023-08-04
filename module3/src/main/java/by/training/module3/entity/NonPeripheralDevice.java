package by.training.module3.entity;

public class NonPeripheralDevice extends Device {
    public NonPeripheralDevice(long id, String name, String origin, Price price, String critical, DeviceType deviceType) {
        super(id, name, origin, price, critical, deviceType);
    }
}

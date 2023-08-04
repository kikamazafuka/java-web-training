package by.training.module3.entity;


public class Device {

    private long deviceId;
    private String name;
    private String origin;
    private Price price;
    private String critical;
    DeviceType deviceType;

    public Device() {
    }

    public Device(long id, String name, String origin, Price price,
                  String critical, DeviceType deviceType) {
        this.deviceId = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.critical = critical;
        this.deviceType = deviceType;
    }

    public long getId() {
        return deviceId;
    }

    public void setId(long id) {
        this.deviceId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String isCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }


    @Override
    public String toString() {
        return "Device{" +
                "id= " + deviceId +
                ", name= '" + name + '\'' +
                ", origin= '" + origin + '\'' +
                ", price= " + price +
                ", critical= " + critical +
                ", deviceType= " + deviceType +
                '}';
    }
}

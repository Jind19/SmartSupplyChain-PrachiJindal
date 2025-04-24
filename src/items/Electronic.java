package items;

public class Electronic extends Product {
    private String deviceType;

    public String getDeviceType() {
        return deviceType;
    }

    public Electronic(int id, String name, String deviceType) {
        super(id, name);
        this.deviceType = deviceType;
    }

    @Override
    public String getType() {
        return "Electronic";
    }

    @Override
    public String toString() {
        return "Electronic[ID=" + id + ", Name=" + name + ", DeviceType=" + deviceType + "]";
    }
}

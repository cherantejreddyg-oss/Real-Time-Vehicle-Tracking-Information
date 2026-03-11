package VehicleMonitoring;

public class User {

    String username;
    String password;
    String vehicleNumber;
    VehicleHistory history;

    public User(String username, String password, String vehicleNumber) {
        this.username = username;
        this.password = password;
        this.vehicleNumber = vehicleNumber;
        this.history = new VehicleHistory();
    }
}

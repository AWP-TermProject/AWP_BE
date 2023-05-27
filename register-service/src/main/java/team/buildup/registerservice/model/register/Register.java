package team.buildup.registerservice.model.register;

public class Register {
    private String username;
    private String registrationDate;
    private String[] droneTypes;

    public Register(String username, String[] droneTypes, String registrationDate) {
        this.username = username;
        this.droneTypes = droneTypes;
        this.registrationDate = registrationDate;
    }

    public String getUsername() {
        return username;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String[] getDroneTypes() {
        return droneTypes;
    }
}

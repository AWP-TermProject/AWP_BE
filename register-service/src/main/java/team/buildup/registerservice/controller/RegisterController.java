package team.buildup.registerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import team.buildup.registerservice.model.register.Register;

import java.util.HashMap;
import java.util.Map;

public class RegisterController {
    private Map<String, Register> registerMap = new HashMap<>();

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        String[] droneTypes = registerRequest.getDroneTypes();
        String registrationDate = registerRequest.getRegistrationDate();

        // 사용자 등록 정보 저장
        Register register = new Register(username, droneTypes, registrationDate);
        registerMap.put(username, register);

        return "사용자 등록이 완료되었습니다.";
    }

    @GetMapping("/users/{username}")
    public Register getUser(@PathVariable String username) {
        return registerMap.get(username);
    }

    public static class RegisterRequest {
        private String username;
        private String[] droneTypes;
        private String registrationDate;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String[] getDroneTypes() {
            return droneTypes;
        }

        public void setDroneTypes(String[] droneTypes) {
            this.droneTypes = droneTypes;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }
    }
}

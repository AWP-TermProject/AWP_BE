package team.buildup.registerservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    private final RegisterRepository registerRepository;

    public RegisterController(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody Register register) {
        registerRepository.save(register);
        return ResponseEntity.ok("드론 예약이 저장되었습니다.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Register> getReservation(@PathVariable("id") Long id) {
        Optional<Register> register = registerRepository.findById(id);
        return register.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Register>> getAllReservations() {
        List<Register> reservations = registerRepository.findAll();
        return ResponseEntity.ok(reservations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable("id") Long id, @RequestBody Register register) {
        Optional<Register> optionalRegister = registerRepository.findById(id);
        if (optionalRegister.isPresent()) {
            Register existingRegister = optionalRegister.get();
            existingRegister.setUsername(register.getUsername());
            existingRegister.setReservationDate(register.getReservationDate());
            existingRegister.setDroneType(register.getDroneType());

            registerRepository.save(existingRegister);
            return ResponseEntity.ok("드론 예약이 업데이트되었습니다.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") Long id) {
        Optional<Register> optionalRegister = registerRepository.findById(id);
        if (optionalRegister.isPresent()) {
            registerRepository.deleteById(id);
            return ResponseEntity.ok("드론 예약이 삭제되었습니다.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
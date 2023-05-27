package buildup.backend.usersservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin("http://localhost:8083")
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/api/user/{id}")
    public Optional<User> getMemberId(@PathVariable("id") Long id ){
        return  userRepository.findById(id);
    }

    @GetMapping("/")
    public User  index(){
        User member = new User(1, "gachon", "gachon.ac.kr", "gcu");
        return member;
    }
    @GetMapping("/api/users")
    public List<User> showAll(){
        return userRepository.findAll();
    }
    @PostMapping("/api/user")
    public String create(@RequestBody User member) {
        userRepository.save(member);
        return "member create ok";
    }
    //email, pw


    //회원가입 api : post/api/register/local

    //로그인 api : post /api/login/local

    //이메일 아이디 중복확인 GET /exists/:key/
}

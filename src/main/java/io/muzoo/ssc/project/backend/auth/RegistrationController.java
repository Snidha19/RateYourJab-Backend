package io.muzoo.ssc.project.backend.auth;

import io.muzoo.ssc.project.backend.dto.SimpleResponseDTO;
import io.muzoo.ssc.project.backend.model.User;
import io.muzoo.ssc.project.backend.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("api/register")
    public SimpleResponseDTO signup(HttpServletRequest request){
        String username = request.getParameter("username");
        if (userRepository.findFirstByUsername(username) != null){
            return SimpleResponseDTO
                    .builder()
                    .success(false)
                    .message("username already exist")
                    .build();
        } else {
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");

            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole("USER");
            user.setAge(Integer.valueOf(age));
            user.setGender(gender);
            user.setFullName(fullName);
            userRepository.save(user);

            return SimpleResponseDTO
                    .builder()
                    .success(true)
                    .message("Sign in complete")
                    .build();
        }
    }
}

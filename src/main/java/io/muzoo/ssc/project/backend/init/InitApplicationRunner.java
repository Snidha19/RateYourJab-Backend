package io.muzoo.ssc.project.backend.init;

import io.muzoo.ssc.project.backend.User;
import io.muzoo.ssc.project.backend.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //add default admin user and set it's password if missing
        User admin = userRepository.findFirstByUsername("ing");
        if (admin == null){
            admin = new User();
            admin.setUsername("ing");
            admin.setPassword(passwordEncoder.encode("Password"));
            admin.setRole("USER");
            admin.setDateOfBirth("21/11/2000");
            admin.setGender("MALE");
            admin.setFullName("Jirayu Apivisankij");
            userRepository.save(admin);
        }
    }
}

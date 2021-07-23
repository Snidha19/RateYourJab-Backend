package io.muzoo.ssc.project.backend.init;

import io.muzoo.ssc.project.backend.model.User;
import io.muzoo.ssc.project.backend.model.UserRepository;
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
        User admin = userRepository.findFirstByUsername("Ing");
        if (admin == null){
            admin = new User();
            admin.setUsername("Ing");
            admin.setPassword(passwordEncoder.encode("pass"));
            admin.setRole("USER");
            admin.setAge(21);
            admin.setGender("MALE");
            admin.setFullName("Jirayu Apivisankij");
            userRepository.save(admin);
        }

    }
}

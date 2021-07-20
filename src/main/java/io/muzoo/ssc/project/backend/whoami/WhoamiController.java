package io.muzoo.ssc.project.backend.whoami;


import io.muzoo.ssc.project.backend.UserRepository;
import io.muzoo.ssc.project.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
A controller to retrieve currently logged-in user
 */
@RestController
public class WhoamiController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/whoami")
    public WhoamiDTO whoami() {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null && principal instanceof org.springframework.security.core.userdetails.User) {
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) principal;
                User u = userRepository.findFirstByUsername(user.getUsername());
                return WhoamiDTO.builder()
                        .loggedIn(true)
                        .name(u.getUsername()).build();
            }
        } catch (Exception e) {
            //user is not log in
            return WhoamiDTO.builder()
                    .loggedIn(false)
                    .build();
        }
        //user is not log in
        return WhoamiDTO.builder()
                .loggedIn(false)
                .build();
    }
}

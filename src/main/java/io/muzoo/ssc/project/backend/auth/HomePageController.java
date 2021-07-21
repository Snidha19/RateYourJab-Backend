package io.muzoo.ssc.project.backend.auth;

import org.springframework.web.bind.annotation.GetMapping;

public class HomePageController {
    @GetMapping("/api/homepage")
    //this will be directed only a user is logged in
    //once the user is here, all the reviews will be rendered
    public String home(){
        return "If this message is shown, it means login is successful";
    }
}

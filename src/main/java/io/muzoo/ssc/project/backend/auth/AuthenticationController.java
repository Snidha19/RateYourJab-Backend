package io.muzoo.ssc.project.backend.auth;

import io.muzoo.ssc.project.backend.SimpleResponseDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @GetMapping("/api/test")
    public String test(){
    return "If this message is shown, it means login is successful because we did not permit this path";
    }


    @PostMapping("/api/login")
    public SimpleResponseDTO login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            //check if there is a current user logged, if so, log out the current user first
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal!=null && principal instanceof org.springframework.security.core.userdetails.User){
                request.logout();
            }
            request.login(username,password);
            return SimpleResponseDTO
                    .builder()
                    .success(true)
                    .message("Login successful")
                    .build();
        } catch (ServletException e) {
            return SimpleResponseDTO
                    .builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }


    }
    @GetMapping("/api/logout")
    public SimpleResponseDTO logout(HttpServletRequest request){
        try {
            request.logout();
            return SimpleResponseDTO
                    .builder()
                    .success(true)
                    .message("Logout successful")
                    .build();
        } catch (ServletException e) {
            return SimpleResponseDTO
                    .builder()
                    .success(false)
                    .message(e.getMessage()) //i wanna see what is this error message so lego -> so it says: Bad credentials
                    .build();
        }
    }
}

package store.web;

import store.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @GetMapping("/signup")
    public String signup() {

//        todo complete registration

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {

//        todo complete registration

        return "signup";
    }
}

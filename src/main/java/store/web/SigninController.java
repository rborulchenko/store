package store.web;

import store.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

@Controller
public class SigninController {


    @GetMapping("/")
    public String index() {
        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signin(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute User user) {

        if (StringUtils.equals(user.getUsername(), "admin") && StringUtils.equals(user.getPassword(), "admin")) {
            return "catalog";
        }

        return "index";
    }
}

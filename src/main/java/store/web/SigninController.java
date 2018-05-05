package store.web;

import store.model.Customer;
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
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute Customer customer) {

        if (StringUtils.equals(customer.getUsername(), "admin") && StringUtils.equals(customer.getPassword(), "admin")) {
            return "catalog";
        }

        return "index";
    }
}

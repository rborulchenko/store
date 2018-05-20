package store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import store.model.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import store.repository.PrincipalRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SigninController
{
  @Autowired
  PrincipalRepository principalRepository;


  @GetMapping("/")
  public String root()
  {
    return "redirect:/signin";
  }

  @GetMapping("/signin")
  public String signin(Model model)
  {
    model.addAttribute("principal", new Principal());
    return "signin";
  }

  @PostMapping("/signin")
  @Transactional(readOnly = true)
  public String signin(@ModelAttribute Principal principal)
  {
    List<Principal> byUsername = principalRepository.findByLoginReturnsStream(principal.getLogin()).collect(Collectors.toList());
    if (!byUsername.isEmpty() && byUsername.get(0) != null) {
      return "catalog";
    }

    return "signin";
  }
}

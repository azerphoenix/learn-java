package info.md7.java.homeworks.enterprise.controllers;


import info.md7.java.homeworks.enterprise.dto.CarDto;
import info.md7.java.homeworks.enterprise.dto.UserDto;
import info.md7.java.homeworks.enterprise.services.CarService;
import info.md7.java.homeworks.enterprise.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FrontController {

  private final UserService userService;
  private final CarService carService;

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("users", userService.findAll());
    model.addAttribute("cars", carService.findAll());
    model.addAttribute("car", new CarDto());
    model.addAttribute("user", new UserDto());
    return "home";
  }

}

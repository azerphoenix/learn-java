package info.md7.java.homeworks.enterprise.controllers;


import info.md7.java.homeworks.enterprise.dto.UserDto;
import info.md7.java.homeworks.enterprise.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @PostMapping("/add")
  public String addNewUser(@ModelAttribute UserDto userDto) {
    userService.save(userDto);
    return "redirect:/";
  }

  @PostMapping("/delete")
  @ResponseBody
  public String deleteUser(@RequestParam("userId") Long userId) {
    String response;
    if (userService.delete(userId)) {
      response = "true";
    } else {
      response = "false";
    }
    return response;
  }

}

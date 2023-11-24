package kz.bitlab.G118security.controller;

import kz.bitlab.G118security.model.User;
import kz.bitlab.G118security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/forbidden")
    public String forbiddenPage() {
        return "forbidden";
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public String addUser(User user, @RequestParam String rePassword) {
        String result = userService.createUser(user, rePassword);
        return "redirect:/login?" + result;
    }

    @PostMapping("/change-password")
    @PreAuthorize("isAuthenticated()")
    public String changePassword(String currentPassword, String newPassword, String reNewPassword) {
        String result = userService.changePassword(currentPassword, newPassword, reNewPassword);
        return "redirect:/" + result;
    }
}

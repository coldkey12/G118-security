package kz.bitlab.G118security.service;

import kz.bitlab.G118security.model.Role;
import kz.bitlab.G118security.model.User;
import kz.bitlab.G118security.repository.RoleRepository;
import kz.bitlab.G118security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public String createUser(User newUser, String rePassword) {
        User user = userRepository.findByUsername(newUser.getUsername());
        if (user != null) {
            return "errorEmail";
        }
        if (!newUser.getPassword().equals(rePassword)) {
            return "errorPassword";
        }
        newUser.setPassword(passwordEncoder.encode(rePassword));
        Role userRole = roleRepository.findUserRole();
        newUser.setRoles(List.of(userRole));
        userRepository.save(newUser);
        return "success";
    }

    public User getCurrentUser() {
        var currentUser = SecurityContextHolder.getContext().getAuthentication();
        return (User) currentUser.getPrincipal();
    }

    public String changePassword(String currentPassword, String newPassword, String reNewPassword) {
        if (!passwordEncoder.matches(currentPassword, getCurrentUser().getPassword())) {
            return "errorCurrentPassword";
        }

        if (!newPassword.equals(reNewPassword)) {
            return "errorNewPassword";
        }

        getCurrentUser().setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(getCurrentUser());
        return "success";
    }
}

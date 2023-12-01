package kz.bitlab.G118security.report;

import kz.bitlab.G118security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ReportGenerator {
    private final UserService userService;

//    @Scheduled(fixedDelay = 60000 * 60 * 24)
//    public void generateUserReport() throws IOException {
//        userService.generateUserReport();
//    }
//
//    @Scheduled(fixedDelay = 60000 * 60 * 24)
//    private void checkAndCreateUsers() throws IOException{
//        userService.checkAndCreateUsers();
//    }
}

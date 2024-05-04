package com.example.testrest;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/")
public class TestController {

    @PostMapping
    public void test(@RequestPart("user") User user,
                     @RequestPart("avatar") MultipartFile avatar,
                     @RequestPart("cv") MultipartFile cv,
                     @RequestPart("doc")MultipartFile doc) throws IOException {


//        File file = new File("test.png");
        FileOutputStream fileOutputStream = new FileOutputStream("test.png");
        fileOutputStream.write(avatar.getBytes());
        FileOutputStream fileOutputStream1 = new FileOutputStream("test.pdf");
        fileOutputStream1.write(doc.getBytes());
        log.info(fileOutputStream1.toString());

        fileOutputStream.close();

        System.out.println(user);
        System.out.println(Arrays.toString(avatar.getBytes()));
        System.out.println(Arrays.toString(cv.getBytes()));
    }



    @Setter
    @Getter
    static class User {
        String userName;
        String password;

        public User() {
        }

        public User(String name) {
            this.userName = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userName, password);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + userName + '\'' +
                    '}';
        }
    }
}



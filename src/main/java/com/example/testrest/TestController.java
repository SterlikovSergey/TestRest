package com.example.testrest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class TestController {

    @PostMapping
    public void test(@RequestPart("user") User user,
                     @RequestPart("avatar") MultipartFile avatar,
                     @RequestPart("cv") MultipartFile cv) throws IOException {


//        File file = new File("test.png");
        FileOutputStream fileOutputStream = new FileOutputStream("test.png");
        fileOutputStream.write(avatar.getBytes());
        System.out.println(user);
        System.out.println(avatar.getBytes());
        System.out.println(cv.getBytes());
    }



    static class User {
        String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}



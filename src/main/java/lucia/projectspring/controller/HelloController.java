package lucia.projectspring.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("helloMvc")
    public String helloMvc(@RequestParam("user") String name, Model model) {
        model.addAttribute("user", name);
        return "hello-template";
    }

    @GetMapping("helloApi")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    @Getter
    @Setter
    static class Hello {
        private String name;
    }
}

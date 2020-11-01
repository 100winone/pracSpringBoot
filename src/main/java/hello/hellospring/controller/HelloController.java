package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 어노테이션 필수
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello"; // hello.html 을 찾아서 열어라 , viewResolver가 화면을 찾아서 처리
    }
}

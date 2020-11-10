package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 어노테이션 필수
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // hello.html 을 찾아서 열어라 , viewResolver가 화면을 찾아서 처리
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // 모델에 담으면 뷰에서 렌더링 할때 받아옴
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 데이터를 그대로 내려주는 방식
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // hello spring // 내가 요청한 클라이언트에 그대로 들어
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 이렇게 객체를 넘기면 json방식으로 넘어
    }

    static class Hello { // static class는 클래스 안에서 클래스를 또 쓸 수 있음
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

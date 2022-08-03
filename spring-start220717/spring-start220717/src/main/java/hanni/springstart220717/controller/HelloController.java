package hanni.springstart220717.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello Spring");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    @GetMapping("hello-string")//문자 그대로 데이터를 직접 넣어준다
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")//객체
    @ResponseBody  //객체가 return 되면 json형태로 반환되는 것이 기본
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() { //getter and setter alt+insert
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
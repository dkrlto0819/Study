package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get")
    public ModelAndView get() {
        User user = User.builder().id(1).name("hulk").password("1234").build();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadpage() {
        return "upload";
    }


    @RequestMapping("/error")
    public void error() {
        throw new RuntimeException("runtime exception");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView errorpage(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }
}

package org.launchcode.animalroster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "hello") // localhost:8080/hello/ROUTENAME
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // localhost:8080/hello/hello
    public String hello(@RequestParam String name) {
        if (name.isBlank()) {
            name = "LaunchCode";
        } else if (name.equalsIgnoreCase("apple dog")) {
            return "<h1>Hello, Banana Cat! <em>Also how dare you.</em> >:(</h1>";
        }

        return String.format("<h1>Hello, %s!</h1>", name);
    }

    @GetMapping // localhost:8080/hello
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = '/hello/hello'>" +
                "<input type = 'text' name = 'name' />" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
    }


//    @ResponseBody
//    @GetMapping("hello") // localhost:8080/hello
//    public String hello() {
//        return "<h1>Hello, Gerard!</h1>";
//    }
//
//    @ResponseBody
//    @GetMapping("helloquery") // localhost:8080/helloquery?name=SOMETHING
//    public String helloQuery(@RequestParam String name) {
//        if (name.isBlank()) {
//            name = "LaunchCode";
//        }
//        return String.format("<h1>Hello, %s!</h1>", name);
//    }
//
//    @ResponseBody
//    @GetMapping("hello/{name}") // localhost:8080/hello/{name}
//    public String helloPath(@PathVariable String name) {
//        return String.format("<h1>Hello, %s!</h1>", name);
//    }
}

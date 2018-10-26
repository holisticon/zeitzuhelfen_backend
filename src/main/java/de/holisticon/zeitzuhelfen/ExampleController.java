package de.holisticon.zeitzuhelfen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/private")
public class ExampleController {

    @GetMapping("tryOut")
    public String tryOut() {
        return "HelloWorld!";
    }
}

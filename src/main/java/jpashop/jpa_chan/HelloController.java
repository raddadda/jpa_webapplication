package jpashop.jpa_chan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    //hello.html에서..
    @GetMapping("hello")
    public String hello(Model model){
        //value객체를 name이름으로 추가한다.
        model.addAttribute("data","hello!!!");
        return "hello";
    }
}

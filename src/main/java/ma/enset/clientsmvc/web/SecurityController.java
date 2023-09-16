package ma.enset.clientsmvc.web;

import org.springframework.web.bind.annotation.GetMapping;

public class SecurityController {
    @GetMapping("403")
    public String noAuthorized(){
        return "403";
    }


}

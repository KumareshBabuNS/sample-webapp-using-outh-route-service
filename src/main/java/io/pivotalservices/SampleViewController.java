package io.pivotalservices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

@Controller
final class SampleViewController {

    private Random random = new Random();
    private final String SESSION_ATTRIBUTE_NAME="myattribute";
    
    @RequestMapping("/")
    public String page() {
        return "index";
    }

    @RequestMapping("/storeinsession")
    public String storeInSession(HttpSession session) {
        session.setAttribute(SESSION_ATTRIBUTE_NAME, random.nextInt(10000));
        return "redirect:/";
    }

    @RequestMapping("/retrievefromsession")
    public String retrieveFromSession(HttpSession session, Model model) {
        model.addAttribute(SESSION_ATTRIBUTE_NAME, session.getAttribute(SESSION_ATTRIBUTE_NAME));
        return "sessionattributes";
    }
}

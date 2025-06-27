package com.example.mail.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MailController {

    @RequestMapping("/config")
    public String showConfig(Model model) {
        Map<String, Object> config = (Map<String, Object>) SpringContext.getBean("mailConfig");
        model.addAttribute("config", config);
        return "mailConfig";
    }

    @RequestMapping(value = "/updateConfig", method = RequestMethod.POST)
    public String updateConfig(
            @RequestParam("language") String language,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("spamFilter") boolean spamFilter,
            @RequestParam("signature") String signature,
            Model model) {
        Map<String, Object> config = (Map<String, Object>) SpringContext.getBean("mailConfig");
        config.put("language", language);
        config.put("pageSize", pageSize);
        config.put("spamFilter", spamFilter);
        config.put("signature", signature);
        model.addAttribute("config", config);
        return "mailConfig";
    }
}


class SpringContext {
    public static Object getBean(String beanName) {

        return new java.util.HashMap<>();
    }
}

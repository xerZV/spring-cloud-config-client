package com.simitchiyski.cloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RefreshScope
public class RateController {

    @Value("${rate}")
    String rate;

    @Value("${lanecount}")
    String laneCount;

    @Value("${tollstart}")
    String tollStart;

    @Value("${tollstop}")
    String tollStop;

    @Value("${connstring}")
    String connString;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/rate";
    }

    @GetMapping("/rate")
    public String getRate(Model model) {
        model.addAttribute("rate", rate);
        model.addAttribute("laneCount", laneCount);
        model.addAttribute("tollStart", tollStart);
        model.addAttribute("tollStop", tollStop);
        model.addAttribute("connString", connString);

        return "rateview";
    }

}

package volodymyr.zalutskyi.transfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPageController {

    @RequestMapping("/addresses")
    public String addresses() {
        return "addresses.html";
    }

    @RequestMapping("/stops")
    public String stops(){
        return "stops.html";
    }

    @RequestMapping("/clients")
    public String clients(){
        return "clients.html";
    }

    @RequestMapping("/cabs")
    public String cabs(){
        return "cabs.html";
    }

    @RequestMapping("/destinations")
    public String destinations(){
        return "destinations.html";
    }

    @RequestMapping("/orders")
    public String orders(){
        return "orders.html";
    }

    @RequestMapping("/caborders")
    public String caborders(){
        return "caborders.html";
    }
}

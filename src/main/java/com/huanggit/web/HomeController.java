package com.huanggit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET,produces = "text/html")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET,produces = "text/html")
    public String testPage() {
        return "test";
    }
}

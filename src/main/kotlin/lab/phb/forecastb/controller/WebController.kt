package lab.phb.forecastb.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class WebController {

    @RequestMapping("/")
    fun getRoot() = "root"

}
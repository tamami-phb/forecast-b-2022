package lab.phb.forecastb.controller

import lab.phb.forecastb.model.Periode
import lab.phb.forecastb.repo.ResumeRepo
import lab.phb.forecastb.services.LeastSquare
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class WebController {

    val log = LoggerFactory.getLogger(WebController::class.java)
    @Autowired
    lateinit var repo: ResumeRepo

    @RequestMapping("/")
    fun getRoot(model: Model): String {
        model.addAttribute("param", Periode())
        return "root"
    }

    @RequestMapping(value = [ "/proses" ], method = [ RequestMethod.POST ])
    fun proses(param: Periode, model: Model): String {
        var data = repo.findByTglBetween(param.tglAwal, param.tglAkhir)

        if(data.size <= 0) {
            model.addAttribute("error", "data tidak ada")
            return "proses"
        }


        var result = LeastSquare.getLeastSquare(data)
        model.addAttribute("hasil", result)
        return "proses"
    }

}
package lab.phb.forecastb.services

import lab.phb.forecastb.repo.ResumeRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LeastSquareTest {

    @Autowired
    lateinit var repo: ResumeRepo
    val log = LoggerFactory.getLogger(LeastSquareTest::class.java)

    @Test
    fun getATest() {
        var result = repo.findAll()
        var a = LeastSquare.getA(result)
        log.info("a : " + a)
        Assertions.assertNotNull(a)
    }

    @Test
    fun initXTest() {
        var x1 = LeastSquare.initX(2)
        var x2 = LeastSquare.initX(5)
        var x3 = LeastSquare.initX(10)
        var x4 = LeastSquare.initX(11)
        log.info("x1 : " + x1)
        log.info("x2 : " + x2)
        log.info("x3 : " + x3)
        log.info("x4 : " + x4)
        Assertions.assertTrue(true)
    }

    @Test
    fun generateXTest() {
        var data = repo.findAll()
        var result = LeastSquare.generateX(data)
        log.info(result.toString())
        Assertions.assertNotNull(result)
    }

    @Test
    fun getSumXYTest() {
        var data = repo.findAll()
        var x = LeastSquare.generateX(data)
        var result = LeastSquare.getSumXY(x, data)
        log.info("hasil: " + result)
        Assertions.assertNotNull(result)
    }

    @Test
    fun getLeastSquareTest() {
        var data = repo.findAll()
        var result = LeastSquare.getLeastSquare(data)
        log.info("hasil : " + result)
        Assertions.assertNotNull(result)
    }

}
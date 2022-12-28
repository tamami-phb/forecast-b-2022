package lab.phb.forecastb.repo

import lab.phb.forecastb.model.Resume
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResumeRepo: JpaRepository<Resume, String> {

    fun findByTglBetween(tgl1: String, tgl2: String): List<Resume>

}
package lab.phb.forecastb.model

data class Periode(
    var tglAwal: String,
    var tglAkhir: String
) {
    constructor(): this("", "")
}

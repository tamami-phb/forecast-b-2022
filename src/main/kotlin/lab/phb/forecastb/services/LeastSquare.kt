package lab.phb.forecastb.services

import lab.phb.forecastb.model.Resume

class LeastSquare {

    companion object {
        fun getLeastSquare(data: List<Resume>): Double {
            // a + bx
            var a = getA(data)
            var b = getB(data)
            var x = getFinalX(data)
            return a + (b * x)
        }

        fun getFinalX(data: List<Resume>): Int {
            var listX = generateX(data)
            if(data.size % 2 == 0) {    // genap
                return listX[data.size - 1] + 2
            } else {
                return listX[data.size - 1] + 1
            }
        }

        fun getB(data: List<Resume>): Double {
            var xField = generateX(data)
            var sumXY = getSumXY(xField, data)
            var sumX2 = getSumX2(xField)
            return sumXY / sumX2
        }

        fun getSumX2(data: List<Int>): Double {
            var result = 0.0
            data.forEach {
                result += it * it
            }
            return result
        }

        fun getSumXY(x: List<Int>, data: List<Resume>): Double {
            var result = 0.0
            for(i in 0..x.size-1) {
                result += x.get(i) * data.get(i).total
            }
            return result
        }

        fun generateX(data: List<Resume>): List<Int> {
            var xAwal = initX(data.size)
            var result = mutableListOf<Int>()
            if(data.size % 2 == 0) {
                data.forEach {
                    result.add(xAwal)
                    xAwal += 2
                }
            } else {
                data.forEach {
                    result.add(xAwal++)
                }
            }
            return result
        }

        fun initX(n: Int): Int {
            if(n % 2 == 0) {    // genap
                return (n - 1) - ((n - 1) * 2)
            } else {    // ganjil
                return ((n - 1) / 2) - (n - 1)
            }
        }

        fun getA(data: List<Resume>): Double {
            var result = 0.0
            data.forEach {
                result += it.total
            }
            return result / data.size
        }

    }

}
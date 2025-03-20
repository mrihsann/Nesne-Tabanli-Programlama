package com.ihsanarslan.nesnetabanliprogramlama


class Araba(val marka: String, val model: String, val renk: String, val beygirGucu : Int) {

    var hiz: Int = 0

    fun sur() {
        println("Motor çalıştırıldı! Güç: $beygirGucu HP")
        println("$renk $marka $model yola çıkıyor!")
    }

    fun gazaBas(miktar: Int) {
        hiz += miktar
        println("Hız arttı: $hiz km/s")
    }

    fun frenYap(miktar: Int) {
        hiz -= miktar
        if (hiz < 0) hiz = 0
        println("Hız azaldı: $hiz km/s")
    }
}

fun main() {
    // Araba Kullanımı
    val araba = Araba("Toyota", "Corolla", "Kırmızı", 150)
    araba.sur()
    araba.gazaBas(30)
    araba.gazaBas(20)
    araba.frenYap(25)
    araba.frenYap(30)
}
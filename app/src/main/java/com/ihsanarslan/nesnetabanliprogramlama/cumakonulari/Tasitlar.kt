package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Temel taşıt sınıfı
open class Tasit(
    val marka: String,
    val model: String,
    var hiz: Int = 0
) {
    open fun hizlan(artis: Int) {
        hiz += artis
        println("$marka $model hızlanıyor. Mevcut hız: $hiz")
    }
    
    open fun yavasla(azalis: Int) {
        hiz = maxOf(0, hiz - azalis)
        println("$marka $model yavaşlıyor. Mevcut hız: $hiz")
    }
}

// Araba sınıfı
class Araba(
    marka: String,
    model: String,
    val kapiSayisi: Int,
    private var vitesPos: Int = 1
) : Tasit(marka, model) {
    
    fun vitesArttir() {
        if (vitesPos < 6) {
            vitesPos++
            println("Vites $vitesPos'e yükseltildi")
        }
    }
    
    fun vitesAzalt() {
        if (vitesPos > 1) {
            vitesPos--
            println("Vites $vitesPos'e düşürüldü")
        }
    }
}

// Motosiklet sınıfı
class Motosiklet(
    marka: String,
    model: String,
    val elektrikliMi: Boolean
) : Tasit(marka, model) {
    
    override fun hizlan(artis: Int) {
        super.hizlan(artis)
        if (hiz > 50) {
            println("Kask takılı olduğundan emin olun!")
        }
    }
}

fun main() {
    val araba = Araba("Toyota", "Corolla", 4)
    val motosiklet = Motosiklet("Honda", "CBR", false)
    
    println("--- Araba Test ---")
    araba.hizlan(30)
    araba.vitesArttir()
    araba.hizlan(20)
    araba.yavasla(10)
    
    println("\n--- Motosiklet Test ---")
    motosiklet.hizlan(40)
    motosiklet.hizlan(20)
    motosiklet.yavasla(30)
}
package com.ihsanarslan.nesnetabanliprogramlama.salikonulari


class HesapMakinesi {
    var sonuc: Double = 0.0

    fun topla(vararg sayilar: Double) {
        sayilar.forEach { sayi ->
            sonuc += sayi
        }
        println("Toplam: $sonuc")
    }

    fun cikar(a: Double, b: Double) {
        sonuc = a - b
        println("Fark: $sonuc")
    }

    fun carp(vararg sayilar: Double) {
        sonuc = 1.0
        sayilar.forEach { sayi ->
            sonuc *= sayi
        }
        println("Çarpım: $sonuc")
    }

    fun bol(a: Double, b: Double) {
        if (b == 0.0) {
            println("Bölen 0 olamaz!")
            return
        }
        sonuc = a / b
        println("Bölüm: $sonuc")
    }
}

fun main() {
    // Hesap Makinesi Kullanımı
    val hesapMakinesi = HesapMakinesi()
    hesapMakinesi.topla(10.0, 5.0, 3.0)
    hesapMakinesi.cikar(20.0, 4.0)
    hesapMakinesi.carp(2.0, 3.0, 4.0)
    hesapMakinesi.bol(100.0, 5.0)
    hesapMakinesi.bol(10.0, 0.0) // Hata durumu test etme
}

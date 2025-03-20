package com.ihsanarslan.nesnetabanliprogramlama


class BankaHesabi(
    val hesapNo: String,
    val hesapSahibi: String,
    var bakiye: Double = 0.0  // Başlangıç bakiyesi 0
) {
    fun paraYatir(miktar: Double) {
        if (miktar > 0) {
            bakiye += miktar
            println("$miktar TL yatırıldı")
            bakiyeGoster()
        } else {
            println("Geçersiz miktar! Pozitif bir değer giriniz.")
        }
    }

    fun paraCek(miktar: Double) {
        if (miktar <= 0) {
            println("Geçersiz miktar! Pozitif bir değer giriniz.")
            return
        }

        if (miktar > bakiye) {
            println("Yetersiz bakiye!")
            bakiyeGoster()
            return
        }

        bakiye -= miktar
        println("$miktar TL çekildi")
        bakiyeGoster()
    }

    fun bakiyeGoster() {
        println("Güncel bakiye: $bakiye TL")
    }

    fun hesapBilgileri() {
        println("Hesap No: $hesapNo")
        println("Hesap Sahibi: $hesapSahibi")
        println("Bakiye: $bakiye TL")
    }
}

fun main() {
    // Yeni bir hesap oluşturalım
    val hesap1 = BankaHesabi(hesapNo = "12345", hesapSahibi = "İhsan Arslan")

    // Hesap bilgilerini gösterelim
    hesap1.hesapBilgileri()
    println("---------------")

    // Para yatıralım
    hesap1.paraYatir(1000.0)
    println("---------------")

    // Para çekelim
    hesap1.paraCek(500.0)
    println("---------------")

    // Yetersiz bakiye durumunu test edelim
    hesap1.paraCek(1000.0)
    println("---------------")

    // Geçersiz miktar durumunu test edelim
    hesap1.paraYatir(-100.0)
}
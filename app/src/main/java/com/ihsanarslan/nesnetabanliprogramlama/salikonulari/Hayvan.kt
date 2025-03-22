package com.ihsanarslan.nesnetabanliprogramlama.salikonulari


class Hayvan(val tur: String, val isim: String, var yas: Int) {
    fun sesCikar() {
        when (tur) {
            "kedi" -> println("$isim: Miyav!")
            "köpek" -> println("$isim: Hav hav!")
            "kuş" -> println("$isim: Cik cik!")
            else -> println("$isim bir ses çıkardı!")
        }
    }

    fun bilgileriGoster() {
        println("Hayvan türü: $tur")
        println("İsmi: $isim")
        println("Yaşı: $yas")
    }
}

fun main() {
    // Hayvanları oluşturalım
    val kedi = Hayvan("kedi", "Pamuk", 3)
    val kopek = Hayvan("köpek", "Karabaş", 5)

    // Hayvanların bilgilerini gösterelim
    kedi.bilgileriGoster()
    kedi.sesCikar()

    println("---------------")

    kopek.bilgileriGoster()
    kopek.sesCikar()
}
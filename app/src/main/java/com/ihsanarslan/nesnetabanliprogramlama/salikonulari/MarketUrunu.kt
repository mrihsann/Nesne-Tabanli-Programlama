package com.ihsanarslan.nesnetabanliprogramlama.salikonulari


class MarketUrunu(val ad: String, var fiyat: Double, var stok: Int) {
    fun satis(adet: Int) {
        if (adet <= stok) {
            stok -= adet
            val toplamFiyat = fiyat * adet
            println("$adet adet $ad satıldı")
            println("Toplam fiyat: $toplamFiyat TL")
            println("Kalan stok: $stok")
        } else {
            println("Üzgünüz, yeterli stok yok!")
            println("Mevcut stok: $stok")
        }
    }

    fun stokEkle(miktar: Int) {
        stok += miktar
        println("$ad ürününe $miktar adet eklendi")
        println("Yeni stok: $stok")
    }

    fun bilgileriGoster() {
        println("Ürün: $ad")
        println("Fiyat: $fiyat TL")
        println("Stok: $stok adet")
    }
}

fun main() {
    // Ürünleri oluşturalım
    val ekmek = MarketUrunu("Ekmek", 5.0, 50)
    val sut = MarketUrunu("Süt", 15.0, 30)

    // Ürün bilgilerini gösterelim
    ekmek.bilgileriGoster()
    println("---------------")

    // Satış yapalım
    ekmek.satis(3)
    println("---------------")

    // Stok ekleyelim
    sut.bilgileriGoster()
    sut.stokEkle(10)
}
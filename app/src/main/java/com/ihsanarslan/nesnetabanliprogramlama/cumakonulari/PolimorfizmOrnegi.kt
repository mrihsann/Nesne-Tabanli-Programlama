package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Polimorfizm, bir nesnenin farklı biçimlerde davranabilmesidir
// Bu örnekte hayvanların seslerini ve hareketlerini gösterelim

// Ana (üst) sınıf
open class Hayvan(
    val isim: String,
    val tur: String
) {
    // open keywordü ile bu metodların alt sınıflarda override edilebileceğini belirtiyoruz
    open fun sesCikar() {
        println("$isim bir ses çıkardı!")
    }
    
    open fun hareketEt() {
        println("$isim hareket ediyor")
    }
    
    // Bu metod final'dır (override edilemez)
    fun bilgiGoster() {
        println("Bu hayvan bir $tur ve adı $isim")
    }
}

// Köpek sınıfı - Hayvan sınıfından kalıtım alıyor
class Kopek(
    isim: String,
    val cins: String
) : Hayvan(isim, "Köpek") {
    
    override fun sesCikar() {
        println("$isim: Hav hav!")
    }
    
    override fun hareketEt() {
        println("$isim koşuyor")
    }
    
    // Köpek sınıfına özel metod
    fun kuyrukSalla() {
        println("$isim kuyruk sallıyor")
    }
}

// Kuş sınıfı - Hayvan sınıfından kalıtım alıyor
class Kus(
    isim: String,
    val kanatAcikligi: Double
) : Hayvan(isim, "Kuş") {
    
    override fun sesCikar() {
        println("$isim: Cik cik!")
    }
    
    override fun hareketEt() {
        println("$isim uçuyor")
    }
    
    // Kuş sınıfına özel metod
    fun kanatCirp() {
        println("$isim kanatlarını çırpıyor")
    }
}

// Balık sınıfı - Hayvan sınıfından kalıtım alıyor
class Balik(
    isim: String,
    val turAdi: String
) : Hayvan(isim, "Balık") {
    
    override fun sesCikar() {
        println("$isim sessizce yüzüyor")
    }
    
    override fun hareketEt() {
        println("$isim suda yüzüyor")
    }
    
    // Balık sınıfına özel metod
    fun solungaclariniCalistir() {
        println("$isim solungaçlarını çalıştırıyor")
    }
}

// Hayvanları yöneten bir sınıf
class HayvanBakicisi(val isim: String) {
    // Polimorfik metod - tüm hayvan türleri ile çalışabilir
    fun hayvaniBesle(hayvan: Hayvan) {
        println("$isim, ${hayvan.isim} isimli ${hayvan.tur}'ı besliyor")
        hayvan.sesCikar()
    }
    
    // Polimorfik metod - tüm hayvan türleri ile çalışabilir
    fun hayvaniHareketEttir(hayvan: Hayvan) {
        println("$isim, ${hayvan.isim}'a hareket etmesini söylüyor")
        hayvan.hareketEt()
    }
}

fun main() {
    // Hayvanları oluşturalım
    val kopek = Kopek("Karabaş", "Golden")
    val kus = Kus("Maviş", 30.0)
    val balik = Balik("Nemo", "Palyaço Balığı")
    
    // Bakıcıyı oluşturalım
    val bakici = HayvanBakicisi("Ahmet")
    
    println("--- Hayvan Bakımı ---")
    
    // Polimorfizm örneği - aynı metodlar farklı davranışlar sergiliyor
    bakici.hayvaniBesle(kopek)
    bakici.hayvaniHareketEttir(kopek)
    kopek.kuyrukSalla()
    println()
    
    bakici.hayvaniBesle(kus)
    bakici.hayvaniHareketEttir(kus)
    kus.kanatCirp()
    println()
    
    bakici.hayvaniBesle(balik)
    bakici.hayvaniHareketEttir(balik)
    balik.solungaclariniCalistir()
    println()
    
    // Hayvanları bir listede toplayabiliriz
    println("--- Hayvanat Bahçesi Turu ---")
    val hayvanlar = listOf(kopek, kus, balik)
    
    // Polimorfik döngü - her hayvan kendi davranışını sergiler
    hayvanlar.forEach { hayvan ->
        hayvan.bilgiGoster()
        hayvan.sesCikar()
        hayvan.hareketEt()
        println()
    }
}
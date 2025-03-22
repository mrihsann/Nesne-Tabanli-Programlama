package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Temel çalışan sınıfı
open class Personel(
    val ad: String,
    val soyad: String,
    protected var maas: Double
) {
    open fun maasHesapla(): Double {
        return maas
    }
    
    fun bilgileriGoster() {
        println("$ad $soyad - Maaş: ${maasHesapla()} TL")
    }
}

// Yazılımcı sınıfı
class Yazilimci(
    ad: String,
    soyad: String,
    maas: Double,
    val bildigiDiller: List<String>,
    private val projePrimi: Double = 5000.0
) : Personel(ad, soyad, maas) {
    
    override fun maasHesapla(): Double {
        return maas + projePrimi
    }
    
    fun dilleriGoster() {
        println("Bildiği diller: ${bildigiDiller.joinToString(", ")}")
    }
}

// Satış temsilcisi sınıfı
class SatisTemsilcisi(
    ad: String,
    soyad: String,
    maas: Double,
    private var aylikSatis: Double = 0.0,
    private val komisyonOrani: Double = 0.1
) : Personel(ad, soyad, maas) {
    
    override fun maasHesapla(): Double {
        return maas + (aylikSatis * komisyonOrani)
    }
    
    fun satisEkle(satisMiktari: Double) {
        aylikSatis += satisMiktari
        println("$ad $soyad yeni satış ekledi. Toplam satış: $aylikSatis TL")
    }
}

fun main() {
    val yazilimci = Yazilimci(
        "Ali", 
        "Yılmaz", 
        20000.0, 
        listOf("Kotlin", "Java", "Python")
    )
    
    val satisci = SatisTemsilcisi(
        "Ayşe", 
        "Demir", 
        10000.0
    )
    
    println("--- Yazılımcı Bilgileri ---")
    yazilimci.bilgileriGoster()
    yazilimci.dilleriGoster()
    
    println("\n--- Satış Temsilcisi Bilgileri ---")
    satisci.bilgileriGoster()
    satisci.satisEkle(50000.0)
    satisci.satisEkle(30000.0)
    println("Komisyon sonrası:")
    satisci.bilgileriGoster()
}
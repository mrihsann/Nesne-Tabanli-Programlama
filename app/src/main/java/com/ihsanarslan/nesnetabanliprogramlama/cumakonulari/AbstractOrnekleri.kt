package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Abstract sınıflar soyut kavramları modellemek için kullanılır
abstract class Calisan(
    val isim: String,
    val departman: String,
    protected var maas: Double
) {
    // Abstract metodlar
    abstract fun maasHesapla(): Double
    abstract fun departmanGoreviniYap()
    
    // Normal metod
    fun bilgileriGoster() {
        println("İsim: $isim")
        println("Departman: $departman")
        println("Maaş: ${maasHesapla()} TL")
    }
}

class Developer(
    isim: String,
    maas: Double,
    private val bildigiDiller: List<String>
) : Calisan(isim, "Yazılım", maas) {
    
    override fun maasHesapla(): Double {
        return maas + (bildigiDiller.size * 1000) // Her dil için bonus
    }
    
    override fun departmanGoreviniYap() {
        println("$isim kod yazıyor...")
        println("Bildiği diller: ${bildigiDiller.joinToString(", ")}")
    }
}

class Pazarlamaci(
    isim: String,
    maas: Double,
    private var satisHedefi: Double
) : Calisan(isim, "Pazarlama", maas) {
    
    override fun maasHesapla(): Double {
        return maas + (satisHedefi * 0.1) // Satış hedefinden bonus
    }
    
    override fun departmanGoreviniYap() {
        println("$isim müşterilerle görüşüyor...")
        println("Satış hedefi: $satisHedefi TL")
    }
}

fun main() {
    val yazilimci = Developer("Ali Yılmaz", 15000.0,
        listOf("Kotlin", "Java", "Python"))
    
    val pazarlamaci = Pazarlamaci("Ayşe Demir", 10000.0, 100000.0)
    
    println("--- Yazılımcı Bilgileri ---")
    yazilimci.bilgileriGoster()
    yazilimci.departmanGoreviniYap()
    
    println("\n--- Pazarlamacı Bilgileri ---")
    pazarlamaci.bilgileriGoster()
    pazarlamaci.departmanGoreviniYap()
}
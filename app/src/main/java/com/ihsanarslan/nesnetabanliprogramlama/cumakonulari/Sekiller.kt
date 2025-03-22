package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

import kotlin.math.sqrt

// Temel şekil sınıfı
abstract class Sekil {
    abstract fun alanHesapla(): Double
    abstract fun cevreHesapla(): Double
    
    fun bilgileriGoster() {
        println("Alan: ${alanHesapla()}")
        println("Çevre: ${cevreHesapla()}")
    }
}

// Dikdörtgen sınıfı
class Dikdortgen(
    private val uzunluk: Double,
    private val genislik: Double
) : Sekil() {
    
    override fun alanHesapla(): Double {
        return uzunluk * genislik
    }
    
    override fun cevreHesapla(): Double {
        return 2 * (uzunluk + genislik)
    }
}

// Daire sınıfı
class Daire(private val yaricap: Double) : Sekil() {
    companion object {
        private const val PI = 3.14159
    }
    
    override fun alanHesapla(): Double {
        return PI * yaricap * yaricap
    }
    
    override fun cevreHesapla(): Double {
        return 2 * PI * yaricap
    }
}

// Üçgen sınıfı
class Ucgen(
    private val a: Double,
    private val b: Double,
    private val c: Double
) : Sekil() {
    
    init {
        require(a + b > c && b + c > a && a + c > b) {
            "Geçersiz üçgen! Üçgen eşitsizliği sağlanmalıdır."
        }
    }
    
    override fun alanHesapla(): Double {
        val s = (a + b + c) / 2
        return sqrt(s * (s - a) * (s - b) * (s - c))
    }
    
    override fun cevreHesapla(): Double {
        return a + b + c
    }
}

fun main() {
    val dikdortgen = Dikdortgen(5.0, 3.0)
    val daire = Daire(4.0)
    val ucgen = Ucgen(3.0, 4.0, 5.0)
    
    println("--- Dikdörtgen ---")
    dikdortgen.bilgileriGoster()
    
    println("\n--- Daire ---")
    daire.bilgileriGoster()
    
    println("\n--- Üçgen ---")
    ucgen.bilgileriGoster()
    
    // Polimorfik kullanım
    val sekiller = listOf(dikdortgen, daire, ucgen)
    
    println("\n--- Tüm Şekiller ---")
    sekiller.forEachIndexed { index, sekil ->
        println("${index + 1}. Şekil:")
        sekil.bilgileriGoster()
        println()
    }
}
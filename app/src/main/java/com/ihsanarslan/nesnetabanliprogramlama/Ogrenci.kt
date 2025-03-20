package com.ihsanarslan.nesnetabanliprogramlama

// Basit bir öğrenci sınıfı
class Ogrenci(val ad: String, val soyad: String, var sinif: Int) {
    var not = 0

    fun notVer(yeniNot: Int) {
        if (yeniNot in 0..100) {
            not = yeniNot
            println("$ad'ın notu: $not")
        } else {
            println("Geçersiz not! Not 0-100 arasında olmalıdır.")
        }
    }

    fun durumGoster() {
        println("$ad $soyad - $sinif. sınıf")
        println("Notu: $not")

        if (not >= 50) {
            println("Durum: Geçti")
        } else {
            println("Durum: Kaldı")
        }
    }
}

fun main() {
    // Öğrencileri oluşturalım
    val ogrenci1 = Ogrenci("Ali", "Yılmaz", 1)
    val ogrenci2 = Ogrenci("Ayşe", "Demir", 2)

    // Notları verelim
    ogrenci1.notVer(75)
    ogrenci2.notVer(45)

    println("---------------")

    // Öğrencilerin durumlarını gösterelim
    ogrenci1.durumGoster()
    println("---------------")
    ogrenci2.durumGoster()
}
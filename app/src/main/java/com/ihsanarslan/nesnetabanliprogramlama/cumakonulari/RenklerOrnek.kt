package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Enum'lar sabit değerler kümesidir
// Örneğin: Renkler, günler, aylar gibi sabit değerleri tanımlamak için kullanılır
enum class Renkler {
    KIRMIZI,
    MAVI,
    YESIL,
    SARI,
    MOR
}

// Enum'ları when yapısı ile kullanmak çok yaygındır
fun renkAnlami(renk: Renkler) {
    when (renk) {
        Renkler.KIRMIZI -> println("Bu renk ateşi temsil eder")
        Renkler.MAVI -> println("Bu renk denizi temsil eder")
        Renkler.YESIL -> println("Bu renk doğayı temsil eder")
        Renkler.SARI -> println("Bu renk güneşi temsil eder")
        Renkler.MOR -> println("Bu renk asaleti temsil eder")
    }
}

// Enum değerlerini parametre olarak alan başka bir örnek
fun trafikIsigi(renk: Renkler) {
    when (renk) {
        Renkler.KIRMIZI -> println("DUR!")
        Renkler.YESIL -> println("GEÇ!")
        Renkler.SARI -> println("HAZIRLAN!")
        else -> println("Geçersiz trafik ışığı rengi!")
    }
}

fun main() {
    // Bir enum değeri oluşturalım
    val benimRengim = Renkler.MAVI
    
    println("--- Renk Anlamı ---")
    renkAnlami(benimRengim)
    
    println("\n--- Trafik Işığı ---")
    trafikIsigi(Renkler.KIRMIZI)
    trafikIsigi(Renkler.YESIL)
    trafikIsigi(Renkler.MOR) // else durumunu test edelim
    
    println("\n--- Tüm Renkleri Listeleyelim ---")
    // entries metodu ile tüm enum değerlerini alabiliriz
    for (renk in Renkler.entries) {
        println("Renk: $renk")
    }
}
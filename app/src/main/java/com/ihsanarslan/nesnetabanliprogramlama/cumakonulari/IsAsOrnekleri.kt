package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// is: tip kontrolü için kullanılır
// as: tip dönüşümü (cast) için kullanılır

// Farklı hayvan türleri için örnek
open class Hayvann(val isim: String)

class Kedii(isim: String, val miyavSesi: String) : Hayvann(isim)
class Kopekk(isim: String, val havlamaSesi: String) : Hayvann(isim)
class Kuss(isim: String, val otmeSesi: String) : Hayvann(isim)

class HayvanBakicisii {
    fun sesCikar(hayvan: Hayvann) {
        // is operatörü ile tip kontrolü
        when {
            hayvan is Kedii -> {
                // Smart cast: Kotlin otomatik olarak Kedi tipine dönüştürür
                println("${hayvan.isim} diyor ki: ${hayvan.miyavSesi}")
            }
            hayvan is Kopekk -> {
                println("${hayvan.isim} diyor ki: ${hayvan.havlamaSesi}")
            }
            hayvan is Kuss -> {
                println("${hayvan.isim} diyor ki: ${hayvan.otmeSesi}")
            }
        }
    }
    
    fun tipKontrolu(nesne: Any) {
        // is ile tip kontrolü
        println("\n--- Tip Kontrolü ---")
        println("nesne bir Hayvan mı? ${nesne is Hayvan}")
        println("nesne bir Kedi mi? ${nesne is Kedii}")
        println("nesne bir String mi? ${nesne is String}")
        
        // as ile güvenli tip dönüşümü
        println("\n--- Tip Dönüşümü ---")
        val hayvan = try {
            nesne as? Hayvan // as? null dönebilir
        } catch (e: Exception) {
            println("Dönüşüm başarısız: ${e.message}")
            null
        }
        
        hayvan?.let {
            println("Dönüşüm başarılı: ${it.isim}")
        }
    }
}

fun main() {
    val kedi = Kedii("Pamuk", "Miyav!")
    val kopek = Kopekk("Karabaş", "Hav hav!")
    val kus = Kuss("Maviş", "Cik cik!")
    
    val bakici = HayvanBakicisii()
    
    println("--- Hayvan Sesleri ---")
    bakici.sesCikar(kedi)
    bakici.sesCikar(kopek)
    bakici.sesCikar(kus)
    
    // Tip kontrolü ve dönüşümü test
    bakici.tipKontrolu(kedi)
    bakici.tipKontrolu("Bu bir string")
}
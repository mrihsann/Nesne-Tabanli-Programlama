package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Nullable (null olabilen) değişkenler String? gibi soru işareti (?) ile tanımlanır
// Non-nullable (null olamayan) değişkenler normal şekilde String gibi tanımlanır

class NullableOrnekleri {
    // Nullable String tanımlama
    var nullOlabilenIsim: String? = null
    
    // Non-nullable String tanımlama
    var normalIsim: String = "Ahmet"
    
    // Nullable Int tanımlama
    var nullOlabilenYas: Int? = null
    
    fun nullKontrolOrnekleri() {
        // 1. Güvenli çağrı operatörü (?.)
        // Eğer değişken null ise fonksiyon çağrılmaz ve null döner
        println("İsmin uzunluğu: ${nullOlabilenIsim?.length}")
        
        // 2. Elvis operatörü (?:)
        // Eğer sol taraf null ise sağ taraftaki değer kullanılır
        val uzunluk = nullOlabilenIsim?.length ?: 0
        println("İsmin uzunluğu (elvis ile): $uzunluk")
        
        // 3. Not-null assertion operatörü (!!)
        // Değişkenin kesinlikle null olmadığından eminseniz kullanın
        // DİKKAT: Eğer değişken null ise program çöker
        println(nullOlabilenIsim!!.length)
    }
    
    fun nullableParametreOrnegi(isim: String?, yas: Int?) {
        // if ile null kontrolü
        if (isim != null) {
            println("Merhaba $isim!")
        } else {
            println("İsim bilgisi bulunamadı")
        }
        
        // when ile null kontrolü
        when (yas) {
            null -> println("Yaş bilgisi bulunamadı")
            in 0..17 -> println("Reşit değil")
            else -> println("Reşit")
        }
    }
    
    fun listelerdeNullable() {
        // Nullable elemanlar içeren liste
        val isimListesi: List<String?> = listOf("Ali", null, "Veli", null, "Ayşe")
        
        // Listedeki null olmayan isimleri filtreleme
        val nullOlmayanIsimler = isimListesi.filterNotNull()
        println("Null olmayan isimler: $nullOlmayanIsimler")
        
        // forEach ile null kontrolü
        isimListesi.forEach { isim -> 
            // let fonksiyonu ile null olmayan değerler üzerinde işlem yapma
            isim?.let {
                println("İsim: $it")
            } ?: println("Null değer bulundu")
        }
    }
}

fun main() {
    val ornek = NullableOrnekleri()
    
    println("--- Null Kontrol Örnekleri ---")
    ornek.nullKontrolOrnekleri()
    
    println("\n--- Nullable Parametre Örnekleri ---")
    ornek.nullableParametreOrnegi("Mehmet", 25)
    ornek.nullableParametreOrnegi(null, null)
    
    println("\n--- Listelerde Nullable Kullanımı ---")
    ornek.listelerdeNullable()
}
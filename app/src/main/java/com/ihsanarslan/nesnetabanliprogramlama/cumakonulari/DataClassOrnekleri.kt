package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Data class'lar özellikle veri tutmak için kullanılan sınıflardır
// Otomatik olarak equals(), hashCode(), toString(), copy() metodlarını oluşturur

// Basit bir data class örneği
data class Ogrenci(
    val id: Int,
    val ad: String,
    val soyad: String,
    var sinif: Int
)

// Varsayılan değer içeren data class
data class Kullanicii(
    val kullaniciAdi: String,
    val email: String,
    var aktifMi: Boolean = true,
    val kayitTarihi: String = "2025-03-21 21:25:00"
)

// İç içe data class kullanımı
data class Adres(
    val sokak: String,
    val sehir: String,
    val postaKodu: String
)

data class Musteri(
    val id: Int,
    val ad: String,
    val soyad: String,
    val adres: Adres,
    val telefonNo: String
)

fun main() {
    // Öğrenci örneği
    val ogrenci1 = Ogrenci(1, "Ahmet", "Yılmaz", 3)
    val ogrenci2 = Ogrenci(2, "Mehmet", "Kaya", 3)
    
    println("--- Öğrenci Örnekleri ---")
    println(ogrenci1) // toString() otomatik oluşturuldu
    
    // copy() kullanımı
    val ogrenci3 = ogrenci1.copy(id = 3, ad = "Ayşe")
    println("Kopyalanan öğrenci: $ogrenci3")
    
    // Destructuring declaration (Parçalara ayırma)
    val (id, ad, soyad, sinif) = ogrenci1
    println("Parçalara ayrılmış hali: id=$id, ad=$ad, soyad=$soyad, sinif=$sinif")
    
    // Kullanıcı örneği
    println("\n--- Kullanıcı Örnekleri ---")
    val kullanici1 = Kullanicii(
        kullaniciAdi = "mrihsann",
        email = "thearslanihsan@gmail.com"
    )
    println(kullanici1)
    
    // equals() kullanımı
    val kullanici2 = Kullanicii("mrihsann", "thearslanihsan@gmail.com")
    println("Kullanıcılar eşit mi? ${kullanici1 == kullanici2}")
    
    // Müşteri ve Adres örneği
    println("\n--- Müşteri Örnekleri ---")
    val musteri = Musteri(
        id = 1,
        ad = "Ali",
        soyad = "Demir",
        adres = Adres("Atatürk Cad.", "İstanbul", "34100"),
        telefonNo = "5551112233"
    )
    println(musteri)
    
    // Component fonksiyonları
    println("\n--- Component Fonksiyonları ---")
    println("Müşteri Adı: ${musteri.component1()}")    // id
    println("Müşteri Soyadı: ${musteri.component3()}")  // soyad
}
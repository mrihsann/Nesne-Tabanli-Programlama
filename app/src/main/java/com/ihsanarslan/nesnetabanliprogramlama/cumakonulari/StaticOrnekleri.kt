package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Companion object, Java'daki static yapıların Kotlin'deki karşılığıdır
class Matematik {
    // Companion object içindeki değişken ve metodlar static gibi davranır
    companion object {
        // Static değişkenler
        const val PI = 3.14159
        const val E = 2.71828
        
        private var islemSayisi = 0 // Static sayaç
        
        // Static metodlar
        fun kareAl(sayi: Double): Double {
            islemSayisi++
            return sayi * sayi
        }
        
        fun kupAl(sayi: Double): Double {
            islemSayisi++
            return sayi * sayi * sayi
        }
        
        fun daireAlani(yaricap: Double): Double {
            islemSayisi++
            return PI * yaricap * yaricap
        }
        
        fun getIslemSayisi(): Int {
            return islemSayisi
        }
    }
    
    // Normal sınıf metodu (static değil)
    fun bilgiVer() {
        println("Bu sınıf matematiksel işlemler içerir")
    }
}

// Loglama için companion object kullanan bir örnek
class Logger {
    companion object {
        private var logSayisi = 0
        
        fun logInfo(mesaj: String) {
            logSayisi++
            println("[$zaman][INFO] $mesaj (Log #$logSayisi)")
        }
        
        fun logError(mesaj: String) {
            logSayisi++
            println("[$zaman][ERROR] $mesaj (Log #$logSayisi)")
        }
        
        fun toplamLogSayisi(): Int {
            return logSayisi
        }
        
        // Geçerli zamanı döndüren private yardımcı metod
        private val zaman: String
            get() = "2025-03-21 21:25:39" // Simüle edilmiş zaman
    }
}

// Kullanıcı işlemleri için companion object
class KullaniciIslemleri {
    companion object {
        private const val MEVCUT_KULLANICI = "mrihsann"
        private var oturumSayisi = 0
        
        fun girisYap(kullaniciAdi: String) {
            if (kullaniciAdi == MEVCUT_KULLANICI) {
                oturumSayisi++
                Logger.logInfo("$kullaniciAdi kullanıcısı giriş yaptı")
                println("Hoş geldiniz, $kullaniciAdi!")
                println("Toplam oturum sayısı: $oturumSayisi")
            } else {
                Logger.logError("Geçersiz kullanıcı girişi denemesi: $kullaniciAdi")
                println("Geçersiz kullanıcı!")
            }
        }
        
        fun mevcutKullaniciAdi(): String {
            return MEVCUT_KULLANICI
        }
    }
}

fun main() {
    // Matematik sınıfı static metodlarının kullanımı
    println("--- Matematik İşlemleri ---")
    println("Pi sayısı: ${Matematik.PI}")
    println("5'in karesi: ${Matematik.kareAl(5.0)}")
    println("3'ün küpü: ${Matematik.kupAl(3.0)}")
    println("Yarıçapı 4 olan dairenin alanı: ${Matematik.daireAlani(4.0)}")
    println("Toplam işlem sayısı: ${Matematik.getIslemSayisi()}")
    
    // Logger kullanımı
    println("\n--- Loglama İşlemleri ---")
    Logger.logInfo("Uygulama başlatıldı")
    Logger.logError("Bağlantı hatası!")
    Logger.logInfo("İşlem tamamlandı")
    println("Toplam log sayısı: ${Logger.toplamLogSayisi()}")
    
    // Kullanıcı işlemleri
    println("\n--- Kullanıcı İşlemleri ---")
    KullaniciIslemleri.girisYap("mrihsann")
    KullaniciIslemleri.girisYap("test123")
    println("Mevcut kullanıcı: ${KullaniciIslemleri.mevcutKullaniciAdi()}")
}
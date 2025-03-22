package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Visibility Modifiers (Görünürlük Belirteçleri):
// public    : Her yerden erişilebilir (varsayılan)
// private   : Sadece tanımlandığı sınıf içinden erişilebilir
// protected : Sadece tanımlandığı sınıf ve alt sınıflarından erişilebilir
// internal  : Aynı modül içinde her yerden erişilebilir

// Üst sınıf
open class Kullanici(
    // Public - her yerden erişilebilir
    public val kullaniciAdi: String,
    
    // Private - sadece bu sınıf içinden erişilebilir
    private val sifre: String,
    
    // Protected - bu sınıf ve alt sınıflarından erişilebilir
    protected val email: String,
    
    // Internal - aynı modül içinde erişilebilir
    internal val sonGiris: String
) {
    // Private fonksiyon
    private fun sifreKontrol(girilenSifre: String): Boolean {
        return sifre == girilenSifre
    }
    
    // Protected fonksiyon
    protected fun emailGoster() {
        println("Email: $email")
    }
    
    // Public fonksiyon
    public fun girisYap(girilenSifre: String) {
        if (sifreKontrol(girilenSifre)) {
            println("Giriş başarılı!")
            println("Son giriş tarihi: $sonGiris")
        } else {
            println("Hatalı şifre!")
        }
    }
}

// Alt sınıf
class AdminKullanici(
    kullaniciAdi: String,
    sifre: String,
    email: String,
    sonGiris: String,
    private val yetkilevel: Int
) : Kullanici(kullaniciAdi, sifre, email, sonGiris) {
    
    fun bilgileriGoster() {
        println("Kullanıcı Adı: $kullaniciAdi") // public olduğu için erişilebilir
        // println("Şifre: $sifre") // private olduğu için erişilemez
        emailGoster() // protected olduğu için alt sınıftan erişilebilir
        println("Son Giriş: $sonGiris") // internal olduğu için aynı modülde erişilebilir
        println("Yetki Seviyesi: $yetkilevel")
    }
}

fun main() {
    val normalKullanici = Kullanici(
        kullaniciAdi = "mrihsann",
        sifre = "12345",
        email = "thearslanihsan@gmail.com",
        sonGiris = "2025-03-21 21:23:10"
    )
    
    val adminKullanici = AdminKullanici(
        kullaniciAdi = "admin_mrihsann",
        sifre = "admin123",
        email = "admin@mail.com",
        sonGiris = "2025-03-21 21:23:10",
        yetkilevel = 1
    )
    
    println("--- Normal Kullanıcı ---")
    println("Kullanıcı Adı: ${normalKullanici.kullaniciAdi}") // public
    // println(normalKullanici.sifre) // private - erişilemez
    // println(normalKullanici.email) // protected - erişilemez
    println("Son Giriş: ${normalKullanici.sonGiris}") // internal
    normalKullanici.girisYap("12345")
    
    println("\n--- Admin Kullanıcı ---")
    adminKullanici.bilgileriGoster()
    adminKullanici.girisYap("admin123")
}
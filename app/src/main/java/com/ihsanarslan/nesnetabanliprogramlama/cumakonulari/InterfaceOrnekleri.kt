package com.ihsanarslan.nesnetabanliprogramlama.cumakonulari

// Interface'ler davranış tanımlamak için kullanılır
interface Yurutebilir {
    fun baslat()
    fun durdur()
    fun durum(): String
}

interface Kaydedilebilir {
    fun kaydet()
    fun yukle()
}

// Birden fazla interface implement edilebilir
class Uygulama(private val isim: String) : Yurutebilir, Kaydedilebilir {
    private var calisiyor = false
    
    override fun baslat() {
        calisiyor = true
        println("$isim uygulaması başlatıldı")
    }
    
    override fun durdur() {
        calisiyor = false
        println("$isim uygulaması durduruldu")
    }
    
    override fun durum(): String {
        return if (calisiyor) "Çalışıyor" else "Durdu"
    }
    
    override fun kaydet() {
        println("$isim uygulamasının verileri kaydediliyor...")
    }
    
    override fun yukle() {
        println("$isim uygulamasının verileri yükleniyor...")
    }
}

// Property'ler içeren interface
interface Bilgilendirilebilir {
    val bildirimAktif: Boolean
    fun bildirimGonder(mesaj: String)
}

// Default implementasyon içeren interface
interface Loglanabilir {
    fun logla(mesaj: String) {
        println("LOG: $mesaj")
    }
}

// Birden fazla interface'i implement eden sınıf
class MobilUygulama(
    private val isim: String,
    override val bildirimAktif: Boolean
) : Yurutebilir, Bilgilendirilebilir, Loglanabilir {
    
    private var calisiyor = false
    
    override fun baslat() {
        calisiyor = true
        logla("$isim başlatıldı")
        if (bildirimAktif) {
            bildirimGonder("Uygulama başlatıldı")
        }
    }
    
    override fun durdur() {
        calisiyor = false
        logla("$isim durduruldu")
    }
    
    override fun durum(): String {
        return if (calisiyor) "Çalışıyor" else "Durdu"
    }
    
    override fun bildirimGonder(mesaj: String) {
        println("BİLDİRİM: $mesaj")
    }
}

fun main() {
    println("--- Uygulama Testi ---")
    val uygulama = Uygulama("Hesap Makinesi")
    uygulama.baslat()
    println("Durum: ${uygulama.durum()}")
    uygulama.kaydet()
    uygulama.durdur()
    
    println("\n--- Mobil Uygulama Testi ---")
    val mobilUygulama = MobilUygulama("Sosyal Medya", true)
    mobilUygulama.baslat()
    println("Durum: ${mobilUygulama.durum()}")
    mobilUygulama.durdur()
}
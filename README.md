# ☕ Haratres Staj Program Case

Bu repositoryi, Java ile geliştirdiğim iki farklı konsol uygulamasını içermektedir:

* 📝 **Case 1: Metin Analiz Uygulaması**
* 🛒 **Case 2: Alışveriş Sepeti Uygulaması**

---
## 🚀 Kullanılan Teknolojiler

* ☕ Java 25
* ⚙️ Gradle

---
## 📁 Proje Yapısı

```
src/
 └── main/
      └── java/
           ├── case_1/
           │    └── Case.java
           └── case_2/
                ├── service/
                ├── dto/
                ├── entity/
                ├── mapper/
                └── Case.java
```

---

## 📝 Case 1: Metin Analiz Uygulaması

Bu uygulama, kullanıcıdan alınan bir metin üzerinde karakter analizi yapmaktadır.

### 🔹 Özellikler

* Maksimum karakter uzunluğu belirleme 
* Kullanıcıdan metin alma
* Büyük/küçük harf duyarlılığı seçimi
* Belirli bir karakterin frekansını hesaplama

### 🔹 Nasıl Çalışır?

1. Kullanıcı maksimum karakter uzunluğunu girer (Pozitif Tam Sayı Olarak)
2. Metin girer (sadece Latin karakterler kabul edilir)
3. Case sensitive seçimi yapar
4. Aranacak karakteri girer
5. Program karakterin kaç kez geçtiğini hesaplar

---

## 🛒 Case 2: Alışveriş Sepeti Uygulaması

Bu uygulama, basit bir e-ticaret sepeti mantığını simüle etmektedir.

### 🔹 Özellikler

* Ürün ekleme
* Adet belirleme
* İndirimli fiyat hesaplama
* Toplam tutar hesaplama

### 🔹 Nasıl Çalışır?

1. Kullanıcı ekleyeceği ürün sayısını girer (En az 1 adet olmalıdır)
2. Eklenecek olan ürün bilgileri girilir (İsmi, fiyati, stoku, ratingi)
3. Sıralama kriteri girilir (isim, fiyat, stok, rating)
4. Azalan/Artan seçilir
4. Ürünler listelenir ve sepete ekleme sorusu sorulur
5. Cevap evet ise eklenecek ürün ismi yazılarak ürün sepete eklenir
6. Son olarak sepet fiyatı toplanır, indirim uygulanacaksa uygulanır

---

## ⚙️ Kurulum ve Çalıştırma

Projeyi klonla:

```
git clone https://github.com/sem1hs/Haratres-Staj-Program-Case
```

## 👨‍💻 Geliştirici

**Semih Şahinoğlu**

---
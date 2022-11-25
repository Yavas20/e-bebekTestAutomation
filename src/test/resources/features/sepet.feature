
Feature: Sepet sayfasındaki muhtemel işlemleri kontol


  Background: Kullanıcı en az 1 ürün ekleyerek sepet sayfasında
    Given : Kullanıcı sepet sayfasında


  Scenario: Kullanıcı sepet sayfasındaki bilgileri eklenen ürüne göre görebilmeli
    Then Sepetim, Ürünler ve Fiyatı, Kargo ve Fiyatı, Toplam ve Fiyatı
    Then Ürün Bilgileri, Tahmini Kargoya Verimme Tarihi, Çöp Kutusu, Artı İşareti
    Then Favorilere Ekle - Sil - Alışverişi Tamamla - İndirim Kuponun Var butonları ekranda belirir


  Scenario: Kullanıcı sepetteki ürünü silebilmeli
    When Kullanıcı sil kutucuğuna veya çöp kutusuna tıklar
    Then Ürün sayısı sıfıra düştüğünde 'Sepetinizde ürün bulunmamaktadır' mesajı ekranda belirir


  Scenario: Kullanıcı sepetteki ürünü artırabilmeli
    When Kullanıcı + işaretine tıklar
    Then Ürün sayısı maksimum sayıya ulaştığında 'Hoşgeldin ürününün maksimum satış adedine ulaştınız. Bu nedenle ürünün sepetinizdeki adedi ... ' e düşürüldü.' mesajı ekranda belirir
    Then Ürün sayısı maksimum sayıya düşürülür


  Scenario: Kullanıcı sepetteki ürünü artırabilmeli
    When Kullanıcı manuel olarak ürün sayısını değiştirmeye çalışır
    Then Ürün sayısı değişmez


  Scenario: Kullanıcı sepetteki ürün sayısını değiştirdiğinde ürün fiyatı, kargo fiyatı  ve toplam fiyat değişmeli
    When Kullanıcı ürün sayısını değiştirir
    Then Ürün fiyatı, kargo fiyatı ve toplam fiyat güncellenir


  Scenario: Ürün fiyatı 450 TL üzerinde olursa kargo mesajı ekrandan kaybolur ve kargo ücretsiz olur
    When Kullanıcı 450 TL üzeri ürün ekler
    Then Bedava kargo mesajı ekrandan kaybolur ve kargo ücreti sıfır olur


  Scenario: Kullanıcı favorilere ekle butonuna tıklayarak ürünü favorilerine ekler
    When Kullanıcı favorilere ekle butonuna tıklar
    Then Üye olarak giriş yapılmışsa ürün favorilere eklenir


  Scenario: Kullanıcı favorilere ekle butonuna tıklayarak ürünü favorilerine ekler
    When Kullanıcı favorilere ekle butonuna tıklar
    Then Üye olarak giriş yapılmamışsa kullanıcı üye giriş sayfasına yönlendirilir


  Scenario: Kullanıcı indirim kuponum var butonuna tıklar
    When Kullanıcı indirim kuponum var butonuna tıklar
    Then Kuponunuz bulunmamaktadır mesajı, Farklı kupon numarası kutucuğu, uygula butonu ve vazgeç butonu ekranda belirir


  Scenario: Kullanıcı indirim kuponum var butonuna tıklar ve açılan sayfada vazgeç butonuna tıklar
    When Kullanıcı indirim kuponum var butonuna tıklar
    When Kullanıcı vazgeç butonuna tıklar
    Then Kullanıcı sepet sayfasına geri yönlendirilir


  Scenario: Kullanıcı indirim kuponum var butonuna tıklayarak açılan sayfada indirim kuponu ekler
    When Kullanıcı indirim kuponum var butonuna tıklar
    When Açılan sayfada kupon numarası girin kutucuğuna kupon numarası girer ve uygula butonuna basar
    Then Geçerli bir kuponsa kupon uygulanır


  Scenario: Kullanıcı indirim kuponum var butonuna tıklayarak açılan sayfada indirim kuponu ekler
    When Kullanıcı indirim kuponum var butonuna tıklar
    When Açılan sayfada kupon numarası girin kutucuğuna kupon numarası girer ve uygula butonuna basar
    Then Geçersiz bir kuponsa 'Lütfen tekrar kontrol ediniz. Girilen kupon kodu geçersizdir.' mesajı ekranda belirir


  Scenario: Kullanıcı alışverişi tamamla butonuna tıklayarak ürünü satın alır
    When Kullanıcı alışverişi tamamla butonuna tıklar
    Then Üye olarak giriş yapılmışsa ürün satış tamamlama süreci devam eder


  Scenario: Kullanıcı alışverişi tamamla butonuna tıklayarak ürünü satın alır
    When Kullanıcı alışverişi tamamla butonuna tıklar
    Then Üye olarak giriş yapılmamışsa kullanıcı üye giriş sayfasına yönlendirilir


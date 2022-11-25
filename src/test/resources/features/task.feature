@task
Feature: Sepete ürün eklenmesi

  Background: Kullanıcı ana sayfada
    Given : Kullanıcı ana sayfada


  Scenario: Sepete eklenen ürünün kontrol edilmesi
    When Arama çubuğuna "biberon" yazılır ve arama yapılır
    And İlk ürüne tıklanır
    And Sepete Ekle butonuna tıklanır
    And Sepeti Gör butonuna tıklanır
    Then Ürünün sepete eklendiği kontrol edilir







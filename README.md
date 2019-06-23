# Spring Boot ve Kafka ile Big Data Analizi

Spring Boot ve Kafka ile Big Data Analizi uygulaması, beş farklı ilde bulunan kullanıcılar tarafından gönderilen mesajların loglarını alıp bu loglar sayesinde hangi ilden ne kadar log geldiğini dashboard üzerinde gerçek zamanlı göstermeyi amaçlayan bir uygulamadır.

Kullanıcılar arayüz üzerinden mesaj gönderirler. Bu gönderilen mesajın logları ana server'da bulunan log dosyasına kayıt olur. Log dosyasına yeni bir log kayıdı geldiğinde bu log eşzamanlı olarak Kafka Broker'ına gönderilir. Broker'dan dönen kaydın hangi il üzerinden geldiği tespit edilir. Bunun ardından ekranda illere göre gelen log sayıları grafik üzerinde eşzamanlı olarak gösterilir.

## Kullanılan Teknolojiler

* Spring Boot
* Spring Kafka
* Apache Kafka
* Java 8
* JDK 1.8
* Apache Maven 3.5.4
* Log4j
* MySQL 5.7
* Angular 7

## Kurulum

Proje indirilir. Sıkıştırılmış olan proje istenilen bir klasöre çıkartılır. Terminal açılarak projenin bulunduğu klasöre gidilir.

* Zookeeper'ı başlatmak için;
```bash
$ cd kafka
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

* Farklı bir terminal penceresi açılır, proje klasörüne gidilir. Ardından Kafka Server'ı başlatmak için;
```bash
$ cd kafka
$ bin/kafka-server-start.sh config/server.properties
```
* Serverları başlatmak için terminalden proje klasörüne gidilir. Server'ını başlatmak istediğimiz ile ait dosyaya aşağıdaki ilk komutla girilir. (serverIstanbul, serverTokyo, serverMoscow, serverBeijing, serverLondon)
```bash
$ cd serverIstanbul
$ mvn clean install
$ mvn spring-boot:run
```
* Ana server'ı başlatmak için terminal penceresinden proje klasörüne girilir. Aşağıdaki komutlar sırasıyla girilir.
```bash
$ mvn clean install
$ mvn spring-boot:run
```
* Angular arayüzünü çalıştırmak için terminalden proje klasörüne gidilir.
```bash
$ cd src/main/web
$ ng serve
```
* Ardından [http://localhost:4200](http://localhost:4200) adresine gidilir.
***
* MySQL ayarları için terminal açılır;
```bash
$ sudo mysql --password

mysql> create database big_data_db; 
mysql> create user 'bigdata'@'%' identified by 'bigdata'; 
mysql> grant all on big_data_db.* to 'bigdata'@'%'; 

```

## Kullanım
* ANASAYFA![ANASAYFA](https://github.com/melekpzr/SpringApacheKafka/blob/master/images/Screen%20Shot%202019-06-23%20at%2020.45.59.png)
***
* LONDRA SERVER'I![LONDRA SERVER'I](https://github.com/melekpzr/SpringApacheKafka/blob/master/images/Screen%20Shot%202019-06-09%20at%2023.41.49.png)
***
* MESAJLAR![MESAJLAR](https://github.com/melekpzr/SpringApacheKafka/blob/master/images/Screen%20Shot%202019-06-17%20at%2023.15.47.png)
***
* DASHBOARD![DASHBOARD](https://github.com/melekpzr/SpringApacheKafka/blob/master/images/Screen%20Shot%202019-06-23%20at%2020.48.18.png)
***

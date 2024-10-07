# Ticket Com

## Yolculuk uygulaması

![finalCaseDiyagram.jpg](finalCaseDiyagram.jpg)


### Kullanıcı endpointleri

Register olmak için

    localhost:9090/api/v1/auth/register

Login işlemi için

    localhost:9090/api/v1/auth/login

Admin rolüne sahip kullanıcının sefer ekleme , çıkarma ve sefer için bilet bilgilerini öğrenebilmesi sağlayan endpoint

    localhost:9090/api/v1/trips/customer/**

Bilet leri görünütüleme, sepete ekleme, sepeti onaylama ve ödeme yapmak için kullanılan endpoint

    localhost:9090/api/v1/tickets/customer/**

User ın kendi bilgilerini gördüğü ve role ekleyip, çıkarma işlemlerini yaptığı endpoint

    localhost:9090/api/v1/users/customer/**

Seferlerin başlangıç şehiri, varış şehri gibi kriterlere göre seferleri arayabildiği endpoint

    localhost:9090/api/v1/search/**

### Services

* **Auth Service** : Authotencication için User Service ile iletişime geçip Login ve Register işlemlerini gerçekleştirir.
* **Gatevay** : Ağlar arasında bir köprü veya çevirmen görevi görür, Security burada bulunur ve JWT işlemlerini gerçeklerştirir.
* **User Service** : Kullanıcı kayıt işlemleri gerçekleştirir.
* **Trip Service** : Admin rolüne sahip kullanıcıların uçak ve otobüs seferleri için işlemler yapmasını sağlar.
* **Ticket Service** : Seferlere uygun bilet oluşturur, biletlerin sepete eklenme kontrol edilme işlemlerini gerçekleştirir.
* **Payment Service** : Onaylanmış bilet alma işleminin ödeme işlemini gerçekleştirir.
* **Order Service** : Ödeme işlemi gerçekleştirildiğinde bilgileri içeren fatura kesme işlemlerini gerçekleştirir.
* **Notification Service** : Kullanıcıya sms, email yoluyla bildirim gönderme işlemlerini gerçekleştirir.
* **Index Service** : Seferleri Elastic search e kayıt eder.
* **Search Service** : Elastic Searchde bulunan verileri belirlenen koşullar ile arama yapmayı sağlar.
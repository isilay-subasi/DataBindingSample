# DataBindingSample


 Türkçe anlamı veri bağlama olan data binding kütüphanesi view objelerine binding nesnesi üzerinden erişim sağlar.Binding nesnesi bir kez oluşturulduğunda view'lara ve data'lara binding nesnesi üzerinden erişebiliriz. Değişkenlerimizi FindViewById ile çağırmak yerine bir binding objesi ile çağırabiliriz.

## Yararları
> Daha az kod yazmayı ve daha kolay okumayı sağlar.

> Android her bir view'ı almak için bir kez view hiyerarşisini tarıyor ve bunu kullanıcı uygulama ile etkileşim halinde olduğu zamanda değil, uygulama başlangıcında yapıyor.

## Kullanımı

<p>İlk başta aşağıdaki eklemeleri yapmamız gerekmektedir. </p>


```
{..
id 'kotlin-kapt'}
buildFeatures {
    dataBinding true}
```

## Activity Tasarımı

Alt+Enter kısayolu ile XML tasarımınızı data binding formatına dönüştürebilirsiniz. Data Binding kullanmak için tüm XML'in **layout** tag’leri içerisinde yer alması gerekmektedir.

**data** içerisinde çeşitli **variable’lar** tanımlayıp dilediğiniz type'ta değişken tanımlamaları yapabilirsiniz

Projemizde resim ve bir text kullanacağımız için iki değişkeni olan bir model data class oluşturduk. Bunu data tagleri içerisindeki variable ve type değişkenlerine data classımızı tanıtıyoruz.

```
<data>
    <variable
         name="Player"
         type="com.example.databindingsample.Player" />
</data>

```

> ImageView ve textviewi set edeceğimiz için onları nesneye bağlamamız gerekiyor. Bunun için aşağıdaki gibi set işlemini xml kısmında yapacağız.

```
app:imageResource="@{Player.image}"

android:text="@{Player.description}"

```

## RecyclerView Adapter Oluşturma

RecyclerView için önemli yardımcı sınıflarımız **RecyclerView.Adapter** , **RecylerView.ViewHolder** , **RecyclerView.layoutManager** sınıfıdır.

Adapter oluştururken viewholder sınıfıda oluşturmalıyız ve ayrıca memberlerı implement etmemiz gerekmektedir.

> **onCreateViewHolder** -> Adapter oluşturulduğunda viewholderı başlatır.

> **getItemCount** -> Listemizin eleman sayısını verir.

> **onBindViewHolder** -> onCreateViewHolder’dan dönen verilerin bağlama işlemini gerçekleştiriyor.

> **MyViewHolder** -> RecyclerView.ViewHolder extend edecektir.

MyViewHolder'da binding işlemlerini aşağıdaki gibi yapıyoruz.

```
class MyViewHolder(val itemBinding: PlayerRowBinding) : RecyclerView.ViewHolder(itemBinding.root){

    private var binding : PlayerRowBinding? = null

    init {
         this.binding = itemBinding
    }
 }
```
## MainActivity 


> binding nesnesini aşağıdaki gibi oluşturuyoruz. 

> layoutManager olarak ekranda nasıl gözükmesini istiyorsak ona göre değer veriyoruz. Bunlar;

> **LinearLayoutManager** -> Öğeleri dikey kaydırabilecek sütunda, veya yatay olarak kaydırabileceğimiz bir satırda.

> **GridLayoutManager** -> Öğeleri bir klavuzda görüntüler.

> **StaggeredGridLayoutManager** -> Öğeleri , bazı öğelerin yükseklik ve genişlik olduğu aşamalı bir kalvuzda görüntüler.


```
val binding: ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

binding.recyclerView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)

val adapter = PlayerAdapter(this, DummyData.getDummyData() as ArrayList<Player>)
binding.recyclerView.adapter = adapter
```

## Çıktı

DataBinding kullanarak oluşturduğumuz local verileri RecyclerViewda görüntüleyebileceğimiz bir uygulama.Aşağıdaki gibi çıktı verecektir.







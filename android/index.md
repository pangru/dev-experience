# data binding library
[android Reference](https://developer.android.com/topic/libraries/data-binding/index.html#data_objects)


### support
* Android 2.1 (API level 7+)
* gradle  1.5.0-alpha1 or higher
* android studio 1.3 and later

### 1. build environment
```
android {
  dataBinding {
    enabled = true
  }
}
```

### 2. Data Binding Layout Files
* `<variable></variable>` : View에서 사용할 property  
* `@{property name}` : data binding expression

```html
<!-- main_activity.xml -->
<layout>
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout>
       <TextView ...
        android:text="@{user.firstName}"/>
       <TextView ...
           android:text="@{user.lastName}"/>
   </LinearLayout>
</layout>
```

### 2-2. Data Object
* `@{user.firstname} `: user class의 firstname field를 직접 액세스하여 데이터 표시한다.
```java
// plain-old Java Object (POJO)
public class User {
   public final String firstName;
   public final String lastName;
   public User(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
   }
}
```

* `@{user.firstname} `: user class의 getFirstName()를 호출하여 데이터 표시한다.
```java
// JavaBeans Objects
public class User {
   private final String firstName;
   private final String lastName;
   public User(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
   }
   public String getFirstName() {
       return this.firstName;
   }
   public String getLastName() {
       return this.lastName;
   }
}
```

### 2-3. Binding data
* view (ui layout)과 viewModel을 바인딩해주는 클래스는 자동으로 생성된다.
* 바인딩 클래스는 View와 View서 사용할 property(변수)를 갖고 있다
* 생성 규칙: layout file name + "Binding"
  * i.g) MainActiityBinding = main_activity.xml + "Binding"

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
   User user = new User("Test", "User");
   binding.setUser(user);
}

// ListView or RecyclerView adpater에 data를 바인딩하는 법
ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
// or
ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);

```

### 2-4 Event Handling

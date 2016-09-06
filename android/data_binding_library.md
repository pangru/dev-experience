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

### 2. Data Object
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

### 3. Binding data
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

### 4. Event Handling
뷰 (e.g. onClick)에서 전달되는 이벤트를 처리하는 식을 작성할 수 있다.

### 4-1. Method References
* normal binding expression을 사용하여 event handler(listener)의 메소드명을 직접 참조한다.
* view에 참조된 메소드와 owner object를 포함한 listener를 컴파일 시점에 설정한다.
* view객체에 data가 바인딩되는 시점에 event listener 객체가 생성된다.

```java
// TextView ClickListener
public class MyHandlers {
    public void onClickFriend(View view) { ... }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="handlers" type="com.example.MyHandlers"/>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"
           android:onClick="@{handlers::onClickFriend}"/>
   </LinearLayout>
</layout>
```

### 4-2. Listener Bindings
* lambda expression 사용
* view 이벤트가 발생하면, lambda expression을 평가하고 설정된 event handler(listener)를 생성하여 이벤트를 처리한다.

```java
// TextView ClickListener
public class Presenter {
    public void onSaveClick(Task task){}
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
  <layout xmlns:android="http://schemas.android.com/apk/res/android">
      <data>
          <variable name="task" type="com.android.example.Task" />
          <variable name="presenter" type="com.android.example.Presenter" />
      </data>
      <LinearLayout android:layout_width="match_parent" android:layout_height="match_parent">
          <Button android:layout_width="wrap_content" android:layout_height="wrap_content"
          android:onClick="@{() -> presenter.onSaveClick(task)}" />
      </LinearLayout>
  </layout>
```

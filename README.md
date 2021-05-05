Niborhood Application
=====================

This application is a basic representation of stocks data from the given API.

###Android concepts used:

* **Android Architecture Components** - Used Android Architecture Components to address
Separation of Concerns in Android development

* **Live Data** - Used MutableLiveData to help observe data from API and used MediatorLiveData
that acts as a mediator and calculate total portfolio value. See MainViewMode.kt line 13 to 16

* **View Model** - MainViewMode.kt responsible for triggering repository and api call
and posting response through LiveData

* **Repository Pattern** - StocksReponsitory.kt is reponsible for making dealing with retrofit
and network requests. As a future enhancement, this is the place where SQL lite db could be
connected and store/retrieve data using Room for any offline experiences.

* **Data Binding** - Used data binding to bind data to view in adapter. Used BindingAdapter to
write custom bindings. See item.xml and BindingAdapter.kt

* **Recycler View** - Used recycler view to display list of stocks. Used header row and list rows
to display portfolio value and list of stocks

* **List Adapter** - Used List Adapter so that only changed items from api can be redrawn
instead of all rows.

* **Retrofit** - Used retrofit client to make network calls

* **GSON** - Used GSON libray to serialize/deserialize json response

* **Constraint Layout** - Used constraint layout for item.xml

* **Kotlin** - Code is 100% kotlin.

### Assumptions
Focused mainly on demonstrating multiple core components of Android

### Future Enhancements
* **UI**
* **Add sections to Recycler View to show portfolio positions and watchlist(current
everything is in the same list)**
* **Add styles and animations**
* **Add Room for offline support**
* **Add kdocs and tests**

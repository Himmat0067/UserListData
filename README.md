# UserListData Application with User API Call

Create an application that shows user list with the pagination and cache response into Room 

# UserListData App
[Download the APK](https://drive.google.com/file/d/1IlLwtJEalDCqwT6mJOVPpvQsTQxmCvKb/view?usp=sharing)


## Prerequisites
- Android Studio installed
- A physical Android device or an emulator

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Himmat0067/UserListData.git
    ```


2. **Open the Project in Android Studio:**

  - Open Android Studio.
  - Select `Open an existing Android Studio project`.
  - Navigate to the directory where you cloned the repository and select the `build.gradle` file.

3. **Build and Run:**

  - Connect your Android device to your computer or start an emulator.
  - Click on the green "Run" button in Android Studio or use the shortcut `Shift + F10` to build and run the application on your device or emulator.

## UserList App Features
* Show User List Using Recyclerview
* Show User details like image, name and email 
* Store user data into Room db and use in case of network unavailiblity


## Usage

1. **Launch the App:**

  - Open the UserListData on your Android device.
  - User List Is Visible



## Technical Skills
* [Kotlin](https://kotlinlang.org/) + [Coroutines](https://developer.android.com/kotlin/coroutines) for performing background operations
* [Hilt](https://dagger.dev/hilt/) for dependency injection
* [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) for infinte scroll
* [Jetpack](https://developer.android.com/jetpack)
    * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) for notifying views about data change
    * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) for performing an action when lifecycle state changes
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) for storing and managing UI-related data in a lifecycle conscious way
* [Retrofit](https://square.github.io/retrofit/) for REST API communication
* [OkHttp](https://square.github.io/okhttp/) for http & logging
* [Glide](https://bumptech.github.io/glide/) for image loading and caching
* [Retrofit](https://github.com/square/retrofit) for parsing JSON into Java objects
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/)) for writing repeatable tests
    * [MockK](https://mockk.io/) for mocking inside the Unit Test

## Architecture
Application is built on top of MVVM model and Clean Architecture. The code is written in Kotlin.
The goal is to present modern Android application architecture that is modular, scalable, maintainable and testable.

#### Presentation layer
This layer is closest to what the user sees on the screen. The `presentation` layer follows MVVM architecture.

#### Domain layer
This is the core layer of the application. Notice that the `domain` layer is independent of any other layers.
This allows to make domain models and business logic independent from other layers.

Components:
- **UseCase** - contains business logic
- **DomainModel** - defies the core structure of the data that will be used within the application. This is the source of truth for application data.
- **Repository interface** - required to keep the `domain` layer independent from the `data layer`

#### Data layer
Manages application data and exposes these data sources as repositories to the `domain` layer.
Typical responsibilities of this layer would be to retrieve data from the internet and optionally cache this data locally.

Components:
- **Repository** is exposing data to the `domain` layer. Depending on application structure and quality of the external APIs repository can also merge, filter, and transform the data. The intention of
  these operations is to create high-quality data source for the `domain` layer, not to perform any business logic (`domain` layer `use case` responsibility).

- **RetrofitService** - defines a set of API endpoints.
- **DataModel** - defines the structure of the data retrieved from the network and contains annotations, so Retrofit (Moshi) understands how to parse this network data (XML, JSON, Binary...) this data into objects.

### Design decisions
* Architecture - MVVM separates your view (i.e. Activitys and Fragments) from your business logic.
  MVVM is enough for small projects, but when your codebase becomes huge, your ViewModels start bloating.
  Separating responsibilities becomes hard. MVVM with Clean Architecture is pretty good in such cases.
  It goes one step further in separating the responsibilities of your code base. It clearly abstracts
  the logic of the actions that can be performed in your app.

* Caching - Glide checks multiple layers of caches before starting a new request for an image.
  It first checks to see if the resource is in memory and if so, return the image immediately. In the second step it checks to see if the image is on disk and return quickly, but asynchronously.
  If above steps fail to find the image, then Glide will go back to the original source to retrieve the data (the original File, Uri, Url etc).

* Infinite loading & Error states handling - The Paging library helps you load and display pages of data from a larger dataset from local storage or over network and provides below features:
    * In-memory caching for your paged data.
    * Configurable RecyclerView adapters that automatically request data as the user scrolls toward the end of the loaded data.
    * Built-in support for error handling, including refresh and retry capabilities.


## Screens
[Screenshot_detail](https://drive.google.com/file/d/1lBkvC7AAULwrj-3Yw9PAMPfrM0hm8mRK/view?usp=sharing)
# 257 Portal
257 Portal is a small aplication for my hometown and i started developing it just a few week ago, this app is like most of the news app and will contain all relevant data about place.
At this stage there is not very much things implemented in the app but but these are things which I will implement over time. This app is based on modern Android application tech-stacks, and MVVM architecture and also this app is made in single activity multiple fragments design pattern. App is stil in a process of making.
  - Information about sport events
  - Part of the app where all notices will be available
  - Information about all fun events and doings
  - There will also be a marketplace where people will sell their stuff
  - Part of the app where weather will be displayed
  - Searching through databse to find needed data
  - And there will also be a section where readers can enter their own articles

# About
At this point the app consists of Navigation Drawer and Bottom Navigation Drawer and when I clik on any of their items app sends me to the specific fragment. App consists of fragments for general news, sport news, notices, news about fun events a there is also implemented that users of this app can also add their own story. When clicked on any of items in RecyclerView app sends us to detail fragment where we see much more information about the specific piece of news. Also this app has implemented functionality that when long pressed we can update or delete specific item. This app is still in process of making so there will be more features in future.

# Tech stack & Open-source libraries 🛠
- Minimum SDK Level 26
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Navigation Component](https://developer.android.com/guide/navigation) -  Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
- [Retrofit](https://square.github.io/retrofit/) - to aid with API communicaton
- [Dependency Injection](https://developer.android.com/training/dependency-injection)
    - [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
    - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - Dependecy injection for injecting ViewModel.   
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
    - [Android KTX](https://developer.android.com/kotlin/ktx) - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original Android Support Library, which is no longer maintained.
    - [Room](https://developer.android.com/training/data-storage/room) - SQLite object mapping library.
- Architecture
    - [MVVM Architecture](https://developer.android.com/jetpack/guide?gclid=CjwKCAiAkJKCBhAyEiwAKQBCkrariGLVBTGun7TGT9IMaVf0ojoXdjIc-5tz-jl1L-CM7EsWjQrExRoCHO0QAvD_BwE&gclsrc=aw.ds) (View - DataBinding - ViewModel - Model)
    - Repository pattern

# Architecture
The architecture of the application is based, apply and strictly complies with each of the following 5 points:
- A single-activity architecture
- Android architecture components, part of Android Jetpack for give to project a robust design, testable and maintainable.
- Pattern Model-View-ViewModel (MVVM) facilitating a separation of development of the graphical user interface.
- S.O.L.I.D design principles intended to make software designs more understandable, flexible and maintainable.
- Modular app architecture allows to be developed features in isolation, independently from other features.

![mvvm-architecture-app-in-android](https://user-images.githubusercontent.com/64093104/110252926-07519900-7f88-11eb-9736-055484d79338.png)

# 257 Portal
257 Portal is a small aplication about my hometown, this app is like most of the news app and will contain all relevant data about place.
At this stage there are a few things with which I am satisfied but app is still long way from what I imagine it would be. This app is based on modern Android application tech-stacks, and also this app is made in single activity multiple fragments design pattern. App is stil in a process of making and at this stage I am implementing Firebase as backend service.
  - Information about sport events
  - Part of the app where all notices will be available
  - Information about all fun events and doings
  - There will also be a marketplace where people will sell their stuff
  - Part of the app where weather will be displayed
  - And there will also be a section where readers can enter their own articles

# About
At this point the app consists of Navigation Drawer and Bottom Navigation Drawer and when I clik on any of their items app sends me to the specific fragment. App consists of fragments for general news, sport news, notices, news about fun events a there is also implemented that users of this app can also add their own story. When clicked on any of items in RecyclerView app sends us to detail fragment where we see much more information about the specific piece of news. Also this app has implemented functionality that when RecyclerView item is long pressed then we are navigated to a login fragment where admin logs in and only he can update or delete specific item. This app is still in process of making so there will be more features in future.

<p float="left"> 
  <img src="https://user-images.githubusercontent.com/64093104/115160141-f6239e00-a096-11eb-9274-2fd4b03de893.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/115160057-7d244680-a096-11eb-9267-cbe1c2215e78.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/115160107-bceb2e00-a096-11eb-9cf7-a8943bf22634.png" width="200" height="400"/>
</p>

<p float="left"> 
  <img src="https://user-images.githubusercontent.com/64093104/115160334-00926780-a098-11eb-8957-c5a8061e2e72.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/115160454-772f6500-a098-11eb-850e-7212556c7e3c.png" width="200" height="400"/>
</p>

# Tech stack & Open-source libraries 🛠
- Minimum SDK Level 26
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Firebase](https://firebase.google.com/)- Firebase is Google's mobile platform that helps you quickly develop high-quality apps.
    - [Firestore]() - Cloud Firestore is a flexible, scalable database for mobile, web, and server development from Firebase and Google Cloud
    - [Authentication]() - Firebase Authentication provides backend services, easy-to-use SDKs, and ready-made UI libraries to authenticate users to your app
    - [Cloud Storage]() - Cloud Storage for Firebase is built for app developers who need to store and serve user-generated content, such as photos or videos.
- [Coroutines](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/) - For asynchronous and non_blocking programming
- [Navigation Component](https://developer.android.com/guide/navigation) -  Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
- [Retrofit](https://square.github.io/retrofit/) - to aid with API communicaton
- [Glide](https://github.com/bumptech/glide) - image loading library  
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
    - [Android KTX](https://developer.android.com/kotlin/ktx) - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original Android Support Library, which is no longer maintained.

# Architecture
The architecture of the application is based, apply and strictly complies with each of the following 5 points:
- A single-activity architecture
- Android architecture components, part of Android Jetpack for give to project a robust design, testable and maintainable.
- S.O.L.I.D design principles intended to make software designs more understandable, flexible and maintainable.
- Modular app architecture allows to be developed features in isolation, independently from other features.

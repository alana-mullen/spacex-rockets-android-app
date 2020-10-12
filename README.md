# Android technical test using the SpaceXData API

Android app displaying a list of SpaceX rockets.

## Technologies used:
* Android SDK
* Kotlin
* View Binding
* [Retrofit](https://github.com/square/retrofit)
* [Moshi](https://github.com/square/moshi)
* Coroutines
* LiveData
* ViewModels
* Repository Pattern
* Dependency Injection using Dagger Hilt
* Room to cache data
* [Coil](https://github.com/coil-kt/coil) image loading library
* [Stetho](http://facebook.github.io/stetho/)
* [Timber](https://github.com/JakeWharton/timber)


## Build instructions:
* Clone the repository
* From Android Studio:
    * Open project from the folder you cloned it into.
    * From the menu select **Run** and then **Run 'App'**.
* From the command line:
    * MacOs/Linux:
        `./gradlew installDebug`
    * Windows:
        `gradlew installDebug`


## Todo:
* Fix filter and use Dialog Fragment.
* Finish paging
* Unit tests.

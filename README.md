# Boilerplate

This repo contains boilerplate for frequently required functionalities when starting a new android project. The codebase is written entirely in Kotlin.

This repo contains boilerplate for the following functionality:
1. Basic API framework.
1. Basic `SharedPreferences` framework.
1. Basic `Activity` with a ProgressBar.
1. Basic Login screen and associated functionality.
1. Two home screens - one with a Navigation Drawer, another with a Bottom Navigation

### Description

Functionality | Description 
--------------|-------------
API framework | This application uses Retrofit2 to create network requests to [JSONPlaceholder](https://jsonplaceholder.typicode.com/), a online REST API for testing and prototyping. In the boilerplate, interface `RetrofitService` contains functionality for two different API endpoints. The calls are serialized using Gson. A singleton object `JsonPlaceHolderApi` should be used to create calls from `Repository`. `JsonPlaceHolder` wraps results in a `sealed class Result`. The response JSON is deserialized using data classes `Response` and `ResponseList`. 
Basic `SharedPreferences` Framework |  Contained in package `preferences`. Contains a `Singleton object` that currently be used to store two different unique preferences but can be easily scaled to as many as may be required.
Basic `Activity` with a ProgressBar |  Many applications will require an activity that will have a circular ProgressBar to notify user of some critical background operation. The `Activity` contains a button that will trigger the appeareance of a progressBar. Link to XML. 
Login screen with associated functionality | This functionality is implemented as an Activity with two standard `EditText`s and a `Button`. The `data` package contains `LoginRepository` class, that requests authentication and user information from the remote data source and maintains an in-memory cache of login status and user credentials information; `LoginDataSource` class that handles authentication w/ login credentials and retrieves user information and LoginResult, a generic class that holds a value with its loading status.
Navigation Drawer| A navigation drawer is vertical menu that is typically opened either by pulling from the left-side of the app of the screen or by pressing a [hamburger icon](https://images.app.goo.gl/iwgwKPn91n8CC9Hi7). The items in the Navigation Drawer are specified in nav_menu.xml. It's navigation is handled by Jetpack's (Navigation Component)[https://developer.android.com/guide/navigation] and is detailed in `navigation.xml`. 
Bottom Navigation Menu | A bottom navigation menu is horizontal menu that is typically present in the bottom of the app screen. The items in the nenu are specified in nav_menu.xml. It's navigation is handled by Jetpack's (Navigation Component)[https://developer.android.com/guide/navigation] and is detailed in `navigation.xml`.   

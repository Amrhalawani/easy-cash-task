
# Football League Application

A Challenge Android app to demonstrate code structure and the latest technologies for android development
the app contains all data for football competitions, Football League application is a simple app consisting of 2 screens that shows list of Competitions, and its
details.


## Environment Variables and Setup

To run this project, you will need to add the following environment variables to your secrets.properties file
it should be not visible here 

It has two constants :

`API_SECRET_KEY`

`BASE_URL`

also the documentation is here[@Apis Documentations](https://www.football-data.org/documentation/quickstart)
the app used V2.
# App Architecture


It's all about the Separation Of concerns, which is the main key for most of the best practice solutions.

so the app is organized into loosely coupled and self contained parts. Each part is a module
(data module, app UI module, utils, and our customCode module,  multi modules Reduce app build time and support Parallel working.

The App uses Multi Module approuch :
#### Data module: 

The data layer contains application data and business logic that determine how application data must be created, stored, getting, and changed.

also, there are the Repository classes that are responsible for Exposing data to the rest of the app.

Centralizing changes to the data.
Resolving conflicts between multiple data sources.
Abstracting sources of data from the rest of the app.

data source in the app was a network API and room database for saving favorites

also Containing business logic ( no need to mak the domain layer for now)

####  App Presentation module (UI):
the main module that is responsible for updating the UI and observes on the data requested by the data layer

it contains ViewModels and UI Components
navigation using jetPack Navigation Componanet  




### App flow

Ui Elements (sending request or event or Intent, observe on data notifier ) -> viewModel (data container that lives longer than the ui element) 
-> useCases or interactor layer inside data module that is responsible for the Business logic -> Repository (take a decision from which source of truth or data source should i receive the data) - > (network call or database )


### Ui flow 
Matches Adaptor responsible for creating Matches views(favorites item or normal item) and notifying the changes from sealed class to another parent adapter that holds all matches and the main date

so the inner adaptor is responsible for notifying the duo to it get the interaction from the user but I can not be relying on it so there is ensuring feedback comes from the database also.

### Unit testing
 i used junit4 and sometimes truth, turbine helper, so for now I tested the database and main functions of useCases.





## Tech Stack

**Dependency Injection:** Hilt

**Database:** Room

**Unit testing:** junit4, turbine, truth

**Reactive prog:** Flow, Coroutines

**Network:** Retrofit, OkHttp, Gson



## Contributing

feedbacks and hints are always welcome!

# The MarketPlace App

## Tech Stack & Architecture

This project follows the Clean Architecture principles and MVVM.

### Libraries Used

- UI: Compose
  - Material 3
  - Coil
- Kotlin Coroutines for handling data streams
- Dependency injection with Hilt
- Networking with Retrofit && OkHttp

### Data Flow

Repository --> UseCase --> ViewModel --> UiState --> ComposeUI 
maintaining the single source of truth for data flow.

#### How to build:
- add your `secret`, `key` and `baseUrl` in `NetworkModule.kt`. 
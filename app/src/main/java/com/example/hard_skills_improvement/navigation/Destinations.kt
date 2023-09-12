package com.example.hard_skills_improvement.navigation

/*enum class Destinations() {
    Home(),
    MobileDevelopment();
    enum class MobileDevelopmentDestinations(){
        Matrix(), Interview()
    }
}*/

enum class MobileDevDestinations : Destination{
  Matrix, Interview;
  
  companion object: Destination{
    private val groupName : String = this::class.java.name
    override val route: String = groupName
  }
  
  override val route: String
    get() = "${groupName}_$name"
}

enum class Destinations : Destination {
  Home,
  MobileDevelopment;
  companion object: Destination{
    private val groupName : String = this::class.java.name
    override val route: String = groupName
  }
  
  override val route: String
    get() = "${groupName}_$name"
}

interface Destination{
  val route : String
}
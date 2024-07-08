package nl.jaysh.spoorweg.core.model.trips

data class Trip(
    val uid: String,
    val legs: List<Leg>,
)

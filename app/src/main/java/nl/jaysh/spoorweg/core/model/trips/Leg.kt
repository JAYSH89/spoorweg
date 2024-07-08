package nl.jaysh.spoorweg.core.model.trips

data class Leg(
    val direction: String? = null,
    val stops: List<Stop>,
    val cancelled: Boolean,
)

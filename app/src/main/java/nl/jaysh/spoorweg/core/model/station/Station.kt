package nl.jaysh.spoorweg.core.model.station

data class Station(
    val uicCode: String,
    val name: String,
    val tracks: List<String>,
    val stationType: StationType,
)
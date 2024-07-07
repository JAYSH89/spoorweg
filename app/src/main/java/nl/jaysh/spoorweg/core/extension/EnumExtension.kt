package nl.jaysh.spoorweg.core.extension

inline fun <reified T : Enum<T>> valueOfOrNull(name: String): T? {
    return enumValues<T>().firstOrNull { it.name == name }
}
package syn.circus.portfolio.domain

enum class Destination(private val s: String) {
    Intro("intro"), About("about"), Projects("projects"), Skills("skills"), Contact("contact");

    object Body {

        fun getAppBarList() : List<Destination> {
            val list = Destination.entries.subList(fromIndex = 1, toIndex = 5)
            return list
        }
    }
}
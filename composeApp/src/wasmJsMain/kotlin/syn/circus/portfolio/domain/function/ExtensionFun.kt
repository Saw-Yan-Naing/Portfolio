package syn.circus.portfolio.domain.function

infix fun <T> Boolean.check(block: () -> T): T? = if (this) block() else null
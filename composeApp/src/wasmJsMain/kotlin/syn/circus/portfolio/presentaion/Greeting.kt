package syn.circus.portfolio.presentaion

import syn.circus.portfolio.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
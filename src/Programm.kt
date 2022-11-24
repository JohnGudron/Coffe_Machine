data class Resources(
    var water: Int = 400,
    var milk: Int = 540,
    var beans: Int = 120,
    var cups: Int = 9,
    var money: Int = 550
)

fun main() {
    val state = Resources()
    val costs = arrayListOf(
        intArrayOf(250, 0, 16, 1),  // espresso
        intArrayOf(350, 75, 20, 1), // latte
        intArrayOf(200, 100, 12, 1) // cappuccino
    )
    val text = { _water: Int, _milk: Int, _beans: Int, _cups: Int, _money: Int ->
        println(
            """The coffee machine has:
$_water ml of water
$_milk ml of milk
$_beans g of coffee beans
$_cups disposable cups
$$_money of money"""
        )
    }

    fun check(cost: IntArray): Pair<Boolean, String> {
        return when {
            state.water - cost[0] < 0 -> Pair(false, "water")
            state.milk - cost[1] < 0 -> Pair(false, "milk")
            state.beans - cost[2] < 0 -> Pair(false, "beans")
            state.cups - cost[3] < 0 -> Pair(false, "cups")
            else -> Pair(true, "full")
        }
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> {
                val act = check(costs[0])
                if (act.first) {
                    println("I have enough resources, making you a coffee!")
                    state.water -= 250
                    state.beans -= 16
                    state.money += 4
                    state.cups -= 1
                } else {
                    println("Sorry, not enough ${act.second}!")
                }
            }

            "2" -> {
                val act = check(costs[1])
                if (act.first) {
                    println("I have enough resources, making you a coffee!")
                    state.water -= 350
                    state.milk -= 75
                    state.beans -= 20
                    state.money += 7
                    state.cups -= 1
                } else {
                    println("Sorry, not enough ${act.second}!")
                }
            }

            "3" -> {
                val act = check(costs[2])
                if (act.first) {
                    println("I have enough resources, making you a coffee!")
                    state.water -= 200
                    state.milk -= 100
                    state.beans -= 12
                    state.money += 6
                    state.cups -= 1
                } else {
                    println("Sorry, not enough ${act.second}!")
                }
            }

            "back" -> { // no action in this branch for now
            }
        }
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        state.water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        state.milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        state.beans += readln().toInt()
        println("Write how many disposable cups you want to add: ")
        state.cups += readln().toInt()
    }

    fun take() {
        println("I gave you $${state.money}")
        state.money -= state.money
    }

    fun remain() {
        text(state.water, state.milk, state.beans, state.cups, state.money)
    }

    fun exit() {
        // just empty function for now
    }

    fun menu() {
        println("Write action (buy, fill, take, remaining, exit):")
        val action = readln()
        when (action) {
            "buy" -> {
                buy()
                menu()
            }
            "fill" -> {
                fill()
                menu()
            }
            "take" -> {
                take()
                menu()
            }
            "remaining" -> {
                remain()
                menu()
            }
            "exit" -> exit()
        }
    }

    menu()
}

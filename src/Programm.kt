fun main() {
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550
    var text = { water: Int, milk: Int, beans: Int, cups: Int, money: Int ->
        println(
            """The coffee machine has:
$water ml of water
$milk ml of milk
$beans g of coffee beans
$cups disposable cups
$$money of money"""
        )
    }
    text(water, milk, beans, cups, money)
    println("Write action (buy, fill, take):")
    val action = readln()
    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        when (readln()) {
            "1" -> {
                water -= 250
                beans -= 16
                money += 4
                cups -= 1
                text(water, milk, beans, cups, money)
            }

            "2" -> {
                water -= 350
                milk -= 75
                beans -= 20
                money += 7
                cups -= 1
                text(water, milk, beans, cups, money)
            }

            "3" -> {
                water -= 200
                milk -= 100
                beans -= 12
                money += 6
                cups -= 1
                text(water, milk, beans, cups, money)
            }
        }

    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        beans += readln().toInt()
        println("Write how many disposable cups you want to add: ")
        cups += readln().toInt()
        text(water, milk, beans, cups, money)
    }

    fun take() {
        println("I gave you $$money")
        money -= money
        text(water, milk, beans, cups, money)
    }

    when (action) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }

    // println("Write how many ml of water the coffee machine has:")
    // val water = readln().toInt()
    // println("Write how many ml of milk the coffee machine has:")
    // val milk = readln().toInt()
    // println("Write how many grams of coffee beans the coffee machine has:")
    // val beans = readln().toInt()
    // println("Write how many cups of coffee you will need:")
    // val cup = readln().toInt()
    // val n = intArrayOf(water / 200, milk / 50, beans / 15).minOrNull()
    // if (n!! == cup) {
    //     println("Yes, I can make that amount of coffee")
    // } else if (n > cup) {
    //     println("Yes, I can make that amount of coffee (and even ${n - cup} more than that)")
    // } else println("No, I can make only $n cups of coffee")
}

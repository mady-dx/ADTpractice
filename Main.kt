import java.util.ArrayList
import java.util.Scanner
fun main(args: Array<String>) {
    var groceryList = arrayListOf<String>();
    var done: Boolean = false;
    var itemNum: Int = 0;
    val console= Scanner(System.`in`)

    println("Welcome to your Grocery List \"App\"")
    do{
        println("There are currently $itemNum items in your list")
        println("What would you like to do?\n[1] Add to List\n[2] remove an item from list\n[0]exit program\n")
        val input = console.nextInt()
        when(input){
            1->{
                itemNum += addToList(groceryList)
                done = false;
            }
            2->{
                itemNum -= removeFromList(groceryList)
                done = false
            }
            else ->{
                done = true
            }
        }

    }while(!done)
    println("This is your Grocery List: ")
    printList(groceryList)
}

fun addToList( groceryList: ArrayList<String>): Int{
    val console = Scanner(System.`in`)
    println("What would you like to add to your list? ")
    var item :String = console.nextLine();
    groceryList.add(item)
    return 1
}

fun removeFromList(groceryList: ArrayList<String>):Int{
    val console = Scanner(System.`in`)
    println("What would you like to remove? [enter a number]")
    printList(groceryList)
    var item : Int = console.nextInt()
    if(item > 0 && item < groceryList.size){
        groceryList.removeAt(item - 1)
        return 1
    }
    else {
        println("Number give is not an item in list")
        return 0
    }
}

fun printList(groceryList: ArrayList<String>){
    for(i in 0..groceryList.size-1){
        var num = i+1
        println("$num. ${groceryList.get(i)}")
    }
}
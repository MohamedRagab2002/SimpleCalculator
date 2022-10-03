fun main(args : Array<String>) {

    var Number1 = 0
    var Number2 = 0
    var operation : Char = '+'

    println("Please Enter The First Number :")
    Number1 = readLine()!!.toInt()
    println("Please Enter The Second Number :")
    Number2 = readLine()!!.toInt()

    println("Please Enter The Operation like (+ , - , *) :")
    operation = readLine()!!.single()

    when(operation) {
        '+' -> add(Number1,Number2)
        '-' -> Sub(Number1,Number2)
        '*' -> multiplication(Number1,Number2)
    }
}
  fun add(num1:Int,num2:Int) {
      println("Result = ${num1+num2}")
  }

  fun Sub(num1 : Int, num2 : Int) {
    println("Result = ${num1 - num2}")
 }

 fun multiplication (num1 : Int , num2 : Int) {
     println("Result = ${num1 * num2}")
 }


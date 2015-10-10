import scala.annotation.tailrec

object Calculator {

  def main(args: Array[String]) {
    try{
      val number: Int = io.StdIn.readLine("Enter start number: " ).toInt
      println(this.calculate(number))
    }catch{
      case num: NumberFormatException => println("You must enter a number without decimal point")
      case _: Exception => println("Error has occurred")
    }
  }

  /**
   * Calculate result in recursion
   *
   * If you not choose = as operator function will go in recursion and ask for next number to calculate with last result,
   * if you enter wrong operator sum will be applied
   *
   * @param x [Int]
   *
   * @return [Int]
   */
  @tailrec
  def calculate(x: Int): Int = {
    val operate = io.StdIn.readLine("Enter operator: ")
    if(operate == "="){
      x
    }else{
      val newNumber: Int = io.StdIn.readLine("Enter number: ").toInt
      val result: Int = operate match {
        case "+" => x + newNumber
        case "-" => x - newNumber
        case "*" => x * newNumber
        case "/" => x / newNumber
        case _   => x + newNumber
      }
      this.calculate(result)
    }
  }

}

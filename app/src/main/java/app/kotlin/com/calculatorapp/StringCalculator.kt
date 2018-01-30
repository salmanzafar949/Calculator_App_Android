package app.kotlin.com.calculatorapp

/**
 * Created by salman on 1/30/18.
 */

class StringCalculator
{
   fun calculation(CalculationList: List<String>): Int
   {
       var current_opt : String =""
       var current_num  = 0

       CalculationList.forEach{ token ->
           when
           {
               token.equals("+")
                       || token.equals("-")
                       || token.equals("*")
                       || token.equals("/") -> current_opt = token
               current_opt.equals("-") -> current_num -= token.toInt()
               current_opt.equals("*") -> current_num *= token.toInt()
               current_opt.equals("/") -> current_num /= token.toInt()
               else ->  current_num += token.toInt()
           }

       }

       return current_num
   }
}
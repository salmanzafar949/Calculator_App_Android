package app.kotlin.com.calculatorapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        update_ui("")

    }

    // List of Operations
    val operation_list : MutableList<String> = arrayListOf()

    // List of numbers

    val numCache : MutableList<String> = arrayListOf()

    private fun extract_Strings(items : List<String>, Connect : String = ""): String
    {
        if(items.isEmpty())
            return ""
        return items.reduce { acc, s -> acc + Connect + s  }
    }

    private fun update_ui(main_String : String)
    {
        val Calculate_String = extract_Strings(operation_list, "")
        val calculation_text_View = findViewById<View>(R.id.disp_num) as TextView
        calculation_text_View.text = Calculate_String
        val ans = findViewById<View>(R.id.disp) as TextView
        ans.text = main_String
    }


    fun number_smash (view: View)
    {
        val button  = view as Button
        val num_str = button.text
        numCache.add(num_str.toString())
        val text = extract_Strings(numCache)
        update_ui(text)
    }

    fun Operator_smash(view: View)
    {
        val button = view as Button
        if(numCache.isEmpty())
            return
        operation_list.add(extract_Strings(numCache))
        numCache.clear()
        operation_list.add(button.text.toString())
        update_ui(button.text.toString())
    }

    private fun ClearCache()
    {
        operation_list.clear()
        numCache.clear()
    }

    fun all_clear(view: View)
    {
        ClearCache()
        update_ui("")
    }

    fun equal_smash(view: View)
    {
        operation_list.add(extract_Strings(numCache))
        numCache.clear()
        val Cal = StringCalculator()
        val ans = Cal.calculation(operation_list)
        update_ui("="+ ans.toString())
        ClearCache()

    }

}

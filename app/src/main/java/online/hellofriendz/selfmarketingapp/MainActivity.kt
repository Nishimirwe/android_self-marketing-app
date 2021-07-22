package online.hellofriendz.selfmarketingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var jobs:Array<String> = arrayOf("Software Engineer","Software Developer","Smartphone apps developer","Software Analyst")

        var adp=ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,jobs)
        drop_down_field.adapter=adp

        preview_button.setOnClickListener {
            onSubmitClicked()
        }
    }
    private fun onSubmitClicked() {

        var Message=MessageToSentClass(
            my_name.text.toString(),
            contact_number.text.toString(),
            my_email.text.toString(),
            ready_now_check_box.isChecked,
            available_from_data_text_field.text.toString(),
            drop_down_field.selectedItem.toString(),
            junior_check_box.isChecked
        )
        if(my_name.text.toString().isEmpty() || contact_number.text.toString().isEmpty() ||
            (!ready_now_check_box.isChecked && available_from_data_text_field.text.toString().isEmpty()) ||
                my_email.text.toString().isEmpty())
        {
            Toast.makeText(this,"Please, check if essential data are filled properly",Toast.LENGTH_LONG).show()
        }
        else
        {
            val i=Intent(this,PreviewActivity::class.java)
            // This is how we pass our variable to a new Activity. So nice and fantastic and simple
            i.putExtra("Message",Message)
            startActivity(i)
        }
    }
}
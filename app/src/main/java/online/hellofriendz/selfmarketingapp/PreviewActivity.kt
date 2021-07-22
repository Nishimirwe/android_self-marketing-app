package online.hellofriendz.selfmarketingapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    private lateinit var real_message: MessageToSentClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        message_preview_text_view_id.text = message()
        // sending a message, the following function contains the clicking of the button isnide itself. Visiti it if you want
        //look at it
        sendMessage()
    }

    private fun message(): String {
        var Message: MessageToSentClass =
            intent.getSerializableExtra("Message") as MessageToSentClass
        real_message=Message
        var message_to_display: String = """
            Hi ${Message.getName()} recruiter,
            
            My name is Jean Paul Nishimirwe and I am ${Message.manageJunior()}.
            
            I have a portfolio app to demonstrate my technical skills for you, and I can show that on any request. 
            
            I am able to help you as ${Message.getJobTitle()} in your company at a high level. Interestingly, I am ready to start the job ${Message.toStart()}.
            
            Please get in touch if you have any suitable role for me.
                        
            Best,
            
            Jean Paul
            - - - - - -
            Name: Jean Paul Nishimirwe
            College: Carnegie Mellon University
            Telephone: +250 789 336 678
            
        """.trimIndent()
        return message_to_display
    }
    private fun sendMessage()
    {
        send_button_id.setOnClickListener {
            // here, we are going to sent our message to the recruiter.
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:${real_message.getPhone()}")  // This ensures only SMS apps respond
                putExtra("sms_body", message())
            }
            startActivity(intent)
        }
    }
}
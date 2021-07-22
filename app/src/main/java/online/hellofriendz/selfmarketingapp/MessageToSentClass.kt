package online.hellofriendz.selfmarketingapp

import java.io.Serializable

data class MessageToSentClass(
    private val name: String,
    private val phone: String,
    private val email: String,
    private val start_now: Boolean,
    private val start_date: String,
    private val job_title: String,
    private val junior: Boolean
) : Serializable {
    fun manageJunior(): String {
        if (junior) {
            return "a junior android engineer"
        }
        return "an android engineer"
    }
    fun getName()=name
    fun toStart():String= if(start_now) "immediately" else "from $start_date"

    fun getJobTitle(): String= job_title
    fun getPhone():String=phone

}
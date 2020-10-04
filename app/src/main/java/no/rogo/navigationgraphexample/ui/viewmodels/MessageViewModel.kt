package no.rogo.navigationgraphexample.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import no.rogo.navigationgraphexample.repository.Message

class MessageViewModel:ViewModel() {

    val TAG = javaClass.simpleName

    fun addMessage(messageMLD: MutableLiveData<ArrayList<String>>, message:String)
    {
        Log.i(TAG, "addMessage: Message added: $message")
        messageMLD.value?.add(message)?.let { messageMLD.postValue(arrayListOf(message)) }
    }

    val errorMessageTextMLD = Message.getErrorMessageTextMLD()
    val informationMessageTextMLD = Message.getInformationMessageTextMLD()
    val warningMessageTextMLD = Message.getWarningMessageTextMLD()
}
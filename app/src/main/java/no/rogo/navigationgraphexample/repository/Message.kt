package no.rogo.navigationgraphexample.repository

import androidx.lifecycle.MutableLiveData

class Message {

    private val TAG = javaClass.simpleName

    private val informationMessageTextMLD = MutableLiveData<String>()
    private val warningMessageTextMLD = MutableLiveData<String>()
    private val errorMessageTextMLD = MutableLiveData<String>()

    companion object{
        private val TAG = javaClass.simpleName

        @Volatile private var instance: Message?=null

        fun getInstance() = instance?: synchronized(this)
        {
            instance ?: Message().also { instance = it }
        }

        fun info(infoText: String)
        {
            instance?.info(infoText)
        }

        fun warning(warningText: String)
        {
            instance?.warning(warningText)
        }

        fun error(errorText: String)
        {
            instance?.error(errorText)
        }

        fun getInformationMessageTextMLD() = instance?.getInformationMessageTextMLD()
        fun getWarningMessageTextMLD() = instance?.getWarningMessageTextMLD()
        fun getErrorMessageTextMLD() = instance?.getErrorMessageTextMLD()

    }


    fun info(infoText: String)
    {
        informationMessageTextMLD.postValue(infoText)
    }

    fun warning(warningText: String)
    {
        warningMessageTextMLD.postValue(warningText)
    }

    fun error(errorText: String)
    {
        errorMessageTextMLD.postValue(errorText)
    }

    fun getErrorMessageTextMLD():MutableLiveData<String>{
        return errorMessageTextMLD
    }

    fun getWarningMessageTextMLD():MutableLiveData<String>{
        return warningMessageTextMLD
    }

    fun getInformationMessageTextMLD():MutableLiveData<String>
    {
        return informationMessageTextMLD
    }

}
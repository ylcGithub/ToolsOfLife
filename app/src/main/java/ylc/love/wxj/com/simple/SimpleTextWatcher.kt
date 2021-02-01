package ylc.love.wxj.com.simple

import android.text.Editable
import android.text.TextWatcher

/**
 *@author YLC-D
 *@create on 2021/2/1 09
 *说明:
 */
 abstract class SimpleTextWatcher: TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {

    }
}
package ylc.love.wxj.com.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import ylc.love.wxj.com.utils.FontCustom

/**
 *@author YLC-D
 *@create on 2021/2/23 10
 *说明:
 */
class AppButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatButton(context, attrs, defStyle) {

    init {
        //不是预览页面情况下，设置字体样式
        if (!isInEditMode) {
            typeface = FontCustom.setFont(context)
        }
    }

    fun notifyTypeFace() {
        typeface = FontCustom.setFont(context)
    }
}
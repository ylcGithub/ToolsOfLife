package ylc.love.wxj.com.widget

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView
import ylc.love.wxj.com.R

/**
 * @author YLC-D
 * @create on 2020/10/26 14
 * 说明:
 */
open class AppTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {
    private var normalTextColor: ColorStateList
    private var pressedColor: ColorStateList? = null
    private var selectedColor: ColorStateList? = null
    override fun drawableStateChanged() {
        super.drawableStateChanged()
        if (selectedColor != null && isSelected) {
            setTextColor(selectedColor)
        } else {
            if (isPressed && pressedColor != null) {
                setTextColor(pressedColor)
            } else {
                setTextColor(normalTextColor)
            }
        }
    }

    fun setPressedColor(@ColorInt pColor: Int) {
        pressedColor = ColorStateList.valueOf(pColor)
    }

    override fun setTextColor(color: Int) {
        super.setTextColor(color)
        normalTextColor = ColorStateList.valueOf(color)
    }

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AppTextView)
        val pressColor = typedArray.getColor(R.styleable.AppTextView_text_pressed_color, 0)
        val selectColor = typedArray.getColor(R.styleable.AppTextView_text_selected_color, 0)
        typedArray.recycle()
        normalTextColor = textColors
        if (pressColor != 0) {
            pressedColor = ColorStateList.valueOf(pressColor)
        }
        if (selectColor != 0) {
            selectedColor = ColorStateList.valueOf(selectColor)
            pressedColor = selectedColor
        }
    }
}
package ylc.love.wxj.com.ui.game

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import ylc.love.wxj.com.R
import ylc.love.wxj.com.utils.ResUtil
import ylc.love.wxj.com.widget.AppTextView

/**
 *@author YLC-D
 *@create on 2021/3/1 15
 *说明:
 */
@SuppressLint("ViewConstructor")
class Card constructor(
    context: Context,
    pLeft:Int = 0,
    pTop:Int = 0,
    pRight:Int = 0,
    pBottom:Int = 0,
) : FrameLayout(context, null) {

    private var label:AppTextView = AppTextView(context)
    var num: Int = 0
        set(value) {
            field = value
            if (value == 0) label.text = "" else label.text = value.toString()
            setBg()
        }

    init {
        label.textSize = 24f
        label.gravity = Gravity.CENTER
        label.radius = 20
        label.setTextColor(ResUtil.getColor(context,R.color.color_333))

        addView(label, LayoutParams(-1,-1))
        setPadding(pLeft,pTop,pRight,pBottom)
    }

    private fun setBg(){
        if(0 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_0)
        }else if(2 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_2)
        }else if(4 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_4)
        }else if(8 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_8)
        }else if(16 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_16)
        }else if(32 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_32)
        }else if(64 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_64)
        }else if(128 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_128)
        }else if(256 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_256)
        }else if(512 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_512)
        }else if(1024 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_1024)
        }else if(2048 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_2048)
        }else if(4096 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_4096)
        }else if(8182 == num){
            label.bgColor = ResUtil.getColor(context, R.color.card_color_8182)
        }
        label.setBgSelector()
    }

    fun equal(card: Card): Boolean {
        return num == card.num
    }
}
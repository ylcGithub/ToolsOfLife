package ylc.love.wxj.com.ui.game

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams
import android.widget.GridLayout
import ylc.love.wxj.com.R
import ylc.love.wxj.com.utils.ResUtil
import ylc.love.wxj.com.utils.ScreenUtil

/**
 *@author YLC-D
 *@create on 2021/3/1 11
 *说明:
 */
class GameViewBg @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : GridLayout(context, attrs, defStyle) {
    companion object {
        private const val space: Int = 10
    }

    init {
        setBackgroundColor(ResUtil.getColor(context, R.color.game_background))
        columnCount = 4
        setPadding(space, space, space, space)
        addCards((ScreenUtil.getScreenWidth() - 2 * space) / 4)
    }

    private fun addCards(cardWidth: Int) {
        val lp = LayoutParams(cardWidth, cardWidth)
        var card: Card
        for (x in 0..3) {
            for (y in 0..3) {
                card = Card(context, space, space, space, space)
                card.num = 0
                addView(card, lp)
            }
        }
    }
}
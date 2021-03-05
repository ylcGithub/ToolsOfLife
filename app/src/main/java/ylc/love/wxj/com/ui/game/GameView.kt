package ylc.love.wxj.com.ui.game

import android.animation.Animator
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup.LayoutParams
import android.widget.GridLayout
import ylc.love.wxj.com.utils.AnimUtil
import ylc.love.wxj.com.utils.ScreenUtil
import kotlin.math.absoluteValue

/**
 *@author YLC-D
 *@create on 2021/3/1 11
 *说明:
 */
@SuppressLint("ClickableViewAccessibility")
class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : GridLayout(context, attrs, defStyle) {

    var startX: Float = 0f
    var startY: Float = 0f
    var offsetX: Float = 0f
    var offsetY: Float = 0f

    companion object {
        private const val space: Int = 10
        private val cardArray = Array(4) { arrayOfNulls<Card>(4) }
        private val worthyArray = Array(4){ arrayOfNulls<Card>(4)}
    }

    init {
        columnCount = 4
        setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x
                    startY = event.y
                }
                MotionEvent.ACTION_UP -> {
                    offsetX = event.x - startX
                    offsetY = event.y - startY
                    judgingTheDirection(offsetX, offsetY)
                }
            }
            true
        }
        setPadding(space, space, space, space)
        addCards((ScreenUtil.getScreenWidth() - 2 * space) / 4)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        randomCard()
        randomCard()
    }

    private fun addCards(cardWidth: Int) {
        val lp = LayoutParams(cardWidth, cardWidth)
        var card: Card
        for (x in 0..3) {
            for (y in 0..3) {
                card = Card(context, space, space, space, space)
                card.num = 0
                addView(card, lp)
                cardArray[x][y] = card
            }
        }
    }

    /**
     * 判断用户的手指滑动方向
     */
    private fun judgingTheDirection(offsetX: Float, offsetY: Float) {
        val xD = offsetX.absoluteValue > offsetY.absoluteValue
        when {
            xD && offsetX < -5 -> swipeLeft()
            xD && offsetX > 5 -> swipeRight()
            !xD && offsetY < -5 -> swipeUp()
            !xD && offsetY > 5 -> swipeDown()
        }
    }

    private fun swipeLeft() {
       scheduleSwipeAnim(Dir.LEFT)
    }

    private fun swipeRight() {
        scheduleSwipeAnim(Dir.RIGHT)
    }

    private fun swipeUp() {
        scheduleSwipeAnim(Dir.TOP)
    }

    private fun swipeDown() {
        scheduleSwipeAnim(Dir.BOTTOM)
    }

    /**
     * index 要排除的不移动的行 列
     */
    private fun scheduleSwipeAnim(index:Dir){
        val hashMap = HashMap<Card,Int>()
        for(x in 0..3){
            for (y in 0..3){
                if(index == Dir.LEFT && y != 0){
                    worthyArray[x][y]?.let {
                        hashMap.put(it,y)
                    }
                }else if(index == Dir.TOP && x != 0 ){
                    worthyArray[x][y]?.let {
                        list.add(it)
                    }
                }else if(index == Dir.RIGHT && y != 3){
                    worthyArray[x][y]?.let {
                        list.add(it)
                    }
                }else if(index == Dir.BOTTOM && x != 3){
                    worthyArray[x][y]?.let {
                        list.add(it)
                    }
                }
            }
        }
        startAnim(list,index)
    }

    private fun startAnim(list:MutableList<Card>,dir:Dir){

    }

    private fun randomCard() {
        val num = if ((0..2).random() > 0) 2 else 4
        var indexX = (0..3).random()
        var indexY = (0..3).random()
        while (cardArray[indexX][indexY]?.num != 0) {
            indexX = (0..3).random()
            indexY = (0..3).random()
        }
        showViewAnim(cardArray[indexX][indexY]!!,num)
        worthyArray[indexX][indexY] = cardArray[indexX][indexY]
    }

    //卡片出现的动画
   private fun showViewAnim(card: Card,num:Int) {
        val set = AnimatorSet()
        set.playTogether(
            AnimUtil.getScaleX(card, 0f, 1f),
            AnimUtil.getScaleY(card, 0f, 1f)
        )
        set.duration = 300
        set.addListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
                card.num = num
            }

            override fun onAnimationEnd(animation: Animator?) {

            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }
        })
        set.start()
    }
}
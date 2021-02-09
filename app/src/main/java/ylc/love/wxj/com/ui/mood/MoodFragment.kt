package ylc.love.wxj.com.ui.mood

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import kotlinx.android.synthetic.main.fragment_mood.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentMoodBinding

class MoodFragment : BaseFragment<MoodViewModel,FragmentMoodBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_mood

    override fun getViewModel(): MoodViewModel = getViewModelProvider(this).get(MoodViewModel::class.java)

    override fun initData() {
        start.setOnClickListener {
            val animators = listOf<ObjectAnimator>(
//                ObjectAnimator.ofFloat(btn,"scaleX",1f,0.2f,1.8f,0.5f,1f),
//                ObjectAnimator.ofFloat(btn,"scaleY",1f,0.2f,1.8f,0.5f,1f),
                ObjectAnimator.ofFloat(btn, View.ROTATION_X,0f,360f),
//                ObjectAnimator.ofFloat(btn,"rotationY",0f,180f),
//                ObjectAnimator.ofFloat(btn,"rotation",0f,-90f),
//                ObjectAnimator.ofFloat(btn,"scaleY",1f,1.5f),
//                ObjectAnimator.ofFloat(btn,"scaleX",1f,0.5f),
//                ObjectAnimator.ofFloat(btn,"alpha",0f,1f,0.25f,1f)
            )
            val set  = AnimatorSet()
            set.playTogether(animators)
            set.setDuration(6*1000).start()

        }
    }


//    ObjectAnimator.ofFloat(it,"rotationX",0f,360f),
//    ObjectAnimator.ofFloat(it,"rotationY",0f,180f),
//    ObjectAnimator.ofFloat(it,"rotation",0f,-90f),
//    ObjectAnimator.ofFloat(it,"scaleY",1f,1.5f),
//    ObjectAnimator.ofFloat(it,"scaleX",1f,0.5f),
//    ObjectAnimator.ofFloat(it,"alpha",0f,1f,0.25f,1f)
}
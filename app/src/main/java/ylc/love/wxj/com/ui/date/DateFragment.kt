package ylc.love.wxj.com.ui.date

import kotlinx.android.synthetic.main.fragment_date.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.databinding.FragmentDateBinding

class DateFragment : BaseFragment<DateViewModel,FragmentDateBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_date
    override fun getViewModel(): DateViewModel = getViewModelProvider(this).get(DateViewModel::class.java)

    override fun initData() {
        create_date.setOnClickListener {
            navigate(R.id.date_to_create)
        }
    }

}
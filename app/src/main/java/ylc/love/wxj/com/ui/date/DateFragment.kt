package ylc.love.wxj.com.ui.date

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_date.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.base.BaseOneLayoutAdapter
import ylc.love.wxj.com.base.BaseViewHolder
import ylc.love.wxj.com.databinding.DateListItemBinding
import ylc.love.wxj.com.databinding.FragmentDateBinding
import ylc.love.wxj.com.model.DateBean
import ylc.love.wxj.com.utils.DateUtils
import java.util.*

class DateFragment : BaseFragment<DateViewModel, FragmentDateBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_date
    override fun getViewModel(): DateViewModel =
        getViewModelProvider(this).get(DateViewModel::class.java)

    override fun initData() {
        rcv_date.layoutManager =
            LinearLayoutManager(context).also { it.orientation = LinearLayoutManager.VERTICAL }
        rcv_date.adapter = listAdapter
    }


    private val listAdapter =
        object : BaseOneLayoutAdapter<DateBean, DateListItemBinding>(R.layout.date_list_item) {
            override fun itemIsSame(oldItem: DateBean, newItem: DateBean): Boolean =
                oldItem.id == newItem.id

            @RequiresApi(Build.VERSION_CODES.Q)
            override fun onBindItem(
                bind: DateListItemBinding,
                item: DateBean,
                holder: BaseViewHolder) {
                bind.tvTitle.text = item.title
                bind.tvTitleDate.text = DateUtils.getDateStr(item.date,"yyyy-MM-dd")
                bind.tvGone.text = "33天"
                bind.tvNeedTime.text = "66天"
                bind.tvDes.text = item.des
            }

        }
}
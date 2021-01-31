package ylc.love.wxj.com.ui.date

import android.os.Build
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_date.*
import ylc.love.wxj.com.R
import ylc.love.wxj.com.base.BaseFragment
import ylc.love.wxj.com.base.BaseOneLayoutAdapter
import ylc.love.wxj.com.base.BaseViewHolder
import ylc.love.wxj.com.databinding.DateListItemBinding
import ylc.love.wxj.com.databinding.FragmentDateBinding
import ylc.love.wxj.com.model.EventBean
import ylc.love.wxj.com.utils.DateUtils
import ylc.love.wxj.com.utils.ResUtil
import ylc.love.wxj.com.widget.CustomItemDecoration

class DateFragment : BaseFragment<DateViewModel, FragmentDateBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_date
    override fun getViewModel(): DateViewModel =
        getViewModelProvider(this).get(DateViewModel::class.java)

    override fun initData() {
        rcv_date.layoutManager =
            LinearLayoutManager(context).also { it.orientation = LinearLayoutManager.VERTICAL }
        rcv_date.adapter = listAdapter
        mViewModel.getAllDateBeans()
        if (rcv_date.itemDecorationCount == 0) {
            rcv_date.addItemDecoration(CustomItemDecoration(CustomItemDecoration.Type.VER).apply {
                space = ResUtil.getDimen(mContext, R.dimen.widget_size_15).toInt()
                mostTop = space
                mostLeft = space
                mostRight = space
                mostBottom = space
            })
        }
        mViewModel.dateList.observe(this, {
            listAdapter.updateList(it, true)
        })
    }


    private val listAdapter =
        object : BaseOneLayoutAdapter<EventBean, DateListItemBinding>(R.layout.date_list_item) {
            override fun itemIsSame(oldItem: EventBean, newItem: EventBean): Boolean =
                oldItem.id == newItem.id

            @RequiresApi(Build.VERSION_CODES.Q)
            override fun onBindItem(
                bind: DateListItemBinding,
                item: EventBean,
                holder: BaseViewHolder
            ) {
                bind.tvTitle.text = item.title
                bind.tvTitleDate.text = DateUtils.getDateStr(item.date, "yyyy-MM-dd")
                bind.tvGone.text = DateUtils.getGone(item.date)
                bind.tvNeedTime.text = DateUtils.getNeed(item.date)
                bind.tvDes.text = item.des
                bind.tvDes.setOnClickListener {
                    if (bind.tvDes.maxLines == 1) {
                        bind.tvDes.maxLines = 10
                        bind.tvDes.ellipsize = null
                    } else {
                        bind.tvDes.maxLines = 1
                        bind.tvDes.ellipsize = TextUtils.TruncateAt.END
                    }
                }
            }
        }

}
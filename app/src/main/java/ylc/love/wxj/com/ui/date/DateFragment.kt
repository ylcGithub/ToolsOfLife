package ylc.love.wxj.com.ui.date

import android.annotation.SuppressLint
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
import ylc.love.wxj.com.model.AppDataBase
import ylc.love.wxj.com.model.DateBean
import ylc.love.wxj.com.ui.create.date.CreateDateActivity
import ylc.love.wxj.com.utils.DateUtils
import ylc.love.wxj.com.utils.ResUtil
import ylc.love.wxj.com.widget.CustomItemDecoration

class DateFragment : BaseFragment<DateViewModel, FragmentDateBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_date
    override fun getViewModel(): DateViewModel =
        getViewModelProvider(this).get(DateViewModel::class.java)

    override fun initData() {
        rcv_date.layoutManager = LinearLayoutManager(context)
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
        create.setOnClickListener {
            toNextActivity(CreateDateActivity::class.java)
        }
    }


    private val listAdapter =
        object : BaseOneLayoutAdapter<DateBean, DateListItemBinding>(R.layout.date_list_item) {
            override fun itemIsSame(oldItem: DateBean, newItem: DateBean): Boolean =
                oldItem.id == newItem.id

            @SuppressLint("SetTextI18n")
            @RequiresApi(Build.VERSION_CODES.Q)
            override fun onBindItem(
                bind: DateListItemBinding,
                item: DateBean,
                holder: BaseViewHolder
            ) {
                bind.tvTitle.text = item.title
                bind.tvTitleDate.text = DateUtils.getDateStr(item.date, "yyyy-MM-dd")
                bind.tvGone.text = "${item.goneDay}天"
                bind.tvNeedTime.text = "${item.needDay}天"
                bind.tvDes.text = item.des ?: item.title
                bind.tvDes.setOnClickListener {
                    if (bind.tvDes.maxLines == 1) {
                        bind.tvDes.maxLines = 10
                        bind.tvDes.ellipsize = null
                    } else {
                        bind.tvDes.maxLines = 1
                        bind.tvDes.ellipsize = TextUtils.TruncateAt.END
                    }
                }
                bind.tvDes.setOnLongClickListener {
                    deleteItem(holder.adapterPosition)
                    showDeleteWindow(item)
                    true
                }
            }
        }

    private fun showDeleteWindow(item:DateBean) {
        val eventBeanDao = AppDataBase.instance.eventBeanDao()
        eventBeanDao.delete(item)
    }

}
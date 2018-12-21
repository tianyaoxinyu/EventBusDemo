package kotlindemo.forwor.com.eventbusdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import kotlindemo.forwor.com.eventbusdemo.adapter.FilterSpecificAdapter;
import kotlindemo.forwor.com.eventbusdemo.adapter.SpcificAdapter;
import kotlindemo.forwor.com.eventbusdemo.databinding.ActivityRecyclerSearchViewBinding;
import kotlindemo.forwor.com.eventbusdemo.entity.DataProvider;

/**
 * Created by Myy on 2018/12/19 16:35
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private ActivityRecyclerSearchViewBinding mDataBinding;
    private SpcificAdapter spcificAdapter;
    private FilterSpecificAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_search_view);
        Log.e("dataBinding", "" + mDataBinding);
        mAdapter = new FilterSpecificAdapter(DataProvider.getSpecifics());
        final GridLayoutManager manager = new GridLayoutManager(this,2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItemViewType(position) == FilterSpecificAdapter.CONTENT ? 1 : manager.getSpanCount();
            }
        });
        mDataBinding.rclSpecification.setAdapter(mAdapter);
        mDataBinding.rclSpecification.setLayoutManager(manager);

/*        mDataBinding.rclSpecification.addItemDecoration(new GridMuiltItemDecoration(0, 15, 15, 15));*/
        mAdapter.expandAll();
      /*  mDataBinding.rclSpecification.addItemDecoration(new GridSectionAverageGapItemDecoration(0, 15, 15, 15));
        spcificAdapter = new SpcificAdapter(R.layout.item_rcl_specif_content, R.layout.item_rcl_specif_title, DataProvider.getSpcificCombinData());
        spcificAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SpcificCombin spcificCombin = (SpcificCombin) adapter.getData().get(position);
                String head = spcificCombin.header;
                if (!spcificCombin.isHeader) {
                    Toast.makeText(RecyclerViewActivity.this, head + position, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < spcificAdapter.getData().size(); i++) {
                        if (spcificCombin.t.getHeader().equals(spcificAdapter.getData().get(i).header)) {
                            if (i == position) {
                                spcificAdapter.getData().get(i).t.setSelected(true);
                                Toast.makeText(RecyclerViewActivity.this, spcificCombin.t.getHeader() + "0", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RecyclerViewActivity.this, spcificCombin.t.getHeader() + "1", Toast.LENGTH_SHORT).show();
                                spcificAdapter.getData().get(i).t.setSelected(false);
                            }
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        mDataBinding.rclSpecification.setAdapter(spcificAdapter);*/


    }
}

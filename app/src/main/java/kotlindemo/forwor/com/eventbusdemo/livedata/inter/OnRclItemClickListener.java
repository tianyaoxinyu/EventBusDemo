package kotlindemo.forwor.com.eventbusdemo.livedata.inter;

import android.view.View;

import kotlindemo.forwor.com.eventbusdemo.entity.Movie;

/**
 * Created by Myy on 2019/3/7 15:16
 */
public interface OnRclItemClickListener {
    void onItemClick(View v,Movie movie);
}

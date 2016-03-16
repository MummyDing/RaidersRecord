package com.github.mummyding.raidersrecord.support;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mummyding.raidersrecord.R;
import com.github.mummyding.raidersrecord.model.RaiderModel;

import java.util.List;

/**
 * Created by MummyDing on 16-3-16.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int TYPE_FINISHED = 0;
    public static final int TYPE_RUNNING = 1;

    private List<RaiderModel> list;
    private Context context;

    public ListAdapter(Context context,List<RaiderModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case TYPE_FINISHED:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_raiders_finished,parent,false);
                return new FinishedViewHolder(view);
            case TYPE_RUNNING:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_raiders_running,parent,false);
                return new RunningViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        RaiderModel model = getItem(position);

        if (holder instanceof FinishedViewHolder){
            FinishedViewHolder viewHolder = (FinishedViewHolder) holder;
            if(TextUtil.isNull(model.getImageUri()) == false){
                viewHolder.imageView.setImageURI(Uri.parse(model.getImageUri()));
            }

            viewHolder.title.setText(model.getActivityTitle());
            viewHolder.currentState.setText(model.getCurrentDateState());
            viewHolder.winner.setText(model.getWinner());
            viewHolder.finishedTime.setText(model.getFinishedTime());
        }else {

            RunningViewHolder viewHolder = (RunningViewHolder) holder;
            if(TextUtil.isNull(model.getImageUri()) == false){
                viewHolder.imageView.setImageURI(Uri.parse(model.getImageUri()));
            }

            viewHolder.title.setText(model.getActivityTitle());
            viewHolder.currentState.setText(model.getCurrentDateState());
            viewHolder.progressBar.setProgress(model.getParticipantCount()*5);
            viewHolder.count.setText(Integer.toString(model.getParticipantCount()));
        }
    }

    private RaiderModel getItem(int position){
        return list.get(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).isFinished() ? TYPE_FINISHED:TYPE_RUNNING;
    }

    static class RunningViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;
        TextView currentState;
        ProgressBar progressBar;
        TextView count;

        public RunningViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            currentState = (TextView) itemView.findViewById(R.id.tv_current_state);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress);
            count = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }

    static class FinishedViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;
        TextView currentState;
        TextView winner;
        TextView finishedTime;
        public FinishedViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            currentState = (TextView) itemView.findViewById(R.id.tv_current_state);
            winner = (TextView) itemView.findViewById(R.id.winner);
            finishedTime = (TextView) itemView.findViewById(R.id.tv_finished_time);
        }
    }
}

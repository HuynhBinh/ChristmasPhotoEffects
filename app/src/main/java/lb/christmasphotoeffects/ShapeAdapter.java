/*
 * Copyright (C) 2014 Lucas Rocha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lb.christmasphotoeffects;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.lucasr.twowayview.widget.TwoWayView;

import java.util.ArrayList;
import java.util.List;

public class ShapeAdapter extends RecyclerView.Adapter<ShapeAdapter.SimpleViewHolder> {

    private Activity activity;
    private TwoWayView mRecyclerView;
    private List<Integer> mItems;
    private int size;
    private int pos_choose;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout rltGallery;
        public ImageView imv;

        public SimpleViewHolder(View view) {
            super(view);
            imv = (ImageView) view.findViewById(R.id.imvGallery);
            rltGallery = (RelativeLayout) view.findViewById(R.id.rltGallery);
        }
    }

    public ShapeAdapter(Activity activity, TwoWayView recyclerView, List<Integer> mItems, int pos_choose) {
        this.activity = activity;
        this.mItems = new ArrayList<>();
        this.mItems.addAll(mItems);
        this.pos_choose = pos_choose;

        mRecyclerView = recyclerView;

        size = this.mItems.size();
    }

    public void chooseItem(int pos_choose) {
        this.pos_choose = pos_choose;
        notifyDataSetChanged();
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.row_gallery, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.imv.setImageResource(mItems.get(position));
        if (position == pos_choose) {
            holder.rltGallery.setBackgroundResource(R.color.white);
        } else {
            holder.rltGallery.setBackgroundResource(R.color.black);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}

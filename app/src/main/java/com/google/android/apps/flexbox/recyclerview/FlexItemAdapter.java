/*
 * Copyright 2016 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.apps.flexbox.recyclerview;

import com.google.android.apps.flexbox.R;
import com.google.android.flexbox.FlexItem;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} implementation for {@link FlexItemViewHolder}.
 */
public class FlexItemAdapter extends RecyclerView.Adapter<FlexItemViewHolder> {

    private List<FlexItem> mFlexItems;

    public FlexItemAdapter() {
        this(new ArrayList<FlexItem>());
    }

    public FlexItemAdapter(List<FlexItem> flexItems) {
        mFlexItems = flexItems;
    }

    @Override
    public FlexItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_flex_item, parent, false);
        return new FlexItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlexItemViewHolder holder, int position) {
        holder.mTextView.setText(String.valueOf(position + 1));
        holder.mTextView.setBackgroundResource(R.drawable.flex_item_background);
        holder.mTextView.setGravity(Gravity.CENTER);
    }

    public void addFlexItem(FlexItem flexItem) {
        mFlexItems.add(flexItem);
    }

    public void removeFlexItem(int position) {
        if (position < 0 || position >= mFlexItems.size()) {
            return;
        }
        mFlexItems.remove(position);
    }

    @Override
    public int getItemCount() {
        return mFlexItems.size();
    }
}

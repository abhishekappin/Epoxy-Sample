package com.appinventiv.epoxysample.models.epoxy.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.appinventiv.epoxysample.R;
import com.appinventiv.epoxysample.databinding.HeaderItemFileBinding;

@EpoxyModelClass
public abstract class HeaderItemModel extends EpoxyModelWithHolder<HeaderItemModel.MyViewHolder> {

    @EpoxyAttribute String title;
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash) View.OnClickListener clickListener;

    @Override
    protected int getDefaultLayout() {
        return R.layout.header_item_file;
    }

    @Override
    public void bind(@NonNull MyViewHolder holder) {
        super.bind(holder);
        holder.binding.headerTitle.setText(title);
        holder.binding.headerTitle.setOnClickListener(clickListener);
    }

    class MyViewHolder extends EpoxyHolder{
        HeaderItemFileBinding binding;
        @Override
        protected void bindView(@NonNull View itemView) {
            binding = HeaderItemFileBinding.bind(itemView);
        }
    }
}

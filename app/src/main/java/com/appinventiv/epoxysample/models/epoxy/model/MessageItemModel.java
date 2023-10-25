package com.appinventiv.epoxysample.models.epoxy.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.appinventiv.epoxysample.R;
import com.appinventiv.epoxysample.databinding.SingleItemFileBinding;
import com.appinventiv.epoxysample.models.UserProfile;

@EpoxyModelClass
public abstract class MessageItemModel extends EpoxyModelWithHolder<MessageItemModel.MyViewHolder> {

    @EpoxyAttribute UserProfile user;
    @Override
    protected int getDefaultLayout() {
        return R.layout.single_item_file;
    }


    @Override
    public void bind(@NonNull MyViewHolder holder) {
        super.bind(holder);
        holder.binding.itemImage.setImageResource(user.getImage());
        holder.binding.itemTitle.setText(user.getTitle());
        holder.binding.itemDescription.setText(user.getDescription());
    }

    class MyViewHolder extends EpoxyHolder{
        SingleItemFileBinding binding;
        @Override
        protected void bindView(@NonNull View itemView) {
            binding = SingleItemFileBinding.bind(itemView);
        }
    }
}

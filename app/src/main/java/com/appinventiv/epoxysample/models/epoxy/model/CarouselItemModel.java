package com.appinventiv.epoxysample.models.epoxy.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.appinventiv.epoxysample.R;
import com.appinventiv.epoxysample.databinding.CarouselItemFileBinding;
import com.appinventiv.epoxysample.models.CarouselProfile;

@EpoxyModelClass
public abstract class CarouselItemModel extends EpoxyModelWithHolder<CarouselItemModel.MyViewHolder> {

    @EpoxyAttribute  CarouselProfile carouselProfile;

    @Override
    protected int getDefaultLayout() {
        return R.layout.carousel_item_file;
    }

    @Override
    public void bind(@NonNull MyViewHolder holder) {
        super.bind(holder);
        holder.binding.carouselTitle.setText(carouselProfile.getTitle());
        holder.binding.carouselContent.setText(carouselProfile.getDescription());
    }

    class MyViewHolder extends EpoxyHolder {

        CarouselItemFileBinding binding;
        @Override
        protected void bindView(@NonNull View itemView) {
            binding = CarouselItemFileBinding.bind(itemView);
        }
    }
}

package com.appinventiv.epoxysample.models.epoxy.controller;

import android.view.View;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.CarouselModel_;
import com.airbnb.epoxy.Typed2EpoxyController;
import com.appinventiv.epoxysample.models.CarouselProfile;
import com.appinventiv.epoxysample.models.UserProfile;
import com.appinventiv.epoxysample.models.epoxy.model.CarouselItemModel_;
import com.appinventiv.epoxysample.models.epoxy.model.HeaderItemModel_;
import com.appinventiv.epoxysample.models.epoxy.model.MessageItemModel_;
import com.appinventiv.epoxysample.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class HomeEpoxyController extends Typed2EpoxyController<List<UserProfile>, List<CarouselProfile>> {

    @AutoModel HeaderItemModel_ headerItemModel;
    @AutoModel
    MessageItemModel_ messageItemModel;

    OnItemClickListener clickListener;

    public HomeEpoxyController(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    protected void buildModels(List<UserProfile> users, List<CarouselProfile> carousels) {
        headerItemModel
                .title("My Epoxy Header")
                .clickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clickListener.onClick("Header Clicked");
                    }
                })
                .addTo(this);

        List<MessageItemModel_> messageItemModels = new ArrayList<>();
        for(UserProfile user : users){
            messageItemModels.add(new MessageItemModel_()
                    .id("id")
                    .user(user));
        }
        new CarouselModel_()
                .id("carousel")
                .models(messageItemModels)
                .addTo(this);

        for(CarouselProfile carousel : carousels){
            new CarouselItemModel_()
                    .id("id")
                    .carouselProfile(carousel)
                    .addTo(this);
        }
    }
/*
    @Override
    protected void buildModels() {
//        new HeaderItemsModel_().id("key").title("Hello World").addTo(this);
        headerItemModel.title("My Photos").addTo(this);
        for(UserProfile user : users){
            messageItemModel
                    .user(user)
                    .addTo(this);
        }
    }


    @Override
    protected void buildModels(List<UserProfile> users) {
        headerItemModel.title("My Epoxy Header").addTo(this);

        List<MessageItemModel_> messageItemModels = new ArrayList<>();
        for(UserProfile user : users){
           messageItemModels.add(new MessageItemModel_()
                    .id("id")
                    .user(user));

        }
        new CarouselModel_()
                .id("carousel")
                .models(messageItemModels)
                .addTo(this);

    }
*/
}

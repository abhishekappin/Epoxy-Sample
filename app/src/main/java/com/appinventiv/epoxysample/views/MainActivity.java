package com.appinventiv.epoxysample.views;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.appinventiv.epoxysample.R;
import com.appinventiv.epoxysample.models.CarouselProfile;
import com.appinventiv.epoxysample.models.UserProfile;
import com.appinventiv.epoxysample.models.epoxy.controller.HomeEpoxyController;
import com.appinventiv.epoxysample.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EpoxyRecyclerView epoxyRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEpoxyRecyclerView();
    }

    private void initEpoxyRecyclerView() {
        epoxyRecyclerView = findViewById(R.id.epoxyRecyclerView);
        HomeEpoxyController controller = new HomeEpoxyController(new ItemClickCallback());
        epoxyRecyclerView.setHasFixedSize(true);
        controller.setData(getUserData(), getCarouselData());
        epoxyRecyclerView.setController(controller);
    }

    private List<CarouselProfile> getCarouselData() {
        ArrayList<CarouselProfile> carouselProfiles = new ArrayList<>();
        carouselProfiles.add(new CarouselProfile("Item 1","Description 1"));
        carouselProfiles.add(new CarouselProfile("Item 2","Description 2"));
        carouselProfiles.add(new CarouselProfile("Item 3","Description 3"));
        carouselProfiles.add(new CarouselProfile("Item 4","Description 4"));
        carouselProfiles.add(new CarouselProfile("Item 5","Description 5"));
        carouselProfiles.add(new CarouselProfile("Item 6","Description 6"));
        carouselProfiles.add(new CarouselProfile("Item 7","Description 7"));

        return carouselProfiles;
    }

    private List<UserProfile> getUserData() {
        ArrayList<UserProfile> userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile(R.drawable.nachos1,
                "Dish 1",
                "This is the description od Dish 1"));
        userProfiles.add(new UserProfile(R.drawable.nachos2,
                "Dish 2",
                "This is the description od Dish 2"))
        ;userProfiles.add(new UserProfile(R.drawable.nachos3,
                "Dish 3",
                "This is the description od Dish 3"));
        userProfiles.add(new UserProfile(R.drawable.nachos4,
                "Dish 4",
                "This is the description od Dish 4"));
        userProfiles.add(new UserProfile(R.drawable.nachos5,
                "Dish 5",
                "This is the description od Dish 5"));
        userProfiles.add(new UserProfile(R.drawable.nachos6,
                "Dish 6",
                "This is the description od Dish 6"));
        userProfiles.add(new UserProfile(R.drawable.nachos7,
                "Dish 7",
                "This is the description od Dish 7"));
        userProfiles.add(new UserProfile(R.drawable.nachos8,
                "Dish 8",
                "This is the description od Dish 8"));
        return userProfiles;
    }

    class ItemClickCallback implements OnItemClickListener {

        @Override
        public void onClick(String message) {
            showToast(message);
        }
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

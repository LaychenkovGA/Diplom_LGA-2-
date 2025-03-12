package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static ru.iteco.fmhandroid.ui.data.Helper.childAtPosition;

import android.view.View;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;

public class LoveElement {
    public static ViewInteraction missionName = onView(withId(R.id.our_mission_title_text_view));
    public static ViewInteraction missionList= onView(withId(R.id.our_mission_item_list_recycler_view));

    public static ViewInteraction missionConstraintLayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view), childAtPosition(withClassName(is("android.constraintlayout.widget.ConstraintLayout")), 0)));

    public static Matcher<View> getDescriptionText(){
        return ViewMatchers.withId(R.id.our_mission_item_description_text_view);
    }
}

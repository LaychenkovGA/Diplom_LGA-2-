package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.screenElement.LoveElement.getDescriptionText;
import static ru.iteco.fmhandroid.ui.screenElement.LoveElement.missionConstraintLayout;
import static ru.iteco.fmhandroid.ui.screenElement.LoveElement.missionList;
import static ru.iteco.fmhandroid.ui.screenElement.LoveElement.missionName;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElement.LoveElement;

public class LoveStep {
    public void checkOurMissionElements() {
        Allure.step("Проверка элелемтов экрана Love is all");
        missionName.check(matches(isDisplayed()));
        missionList.check(matches(isDisplayed()));
    }

    public void checkQuote(int number) {
        Allure.step("Развернуть/свернуть цитату");
        missionConstraintLayout.check(matches(isDisplayed()));
        missionConstraintLayout.perform(actionOnItemAtPosition(number, click()));
    }

    public void descriptionNotDisplayed(String text) {
        Allure.step("Отображение цитаты");
        onView(allOf(getDescriptionText(),
        withText(text))).check(matches(not(isDisplayed())));

    }

    public void descriptionIsDisplayed(String text) {
        Allure.step("Скрыть цитаты");
        onView(allOf(getDescriptionText(),
                withText(text))).check(matches(isDisplayed()));
    }

}

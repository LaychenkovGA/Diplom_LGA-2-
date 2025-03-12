package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.categoryText;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.dateEndText;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.dateStartText;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterActive;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterButton;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterInActive;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterNewsName;




import io.qameta.allure.kotlin.Allure;

public class FilterNewsStep {

    public void checkFilterNewsElements(){
        Allure.step("Элементы экрана Фильтровать новости");
        filterNewsName.check(matches(isDisplayed()));
        dateStartText.check(matches(isDisplayed()));
        dateEndText.check(matches(isDisplayed()));
        categoryText.check(matches(isDisplayed()));
        filterButton.check(matches(isDisplayed()));
    }

    public void clickFilterButton(){
        Allure.step("Нажать на кнопку Фильтровать");
        filterButton.perform(click());
    }

    public void fillStartDate(String startDate){
        Allure.step("Ввод данных в поле ОТ даты");
        dateStartText.perform(replaceText(startDate));
    }

    public void fillEndDate(String endDate){
        Allure.step("Ввод данных в поле ДО даты");
        dateEndText.perform(replaceText(endDate));
    }

    public void clickActiveCheckBox (){
        Allure.step("Нажать на чекбокс Активна");
        filterActive.perform(click());
    }

    public void clickNotActiveCheckBox(){
        Allure.step("Нажать на чекбокс Неактивен");
        filterInActive.perform(click());
    }

    public void checkBoxStatusIsActive(boolean checked){
        Allure.step("Проверка нажатия на свитчер Активна");
        if (checked) {
            filterActive.check(matches(isChecked()));
        } else {
            filterActive.check(matches(isNotChecked()));
        }
    }

    public void checkBoxStatusIsNotActive(boolean checked){
        Allure.step("Проверка нажатич на свичер не автивна");
        if (checked) {
            filterInActive.check(matches(isChecked()));
        } else {
            filterInActive.check(matches(isNotChecked()));
        }
    }
}

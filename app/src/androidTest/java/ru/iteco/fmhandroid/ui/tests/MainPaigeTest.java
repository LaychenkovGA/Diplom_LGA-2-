package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.LoveStep;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
import ru.iteco.fmhandroid.ui.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)
public class MainPaigeTest {

    AuthStep authStep = new AuthStep();
    MainSteps mainSteps = new MainSteps();
    NewsStep newsStep = new NewsStep();
    LoveStep loveStep = new LoveStep();
    SplashStep splashStep = new SplashStep();


    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            mainSteps.loadMainScreen();
        } catch (Exception e) {
            authStep.authWithValidLoginAndPass(authInfo());
            authStep.clickSignInButton();
        } finally {
            mainSteps.loadMainScreen();
        }
    }

    @Test
    @DisplayName("Открытие навигационного меню")
    public void menuElementsVisibility() {
        mainSteps.clickMenuButton();
        mainSteps.checkMenuList();
    }

    @Test
    @DisplayName("Открытие вкладки \"Все новости\"")
    public void goToAllNews() {
        mainSteps.clickAllNewsButton();
        newsStep.checkNewsElements();
        mainSteps.clickOnMain();
        mainSteps.checkMainElements();
    }

    @Test
    @DisplayName("Переход во вкладку Наша миссия")
    public void goToOurMission() {
        mainSteps.clickOurMissionButton();
        loveStep.checkOurMissionElements();
    }

    @Test
    @DisplayName("Сворачивание и разворачивание раздела новостей")
    public void newsBlockCheck() {
        mainSteps.checkAllNews();
        mainSteps.allNewsNotDisplayed();
        mainSteps.checkAllNews();
        mainSteps.allNewsAreDisplayed();
    }

    @Test
    @DisplayName("Сворачивание и разворачивание описания отдельных новостей")
    public void checkANews() {
        mainSteps.checkTheNews(0);
        mainSteps.descriptionDisplayed(0);
    }
}




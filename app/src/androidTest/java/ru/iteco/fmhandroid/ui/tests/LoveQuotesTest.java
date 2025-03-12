package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import com.google.android.material.snackbar.BaseTransientBottomBar;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.screenElement.LoveElement;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.LoveStep;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)
public class LoveQuotesTest {

    AuthStep authStep = new AuthStep();
    LoveStep loveStep = new LoveStep();
    MainSteps mainSteps = new MainSteps();
    SplashStep splashStep = new SplashStep();
    Data data = new Data();
    LoveElement loveElement = new LoveElement();


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
            mainSteps.clickOurMissionButton();
        }
    }


    @Test
    @DisplayName("Переход на страницу \"Главное-жить любя\" с помощью кнопки \"бабочка\"")
    public void ourMissionScreenElements() {

        loveStep.checkOurMissionElements();
    }

}



package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import kotlin.jvm.JvmField;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElement.AuthElement;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.GeneralSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.SplashStep;


@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {

    AuthStep authStep = new AuthStep();
    AuthElement authElement = new AuthElement();
    MainSteps mainSteps = new MainSteps();
    GeneralSteps generalSteps = new GeneralSteps();
    SplashStep splashStep = new SplashStep();


    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            authElement.loadAuthPage();
            authStep.checkAuthScreenElements();
        } catch (Exception e) {
            mainSteps.clickLogoutButton();
            authElement.loadAuthPage();
        }
    }

    @Test
    @DisplayName("Запуск приложения и открытие страницы авторизации")
    public void checkAuthScreenElements() {
        authStep.checkAuthScreenElements();
    }

    @Test
    @DisplayName("Авторизация в приложении с валидными данными")
    public void loginWithValidData() {
        authStep.authWithValidLoginAndPass(authInfo());
        authStep.clickSignInButton();
        mainSteps.loadMainScreen();
        mainSteps.checkMainElements();

    }

    @Test
    @DisplayName("Выход из системы после успешной авторизации")
    public void logout() {
        authStep.authWithValidLoginAndPass(authInfo());
        authStep.clickSignInButton();
        mainSteps.loadMainScreen();
        mainSteps.checkMainElements();
        mainSteps.checkMainElements();
        mainSteps.clickLogoutButton();
        authStep.checkAuthScreenElements();
    }

    @Test
    @DisplayName("Авторизация в приложениии с невалидными данными")
    public void loginWithInvalidData() {
        authStep.authWithInvalidLoginAndPass(authInfo());
        authStep.clickSignInButton();
        generalSteps.checkInvalidAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация при не зарегестрированном логине и валидном и зарегестророванном пароле")
    public void authWithInvalidLogin() {
        authStep.authWithInvalidLogin(authInfo());
        authStep.clickSignInButton();
        generalSteps.checkInvalidAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация при не зарегестрированном пароле и валидном и зарегестрированном логине")
    public void authWithInvalidPassword() {
        authStep.authWithInvalidPass(authInfo());
        authStep.clickSignInButton();
        generalSteps.checkInvalidAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация в приложении с пустыми полями ввода Логина и Пароля")
    public void authWithEmptyLoginAndPass() {
        authStep.clickSignInButton();
        generalSteps.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация при пустом Логине и валидном пароле")
    public void authWithEmptyLogin() {
        authStep.authWithEmptyLogin(authInfo());
        authStep.clickSignInButton();
        generalSteps.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация при пустом пароле и валидном логине")
    public void authWithEmptyPassword() {
        authStep.authWithEmptyPass(authInfo());
        authStep.clickSignInButton();
        generalSteps.checkEmptyAuthDataToast();
    }
}
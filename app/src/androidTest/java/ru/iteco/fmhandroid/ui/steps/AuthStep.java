package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.Helper.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidLoginData;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidPassData;
import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.loginText;
import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.nameAuthText;

import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.passwordText;

import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.signInButton;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Helper;

public class AuthStep {

    public void checkAuthScreenElements() {
        Allure.step("Элементы экрана авторизации");
        nameAuthText.check(matches(isDisplayed()));
        loginText.check(matches(isDisplayed()));
        passwordText.check(matches(isDisplayed()));
        signInButton.check(matches(isDisplayed()));
    }

    public void authWithValidLoginAndPass(Helper.User info) {
        Allure.step("Авторизация с валидным логином и паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(info.getLogin()));
        passwordText.perform(replaceText(info.getPass()));
    }

    public void authWithInvalidLoginAndPass(Helper.User info) {
        Allure.step("Авторизация с невалидными логином и паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidAuthData().getLogin()));
        passwordText.perform(replaceText(invalidAuthData().getPass()));
    }

    public void authWithInvalidLogin(Helper.User info) {
        Allure.step("Авторизация с невалидным логином и валидным паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidLoginData().getLogin()));
        passwordText.perform(replaceText(invalidLoginData().getPass()));
    }

    public void authWithInvalidPass(Helper.User info) {
        Allure.step("Авторизация с невалидным паролем и валидным логином");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidPassData().getLogin()));
        passwordText.perform(replaceText(invalidPassData().getPass()));
    }

    public void authWithEmptyPass(Helper.User info) {
        Allure.step("Авторизация с пустым паролем");
        loginText.perform(replaceText(emptyPassword().getLogin()));
        passwordText.perform(replaceText(emptyPassword().getPass()));
    }

    public void authWithEmptyLogin(Helper.User info) {
        Allure.step("Авторизация с пустым логином");
        loginText.perform(replaceText(emptyLogin().getLogin()));
        passwordText.perform(replaceText(emptyLogin().getPass()));
    }

    public void clickSignInButton() {
        Allure.step("Нажать кнопку SignIn");
        signInButton.perform(click());
    }
}
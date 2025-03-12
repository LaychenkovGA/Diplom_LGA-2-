package ru.iteco.fmhandroid.ui.data;

import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentDate;
import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentTime;

import io.bloco.faker.Faker;

public class Data {

    static Faker faker= new Faker();
    public static final String validLogin= "login2";
    public static final String validPassword= "password2";
    public static final String invalidLogin= faker.name.firstName() + faker.number.between(1,10);
    public static final String invalidPassword= faker.internet.password();
    public static final String emptyLogin= "";
    public static final String emptyPassword= "";

    public String textOfTheQuote= "Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. " +
            "Поиск путей решения различных задач - это и есть хосписный индивидуальный подход к паллиативной помощи.";


    public String dateOfPublic= getCurrentDate();
    public String timeOfPublic= getCurrentTime();

    public String nonNewsDate= "09.09.1999";

    public String descriptionOnCyr= "Другое описание новости";
    public String descriptionSymbols = "'+=*&%^$#@~";
    public String titleCyr= "Заголовок Новости";
    public String titleSymbols= "'+*&^%$#@~";
    public String descriptionIsEmpty= "";
    public String newDescription= "Новое описание";
    public String newTitle= "Новый заголовок";
    public String editNewTitle= "Отредактированный заголовок";
    public String editNewDescription= "Отредактированное описание";


}

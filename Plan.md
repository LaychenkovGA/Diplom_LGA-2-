## План тестирования мобильного приложения «Мобильный хоспис»

#### Описание приложения

Приложение предоставляет функционал по работе с претензиями хосписа и включает:

- информацию о новостях и функционал для работы с ними;
- тематические цитаты;
- информацию о приложении.

#### Задачи тестирования

- Проведение функционального и нефункционального тестирования приложения;
- Рекомендации по улучшению качества приложения.

#### Этапы тестирования

1. **Изучение приложения и проведение исследовательского тестирования**
   - Срок: 17.03.2025
2. **Составление чек-листа проверок**
   - Срок: 17.03.2025
3. **Написание тест-кейсов проекта**
   - Срок: 12.03.2025
4. **Создание, запуск и отладка автоматизированных тестов**
   - Срок: 12.03.2025 - 27.03.2025
5. **Составление отчета**
   - Срок: 28.03.2025 - 29.03.2025
6. **Анализ результатов автоматизации**
   - Срок: 30.03.2025

   ## **Порядок выполнения работ**

- Составление плана тестирования

- Составление чек-листа

- Составление тест-кейсов

-  Создание автоматизированных тестов

- Проведение автоматизированного тестирования

- Формирование отчета о тестировании

## **Виды тестирования**

**ПО СТЕПЕНИ АВТОМАТИЗАЦИИ**

- Ручное 
- Автоматизированное

**ФУНКЦИОНАЛЬНОЕ ТЕСТИРОВАНИЕ**
 - Загрузка приложение
 - Авторизация
 - Выход
 - Меню
 - "Главная страница" (Main)
   - "Новости"
 - "Новости"
   - Чтение новостей
   - Фильтрация новостей по дате и по категории
   - Сортировка новостей
   - Переход в панель управления
 - "Панель управления"
   - Создать новости
   - Редактировать новости
   - Удалить новость 
   - Изменение статуса (Активна/не активна)
   - Фильтрация по дате создания и категории
   - Сортировка
 -  О Приложении
 - Цитаты о хосписе(Love is all)

**Проверки специфичные для мобильного приложения области**

- Проверки при разных состояниях сети 
- Работа с функциями телефона(жесты, ориентация, сворачивание, звонки)

**Тестирование совместимости**
- Установка и работа приложения на устройствах с разными версиями Android, разными разрешениями экрана и параметрами самого устройства

**UI/UX тестирование**

- Соответствие макету
- Оценка удобства пользования

**Тестирование локализации**

- Все приложение должно быть на русском языке

#### Необходимые данные для доступа к тестированию

- Логин: login2
- Пароль: password2

## **Сортировка тест-кейсов по степени автоматизации** 

Автоматизированное тестирование

- Переход на страницу "О приложении" через навигационное меню [23]
- Переход по ссылке "Политика конфиденциальности" [113]
- Открытие страницы "О приложении" и нажатие кнопки назад в приложении [115]
- Запуск приложения и открытие страницы авторизации [1]
- Авторизация в приложении с валидными данными [2]
- Выход из системы после успешной авторизации [19]
- Авторизация в приложениии с невалидными данными [11]
- Авторизация при не зарегестрированном логине и валидном и зарегестророванном пароле [3]
- Авторизация при не зарегестрированном пароле и валидном и зарегестрированном логине [4]
- Авторизация в приложении с пустыми полями ввода Логина и Пароля [6]
- Авторизация при пустом Логине и валидном пароле [7]
- Авторизация при пустом пароле и валидном логине [8]
- Переход на страницу "Главное-жить любя" с помощью кнопки "бабочка" [24]
- Открытие навигационного меню [21]
- Открытие вкладки "Все новости" [27]
- Сворачивание и разворачивание раздела новостей [25]
- Сворачивание и разворачивание описания отдельных новостей [54]
- Открытие раздела "Панель управления" [32]
- Создание новости [85]
- Создание новости с пустой формой "Описание" [87]
- Создание новости с пустой формо [86]
- Изменение данных в поле "Заголовок" [96]
- Изменение данных в поле "Описание" [100]
- Отмена создания новости [91]
- Фильтрация новостей только категории из выпадающего списка [66]
- Отмена фильтрации до применения установленных параметров [72]
- Фильтрация новостей по валидно указанному периоду [69]
- Фильтрация только по чек-боксу "Не активна" [63]
- Обновление страницы новостей после фильтрации с помощью кнопки "Обновить" [74]
- Отмена фильтрации до применения установленных параметров с помощью кнопки "Отмена" [48]
- Ввод в поле "Заголовок" данных на латинице/цифр/спецсимволов [79]
- Отмена редактирования новости [107]

#### Окружение

**Разработка**: Windows 11 Pro, i5-13500
Процессор: Intel(R) Core(TM) i5-13500 CPU @ 2.50GHz   4.80 GHz
Оперативная память: DDR5 32.0 ГБ 
SSD: 2 TB
Тип системы: Windows 10 Pro, 64-разрядная операционная система, процессор x64

**Эмулятор**
Устройство: Google pixel
Модель: 4
Версия Android: 10 (Q), API 29.
Разрешение: 1080 x 2280 px, 5.7 дюйма
Память: 128 GB
RAM: 6 GB
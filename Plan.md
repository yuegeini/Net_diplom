# План автоматизации для Курсовой работы курса Тестировщик ПО. QA-65
### Разрешенные данные:

1) Номер карты - 16 цифр
2) Месяц - число от 01 до 12 включительно 
3) Год - две последние цифры года. При чем 2023 <= XX <= 2028 (2023 + 5)
4) Владелец - не меньше одного символа латиницы
5) CVC/CVV - трехзначные числа от 000 до 999 включительно

### Позитивные и негативные сценарии для форм "Оплата по карте" и "Кредит по данным карты"

1) Успешное совершение платежа по дебетовой карте с валидным заполнением всех полей. ОР: В правом верхнем углу экрана отображается "Успешно! Операция одобрена банком".
2) При заполнении поля "Владелец" разрешены пробелы, при условии, что все остальные поля заполнены правильно, ожидаемый результат – появление утверждающего сообщения в правом верху.
3) Использование дефиса в имени владельца при условии валидности других данных. ОР: Информационное сообщение об одобрении операции банком в правом верхнем углу.
4) Оставление поля "Номера карты" без заполнения при валидном остальном наполнении формы. ОР: Сообщение "Поле не может быть пустым" около соответствующего поля.
5) Если в "Номере карты" присутствуют буквы или спецсимволы. ОР: Сообщение "Неверный формат" возле поля.
6) Заполнение поля "Номер карты" лишь одной цифрой. ОР: Уведомление об ошибке формата данных.
7) Ввод в "Номер карты" 15 цифр вместо положенных 16-ти. ОР: Указание на неправильный формат данных.
8) В случае попытки ввести в "Номер карты" больше 16 цифр. ОР: Сообщение о ошибке ввода.
9) Незаполнение поля "Месяц". ОР: Ошибка о необходимости заполнения поля.
10) Попытка заполнить "Месяц" нечисловыми символами. ОР: Уведомление "Неверный формат".
11) Оставьте поле "cvc/cvv" пустым, остальные поля заполнить действительными данными. ОР: под полем "cvc/cvv" появится уведомление об ошибке "поле обязательно для заполнения".
12) В поле "месяц" ввести числа 15, остальные поля заполнить действительными данными. ОР: под полем "месяц" появится уведомление об ошибке "неправильный формат".
13) В поле "cvc/cvv" ввести 2 цифры, остальные поля заполнить действительными данными. ОР: под полем "cvc/cvv" появится уведомление об ошибке "неправильный формат".
14) В поле "месяц" ввести данные предыдущего месяца текущего года, остальные поля заполнить действительными данными. ОР: под полем "месяц" появится уведомление об ошибке "неправильно указан срок действия карты".
15) Оставьте поле "год" пустым, остальные поля заполнить действительными данными. ОР: под полем "год" появится уведомление об ошибке "поле обязательно для заполнения".
16) В поле "владелец" ввести данные кириллицей, остальные поля заполнить действительными данными. ОР: под полем "владелец" появится уведомление об ошибке "неправильный формат".
17) Внесение в поле "год" данные, превышающие 5 лет от текущего года, остальные поля заполнить действительными данными. ОР: под полем "год" появится уведомление об ошибке "неправильно указан срок действия карты".
18) Ввод в поле "год" одну цифру, остальные поля заполнить действительными данными. ОР: под полем "год" появится уведомление об ошибке "неправильный формат".
19) Оставьте поле "владелец" пустым, остальные поля заполнить действительными данными. ОР: под полем "владелец" появится уведомление об ошибке "поле обязательно для заполнения".
20) В поле "владелец" ввести цифры, остальные поля заполнить действительными данными. ОР: под полем "владелец" появится уведомление об ошибке "неправильный формат".
21) Ввод в поле "владелец" специальные символы, остальные поля заполнить действительными данными. ОР: под полем "владелец" появится уведомление об ошибке "неправильный формат".
22) В поле "год" ввести данные предыдущего года, остальные поля заполнить действительными данными. ОР: под полем "год" появится уведомление об ошибке "срок действия карты истек".
23) Ввести в поле "cvc/cvv" буквы, специальные символы или знаки, остальные поля заполнить действительными данными. ОР: поле "cvc/cvv" оставляется незаполненным или, если заполняется, появится уведомление об ошибке "неправильный формат".
24) Внесение значение "2" в поле "месяц" и заполнение остальные поля корректными данными. ОР: поле "месяц" будет автоматически заполняться в формате "02"

## Риски
* Разные версии Java или неправильная настройка переменных среды
* Поврежденные базы данных или неправильная работа с кешем
* Программные ошибки
* Визульаные ошибки (некорректный UI)

## Перечень используемых инструментов
* IntelliJ IDEA - интегрированная среда разработки программного обеспечения, в том числе для написания кода автотестов на Java.
* JUnit 5 - фреймворк для модульного тестирования программного обеспечения на языке Java.
* Gradle- система автоматической сборки проекта. имеет простой и интуитивно понятный синтаксис для описания задач и проектов, позволяет быстро настраивать и собирать проекты, позволяя управлять зависимостями и настройками проектов
* GitHub - система контроля версий, даёт возможность для хранения актуальных версий файлов, отслеживания их изменений, а так же возможность параллельной разработки.
* Selenide - фреймворк для автоматизированного тестирования
* Lombok - библиотека Java для создания аннотаций, которая позволяет заменить ненужный повторяющийся код
* Docker - система контейнеризации для обеспечения автоматизации развёртывания и управления приложениями

## Оценка времени работы
* Подготовка окружения - 5 ч
* Написание кода автотестов - 5 ч
* Дебаг автотестов - 30 ч
* Подготовка отчётов по итогам тестирования и автоматизации - 5 ч

## Общее время работы ~45 ч
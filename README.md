## Процедура запуска автотестов


1. Установить и запустить Docker
2. Зайти в терминал (git bash или обычный системный Linux)
3. Склонировать проект и зайти в него
4. Запустить docker-compose для формирования тестового окружения
5. Открыть новый терминал и запустить SUT для MySQL или для PostgreSQL
6. Открыть новый терминал и запустить наш код c MySQL или c PostgreSQL


```
git clone https://github.com/yuegeini/Net_diplom.git
cd Net_diplom
docker-compose up --build

java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"

java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
```
#  Система фильтрации авиаперелётов

## Описание
Модуль для фильтрации авиаперелётов с поддержкой различных правил фильтрации.
Система предназначена для обработки больших наборов данных и динамического применения правил фильтрации.

## Документация
- [Требования](https://github.com/viktorya-ch/testing/wiki/%D0%A2%D1%80%D0%B5%D0%B1%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
- [Архитектура](https://github.com/viktorya-ch/testing/wiki/%D0%90%D1%80%D1%85%D0%B8%D1%82%D0%B5%D0%BA%D1%82%D1%83%D1%80%D0%B0)
- [REST API](https://github.com/viktorya-ch/testing/wiki/REST-API)
- [Развертывание](https://github.com/viktorya-ch/testing/wiki/%D0%A0%D0%B0%D0%B7%D0%B2%D0%B5%D1%80%D1%82%D1%8B%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5)
- [GitHub Project](https://github.com/users/viktorya-ch/projects/6)

## Сборка и запуск
mvnw.cmd clean package
java -jar target/flight-filtering-service.jar


## Структура проекта

testing/

├── src/
│   ├── main/
│   │   └── java/

│   │       └── com/

│   │           └── gridnine/

│   │               └── testing/

│   │                   ├── Flight.java               # Модель перелёта   

│   │                   ├── FlightFilter.java         # Основной класс фильтрации   

│   │                   ├── FlightBuilder.java        # Фабрика тестовых данных

│   │                   ├── FilterRule.java           # Интерфейс правил фильтрации

│   │                   ├── DepartureBeforeCurrentTimeFilter.java      # Правило 1  

│   │                   ├── ArrivalBeforeDepartureFilter.java          # Правило 2

│   │                   ├── ExcessiveGroundTimeFilter.java             # Правило 3

│   │                   ├── FlightPrinter.java        # Утилита форматирования вывода

│   │                   ├── FilterRules.java          # Фабрика комбинированных правил

│   │                   ├── Segment.java              # Модель сегмента перелёта

│   │                   └── Main.java                 # Точка входа приложения

│   └── test/

│       └── java/

│           └── com/

│               └── gridnine/

│                   └── testing/

│                       └── FlightFilterTest.java     # Юнит-тесты

├── pom.xml                                           # Maven конфигурация

├── .gitignore                                        # Исключения Git

└── README.md                                         # Документация

# Установка

## 1. Клонирование репозитория

git clone <your-repository-url>
cd testing

## 2. Настройка проекта в IntelliJ IDEA

- Откройте IntelliJ IDEA
- File → Open → выберите папку проекта
- Дождитесь загрузки Maven зависимостей
- Убедитесь, что SDK настроен правильно: File → Project Structure → Project SDK

## 3. Проверка установки

mvn clean compile

# Тестирование

## Запуск всех тестов

mvn test

## Запуск конкретного теста

mvn test -Dtest=FlightFilterTest

# Сборка

## Создание JAR файла

mvn clean package

Собранный JAR будет находиться в - target/testing-1.0-SNAPSHOT.jar

## Запуск JAR файла

java -jar target/testing-1.0-SNAPSHOT.jar

# Контакты: 

## Чеботарева Виктория Сергеевна 


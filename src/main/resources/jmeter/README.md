<h1 align="center"><img src="https://jmeter.apache.org/images/logo.svg" alt="Apache JMeter logo" /></h1>

An Open Source Java application designed to measure performance and load test applications.

By The Apache Software Foundation

[![Build Status](https://api.travis-ci.com/apache/jmeter.svg?branch=master)](https://travis-ci.com/apache/jmeter/)
[![codecov](https://codecov.io/gh/apache/jmeter/branch/master/graph/badge.svg)](https://codecov.io/gh/apache/jmeter)
[![License](https://img.shields.io/:license-apache-brightgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Stack Overflow](https://img.shields.io/:stack%20overflow-jmeter-brightgreen.svg)](https://stackoverflow.com/questions/tagged/jmeter)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.apache.jmeter/ApacheJMeter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.apache.jmeter/ApacheJMeter)
[![Javadocs](https://www.javadoc.io/badge/org.apache.jmeter/ApacheJMeter_core.svg)](https://www.javadoc.io/doc/org.apache.jmeter/ApacheJMeter_core)
[![Twitter](https://img.shields.io/twitter/url/https/github.com/apache/jmeter.svg?style=social)](https://twitter.com/intent/tweet?text=Powerful%20load%20testing%20with%20Apache%20JMeter:&url=https://jmeter.apache.org)

## What Is It?

**Apache JMeter** может _измерять производительность_ и **нагружать** _статические и динамические_ веб-приложения.
Его можно использовать **для имитации** _большой нагрузки_ на сервер, _группу серверов_, _сеть_ или объект, 
для проверки их прочности или для анализа общей производительности при различных типах нагрузки.

![JMeter screen](https://raw.githubusercontent.com/apache/jmeter/master/xdocs/images/screenshots/jmeter_screen.png)

## Features


Полная переносимость и 100% Java. Многопоточность допускает 
конкурентную выборку (concurrent sampling) многими потоками 
и одновременную выборку различных функций отдельными группами потоков.


### Protocols

Возможность загрузки и тестирования производительности многих типов _applications/server/protocol_ :

- Web - HTTP, HTTPS (Java, NodeJS, PHP, ASP.NET,...)
- SOAP / REST Webservices
- FTP
- Database via JDBC
- LDAP
- Message-oriented Middleware (MOM) via JMS
- Mail - SMTP(S), POP3(S) and IMAP(S)
- Native commands or shell scripts
- TCP
- Java Objects

### IDE

 Полнофункциональная тестовая среда разработки, которая позволяет 
быстро **записывать (recording)** план тестирования (Test Plan) (из браузеров или собственных приложений), 
**создавать(building)** и **отлаживать(debugging)**.


### Command Line

[Command-line mode (Non GUI / headless mode)](https://jmeter.apache.org/usermanual/get-started.html#non_gui)
чтобы загружать тесты из любой Java-совместимой OS (Linux, Windows, Mac OSX, ...)

### Reporting

Полный и готовый для представления [dynamic HTML report](https://jmeter.apache.org/usermanual/generating-dashboard.html)

![Dashboard screenshot](https://raw.githubusercontent.com/apache/jmeter/master/xdocs/images/screenshots/dashboard/response_time_percentiles_over_time.png)

[Live reporting](https://jmeter.apache.org/usermanual/realtime-results.html)
в сторонние базы данных, такие как **InfluxDB** или **Graphite**

![Live report](https://raw.githubusercontent.com/apache/jmeter/master/xdocs/images/screenshots/grafana_dashboard.png)

### Correlation

Простая корреляция (сопоставление) благодаря возможности извлекать данные из самых популярных форматов ответов.,
[HTML](https://jmeter.apache.org/usermanual/component_reference.html#CSS/JQuery_Extractor),
[JSON](https://jmeter.apache.org/usermanual/component_reference.html#JSON_Extractor),
[XML](https://jmeter.apache.org/usermanual/component_reference.html#XPath_Extractor) or
[any textual format](https://jmeter.apache.org/usermanual/component_reference.html#Regular_Expression_Extractor)

### Highly Extensible Core

- Подключаемые **Samplers** открывают неограниченные возможности тестирования.
- **Scriptable Samplers** (JSR223-compatible languages like Groovy).
- Несколько статистических данных нагрузки могут быть выбраны с помощью **pluggable tiers**.
- Анализ данных и **visualization plugins** позволяют большую расширяемость и персонализацию.
- Функции можно использовать для динамического ввода данных в тест или для обработки данных.
- **Easy Continuous Integration** (Простая непрерывная интеграция) через сторонние библиотеки
с открытым исходным кодом для Maven, Gradle и Jenkins..

## The Latest Version

Подробности о последней версии можно найти на
[JMeter Apache Project web site](https://jmeter.apache.org/)

## Requirements

Для запуска Apache JMeter существуют следующие требования::

- Java Interpreter:

  Для выполнения **Apache JMeter** требуется полностью совместимая среда выполнения Java 8.
  JDK с утилитой **keytool** лучше подходит для записи HTTPS-сайтов (Recording HTTPS websites).


- Optional jars:

  Некоторые jars не включены в **JMeter**. При необходимости их следует 
 загрузить и поместить в каталог **lib**.
  
  - JDBC - можно получить у поставщика базы данных
  - JMS - доступно у провайдера JMS
  - [Bouncy Castle](https://www.bouncycastle.org/) -
    требуется только для SMIME Assertion

- Java Compiler (*OPTIONAL*):

  Компилятор Java не требуется, поскольку дистрибутив включает 
 предварительно скомпилированный бинарный архив Java.

  > **Заметьте** что для создания плагинов для Apache JMeter требуется компилятор..

## Инструкции по установке

> **Заметьте** что **_пробелы_** в именах каталогов могут вызвать проблемы..

- Release builds

  Распакуйте бинарный архив в подходящую структуру каталогов..

## Running JMeter

1. Перейдите в директорию `..apache-jmeter-**\bin` 
2. Запустите файл  `jmeter` (Un\*x) или файл `jmeter.bat` (Windows OS) .

### Windows

Для Windows есть также несколько других скриптов, на которые вы можете перетащить JMX-файл:


- `jmeter-n.cmd` - запускает файл как тест без графического интерфейса ( non-GUI test) 
- `jmeter-n-r.cmd` - запускает файл как удаленный тест без графического интерфейса (non-GUI remote) (клиент-сервер)
- `jmeter-t.cmd` - загружает файл, готовый запустить его в качестве теста графического интерфейса (GUI test)

## Documentation

Также включена документация, доступная на момент выпуска этого выпуска, в формате
HTML format, в директории [printable_docs](printable_docs) ,
и его можно просмотреть, начиная с файла с именем [index.html](printable_docs/index.html).

## Reporting a bug/enhancement

See [Issue Tracking](https://jmeter.apache.org/issues.html).

## Build instructions

### Release builds

 Распакуйте **исходный архив** в подходящую структуру каталогов. 
Большинство файлов сторонних библиотек можно извлечь из бинарного архива, 
распаковав его в ту же структуру каталогов.


Любые дополнительные jars (см. выше) должны быть помещены в каталоги `lib/opt` и/или `lib`.

**Jars** в каталоге `lib/opt` будет использоваться для сборки **JMeter** и запуска модульных тестов,
но не будет использоваться во время выполнения.

_Это полезно для проверки того, что произойдет, 
если дополнительные файлы jar не будут загружены другими 
пользователями JMeter._

Если вы находитесь за прокси, вы можете установить несколько свойств сборки (build properties) 
в `~/.gradle/gradle.properties` для Gradle, чтобы использовать proxy:

```properties
systemProp.http.proxyHost=proxy.example.invalid
systemProp.http.proxyPort=8080
systemProp.http.proxyUser=your_user_name
systemProp.http.proxyPassword=your_password
systemProp.https.proxyHost=proxy.example.invalid
systemProp.https.proxyPort=8080
systemProp.https.proxyUser=your_user_name
systemProp.https.proxyPassword=your_password
```

### Test builds

**JMeter** построен с использованием **Gradle**.

Следующая команда создает и тестирует **JMeter**:

```sh
./gradlew build
```
Если в системе нет дисплея с графическим интерфейсом, то:


```sh
./gradlew build -Djava.awt.headless=true
```

Выходные артефакты (Выходные артефакты (банки, отчеты) помещаются в, отчеты) помещаются в
каталог `build` .
Например, бинарные артефакты можно найти в разделе `src/dist/build/distributions`.

Следующая команда скомпилирует приложение и позволит вам запустить `jmeter`
из директории `bin`.

> **Примечание**: происходит полностью очищение содержимого `lib/`,
поэтому он удалит пользовательские плагины, если они у вас установлены..

```sh
./gradlew createDist
```

В качестве альтернативы вы можете заставить Gradle, запустить графический интерфейс:

```sh
./gradlew runGui
```

## Developer Information

Создание и участие подробно объясняется на
[building JMeter](https://jmeter.apache.org/building.html)
и [CONTRIBUTING.md](CONTRIBUTING.md).
Более подробная информация о задачах, доступных для сборки JMeter с Gradle, доступна в
 [gradle.md](gradle.md).

Код можно получить:

- https://github.com/apache/jmeter
- https://gitbox.apache.org/repos/asf/jmeter.git

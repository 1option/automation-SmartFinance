# FAQ

## Категории дефектов. Распределение дефектов по категориям

По умолчанию на вкладке **Categories** Allure-отчета все прогнанные тестовые методы делятся на 2 категории: дефекты
продукта (**failed tests**) и дефекты теста (**broken tests**). Для того, чтобы сделать кастомную классификацию,
необходимо подложить файл `categories.json` в директорию `target/allure-results`.
Если в `pom.xml` у Вас подключен `allure-maven` плагин, то `categories.json` можно разместить в
поддиректории `resources` директории `test`
Приведем пример кастомной классификации дефектов. Создадим файл `categories.json`:

> Если в `pom.xml` у Вас подключен `allure-maven` плагин, то `categories.json` можно разместить в
> поддиректории `resources` директории `test`

Приведем пример кастомной классификации дефектов. Создадим файл `categories.json`:

```json
[
  {
    "name": "Unknown error",
    "matchedStatuses": ["broken", "failed"],
    "messageRegex": ".*something went wrong.*"
  },
  {
    "name": "No data",
    "matchedStatuses": ["broken"],
    "traceRegex": ".*NullPointerException.*"
  },
  {
    "name": "Product defects",
    "matchedStatuses": ["failed"]
  },
  {
    "name": "Test defects",
    "matchedStatuses": ["broken"]
  }
]
```

Описание атрибутов:

• name — наименование категории. Оно будет отображаться на вкладке «Categories» на самом верхнем уровне классификации.
Обязательный атрибут.

• matchedStatuses — список статусов, с одним из которых должен завершиться тест, чтобы попасть в данную категорию. Из
коробки доступны статусы «failed», «broken», «passed», «skipped» и «unknown». Необязательный атрибут.

• messageRegex — регулярное выражение, которому должно соответствовать Exception-сообщение, чтобы попасть в данную
категорию. Необязательный атрибут.

• traceRegex — регулярное выражение, которому должно соответствовать Exception-StackTrace, чтобы попасть в данную
категорию. Необязательный атрибут.
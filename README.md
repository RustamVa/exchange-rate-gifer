# Описание 

сервис, который обращается к сервису курсов валют, и отображает gif:

• если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich

• если ниже - отсюда https://giphy.com/search/broke
Ссылки

• REST API курсов валют - https://docs.openexchangerates.org/

• REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide
Must Have

• Сервис на Spring Boot 2 + Java / Kotlin

• Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD

• Для взаимодействия с внешними сервисами используется Feign

• Все параметры (адреса внешних сервисов и т.д.) вынесены в настройки

## Endpoints

/currency/codes - список доступных валют

/currency/check/{code} - JSON c ссылкой на гиф с GIPHY

_______________


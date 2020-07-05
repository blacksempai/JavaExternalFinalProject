# JavaExternalFinalProject

# Система Подачи Отчетов в Налоговую.
Физ./Юр.лицо (далее Пользователь) регистрируется. Подает отчет (XML/JSON/Форма). Налоговый Инспектор принимает/отклоняет отчет (указывая причину отказа). Пользователь может просмотреть все поданные отчеты, причины отказа и изменять их если того потребовал Инспектор. Пользователь может отправлять запрос на замену Инспектора в случае неудовлетворения. 

# Инструкция по установке 
```
git clone https://github.com/blacksempai/JavaExternalFinalProject.git
```

# Инструкция по запуску приложения

1)Install database from [db.sql](database/db.sql)

2)Build and deploy the project with maven:
```
mvn tomcat7:run
```
3)Go to url localhost:8888/

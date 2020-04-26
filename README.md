# Проект-подсказка для быстрого решения задач, связанных с созданием готовых вэб приложений

## Скафолд нового Spring-Vue проекта (см Initial commit)
 1. В Идее создать новый мавен проект. Папку **src** переименовать в **backend** и удалить из нее все содержимое
 2. На [https://start.spring.io/](https://start.spring.io/ "https://start.spring.io/") сгенерировать новый проект и распаковать содержимое в **backend** (файл **.gitignore** перетащить в корень, дополнить (см код))
 3. (опционально) В **backend\src\main\resources** файл application.properties переименовать в application.yml добавить **banner.txt** c [кастомным баннером приложения](https://devops.datenkollektiv.de/banner.txt/index.html "https://devops.datenkollektiv.de/banner.txt/index.html")
 4. В корне проекта запустить **vue create frontend --no-git**
 5. В созданную папку **frontend** добавить **vue.config.js** с таким содержанием:
 
        module.exports = {
        outputDir: 'target/dist',
        assetsDir: 'static'
        }
    а так же **pom.xml** 
 6.   модернизировать все три помника (смотри код) 
 7. Собрать проект  **mvn clean install** (перед этим лучше дропнуть **node_modules** и сделать **npm install** - меньше ВОРНИНГОВ при сборке)
 8. Тест, что все запускается **mvn --projects backend spring-boot:run** или **java -jar demo-app.jar**

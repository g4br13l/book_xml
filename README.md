
# Book_XML
This is a project made with Java and Spring Boot that manages books, chapters and pages. This project exposes a Rest API and generates XML documents.

Este é um projeto feito com Java e Spring Boot que gerencia livros, capítulos e páginas. Esse projeto expõe uma API Rest e gera documentos XML.






## 🛠 Technologies
- Language: `Java` 
- Framework: `Spring Boot`, `Spring Data`, `JPA`
- Lib: `Jaxb`, `Jackson`, `ModelMapper`, `lombok`


## Documentação da API


Register a book
```http
  POST /api/books
```
| Parâmetro     | Tipo          | Descrição                                         |
| :----------   | :---------    | :------------------------------------------       |
| `name`        | `string`      | *Required. Book's name.                           |
| `pagesNumber` | `Integer`     | *Required. Total number of pages in the book.     |
| `chapterIds`  | `List<UUID>`  | *Required. Book chapter identification number.    |

.

Returns all books in Json format
```http
  GET /api/books_json
```
.

Returns a specific book in Json format
```http
  GET /api/books_json/{id}
```
.

Returns all books in XML format 
```http
  GET /api/books_xml
```
.

Returns a specific book in XML format 
```http
  GET /api/books_xml/{id}
```
.

Returns a specific book in XML format, generates an XML document and saves it in the folder: "\src\main\java\com\gabriel\bookxml\xml\exports\"
```http
  GET /api/save_books_xml/{id}
```
.

Register a chapter
```http
  POST /api/chapters
```
| Parâmetro     | Tipo          | Descrição                                     |
| :----------   | :---------    | :------------------------------------------   |
| `title`       | `string`      | *Required. Chapter's name.                    |
| `text`        | `string`      | *Required. Text of the entire chapter.        |





## Author
- [@g4br13l - Gabriel Lima](https://github.com/g4br13l)



# msm-blog-service

Este repositorio fue creado para gestionar una plataforma de blog, permitiendo la creación, edición y visualización de posts de usuarios.

## Descripción

El servicio **msm-blog-service** es parte de una arquitectura modular y está diseñado para facilitar la gestión de un portal de blog. Los usuarios pueden crear publicaciones, interactuar con el contenido a través de comentarios y ver estadísticas relacionadas con los posts.

## Funcionalidades Principales

- Crear, editar y eliminar posts de blog.
- Gestión de comentarios asociados a los posts.
- Soporte para múltiples usuarios.
- Consultas avanzadas sobre estadísticas del blog (número de posts, comentarios, calificaciones, etc.).

## Requisitos

Para compilar y ejecutar la aplicación, se necesita:

- JDK 1.8 o superior
- Maven 3.6+
- Spring Boot 2.5.6
- Base de datos relacional SQL Server

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/leandroescalera/msm-blog-service.git
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd msm-blog-service
    ```

3. Compila el proyecto con Maven:

    ```bash
    mvn clean install
    ```

4. Ejecuta la aplicación:

    ```bash
    mvn spring-boot:run
    ```

## Uso

Una vez que el servicio esté en funcionamiento, puedes acceder a los endpoints RESTful para gestionar el contenido del blog. A continuación, se muestra un ejemplo básico de interacción:

- **Crear un autor**: 
  ```http
  POST /evaluation/blog/api/v1.0/createAuthor
  ```
- **Crear blogs**:
  ```http
  POST /evaluation/blog/api/v1.0/createBlog
  ```
- **Crear comentarios**:
  ```http
  POST /evaluation/blog/api/v1.0/createComment
  ```
- **Actualizar blogs**:
  ```http
  POST /evaluation/blog/api/v1.0/updateBlog
  ```
- **Obtener los blogs por id**:
  ```http
  POST /evaluation/blog/api/v1.0/getBlog
  ```

## Docker

También puedes ejecutar el servicio utilizando Docker. Aquí están los pasos para construir y ejecutar la imagen Docker:

1. Construye la imagen Docker:

    ```bash
    docker build -t msm-blog-service .
    ```

2. Verifica las imágenes Docker disponibles:

    ```bash
    docker images
    ```

3. Ejecuta el contenedor:

    ```bash
    docker run -p 8080:8080 msm-blog-service
    ```

   Esto iniciará el contenedor y mapeará el puerto 8080 del contenedor al puerto 8080 de tu máquina local. Ahora puedes acceder al servicio en `http://localhost:8080`.

## Clientes

Este proyecto será utilizado para la gestión de un portal de blogs en la creación y gestión de contenido.

## Autores

- **Leandro Escalera** - marcelo.escalera.inf@gmail.com

## Contribuciones

Si deseas contribuir a este proyecto, por favor sigue las directrices en [CONTRIBUTING.md](CONTRIBUTING.md).

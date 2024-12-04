# Farmacias App

Una aplicación móvil para gestionar una lista de farmacias utilizando datos obtenidos de una API externa. Esta aplicación permite visualizar las farmacias en una lista, ver los detalles de cada una (como su ubicación en un mapa) y consultar información adicional como el número de teléfono.

## Descripción

La aplicación permite al usuario:

- Visualizar una lista de farmacias obtenida desde una API externa.
- Ver los detalles de cada farmacia, que incluyen su nombre, teléfono y ubicación en un mapa.
- Mostrar un mapa interactivo con la ubicación de la farmacia seleccionada.

## Funcionalidades

- **Lista de farmacias**: La aplicación obtiene y muestra una lista de farmacias utilizando Retrofit para hacer una solicitud HTTP a una API externa.
- **Detalles de farmacia**: Al hacer clic en una farmacia, el usuario puede ver los detalles, que incluyen el nombre, teléfono y una visualización en un mapa de la ubicación de la farmacia.
- **Manejo de errores**: Si ocurre algún error al cargar los datos o al intentar acceder a la API, la aplicación muestra un mensaje informativo.

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación para el desarrollo de la aplicación.
- **Jetpack Compose**: Librería para crear la UI de la aplicación de manera declarativa.
- **Retrofit**: Librería para realizar las solicitudes HTTP a la API y manejar la conversión de datos.
- **Google Maps SDK**: Para mostrar un mapa con la ubicación de las farmacias.
- **OkHttp**: Usado para realizar las peticiones HTTP con logging para facilitar el desarrollo y depuración.

## Requisitos

- Android Studio o cualquier otro entorno compatible con desarrollo Android.
- Un dispositivo Android o un emulador para ejecutar la aplicación.

## Instrucciones de Instalación

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en Android Studio.
3. Asegúrate de tener configuradas las dependencias de Gradle correctamente.
4. Ejecuta la aplicación en un emulador o dispositivo físico.


## Contribución

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama con tus cambios.
3. Realiza los cambios y haz commit.
4. Haz un pull request con una descripción clara de tus cambios.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

## Autores

- [Tu Nombre](https://github.com/tuusuario) - Desarrollador principal.
- Contribuciones de la comunidad.

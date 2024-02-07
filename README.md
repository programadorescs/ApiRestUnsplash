# Consumo de la Api Unsplash usando Retrofit, ROOM, patrón MVVM e inyección de dependencia con Dagger Hilt
Mediante este ejemplo accederemos a la api de Unsplash, la particularidad de este endpoint es que la api_key esta al final de la misma url, para ello haremos uso los Interceptor para agregar dicha api_key. El resultado obtenido de la api será almacenado en ROOM.

## Requisitos

- Android Studio Hedgehog | 2023.1.1 Patch 2 o superior.
- Android Gradle Plugin Version 8.2.2
- Gradle Version 8.2
- Kotlin 1.9.22 o superior.
- Api key, para ello deberá de ingresar a la página (https://unsplash.com/developers) y registrarse para obtener dicha api key.

## Dependencias

- Retrofit: Para el consumo de la api.
- ViewModel y LiveData: Para la implementación del patrón MVVM.
- Dagger Hilt: Para la inyección de dependencias.
- Coil: Sera usado para cargar las imagenes.
- ROOM: Para almacenar la info recibida de la api.

## Estructura del proyecto

- di: Contiene las  inyeccion de dependencia a nivel de módulo.
- data: Contiene las clases, interfaces para el consumo de la api, manejo de room, implementacion del repositorio, etc.
- domain: Contiene el modelo, repositorio y el use case.
- presentation: Contiene la interfaz de usuario, funcionalidades comunes, adaptador y el viewmodel.

## Resultado del endpoint
De todo el resultado obtenido del endpoint, estos serán los campos que manejaremos.

![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/respuesta_json.png)

## Estructura de la app
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/estructura_app.png)

## Imagen de la app

### Login
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/api_login.png)

### Registrar una nueva cuenta
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/api_cuenta.png)

### Datos de la api
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/pantalla_01.png)

### Info de la app
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/api_info.png)
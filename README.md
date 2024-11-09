 # price-api-hexagonal (MODULAR)- API REST para Gestión de Tarifas de Precios

Este proyecto implementa un controlador REST para gestionar las tarifas de precios de productos en función de diferentes criterios. La arquitectura utilizada es **hexagonal**, y la aplicación está construida sobre **Spring Boot** con **H2** como base de datos en memoria para simplificar las pruebas y la persistencia de datos durante la ejecución.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para construir la API REST.
- **H2 Database**: Base de datos en memoria para almacenar los datos temporalmente.
- **Arquitectura Hexagonal (Ports and Adapters)**: Permite una separación clara entre la lógica de negocio y las implementaciones externas.
- **Lombok**: Para simplificar la implementación de las entidades y DTOs.
- **Swagger** (opcional): Para documentación interactiva de la API.

## Arquitectura Hexagonal

La arquitectura hexagonal permite organizar el código en capas independientes, lo que facilita su mantenimiento y pruebas. En este proyecto, la lógica de negocio está separada en **puertos** (interfaces) y **adaptadores** (implementaciones de esas interfaces). Esto permite que el controlador (adaptador de entrada) interactúe con los casos de uso y las capas de dominio sin acoplarse a detalles de implementación específicos.

## Endpoints del Controlador

Este controlador expone los siguientes endpoints:

| Método HTTP | Endpoint                | Descripción                                                                                                                                                           |
|-------------|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `POST`      | `/prices`               | Crear una nueva tarifa de precio a partir de los datos proporcionados.                                                                                               |
| `GET`       | `/prices`               | Obtener todas las tarifas de precios almacenadas en la base de datos.                                                                                                 |
| `GET`       | `/prices/rates`         | Consultar tarifas aplicables a un producto específico en una fecha y hora dada, considerando el ID del producto y el ID de la marca.                                 |

Created by DARWIN ROCHA

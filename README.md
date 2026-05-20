# Projecto-de-fullstack-1-

# 🚀 Sistema de Gestión de Microservicios - Proyecto Fullstack (DUOC)

Bienvenido al repositorio del proyecto final. Este sistema implementa una arquitectura de **microservicios** para la gestión integral de ventas y productos.

## 🏗️ Estructura del Proyecto
El proyecto está organizado en múltiples servicios independientes que se comunican entre sí:

* **Eureka-Server**: Service Discovery para el registro y localización de servicios.
* **Api-Gateway**: Punto de entrada centralizado para gestionar las rutas al puerto 9000.
* **Microservicios**:
    * `usuario-service`: Gestión de clientes.
    * `producto-service`: Catálogo y gestión de productos.
    * `carrito-service`: Orquestación de compras.
    * `pagos-service`, `facturaciones-service`, `inventario-service`, `transporte-service`, `notificaciones-service`.

## ⚙️ Tecnologías Utilizadas
* **Java 17** con **Spring Boot**.
* **Spring Cloud** (Netflix Eureka, Gateway, OpenFeign).
* **JPA/Hibernate** con base de datos **MySQL**.
* **Lombok** para optimización de código.

## 🚀 Guía de Inicio (Orden de ejecución)
Para levantar el ecosistema, sigue este orden estrictamente:
1. `Eureka-Server` (Esperar a que inicie).
2. `Api-Gateway`.
3. Microservicios restantes.

## 📡 Endpoints principales (Ejemplos)
* **Listar productos**: `GET http://localhost:9000/api/v1/productos`
* **Crear producto**: `POST http://localhost:9000/api/v1/productos`

---
*Desarrollado por Kevin - Alumno de DUOC.*
*Desarrollado por Jaime - Alumno de DUOC.*
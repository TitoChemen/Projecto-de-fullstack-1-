# 🚀 Sistema de Gestión de Microservicios - Proyecto Fullstack

Proyecto desarrollado como parte de la formación en IT en el DUOC. Este sistema implementa una arquitectura robusta de **microservicios** para la gestión integral de ventas, catálogo de productos y usuarios.

## 👥 Equipo de Desarrollo
* **Kevin Sosa**
* **Jaime [Apellido de tu compañero]**

## 🏗️ Estructura del Proyecto
El sistema está compuesto por servicios independientes comunicados vía **Spring Cloud**:
* **Eureka-Server**: Service Discovery.
* **Api-Gateway**: Punto de entrada centralizado (Puerto 9000).
* **Microservicios**: `usuario-service`, `producto-service`, `carrito-service`, `pagos-service`, `facturaciones-service`, `inventario-service`, `transporte-service`, `notificaciones-service`.

## ⚙️ Tecnologías Utilizadas
* **Java 25** con **Spring Boot**.
* **Spring Cloud** (Eureka, Gateway, OpenFeign).
* **JPA/Hibernate** con base de datos **MySQL**.
* **Lombok** para optimización de código.

## 🚀 Guía de Inicio (Orden de ejecución)
1. Iniciar **Eureka-Server**.
2. Iniciar **Api-Gateway**.
3. Iniciar los microservicios restantes.

## 📡 Endpoints principales
* **Listar productos**: `GET http://localhost:9000/api/v1/productos`
* **Crear producto**: `POST http://localhost:9000/api/v1/productos`
---
> "Lo único que importa es ganar." — Inspirado por Harvey Specter, pero construido con el código de Kevin y Jaime.

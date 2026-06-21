# 🚀 Sistema de Gestión de Microservicios - Proyecto Fullstack

Proyecto desarrollado como parte de la formación en IT en el DUOC. Este sistema implementa una arquitectura robusta de **microservicios** para la gestión integral de ventas, catálogo de productos y usuarios.

## 👥 Equipo de Desarrollo
* **Kevin Sosa**
* **Jaime Rodriguez**

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
* **Docker & Docker Compose** para la contenedorización y orquestación.

## 🐳 Despliegue con Docker (Docker Compose)
Para levantar todo el ecosistema (bases de datos MySQL independientes y microservicios) de forma automatizada y sin configurar nada a mano:
1. Situarse en la raíz del proyecto donde está el archivo `docker-compose.yml`.
2. Ejecutar el siguiente comando para compilar y levantar los contenedores: `docker-compose up --build`
* Nota: Este comando creará la base de datos MySQL con sus esquemas iniciales, iniciará el servidor Eureka, el Config Server, el API Gateway y el resto de los microservicios de manera completamente coordinada.

## 🚀 Guía de Inicio Manual (Orden de ejecución)
1. Iniciar **Eureka-Server**.
2. Iniciar **Api-Gateway**.
3. Iniciar los microservicios restantes.

## 📡 Endpoints principales
* **Listar productos**: `GET http://localhost:9000/api/v1/productos`
* **Crear producto**: `POST http://localhost:9000/api/v1/productos`

---
> "Lo único que importa es ganar." — Inspirado por Harvey Specter, pero construido con el código de Kevin y Jaime.
# JAX-RS Test 2 🚀

Este proyecto es una API RESTful construida con **Jakarta EE 10**, **JAX-RS**, y **MySQL**, desplegada en **Payara Micro 6.2025.1**.

## 📌 Características

- CRUD de clientes usando **JAX-RS** y **Jakarta EE 10**.
- Conexión a **MySQL** para almacenar información de clientes.
- Uso de **Payara Micro** como servidor de aplicaciones.
- Implementado en **Java 17**.

---

## 🛠️ **Requisitos Previos**

Antes de ejecutar el proyecto, asegúrate de tener instalado:

1. **Java 17**  
   Puedes verificar la versión con:
   ```sh
   java -version
   ```

2. **Maven**  
   Para verificar:
   ```sh
   mvn -version
   ```

3. **MySQL**  
   Asegúrate de que MySQL esté ejecutándose y crea la base de datos:

   ```sql
   CREATE DATABASE jaxrsdb;
   ```

---

## 🚀 **Instalación y Configuración**

### 1️⃣ **Clonar el Repositorio**
```sh
git clone https://github.com/carlosaugustocue/jax-rs-test2.git
cd jax-rs-test2
```

### 2️⃣ **Configurar la Base de Datos**
Ejecuta el siguiente script SQL en MySQL:
```sql
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 3️⃣ **Configurar la Conexión a MySQL**
Edita el archivo `DatabaseConnection.java` y ajusta las credenciales:

```java
private static final String URL = "jdbc:mysql://localhost:3306/jaxrsdb?serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "";
```

Si usas una contraseña para MySQL, reemplaza `""` con la contraseña correspondiente.

### 4️⃣ **Compilar y Construir el Proyecto**
```sh
mvn clean package
```
Esto generará un archivo **WAR** en `target/jax-rs-test2.war`.

---

## 🎯 **Ejecución del Proyecto**

### 1️⃣ **Ejecutar Payara Micro con el WAR**
```sh
java -jar path/to/payara-micro-6.2025.1.jar --deploy target/jax-rs-test2.war --port 8080
```
Si el driver de MySQL no es detectado, agrégalo manualmente:

```sh
java -jar path/to/payara-micro-6.2025.1.jar --deploy target/jax-rs-test2.war --addlibs ~/.m2/repository/mysql/mysql-connector-java/8.0.33/mysql-connector-java-8.0.33.jar --port 8080
```

---

## 📡 **Uso de la API**

### Obtener todos los clientes
```sh
GET http://localhost:8080/jax-rs-test2/api/clientes
```

### Agregar un nuevo cliente
```sh
POST http://localhost:8080/jax-rs-test2/api/clientes
Content-Type: application/json

{
  "nombre": "Carlos Pérez",
  "email": "carlos@example.com",
  "telefono": "3001234567"
}
```

### Obtener un cliente por ID
```sh
GET http://localhost:8080/jax-rs-test2/api/clientes/{id}
```

### Actualizar un cliente
```sh
PUT http://localhost:8080/jax-rs-test2/api/clientes/{id}
Content-Type: application/json

{
  "nombre": "Carlos Pérez Actualizado",
  "email": "carlos@example.com",
  "telefono": "3019876543"
}
```

### Eliminar un cliente
```sh
DELETE http://localhost:8080/jax-rs-test2/api/clientes/{id}
```

---

## 🛠 **Solución de Problemas Comunes**

### ❌ **"No suitable driver found for jdbc:mysql://localhost:3306/jaxrsdb"**
✅ Solución: Agrega manualmente el driver en `DatabaseConnection.java`:
```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### ❌ **"Table 'jaxrsdb.clientes' doesn't exist"**
✅ Solución: Asegúrate de que la tabla `clientes` fue creada correctamente en MySQL.

### ❌ **"Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin"**
✅ Solución: Borra la carpeta `target/` y recompila:
```sh
mvn clean package
```

---

## 📜 **Licencia**
Este proyecto está bajo la licencia **MIT**.

---

¡Disfruta codificando! 🚀🔥

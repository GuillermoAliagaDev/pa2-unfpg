# UNFPG - Servicios REST (Integración de Aplicaciones, PA2)

Proyecto Spring Boot (Maven) para la práctica grupal sobre la base de datos `universidad_unfpg`.
Compatible con Spring Tools Suite (STS) / Eclipse.

## Requisitos
- JDK 25 (si tu STS usa otra versión, ajusta `java.version` en `pom.xml`)
- MySQL con la base de datos `universidad_unfpg` ya creada (tablas + datos: `database/bduniversidad datos v2.sql`)
- Spring Tools Suite

## Importar en STS
`File > Import > Maven > Existing Maven Projects` y seleccionar la carpeta del proyecto.

## Configuración de la conexión
`src/main/resources/application.properties` usa por defecto `localhost:3306`, usuario `root`, clave `root`.
Cada integrante puede usar sus propios datos sin tocar el archivo, con variables de entorno
(`DB_URL`, `DB_USERNAME`, `DB_PASSWORD`) o editando `application.properties` **sin subir** ese cambio.

`ddl-auto=none`: la aplicación nunca crea ni modifica tablas.

## Ejecutar
Botón derecho en el proyecto > `Run As > Spring Boot App`, o:
```bash
./mvnw spring-boot:run
```
Si la conexión es correcta, la consola muestra `HikariPool-1 - Start completed` y Tomcat en el puerto 8080.

## Estructura (paquete `pe.com.unfpg`)
| Paquete | Contenido |
|---|---|
| `config` | Configuraciones |
| `entity` | Entidades JPA (`XxxEntity`) |
| `repository` | Repositorios (`XxxRepository`) |
| `service` | Interfaces (`XxxService`) |
| `service.impl` | Implementaciones (`XxxServiceImpl`) |
| `restcontroller` | Controladores REST (`XxxRestController`, ruta `/api/xxx`) |

## Reparto de tareas
1. Base de proyecto y conexión (hecho)
2. Consultas GET (listar y buscar por id)
3. Registro POST
4. Actualización PUT
5. Deshabilitar (DELETE) y habilitar (PATCH)

## Flujo con Git
Cada integrante trabaja en su rama (`git checkout -b parte-2-get`), hace commit y abre Pull Request a `main`.
Para evitar conflictos, cada uno agrega sus propios métodos/archivos y avisa antes de editar los de otro.

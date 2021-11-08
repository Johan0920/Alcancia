# Alcancia
Este proyecto es una prueba, se muestra los siguientes pasos:


1. Descargar de Git el repositorio https://github.com/Johan0920/Alcancia.git
2. crear sql azure con nombre de servidor sqlalcancia, con nombre de base de datos alcanciadb, usuario=alcancia, clave=Pa55w.rd
	en la opcion del servidor sqlalcanci|firewalls y redes virtuales, la opción  "Permitir que los servicios y recursos de Azure accedan a este servidor" = SI
3. en la ruta que descarguen el repositorio realizar lo siguiente (IDE de uso VS Code) 
	al abrir ejecutar e instalar los componentes y plugins que soliciten, luego ejecuta en una terminal
	& "c:\respositorioendondeguardarelproyecto\alcancia\mvnw.cmd" spring-boot:run -f "c:\respositorioendondeguardarelproyecto\alcancia\pom.xml"
	Este comando creara la tabla moneda en la base de datos SQL en Azure
	con postman podra acceder a localhost:8080 o en un navegador localhost:8080/swagger-ui.html
4. Este proyecto tiene las dependencias
	SQL Server
	JPA 
	Junit5
	Jacoco
	Spring boot
	Azure App Service
5. Ejecutando los procesos de
	Clean (limpiar el proyecto)
	Test (Ejecutar las pruebas de Junit)
	Package (crea alcancia-0.0.1-SNAPSHOT para subir el api service en AZURE)
6. click derecho a alcancia-0.0.1-SNAPSHOT.war y tomar la opcion Deploy to Web App
	apinetalcancia es la api service creada en AZURE
	Debe tener una cuenta de azure en la cual le pedira las claves de acceso
	https://apinetalcancia.azurewebsites.net/ esta es la url en Azure

Resumen:

Nube local --> http://localhost:8080/swagger-ui.html

Nube de azure --> https://apinetalcancia.azurewebsites.net/

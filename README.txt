* Exámen técnico Optimissa

* Desarrollo de una API REST que cumpla con los requerimientos funcionales de transferir dinero, mostrar el histórico de las 
  transacciones pasadas y el saldo actual de una cuenta.
  
  
* La ejecución se realizará en un ambiente de desarrollo con una bsae de datos en memoria.

* Ejecución desde consola:

  Desde una consola, colocarse en el directorio del proyecto (/banca-optimissa) y ejecutar:  mvnw spring-boot:run
  
  - Ejemplos de ejecutaciones de end-points: 
  
  	1. Obtener el listado de cuentas existentes en el sistema
  		curl -X GET "http://localhost:8080/accounts" -H "accept: */*"
  	
  	2. Transferencia de dinero
  		curl -X POST "http://localhost:8080/transfers" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"amount\": 99.54, \"fromAccount\": \"987654321\", \"toAccount\": \"123456789\"}"
  		curl -X POST "http://localhost:8080/transfers" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"amount\": 104.25, \"fromAccount\": \"13456658\", \"toAccount\": \"987654321\"}"
  	
  	3. Histórico de transacciones
  		a) Obtener todas las transacciones de una cuenta especifica
  		curl -X GET "http://localhost:8080/transactions/987654321/findAllByAccount" -H "accept: */*"
  	
  		b) Obtener todas las transacciones recibidas en una cuenta específica
  		curl -X GET "http://localhost:8080/transactions/987654321/findAllByAccountTo" -H "accept: */*"
  	
  		c) Obtener todas las transacciones enviadas por una cuenta específica 
  		1curl -X GET "http://localhost:8080/transactions/987654321/findAllByAccountFrom" -H "accept: */*"
  	
  	4. Obtener el balance actual de una cuenta específica
  		curl -X GET "http://localhost:8080/balances/13456658/findBalanceByAccount" -H "accept: */*"
  	  

* Para abrir la consola de Swagger, ejecutar en un navegador la siguiente url: http://localhost:8080/swagger-ui.html
 

* Para agregar mas cuentas se deberá editar y guardar los cambios del archivo /src/main/resources/data.sql
	
	ejemplo de insercion:		
		INSERT INTO ACCOUNT (account, balance, owner, created_at ) values('13456658', 32442, '761233785', parsedatetime('23-04-2012 08:09:11.51111', 'dd-MM-yyyy hh:mm:ss.SSSSS'))

	Una vez finalizada la edición del archivo, se debe detener el servicio en caso de que se este ejecutando, posteriormente 
	se debe arrancar nuevamente la aplicación. Como la base de datos se esta ejecutando en memoria, la información guardada en
	ejecuciones anteriores se perderá y únicamente se contará con las cuentas que se generan durante el arranque.
	
* Para finalizar la ejecución: Ctrl + C 
 
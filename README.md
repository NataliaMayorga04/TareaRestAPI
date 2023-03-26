# TareaRestAPI

## Funcionamiento general 
Esta API se divide en diferentes carpetas, las cuales son controlador, modelo, servicio y repositorio. En el caso de controlador, este se encarga de asignar lo paths para que el usuario final pueda ingresar a la URL y la respectiva URI. Por otro lado, en la capa de modelo, se encuentran las entidades que son cliente, mascota y reservación, continuando con la capa de servicio, allí es donde se guarda la lógica del negocio y en el caso de repositorio, se llama a las funciones REST. 

Para tener en cuenta de la API, un cliente puede tener máximo dos mascotas en la guardería y puede realizar reservaciones siempre y cuando no reserve dos mascotas en la misma fecha. A la vez, se puede consultar las mascotas de un cliente a partir de su respectivo ID.

Para el desarrollo de la API se trabajo con la base de datos de MySQL proporcionada por el profesor. A conitnuación, se puede ver las diferentes tablas y en este caso el contenido de la tabla de CLIENT.
![MicrosoftTeams-image (13)](https://user-images.githubusercontent.com/78512829/227751374-1801fe8e-df9d-4578-9c36-872fb379d658.png)




## Modelo de datos
<img width="500" alt="image" src="https://user-images.githubusercontent.com/78512829/227750511-da63cb0f-afb1-4e52-8e65-eb84f2dc2143.png">

## Requerimientos
Para el funcionamiento del código se debe implementar JAVA 11 en adelante. 

## Link de ingreso a swagger
http://localhost:8081/swagger-ui/#/

## Postman

### saveCLient: Se encarga de enviar un json de un cliente y crearlo



###  obtainClient: Recupera el cliente por medio de su id


### saveReservation: se encarga de enviar un json con la informacion de la reserva



## getAllReservations: Recupera la reserva por medio de el id del cliente



 ## getReservationByDate: busca las reservas segun el dia:



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

### saveCLient - postClient: Se encarga de enviar un json de un cliente y crearlo

![image](https://user-images.githubusercontent.com/78616272/227788493-692d4542-9329-4d55-94a0-4902c4d399df.png)
![image](https://user-images.githubusercontent.com/78616272/227788909-ffd93680-f707-4b9e-89d4-1ac94000a160.png)



###  savePet - postPet : Se encarga de enviar un json de un cliente y crearlo
![image](https://user-images.githubusercontent.com/78616272/227788531-3f625fb3-20ee-47f7-a956-fbfc47f900f0.png)
![image](https://user-images.githubusercontent.com/78616272/227788555-cd129a76-0b5b-4194-aa3d-51f4090e871f.png)
<br>
<br>
Si se crea una tercera mascota salda error indicando que no es posible tener mas de dos mascotas para una misma persona

![image](https://user-images.githubusercontent.com/78616272/227788611-6b44ebb9-10b6-40ac-bbdb-3bbc3eecefb8.png)

![image](https://user-images.githubusercontent.com/78616272/227788998-21f48dc8-01be-497b-b1ef-0f023913fc97.png)



## getPetsByClientId - id/pets : Recupera todos los clientes de un mismo id

![image](https://user-images.githubusercontent.com/78616272/227788700-8382762d-d3cd-4298-b215-930a8836fb8e.png)


### saveReservation: se encarga de enviar un json con la informacion de la reserva

![image](https://user-images.githubusercontent.com/78616272/227788770-945990f7-33c9-456c-bc9f-1b9e1cf22534.png)
![image](https://user-images.githubusercontent.com/78616272/227789060-e972d416-cfad-4cd4-b26d-645fb014fbdd.png)


<br>
<br>
Si realiza una reserva para la misma fecha con algun perro saldra error

![image](https://user-images.githubusercontent.com/78616272/227788817-35cd34c2-73c2-494f-a13f-c995957c77f9.png)

<br>
Si cambiamos la fecha la permite realizar de nuevo

![image](https://user-images.githubusercontent.com/78616272/227789271-4fd6fc13-df15-4235-91e3-0a4b7a8e6442.png)

![image](https://user-images.githubusercontent.com/78616272/227789313-7f789474-fca2-4669-a58b-19f9c3f392e5.png)












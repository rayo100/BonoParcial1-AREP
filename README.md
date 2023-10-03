# Bono Parcial Tercio1 AREP

#  Creamos la imagen para docker

Inicialmente creamos el archivo Dockerfile

![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/a5e8ebe8-439c-4714-b74d-2c2b6c9bdec4)

Con el siguiete comando desde el cmd, construimos la imagen

  docker build --tag bonodocker .

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/22b39177-bd82-438a-963b-ee570d5b2541)

Revisamos la imagen con el comando:

  docker images

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/10e5c199-2f32-4b6b-a8be-3d6f90d086ac)

A partir de la imagen creada creamos tres instancias de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto físico de su máquina (opción -p):

  docker run -d -p 34000:6000 --name firstdockercontainer bonodocker
  docker run -d -p 34001:6000 --name firstdockercontainer2 bonodocker
  docker run -d -p 34002:6000 --name firstdockercontainer3 bonodocker

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/7b652412-c77f-4a41-ab0f-5c3c3da6353c)

  Nos aseguramos que está corriendo de manera correcta

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/f13350ad-c3a1-4f10-82d5-dcd2a28fedac)

  Nos apoyamos de Docker Desktop para verificar dicha acción y que se esté corriendo

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/d9d30a0a-b386-4972-88d7-45d53a419056)

  Y abrimos las instancias con los puertos 34000, 34001 y 34002

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/a8fa1920-e25c-4fad-b55a-0cd65c009db0)

Usamos docker-compose para generar automáticamente una configuración docker, por ejemplo un container y una instancia a de mongo en otro container. Creamos en la raíz de nuestro directorio el archivo docker-compose.yml con le siguiente contenido:

![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/b08196b1-89fa-4f15-a136-af9c73aeed4a)

  Ejecutamos el docker compose, con el siguiete comando:

  docker-compose up -d

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/06503133-3103-4d59-a9c5-fdbddc2d36b8)

  Verificamos que se crearon los servicios:

  docker ps

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/03619d76-e446-47af-bcca-40ef6fb4ad92)

  Verificamos en nuestro apoyo Docker Desktop

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/5494631f-a6c5-4563-800d-0e5c840b62df)


# Finalmente, subimos la imagen a DockerHub

Creamos nuestro repositorio

![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/c08a05a8-1609-4c0a-895a-887617392ca5)

En nuestro motor de docker local creamos una referencia a nuestra imagen con el nombre del repositorio a donde desea subirla:

  docker tag bonodocker cesar0616/bono_docker

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/147e1586-c0db-4cd2-a36e-7bfd286ab2f3)

  !OJO! Si desea puede usr tags para poner nombre específicos, como solo tenemos una imagen simplemente creamos una referencia con le nombre de repositorio y dejamos el mismo nombre de tag , en este caso “latest”

  Verificamos que la nueva referencia de imagen existe

  docker images

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/7af1ed10-3c9d-449e-97f7-a269c794b4d0)

  Autenticamos en su cuenta de dockerhubd desde la consola (ingresando nuestro usuario y clave ):

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/0eddabde-95b4-43c0-a71e-e0ad1bab8859)

  Empujamos la imagen al repositorio en DockerHub con el comando:

  docker push cesar0616/bono_docker:latest

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/5178c242-5321-4e74-a19d-e0aa665a904c)

  Finalmente, revisamos en nuestro DockerHub el tag y hemos terminado

  ![image](https://github.com/rayo100/BonoParcial1-AREP/assets/89558695/6daa620a-c5b3-4fbd-81bc-6b2357d5acd5)


# Cesar Vásquez
















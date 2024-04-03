# Parcial 2

## Prerrequisitos
Maven, java, git y verificar disponibilidad de puertos.

## Instalación
1. Por terminal
   
   En tres cmds diferentes:
   Clonar el proyecto del repositorio y acceder al directorio que contiene el proyecto. Ejecutar el comando `mvn clean install`.
   
   - Para el primer cmd para una de las instancias de *MathService*
     
     `set PORT=4566`
     
     `java -cp "target/classes;target/dependency/*" parcial2.MathService`

    ![image](https://github.com/JessicaDMunozO/Parcial2-AREP/assets/123814482/6e4a5ce6-0591-49f9-8a26-94861fd4f08b)

   - Para el segundo cmd para la segunda instancia de *MathService*

     `java -cp "target/classes;target/dependency/*" parcial2.MathService`

     ![image](https://github.com/JessicaDMunozO/Parcial2-AREP/assets/123814482/03925a9d-9656-4641-9b13-d6a12e0eacd3)

   - Para el tercer cmd para el *ServiceProxy* pasando como parámetro las dos instancias del *MathService*

     `java -cp "target/classes;target/dependency/*" parcial2.ServiceProxy http://localhost:4567/ http://localhost:4566/`

     ![image](https://github.com/JessicaDMunozO/Parcial2-AREP/assets/123814482/d09cf12f-3e83-4fee-b677-12999dcd5f21)

2. Con EC2
   
   Se crearon dos instancias nuevas de EC2 y se agregaron las reglas de entrada para los puertos. Además se instaló java, maven y git para poder ejecutar el proyecto. Después se siguieron
   los mismos pasos enunciados antes para clonar, y ejecutar el proyecto.

   En las dos instancias de *MathService* se ejecutó el comando `java -cp "target/classes:target/dependency/*" parcial2.MathService`

   Y en la instancia para el *ServiceProxy* se ejecutó el comando pasando como parámetro las dos instancias del *MathService* con su respectiva IP
   `java -cp "target/classes:target/dependency/*" parcial2.ServiceProxy http://172.31.92.237:4567/ http://172.31.85.109:4567/`

## Ejecución
En el navegador abrir http://localhost:5000/response.html

![image](https://github.com/JessicaDMunozO/Parcial2-AREP/assets/123814482/b38d0b7b-e8ba-4156-9620-f111795a1d3a)

Calcular factores de 15

![image](https://github.com/JessicaDMunozO/Parcial2-AREP/assets/123814482/bec242d6-0313-4ffc-80d6-40de22f37d85)

Calcular factores de 112

![image](https://github.com/JessicaDMunozO/Parcial2-AREP/assets/123814482/5fe5c87d-056c-470b-9992-f3b3dd010ed0)

Calcular primos hasta 100

![image](https://github.com/JessicaDMunozO/Parcial2-AREP/assets/123814482/582cc96e-e8a5-492b-a33d-d28721930c9e)

## Video AWS
https://youtu.be/3Y-q-juuuBE

## Autor
Jessica Daniela Muñoz Ossa




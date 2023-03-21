# Criptografía en Java

![](https://i.ibb.co/dGsX86H/image.png)

### Features
Este programa permite ver de manera simple, fácil y practica la manera como se puede usar los dos tipos de criptografía mas comunes:
- Criptografía Simetrica.
- Criptografía Asimetrica.

Para esto se genera en java un programa que permite a través de los diferentes objetos generar la criptografía para proteger la información usando algoritmos que codifican la información.
Es este programa se usara los dos tipos de criptografía para hashear el password (El cual es una cadena de caracteres.) con una longitud fija.


### Requirements
Para este programa se necesita tener una base de datos SQL en este caso se monto en PostgreSQL con las siguientes caracteristicas:

![](https://i.ibb.co/kmzx2yg/BD.png)

    String usuario = "aolartes";
    String contrasenia = "Password123";
    String bd = "javadb";
    String ip = "Localhost";
    String puerto = "5432";

En la cual se creara la siguiente tabla para donde se almacenara la información:


```sql
CREATE TABLE users (
	id SERIAL NOT NULL PRIMARY JEY,
	usuario varchar(10),
	password varchar (50),
	password_hash (70)
);
```
Creada la base de datos traer la dependencia postgresql :

```html
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.5.1</version>
        </dependency>
    </dependencies>
```
Incluirla en el archivo pom.xml del Project Files (En caso que no exista).


Con esto cargar la aplicación en el IDE (NetBeans, Eclipse, IntelliJ IDEA, etc...)

#Application
## Criptografia Simetrica
![](https://i.ibb.co/Q8sQphc/image.png)
![](https://i.ibb.co/FWqQzmR/image.png)
![](https://i.ibb.co/RQRdXrc/image.png)
![](https://i.ibb.co/9WLTN69/image.png)
![](https://i.ibb.co/2NMvJQ1/image.png)
![](https://i.ibb.co/2PtqGVW/image.png)


##### En caso de que la contraseña no coincida con la contraseña hasheada en la base de datos esta aroojara error:

![](https://i.ibb.co/GnLTBNv/image.png)


## Criptografia Asimetrica:
![](https://i.ibb.co/JBf0qrt/image.png)
![](https://i.ibb.co/d0HhmLy/image.png)
![](https://i.ibb.co/GRHLz55/image.png)
![](https://i.ibb.co/YfBQBmF/image.png)


Developed by: aolartes
![](https://i.ibb.co/n1Br7mn/image.png)

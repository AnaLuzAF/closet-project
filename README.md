# Readme de referencia para configuración futura (obtenido de Library project)

## Configuración del entorno de desarrollo


### Maven y GitHub

Uno de los objetivos de Maven es el empaquetado y distribución de librerías de clases. Cada proyecto maven puede ser empaquetado usando el comando `mvn clean install`.

Las dependencias de los proyectos maven son jars empaquetas y subidos a un repositorio de artefactos maven. La mayoría de las dependencias que usamos residen en el repositorio central Maven Central.

Además de las librerías opensource que encontramos en Maven Central, es habitual querer utilizar dependencias desarrolladas por la propia organización. Para que esto sea posible cada organización debe configurar un repositorio maven en el que registrar los artefactos que se van desarrollando.

Los desarrolladores de una organización deben configurar Maven en sus máquinas para que acceda al repositorio de la organización. En nuestro caso vamos a utilizar un repositorio de artefactos alojado en GitHub, dentro de DAM2-2021-2022. Para configurarlo hay que crear el fichero `~/.m2/settings.xml` y pegar dentro el siguiente XML (Se deben sustituir los valores *$USERNAME* y *$TOKEN*)


```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">

  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>

  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
        </repository>
        <repository>
          <id>github</id>
	  <url>https://maven.pkg.github.com/dam2-2021-2022</url>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github</id>
      <username>$USERNAME</username>
      <password>$TOKEN</password>
    </server>
  </servers>
</settings>
```

Para generar el *TOKEN* hay que ir a github.com > Settings > Developer settings > Personal access tokens > Generate new token. Seleccionar los scopes: "write:packages" y "delete:packages". Seleccionar "No expiration"

Una vez configurado el equipo para que acceda a ese repositorio de artfactos, toca configurar cada proyecto que quiere acceder al mismo. Para ello se debe añadir el siguiente elemento al pom.xml


```xml
    <distributionManagement>
        <repository>
            <id>github</id>
            <name>GitHub OWNER Apache Maven Packages</name>
            <url>https://maven.pkg.github.com/dam2-2021-2022/libraryproject</url>
        </repository>
    </distributionManagement>
```

Una vez configurado el proyecto, es posible subir a un repositorio una versión de un proyecto ejecutando el comando `mvn clean deploy` y referenciar a librerías registradas en ese repositorio. 

*IMPORTANTE* Para que el deploy funcione el artifactId debe coincidir con el nombre del repositorio GitHub todo en minúsculas.

*PROYECTOS MULTIMÓDULO* En proyectos multimodulo (como LibraryProject) se debe sustituir en el pom ${artifactId} por el valor.

### Releases

Cuando se desea crear una versión ya cerrada del proyecto se debe hacer una release. Para poder hacer una release hay que configurar en el pom.xml el repositorio de GitHub a través del elemento SCM
```xml
<scm>
      <url>https://github.com/dam2-2021-2022/libraryproject</url>
      <connection>scm:git:git://github.com/dam2-2021-2022/libraryproject.git</connection>
      <developerConnection>scm:git:git@github.com:dam2-2021-2022/libraryproject.git</developerConnection>
      <tag>HEAD</tag>
</scm>
```

Para hacer una release en maven usaremos el plugin maven-release.

```bash
mvn release:prepare release:perform
```

En caso de que falle la release se puede intentar deshacer los cambios ejecutando el siguiente comando
```bash
mvn release:rollback
```

El proceso de release realizará los siguientes pasos:
- Pide la versión de la release
- Pide la siguiente versión SNAPSHOT
- Comprueba que todos los módulos compilan
- Ejecuta los test unitarios. Si alguno falla se detiene la release
- Realiza otras comprobaciones. Por ejemplo, no puede haber dependencias a proyectos *externos* que tengan versión SNAPSHOT
- Hace un commit de la versión sin SNAPSHOT y crea un tag en GIT
- Sube los jar al repositorio de paquetes
- Pone la nueva versión SNAPSHOT en los pom.xml
- Hace push a GitHub


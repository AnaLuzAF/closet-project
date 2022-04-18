package org.iesfm.closet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@SpringBootApplication
public class ApiMain {

    public static void main(String[] args) {
        SpringApplication.run(ApiMain.class, args);

        //crear la carpeta imagenes y una vez creada comprobar si existe un usuario, y si existe crear su carpeta.
        //para comprobar si un user existe hago un select name from user where id :=id; llamada a JDBuserDAO


    }

}

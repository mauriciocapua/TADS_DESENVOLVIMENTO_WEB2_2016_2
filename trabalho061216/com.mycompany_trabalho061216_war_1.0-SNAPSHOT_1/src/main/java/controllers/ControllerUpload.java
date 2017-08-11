package controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application file upload requests
 */
@Controller
@RequestMapping("arquivo")
public class ControllerUpload {

    @RequestMapping("tela")
    public String chamaTelaDeUpload() {
        return "arquivo/tela";
    }

    @RequestMapping("/teste")
    public String foto() {
        return "arquivo/mostrarFoto";
    }

    @RequestMapping("/enviar")
    public String uploadFileHandler(
            @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Diretorio...
                String diretorio = "D:/Meus Documentos/Ifrs/NetBeansProjects/TADS_HOMEWORK/Desenvolvimento Web II/trabalho061216/com.mycompany_trabalho061216_war_1.0-SNAPSHOT_1/src/main/webapp/resources/img";

                File dir = new File(diretorio);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Cria arquivo
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + "02.jpg");
                //grava

                System.out.println(serverFile.getAbsolutePath());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                return "arquivo/mostrarFoto";
            } catch (Exception e) {
                return "Falha em upload  => " + e.getMessage();
            }
        } else {
            return "Sem arquivo ";
        }
    }
}

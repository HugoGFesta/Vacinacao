package Serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Backend.Sistema;

public class Serializacao {

    private final File ficheiro;

    public Serializacao(String ficheiro) {
        this.ficheiro = new File(ficheiro);
    }

    public File getFicheiro() {
        return ficheiro;
    }

    public Sistema carregar() {
        try ( FileInputStream fileInput = new FileInputStream(ficheiro);  ObjectInputStream input = new ObjectInputStream(fileInput)) {
            Sistema sistema = (Sistema) input.readObject();
            return sistema;
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(String.format("Erro ao carregar o ficheiro", ex.getLocalizedMessage()), ex);
        }
    }

    public void guardar(Sistema sistema) {
        try ( FileOutputStream fileOut = new FileOutputStream(ficheiro);  ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            try {
                out.writeObject(sistema);
            } catch (IOException ex) {
                throw new RuntimeException(String.format("Erro ao guardar o ficheiro", ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Erro ao guardar o ficheiro", ex.getLocalizedMessage()), ex);
        }
    }
}

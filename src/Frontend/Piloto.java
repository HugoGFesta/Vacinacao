package Frontend;

import Backend.Sistema;
import Serialize.Serializacao;

public class Piloto {      
    
    public static void main(String[] args) throws Excecoes.UserJaExisteException {
        Sistema sistema;        
        String ficheiroDados = String.format("%s\\utilizadores.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao bd = new Serializacao(ficheiroDados);        
        
        //Se o ficheiro de base de dados nao existir
        if (! bd.getFicheiro().exists()) {
            //Cria uma instancia do sistema
            sistema = new Sistema();      
            //Adiciona dois utilizadores para que possa ser possivel entrar no sistema
            sistema.iniciar();                    
        }else{
            sistema = bd.carregar();            
        }
        
        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        JanelaLogin login = new JanelaLogin(sistema, bd);               
        login.setVisible(true);
        
    }          
    
}

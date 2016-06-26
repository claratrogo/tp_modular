/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_modular;
import java.io.IOException;
/**
 *
 * @author clara
 */
public interface Arquivo {
    public void LerArquivo() throws IOException;
    public void EscreverArquivo(String path) throws IOException;
}

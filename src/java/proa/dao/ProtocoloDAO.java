/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proa.dao;

import java.util.List;
import proa.model.Protocolo;

/**
 *
 * @author Administrador
 */
public interface ProtocoloDAO {

        public List<Protocolo> listarProtocolo();

        public void cadastrarProtocolo(Protocolo protocolo);
}

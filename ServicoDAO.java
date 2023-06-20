/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Servicos;

//Cria��o da conex�o dentro da classe Servico, aqui poder�amos estar com acesso a cadastro de servi�os
public class ServicoDAO {
    public void create(Servicos servicos) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("INSERT INTO servicos (nomeServico,precoServico)VALUES(?,?)");
          stmt.setString(1,servicos.getNomeServico());
          stmt.setDouble(2,servicos.getPrecoServico());
       
          
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
      }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
      
    }
    //Cria��o da classe que nos possibilitaria ler ou consultar um servi�o que j� foi criado   
    public List<Servicos> read() throws SQLException{
          Connection con = ConnectionFactory.getConnection();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Servicos> servico = new ArrayList<>();
          
         try{
          stmt = con.prepareStatement("SELECT * FROM servicos");
          rs = stmt.executeQuery();
          while(rs.next()){
            Servicos servicos = new Servicos();
            servicos.setNomeServico(rs.getString("nomeServico"));
            servicos.setPrecoServico(rs.getDouble("precoServico"));
      
          }
         }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na leitura " + ex);
        }finally{
             ConnectionFactory.closeConnection(con, stmt, rs);
         }
         
        return servico;
    }
    // Fun��o que nos possibilitaria atualizar algum servi�o que j� foi criado   
    public void update(Servicos servicos) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("UPDATE pessoa SET nomeServico = ?, precoServico = ?, WHERE id = ?");
          stmt.setString(1,servicos.getNomeServico());
          stmt.setDouble(2,servicos.getPrecoServico());
         
         
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
      }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
      
    }
     //Fun��o que possibilita deletar um servi�o que j� foi criado
    public void delete(Servicos servicos) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("DELETE WHERE id = ?");
          stmt.setInt(1,servicos.getIdServico());
          
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Excluido com sucesso!!");
      }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluir " + ex);
        }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
      
    }
    
}


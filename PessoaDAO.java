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
import modelos.Pessoa;
//Criação da conexão dentro da classe Pessoa, aqui poderíamos estar com acesso a cadastro de pessoas
public class PessoaDAO {
    public void create(Pessoa pessoa) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("INSERT INTO pessoa(nome,endereco,telefone) VALUES(?,?,?)");
          stmt.setString(1,pessoa.getNome());
          stmt.setString(2,pessoa.getEndereco());
          stmt.setString(3,pessoa.getTelefone());
         
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
      }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
      
    }
   //Criação da classe que nos possibilitaria ler ou consultar uma pessoa que já foi criada   
    public List<Pessoa> read() throws SQLException{
          Connection con = ConnectionFactory.getConnection();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Pessoa> pessoas = new ArrayList<>();
          
         try{
          stmt = con.prepareStatement("SELECT * FROM pessoa");
          rs = stmt.executeQuery();
          while(rs.next()){
              Pessoa pessoa = new Pessoa();
              pessoa.setNome(rs.getString("nome"));
              pessoa.setEndereco(rs.getString("endereco"));
              pessoa.setTelefone(rs.getString("telefone"));
              pessoas.add(pessoa);
     
          }
         }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na leitura " + ex);
        }finally{
             ConnectionFactory.closeConnection(con, stmt, rs);
         }
         
         return pessoas;
    }
    // Função que nos possibilitaria atualizar alguma pessoa que já foi criada  
    public void update(Pessoa pessoa) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("UPDATE pessoa SET nome = ?, endereco = ?, telefone = ? WHERE id = ?");
          stmt.setString(1,pessoa.getNome());
          stmt.setString(2,pessoa.getEndereco());
          stmt.setString(3,pessoa.getTelefone());
         
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
      }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
      
    }
     //Função que possibilita deletar uma pessoa que já foi criada
    public void delete(Pessoa pessoa) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("DELETE WHERE id = ?");
          stmt.setInt(1,pessoa.getId_Pessoa());
          
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

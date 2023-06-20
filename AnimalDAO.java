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
import modelos.Animal;


//Criação da conexão dentro da classe Animal, aqui poderíamos estar com acesso a cadastro de animais
public class AnimalDAO {
    public void create(Animal animal) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("INSERT INTO pets (idade,especie_animal,altura_animal,peso_animal,sexo_animal,raca_animal)VALUES(?,?,?,?,?,?)");
          stmt.setInt(1,animal.getIdadeAnimal());
          stmt.setInt(2,animal.getEspecieAnimal());
          stmt.setDouble(3,animal.getAlturaAnimal());
          stmt.setDouble(4,animal.getPesoAnimal());
          stmt.setInt(5,animal.getSexoAnimal());
          stmt.setInt(6,animal.getRacaAnimal());
          
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
      }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
      
    }
    
    
 //Criação da classe que nos possibilitaria ler ou consultar um animal que já foi criado   
    public List<Animal> read() throws SQLException{
          Connection con = ConnectionFactory.getConnection();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Animal> animais = new ArrayList<>();
          
         try{
          stmt = con.prepareStatement("SELECT * FROM pets");
          rs = stmt.executeQuery();
          while(rs.next()){
              Animal animal = new Animal();
              animal.setIdAnimal(rs.getInt("id"));
              animal.setIdadeAnimal(rs.getInt("idade"));
              animal.setEspecieAnimal(rs.getInt("especie_animal"));
              animal.setAlturaAnimal(rs.getDouble("altura_animal"));
              animal.setPesoAnimal(rs.getDouble("peso_animal"));
              animal.setSexoAnimal(rs.getInt("sexo_animal"));
              animal.setRacaAnimal(rs.getInt("raca_animal"));
              animais.add(animal);
              
              
          }
         }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na leitura " + ex);
        }finally{
             ConnectionFactory.closeConnection(con, stmt, rs);
         }
         
         return animais;
    }
 // Função que nos possibilitaria atualizar algum animal que já foi criado   
    public void update(Animal animal) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("UPDATE pets SET idade = ?, especie_animal = ?, altura_animal = ?, peso_animal = ?, sexo_animal = ?, raca_animal = ? WHERE id = ? ");
          stmt.setInt(1,animal.getIdadeAnimal());
          stmt.setInt(2,animal.getEspecieAnimal());
          stmt.setDouble(3,animal.getAlturaAnimal());
          stmt.setDouble(4,animal.getPesoAnimal());
          stmt.setInt(5,animal.getSexoAnimal());
          stmt.setInt(6,animal.getRacaAnimal());
          stmt.setInt(7,animal.getIdAnimal());
          
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
      }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
        }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
      
    }
    //Função que possibilita deletar um animal que já foi criado
    public void delete(Animal animal) throws SQLException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
          stmt = con.prepareStatement("DELETE WHERE id = ?");
          stmt.setInt(1,animal.getIdAnimal());
          
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

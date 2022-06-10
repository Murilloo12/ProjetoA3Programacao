
package model.dao;

import connection.Conexao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Clientes;


public class ClienteDAO {
    
    public void creat(Clientes c){
        
        Connection con = Conexao.iniciarConexao();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement
            ("INSERT INTO clientes (nome,cpf,email,senha,endereco,telefone)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getSenha());
            stmt.setString(5, c.getEndereco());
            stmt.setInt(6, c.getTelefone());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
    }
    
    
    public List<Clientes> read (){
        
       
            Connection con = Conexao.iniciarConexao();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Clientes> clientes = new ArrayList<>();
            
            try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes cliente = new Clientes();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getInt("telefone"));
                clientes.add(cliente);
                
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                Conexao.fecharConexao();
        }
            
            return clientes;
    }
    
    public void update(Clientes c){
        
        Connection con = Conexao.iniciarConexao();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement
            ("UPDATE clientes SET nome=?,cpf=?,email=?,senha=?,endereco=?,telefone=? WHERE id = ?");
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getSenha());
            stmt.setString(5, c.getEndereco());
            stmt.setInt(6, c.getTelefone());
            stmt.setInt(7, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
    }
    
    public void delete(Clientes c){
        
        Connection con = Conexao.iniciarConexao();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement
            ("DELETE FROM clientes WHERE id = ?");
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!"+ex);
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
    }
}

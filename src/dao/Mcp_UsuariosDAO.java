/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.McpUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class Mcp_UsuariosDAO extends AbstractDAO{
    
    

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpUsuarios.class);
        criteria.add(Restrictions.eq("mcpIdUsuario", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }
    public McpUsuarios autenticar(String apelido, String senha) {
    session.beginTransaction();
    try {
        Criteria criteria = session.createCriteria(McpUsuarios.class);
        criteria.add(Restrictions.eq("mcpApelido", apelido));
        criteria.add(Restrictions.eq("mcpSenha", senha));
        criteria.add(Restrictions.eq("mcpAtivo", "S")); 
        
        List<McpUsuarios> lista = criteria.list();
        session.getTransaction().commit();
        
        if (lista != null && !lista.isEmpty()) {
            return lista.get(0);
        } else {
            return null;
        }
    } catch (Exception e) {
        session.getTransaction().rollback();
        return null;
    }
}

    public static void main(String[] args) {
        Mcp_UsuariosDAO usuariosDAO = new Mcp_UsuariosDAO();
        usuariosDAO.listAll();
    }
}

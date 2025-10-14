/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.McpCupons;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class Mcp_CuponsDAO extends AbstractDAO{

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
        Criteria criteria = session.createCriteria(McpCupons.class);
        criteria.add(Restrictions.eq("idcupons", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpCupons.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        Mcp_CuponsDAO cuponsDAO = new Mcp_CuponsDAO();
        cuponsDAO.listAll();
    }
}

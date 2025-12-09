package dao;

import bean.McpVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class Mcp_VendasDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(McpVendas.class);
        criteria.add(Restrictions.eq("mcpIdVenda", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    public Object listForm(String forma) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendas.class);
        criteria.add(Restrictions.like("mcpFormaPagamento", "%" + forma + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listTotal(String total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendas.class);
        criteria.add(Restrictions.like("mcpTotal", "%" + total + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }


    public Object listFormTotal(String forma, String total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendas.class);
        criteria.add(Restrictions.like("mcpFormaPagamento", "%" + forma + "%"));
        criteria.add(Restrictions.like("mcpTotal", "%" + total + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }
}

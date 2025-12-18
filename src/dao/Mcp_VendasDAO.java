package dao;

import bean.McpClientes;
import bean.McpVendas;
import java.util.ArrayList;
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

    public Object listClientesCbo(McpClientes cliente) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendas.class);
        criteria.add(Restrictions.eq("mcpClientes", cliente));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listTotal(String totalStr) {
        double total;
        try {
            total = Double.parseDouble(totalStr);
        } catch (NumberFormatException e) {
            return new ArrayList();
        }
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendas.class);
        criteria.add(Restrictions.eq("mcpTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listClienteTotal(McpClientes cliente, String totalStr) {
        double total;
        try {
            total = Double.parseDouble(totalStr);
        } catch (NumberFormatException e) {
            return new ArrayList();
        }
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendas.class);
        criteria.add(Restrictions.eq("mcpClientes", cliente));
        criteria.add(Restrictions.eq("mcpTotal", total));
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

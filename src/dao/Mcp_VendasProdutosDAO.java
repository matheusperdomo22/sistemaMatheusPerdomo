package dao;

import bean.McpVendas;
import bean.McpVendasProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class Mcp_VendasProdutosDAO extends AbstractDAO {

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
    public void deleteProdutos(McpVendas vendas) {
        List lista = (List) listProdutos(vendas); 
        session.beginTransaction();
        for (int i = 0; i < lista.size(); i++) {
            McpVendasProdutos vendasProdutos = (McpVendasProdutos) lista.get(i);
            session.flush();
            session.clear();
            session.delete(vendasProdutos);
        }
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendasProdutos.class);
        criteria.add(Restrictions.eq("mcpIdVendaProduto", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    
    public Object listProdutos(McpVendas venda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendasProdutos.class);
        criteria.add(Restrictions.eq("mcpVendas", venda));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(McpVendasProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }
}
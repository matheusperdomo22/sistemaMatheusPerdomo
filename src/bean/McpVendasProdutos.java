package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mcp_vendas_produtos", catalog="vendas")
public class McpVendasProdutos implements java.io.Serializable {

    private Integer mcpIdVendaProduto;
    private McpProdutos mcpProdutos;
    private McpVendas mcpVendas;
    private Integer mcpQuantidade;
    private Double mcpValorUnitario;

    public McpVendasProdutos() {
    }

    public McpVendasProdutos(McpProdutos mcpProdutos, McpVendas mcpVendas, 
                            Integer mcpQuantidade, Double mcpValorUnitario) {
        this.mcpProdutos = mcpProdutos;
        this.mcpVendas = mcpVendas;
        this.mcpQuantidade = mcpQuantidade;
        this.mcpValorUnitario = mcpValorUnitario;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="mcp_idVendaProduto", unique=true, nullable=false)
    public Integer getMcpIdVendaProduto() {
        return this.mcpIdVendaProduto;
    }
    
    public void setMcpIdVendaProduto(Integer mcpIdVendaProduto) {
        this.mcpIdVendaProduto = mcpIdVendaProduto;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="mcp_idProduto")
    public McpProdutos getMcpProdutos() {
        return this.mcpProdutos;
    }
    
    public void setMcpProdutos(McpProdutos mcpProdutos) {
        this.mcpProdutos = mcpProdutos;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="mcp_idVenda")
    public McpVendas getMcpVendas() {
        return this.mcpVendas;
    }
    
    public void setMcpVendas(McpVendas mcpVendas) {
        this.mcpVendas = mcpVendas;
    }

    @Column(name="mcp_quantidade")
    public Integer getMcpQuantidade() {
        return this.mcpQuantidade;
    }
    
    public void setMcpQuantidade(Integer mcpQuantidade) {
        this.mcpQuantidade = mcpQuantidade;
    }

    @Column(name="mcp_valorUnitario", precision=10)
    public Double getMcpValorUnitario() {
        return this.mcpValorUnitario;
    }
    
    public void setMcpValorUnitario(Double mcpValorUnitario) {
        this.mcpValorUnitario = mcpValorUnitario;
    }
}
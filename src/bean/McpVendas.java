package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="mcp_vendas", catalog="vendas")
public class McpVendas implements java.io.Serializable {

    private Integer mcpIdVenda;
    private McpClientes mcpClientes;
    private McpCupons mcpCupons;
    private Date mcpDataVenda;
    private Double mcpTotal;
    private String mcpFormaPagamento;
    private String mcpObservacoes;

    public McpVendas() {
    }

    public McpVendas(McpClientes mcpClientes, McpCupons mcpCupons, Date mcpDataVenda, 
                    Double mcpTotal, String mcpFormaPagamento, String mcpObservacoes) {
        this.mcpClientes = mcpClientes;
        this.mcpCupons = mcpCupons;
        this.mcpDataVenda = mcpDataVenda;
        this.mcpTotal = mcpTotal;
        this.mcpFormaPagamento = mcpFormaPagamento;
        this.mcpObservacoes = mcpObservacoes;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="mcp_idVenda", unique=true, nullable=false)
    public Integer getMcpIdVenda() {
        return this.mcpIdVenda;
    }
    
    public void setMcpIdVenda(Integer mcpIdVenda) {
        this.mcpIdVenda = mcpIdVenda;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mcp_idCliente")
    public McpClientes getMcpClientes() {
        return this.mcpClientes;
    }
    
    public void setMcpClientes(McpClientes mcpClientes) {
        this.mcpClientes = mcpClientes;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mcp_idCupom")
    public McpCupons getMcpCupons() {
        return this.mcpCupons;
    }
    
    public void setMcpCupons(McpCupons mcpCupons) {
        this.mcpCupons = mcpCupons;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="mcp_dataVenda", length=10)
    public Date getMcpDataVenda() {
        return this.mcpDataVenda;
    }
    
    public void setMcpDataVenda(Date mcpDataVenda) {
        this.mcpDataVenda = mcpDataVenda;
    }

    @Column(name="mcp_total", precision=10)
    public Double getMcpTotal() {
        return this.mcpTotal;
    }
    
    public void setMcpTotal(Double mcpTotal) {
        this.mcpTotal = mcpTotal;
    }

    @Column(name="mcp_formaPagamento", length=20)
    public String getMcpFormaPagamento() {
        return this.mcpFormaPagamento;
    }
    
    public void setMcpFormaPagamento(String mcpFormaPagamento) {
        this.mcpFormaPagamento = mcpFormaPagamento;
    }

    @Column(name="mcp_observacoes", length=100)
    public String getMcpObservacoes() {
        return this.mcpObservacoes;
    }
    
    public void setMcpObservacoes(String mcpObservacoes) {
        this.mcpObservacoes = mcpObservacoes;
    }
}
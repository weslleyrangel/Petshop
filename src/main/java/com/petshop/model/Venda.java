package com.petshop.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusVenda status;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemVenda> itens = new ArrayList<>();

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public Date getDataHora() { return dataHora; }
    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public StatusVenda getStatus() { return status; }
    public void setStatus(StatusVenda status) { this.status = status; }

    public List<ItemVenda> getItens() { return itens; }
    public void setItens(List<ItemVenda> itens) { this.itens = itens; }

    public void adicionarItem(ItemVenda item) {
        item.setVenda(this);
        this.itens.add(item);
        this.recalcularTotal();
    }

    public void recalcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemVenda item : itens) {
            total = total.add(item.getSubtotal());
        }
        this.valorTotal = total;
    }
}
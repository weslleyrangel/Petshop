package com.petshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(max = 100, message = "O nome do produto deve ter no máximo 100 caracteres")
    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Positive(message = "O preço deve ser um valor positivo")
    @Column(nullable = false)
    private BigDecimal preco;

    @PositiveOrZero(message = "A quantidade em estoque deve ser um valor positivo ou zero")
    @Column(nullable = false)
    private int quantidadeEstoque;

    @Column
    private String categoria;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean temEstoqueSuficiente(int quantidade) {
        return this.quantidadeEstoque >= quantidade;
    }

    public void diminuirEstoque(int quantidade) {
        if (temEstoqueSuficiente(quantidade)) {
            this.quantidadeEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Estoque insuficiente");
        }
    }
}
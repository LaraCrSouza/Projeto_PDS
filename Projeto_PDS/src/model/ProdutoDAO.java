
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // CREATE - Adicionar um novo usuário
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produto (codigo, nome, URL, Marca, Categorias, PesoBruto, altura, largura, comprimento, preco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setInt(2, produto.getCodigo());
            pstm.setString(3, produto.getURL());
            pstm.setString(4, produto.getMarca());
            pstm.setString(5, produto.getCategorias());
            pstm.setFloat(6, produto.getPesoBruto());
            pstm.setFloat(7, produto.getAltura());
            pstm.setFloat(8, produto.getLargura());
            pstm.setFloat(9, produto.getComprimento());
            pstm.setDouble(10, produto.getPreco());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // READ - Listar todos os usuários
    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produto";
        List<Produto> produto = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Produto produtos = new Produto();
                produtos.setURL(rset.getString("URL"));
                produtos.setNome(rset.getString("nome"));
                produtos.setMarca(rset.getString("Marca"));
                produtos.setCategorias(rset.getString("Categorias"));
                produtos.setPesoBruto(rset.getFloat("PesoBruto"));
                produtos.setAltura(rset.getFloat("Altura"));
                produtos.setComprimento(rset.getFloat("comprimento"));
                produtos.setPreco(rset.getDouble("preco"));
                produtos.add(produto);
//                codigo, String nome, String URL, String Marca, String Categorias, int PesoBruto, int altura, int largura, int comprimento, double preco
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return produto;
    }

    // UPDATE - Atualizar um usuário existente
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, URL= ?, Marca = ?, Categorias = ?, PesoBruto = ?, Altura = ?, comprimento = ?, preco = ?, WHERE codigo = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getURL());
            pstm.setString(3, produto.getMarca());
            pstm.setString(3, produto.getCategorias());
            pstm.setFloat(3, produto.getPesoBruto());
            pstm.setFloat(3, produto.getAltura());
            pstm.setFloat(3, produto.getComprimento());
            pstm.setDouble(3, produto.getPreco());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }

    public void excluirProduto(int codigo) {
        String sql = "DELETE FROM produto WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, codigo);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.BancoDeDados;

public class ProdutoDAO {

    // CREATE - Adicionar um novo usuário
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (codigo, nome, URL, Marca, Categorias, PesoBruto, altura, largura, comprimento, preco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Produto produto = new Produto();
                produto.setURL(rset.getString("URL"));
                produto.setNome(rset.getString("nome"));
                produto.setMarca(rset.getString("Marca"));
                produto.setCategorias(rset.getString("Categorias"));
                produto.setPesoBruto(rset.getFloat("PesoBruto"));
                produto.setAltura(rset.getFloat("Altura"));
                produto.setComprimento(rset.getFloat("comprimento"));
                produto.setPreco(rset.getDouble("preco"));
                produtos.add(produto);
//                codigo, String nome, String URL, String Marca, String Categorias, int PesoBruto, int altura, int largura, int comprimento, double preco
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return produtos;
    }

    // UPDATE - Atualizar um usuário existente
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE usuarios SET nome = ?, URL= ?, Marca = ?, Categorias = ?, PesoBruto = ?, Altura = ?, comprimento = ?, preco = ?, WHERE codigo = ?";
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

    // DELETE - Excluir um usuário pelo ID
    public void excluirProduto(int codigo) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
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


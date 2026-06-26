package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Navegador;

public class CarrinhoDAO {

    private Navegador navegador;

    public CarrinhoDAO(Navegador navegador) {
        this.navegador = navegador;
    }

    public void adicionarProduto(String codigo) {
        String sql = "INSERT INTO carrinho (usuario_id, codigo, quantidade) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, navegador.getUsuarioLogadoId());
            pstm.setString(2, codigo);
            pstm.setInt(3, 1);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

    public List<Produto> listarCarrinho(ProdutoDAO produtoDAO) {
        String sql = "SELECT codigo FROM carrinho WHERE usuario_id = ?";
        List<Produto> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, navegador.getUsuarioLogadoId()); 
            rset = pstm.executeQuery();

            while (rset.next()) {
                Produto p = produtoDAO.buscarPorCodigo(rset.getString("codigo"));
                if (p != null) lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return lista;
    }

    public void removerProduto(String codigo) {
       
        String sql = "DELETE FROM carrinho WHERE usuario_id = ? AND codigo = ? LIMIT 1";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, navegador.getUsuarioLogadoId());
            pstm.setString(2, codigo);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

    public void limparCarrinho() {
        String sql = "DELETE FROM carrinho WHERE usuario_id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, navegador.getUsuarioLogadoId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}
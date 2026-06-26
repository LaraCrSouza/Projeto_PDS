
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

	public void adicionarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (codigo, nome, URL, marca, categorias, PesoBruto, altura, largura, comprimento, preco, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, produto.getCodigo());
			pstm.setString(2, produto.getNome());
			pstm.setString(3, produto.getURL());
			pstm.setString(4, produto.getMarca());
			pstm.setString(5, produto.getCategorias());
			pstm.setFloat(6, produto.getPesoBruto());
			pstm.setFloat(7, produto.getAltura());
			pstm.setFloat(8, produto.getLargura());
			pstm.setFloat(9, produto.getComprimento());
			pstm.setDouble(10, produto.getPreco());
			pstm.setInt(11, produto.getQuantidade());

			pstm.executeUpdate();

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

	public List<Produto> listarProduto() {
		String sql = "SELECT * FROM produto";
		List<Produto> listaProduto = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Produto produto = new Produto();
				produto.setURL(rset.getString("URL"));
				produto.setNome(rset.getString("nome"));
				produto.setMarca(rset.getString("marca"));
				produto.setCategorias(rset.getString("categorias"));
				produto.setPesoBruto(rset.getFloat("PesoBruto"));
				produto.setAltura(rset.getFloat("altura"));
				produto.setComprimento(rset.getFloat("comprimento"));
				produto.setPreco(rset.getDouble("preco"));
				produto.setQuantidade(rset.getInt("quantidade"));
				produto.setCodigo(rset.getString("codigo"));
				produto.setLargura(rset.getFloat("largura"));
				listaProduto.add(produto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);

		}
		return listaProduto;
	}

	public void atualizarProduto(Produto produto, String codigoOriginal) {
		String sql = "UPDATE produto SET nome = ?, URL= ?, marca = ?, categorias = ?, PesoBruto = ?, altura = ?, comprimento = ?, largura = ?, preco = ?, quantidade =?, codigo = ? WHERE codigo = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getURL());
			pstm.setString(3, produto.getMarca());
			pstm.setString(4, produto.getCategorias());
			pstm.setFloat(5, produto.getPesoBruto());
			pstm.setFloat(6, produto.getAltura());
			pstm.setFloat(7, produto.getComprimento());
			pstm.setFloat(8, produto.getLargura());
			pstm.setDouble(9, produto.getPreco());
			pstm.setDouble(10, produto.getQuantidade());
			pstm.setString(11, produto.getCodigo());
			pstm.setString(12, codigoOriginal);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	public void excluirProduto(String codigo) {
		String sql = "DELETE FROM produto WHERE codigo = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, codigo);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	public Produto buscarPorCodigo(String codigo) {
		String sql = "SELECT * FROM produto WHERE codigo = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Produto produto = null;
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, codigo);
			rset = pstm.executeQuery();
			if (rset.next()) {
				produto = new Produto();
				produto.setCodigo(rset.getString("codigo"));
				produto.setNome(rset.getString("nome"));
				produto.setURL(rset.getString("URL"));
				produto.setMarca(rset.getString("marca"));
				produto.setCategorias(rset.getString("categorias"));
				produto.setPesoBruto(rset.getFloat("PesoBruto"));
				produto.setAltura(rset.getFloat("altura"));
				produto.setLargura(rset.getFloat("largura"));
				produto.setComprimento(rset.getFloat("comprimento"));
				produto.setPreco(rset.getDouble("preco"));
				produto.setQuantidade(rset.getInt("quantidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
		return produto;
	}
}

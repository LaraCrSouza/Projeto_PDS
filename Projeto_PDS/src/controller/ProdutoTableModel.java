package controller;

import javax.swing.table.AbstractTableModel;

import model.Produto;

import java.util.List;

public class ProdutoTableModel extends AbstractTableModel {

	private final List<Produto> dados;
	private final String[] colunas = { "Nome", "Marca", "Categorias", "URL", "Altura", "Codigo", "Comprimento",
			"Largura", "PesoBruto", "Altura", "Preco" };

	public ProdutoTableModel(List<Produto> dados) {
		this.dados = dados;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Produto p = dados.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getNome();
		case 1:
			return p.getMarca();
		case 2:
			return p.getCategorias();
		case 3:
			return p.getURL();
		case 4:
			return p.getAltura();
		case 5:
			return p.getCodigo();
		case 6:
			return p.getComprimento();
		case 7:
			return p.getLargura();
		case 8:
			return p.getPesoBruto();
		case 9:
			return p.getAltura();
		case 10:
			return p.getPreco();

		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}

	}

}

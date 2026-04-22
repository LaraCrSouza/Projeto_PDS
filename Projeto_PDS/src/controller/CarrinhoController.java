package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import view.TelaCarrinho;

public class CarrinhoController {

    private TelaCarrinho telaCarrinho;
    private List<Produto> carrinho;
    private Navegador navegador;

    public CarrinhoController(TelaCarrinho telaCarrinho, List<Produto> carrinho, Navegador navegador) {
        this.telaCarrinho = telaCarrinho;
        this.carrinho = carrinho;
        this.navegador = navegador;

        this.telaCarrinho.excluirProduto(e -> {
            excluirProduto();
        });
        
        this.telaCarrinho.concluirCompra(e -> {
        	concluirCompra();
        });
        this.telaCarrinho.VoltarCompras(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        navegador.navegarPara("COMPRAS");
		    
		    }
		});
    }

    public void atualizarTela() {
        telaCarrinho.preencherTabela(carrinho);
        telaCarrinho.atualizarTotal(calcularTotal());
    }

    private void excluirProduto() {
        int linha = telaCarrinho.getLinhaSelecionada();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            carrinho.remove(linha); // remove direto pelo índice da linha
            atualizarTela();
        }
    }
     
    private double calcularTotal() {
        double total = 0;
        for (Produto p : carrinho) {
            total += p.getPreco();
        }
        return total;
    }
    private void concluirCompra() {
    	navegador.navegarPara("FINALIZAR COMPRA");
    }
}
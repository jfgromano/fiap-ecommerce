package br.com.fiap.postech.pagamento.aplicacao;

import br.com.fiap.postech.pagamento.dominio.dto.PedidoDto;
import br.com.fiap.postech.pagamento.dominio.entidade.Cartao;
import br.com.fiap.postech.pagamento.dominio.entidade.Pagamento;
import br.com.fiap.postech.pagamento.dominio.gateway.NotificarErroPagamentoGateway;
import br.com.fiap.postech.pagamento.dominio.gateway.NotificarSucessoPagamentoGateway;
import br.com.fiap.postech.pagamento.dominio.repositorio.CartaoRepository;
import br.com.fiap.postech.pagamento.dominio.repositorio.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RealizarPagamento {
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private NotificarSucessoPagamentoGateway notificarSucessoPagamentoGateway;
    @Autowired
    private NotificarErroPagamentoGateway notificarErroPagamentoGateway;
    @Autowired
    private CartaoRepository cartaoRepository;

    public void executa(PedidoDto pedido) {
        Optional<Cartao> cartao = cartaoRepository.buscarPorId(pedido.idCartao());

        //Para simular sucesso e falha estou mantendo a condicao de que
        // qualquer cartao de credito ira resultar em erro
        if(cartao.isEmpty() || cartao.get().isCredito()) {
            notificarErroPagamentoGateway.executa(pedido);
            return;
        }

        try {
            Pagamento pagamento = new Pagamento(
                    pedido.idPedido(),
                    cartao.get().getIdUsuario(),
                    pedido.valorTotal()
            );
            pagamentoRepository.salvar(pagamento);
            notificarSucessoPagamentoGateway.executa(pedido);
        }catch (Exception e) {
            e.printStackTrace();
            notificarErroPagamentoGateway.executa(pedido);
        }
    }
}

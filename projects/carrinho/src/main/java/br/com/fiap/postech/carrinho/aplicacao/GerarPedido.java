package br.com.fiap.postech.carrinho.aplicacao;

import br.com.fiap.postech.carrinho.dominio.dto.*;
import br.com.fiap.postech.carrinho.dominio.entidade.*;
import br.com.fiap.postech.carrinho.dominio.gateway.IniciarProcessamentoPedido;
import br.com.fiap.postech.carrinho.dominio.gateway.PagamentoGateway;
import br.com.fiap.postech.carrinho.dominio.repositorio.ItemPedidoRepository;
import br.com.fiap.postech.carrinho.dominio.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GerarPedido {
    @Autowired
    private ObterItensCarrinho obterItensCarrinho;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private IniciarProcessamentoPedido iniciarProcessamentoPedido;
    @Autowired
    private PagamentoGateway pagamentoGateway;

    @Transactional
    public Pedido executa(UsuarioDto usuarioDto, CartaoDto cartaoDto) {
        //salvar pedido
        Pedido pedido = Pedido.pendente(UUID.randomUUID());
        pedido.setIdUsuario(usuarioDto.getId());
        pedidoRepository.salvarAtualizar(pedido);

        //Gerar itens do pedido com base no carrinho
        List<ItemCarrinho> itensCarrinho = this.obterItensCarrinho.executa(usuarioDto);
        List<ItemPedido> itensPedido = ItemPedido.fromItensCarrinho(pedido.getId(), itensCarrinho);
        pedido.setItensPedido(itensPedido);
        itemPedidoRepository.salvarItens(itensPedido);

        //Obter token do cartao no servico de pagamentos
        UUID idCartao = pagamentoGateway.obterToken(usuarioDto.getToken(), cartaoDto);

        //Inicia verificação de estoque para o pedido
        BigDecimal valor = calcularValorPedido(itensCarrinho);
        List<ItensDoPedidoDto> itensDto = itensPedido.stream()
                .map(i -> new ItensDoPedidoDto(i.getIdItem(), i.getQuantidade()))
                .collect(Collectors.toList());

        PedidoDto pedidoDto = new PedidoDto(pedido.getId(), idCartao, valor, itensDto);
        iniciarProcessamentoPedido.executa(pedidoDto);

        return pedido;
    }

    private BigDecimal calcularValorPedido(List<ItemCarrinho> itens) {
        BigDecimal valor = BigDecimal.ZERO;
        for(ItemCarrinho i : itens) {
            BigDecimal quantidade = BigDecimal.valueOf(i.getQuantidade());
            valor = valor.add(quantidade.multiply(i.getValorUnitario()));
        }
        return valor;
    }
}

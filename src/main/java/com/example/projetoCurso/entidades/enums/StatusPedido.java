package com.example.projetoCurso.entidades.enums;

public enum StatusPedido {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusPedido valor(int codigo) {
		for (StatusPedido a: StatusPedido.values()) {
			if (a.getCodigo() == codigo) {
				return a;
			}
		}
		throw new IllegalArgumentException(
				"Codigo invalido para status do pedido");
	}
}

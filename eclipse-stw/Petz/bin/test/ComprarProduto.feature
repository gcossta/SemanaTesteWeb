#language: pt

Funcionalidade: Comprar Produto
		# Fluxo de compras no site Petz
		# Envolve as páginas Home, Resultado da Consulta e Detalhes Paginas
		
		Cenario: Compra a partir de uma busca
		Dado que acesso o site Petz
		Quando busco por "coleira" e pressiono Enter
		Entao exibe uma lista de produtos relacionado com "coleira"
		Quando escolho "Coleira Petz Azul para Cães"
		Entao exibe para o "Tamanho P" o preco de "R$ 39,99"
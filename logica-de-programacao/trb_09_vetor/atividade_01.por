//Atividade 01
//Criar um vetor de 5 elementos
//Exibir os valores digitados

programa
{
	const inteiro tamanho = 5
	inteiro vetor[tamanho]
	
	funcao inicio()
	{
		para(inteiro passo = 0; passo < tamanho; passo++){

			inteiro valor

			escreva("Digite um valor: ")
			leia(valor)

			vetor[passo] = valor
			
		}
		para(inteiro passo = 0; passo < tamanho; passo++){
			escreva(vetor[passo])
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 76; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 8, 9, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
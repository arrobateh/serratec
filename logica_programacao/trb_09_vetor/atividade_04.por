//Atividade 04
//Criar um vetor de 6 numeros inteiros
//Pedir ao usuario para digitar os valores
//Contar quantos numeros sao pares e exibir o total

programa
{
	const inteiro tamanho = 6
	inteiro vetor[tamanho]
	
	funcao inicio()
	{
		inteiro pares = 0
		
		para(inteiro passo = 0; passo < tamanho; passo++){

			inteiro valor

			escreva("Digite um valor: ")
			leia(valor)

			vetor[passo] = valor

			se(valor % 2 == 0){
				pares = pares + 1
			}
		}
		escreva("\n",pares, " numeros digitados sao pares.\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 515; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {pares, 13, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
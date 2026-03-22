//Atividade 03
//Criar um vetor de 5 numeros inteiros
//Encontrar o maior valor em um vetor
//Pedir ao usuario para digitar os valores
//Exibir o maior numero do vetor

programa
{
	const inteiro tamanho = 5
	inteiro vetor[tamanho]
	
	funcao inicio()
	{
		inteiro num_maior = 0
		
		para(inteiro passo = 0; passo < tamanho; passo++){

			inteiro valor

			escreva("Digite um valor: ")
			leia(valor)

			vetor[passo] = valor

			se(valor > 0 e valor > num_maior){
				num_maior = valor
			}

			
		}
			escreva("\nO maior numero digitado e: ", num_maior, "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 563; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 10, 9, 5}-{num_maior, 14, 10, 9};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
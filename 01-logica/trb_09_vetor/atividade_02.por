//Atividade 02
//Criar um vetor de 5 numeros inteiros
//pedir ao usuario digitar os valores
//Somar os valores digitados e exibir o resultado

programa
{
	const inteiro tamanho = 5
	inteiro vetor[tamanho]
	inteiro resultado = 0
	
	funcao inicio()
	{
		para(inteiro passo = 0; passo < tamanho; passo++){

			inteiro valor

			escreva("Digite um valor: ")
			leia(valor)
			
			vetor[passo] = valor

			resultado = resultado + valor
		}
		escreva("A soma de todos os valores digitados e: ", resultado)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 511; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 9, 9, 5}-{resultado, 10, 9, 9};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
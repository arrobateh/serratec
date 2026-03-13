//Atividade 05
//Criar um vetor de 5 numeros inteiros
//Pedir ao usuario digitar os numeros
//Inverter a ordem dos numeros e exibir o vetor invertido

programa
{
	const inteiro tamanho = 5
	inteiro vetor[tamanho]
	inteiro vetor_invertido[tamanho]
	
	funcao inicio()
	{
		inteiro posicao = tamanho - 1
		
		para(inteiro passo = 0; passo < tamanho; passo++){

			inteiro valor
			inteiro num = tamanho

			escreva("Digite um valor: ")
			leia(valor)
			
			vetor[passo] = valor	

		}
		
		para(inteiro passo = 0; passo < tamanho; passo++){
			
			vetor_invertido[passo] = vetor[posicao]
			posicao = posicao - 1
			
			escreva("\t",vetor_invertido[passo])
			
		}
		
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 489; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
//Atividade 12
//Calculo de fatorial usando recursao

programa
{
	
	funcao inicio(){
		inteiro n

		escreva("Digite um numero: ")
		leia(n)
		escreva("Fatorial de ", n, " e = ", fatorial(n))
	}

	funcao inteiro fatorial(inteiro n){
		se( n == 1 ou n == 0){
			retorne 1
		}
		senao{
			retorne n * fatorial(n -1)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 180; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
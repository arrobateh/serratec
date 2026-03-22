programa
{
	inclua biblioteca Util --> u
	
	funcao inicio(){

		escreva("ESTAMOS NA ATIVIDADE 01 \n\n")
		atividade01()
		u.aguarde(2000)
		limpa()
		escreva("\n\nESTAMOS NA ATIVIDADE 02 \n\n")
		atividade02()
		u.aguarde(2000)
		limpa()
		escreva("\n\nESTAMOS NA ATIVIDADE 03 \n\n")
		atividade03()
		u.aguarde(2000)
		limpa()
		escreva("\n\nESTAMOS NA ATIVIDADE 04 \n\n")
		atividade04()
		u.aguarde(2000)
		limpa()
		escreva("\n\nESTAMOS NA ATIVIDADE 05 \n\n")
		atividade05()
		u.aguarde(2000)
		limpa()
	}




	
	funcao atividade01()
	{
		
		//Verificar se um numero e par ou impar
		
		inteiro numero
		
		escreva("Digite um numero: ")
		leia(numero)

		se(numero % 2 == 0){
			escreva("O numero ", numero, " e par!")
		}
		senao{
			escreva("O numero ", numero, " e impar!")
		}
	}

	funcao atividade02()
	{
		//Verificar se a pessoa e maior de idade

			inteiro idade

			escreva("Digite sua idade: ")
			leia(idade)

			se(idade > 18){
				escreva("Voce e maior de idade!")
			}
			senao{
				escreva("Voce e menor de idade!")
			}
	}
	
	funcao atividade03(){

		//Comparar dois numeros
		
		inteiro num_um
		inteiro num_dois

		escreva("Digite um numero: ")
		leia(num_um)

		escreva("Digite outro numero: ")
		leia(num_dois)

		se(num_um > num_dois){
			escreva("O numero maior e: ", num_um)
		}
		senao se(num_um < num_dois){
			escreva("O numero maior e: ", num_dois)
		}
		senao{
			escreva("Os numeros sao iguais!")
		}
	}

	funcao atividade04(){

		//Verificar se um aluno foi aprovado

		inteiro nota_final

		escreva("Digite sua nota: ")
		leia(nota_final)

		se(nota_final >= 7){
			escreva("Parabens! Voce foi aprovado(a)")
		}
		senao se(nota_final >= 5 e nota_final <= 6.9){
			escreva("Ops! Voce esta de recuperacao!")
		}
		senao{
			escreva("Voce esta reprovado(a)!")
		}
	}

	funcao atividade05(){

		//Atividade 05
		//Calculo de desconto

		real vlr_compra

		escreva("Digite o valor da compra: ")
		leia(vlr_compra)

		se(vlr_compra >= 100){
			escreva("Voce recebeu 10 % de desconto!\n")
			vlr_compra = vlr_compra - (vlr_compra / 10)
		}
		senao{
			vlr_compra = vlr_compra
		}

		escreva("O valor da compra e: ", vlr_compra)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 497; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
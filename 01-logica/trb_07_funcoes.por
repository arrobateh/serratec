programa{
	inclua biblioteca Util --> u
	inclua biblioteca Matematica --> m
	
	funcao inicio(){
		
		somar()
		quadrado()
		ehPar()
		calcularMedia()
		celsiusParaFahrenheit()

		limpa()
		escreva("FIM")
		u.aguarde(2000)
		limpa()
	}

	funcao logico verificacao(){

		//Faz a verificacao ao fim de cada atividade
		//Caso queira prosseguir para a proxima atividade, digite '1'
		
		inteiro opcao = 0

		enquanto(opcao != 1 e opcao != 2){
		
			escreva("SEGUIR PARA A PROXIMA ATIVIDADE? \n")
			escreva("1) SIM\n")
			escreva("2) NAO\n")
			escreva("DIGITE SUA OPCAO: ")
			leia(opcao)
			limpa()

			se(opcao != 1 e opcao != 2){
				escreva("OPCAO INVALIDA! ESCOLHA ENTRE AS OPCOES DISPONIVEIS.")
				u.aguarde(2000)
				limpa()
			}
		}
		
		se(opcao == 2){
			retorne verdadeiro
		}
		senao{
			retorne falso
		}
		
	}

	funcao somar(){

		//Faz a soma de dois numeros e exibe o resultado 
		
		logico continuar = verdadeiro

		enquanto(continuar){
			
			inteiro numUm
			inteiro numDois
			inteiro resultado

			escreva("ATIVIDADE 01")		//cabecalho
			escreva("\nCALCULAR A SOMA ENTRE DOIS NUMEROS\n\n")
			escreva("Digite um numero: ")
			leia(numUm)
			escreva("Digite outro numero: ")
			leia(numDois)

			resultado = numUm + numDois

			escreva("\n", numUm, " + ", numDois, " = ", resultado)

			u.aguarde(2000)
			limpa()

			continuar = verificacao()
			
		}
		
	}

	funcao quadrado(){

		//Faz o calculo de um numero ao quadrado

		logico continuar = verdadeiro

		
		enquanto(continuar){

			inteiro numUm
			inteiro resultado
			
			escreva("ATIVIDADE 02")		//Cabecalho
			escreva("\nCALCULAR O QUADRADO DE UM NUMERO\n\n")
			
			escreva("Digite um numero: ")
			leia(numUm)

			resultado = numUm * numUm
			escreva(numUm, "²", " = ", resultado)

			u.aguarde(2000)
			limpa()

			continuar = verificacao()
			
		}
		
	}

	funcao ehPar(){

		//Verifica se um numero e par ou impar

		logico continuar = verdadeiro

		enquanto(continuar){

			inteiro numUm
			inteiro resultado

			escreva("ATIVIDADE 03")		//Cabecalho
			escreva("\nVERIFICAR SE UM NUMERO E PAR OU IMPAR\n\n")
			
			escreva("Digite um numero: ")
			leia(numUm)

			resultado = numUm % 2

				se(resultado == 0){
				escreva("\nO numero ", numUm, " e par.\n")
				}
				senao{
				escreva("\nO numero ", numUm, " e impar.")
				}
				
			u.aguarde(2000)
			limpa()
			continuar = verificacao()
		}
		
	}

	funcao calcularMedia(){

		//Calcula e media de 3 notas e exibe o resultado

		logico continuar = verdadeiro

		enquanto(continuar){

			real notaUm
			real notaDois
			real notaTres
			real resultado

			escreva("ATIVIDADE 04")		//Cabecalho
			escreva("\nCALCULAR A MEDIA DE 3 NOTAS\n\n")
			
			escreva("Digite a primeira nota: ")
			leia(notaUm)
			escreva("Digite a segunda nota: ")
			leia(notaDois)
			escreva("Digite a terceira nota: ")
			leia(notaTres)

			resultado = ((notaUm + notaDois + notaTres) / 3)
			resultado = m.arredondar(resultado, 1)
			
			escreva("\nA media das notas e ", resultado)

			u.aguarde(2000)
			limpa()

			continuar = verificacao()

		}
		
	}

	funcao celsiusParaFahrenheit(){

		//Converte uma temperatura em Celsius para Fahrenheit

		logico continuar = verdadeiro

		enquanto(continuar){

			inteiro temperatura
			inteiro resultado

			escreva("ATIVIDADE 05")
			escreva("\nCONVERSAO DE CELSIUS PARA FAHRENHEIT\n\n")
			
			escreva("Digite a temperatura: ")
			leia(temperatura)

			resultado = (temperatura * 1.8) + 32

			escreva("\n", temperatura, "ºC equivale a ", resultado, "ºF")

			u.aguarde(3000)
			limpa()

			continuar = verificacao()
		}
		
	}
		
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 124; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
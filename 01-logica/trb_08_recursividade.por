programa
{
	inclua biblioteca Util --> u
	
	funcao inicio(){
	
		chamar_fatorial()
		chamar_soma()
		chamar_fibonacci()
		chamar_contagem_regressiva()
		chamar_inverter_string()
		
	}

	funcao logico verificacao(){

		//Faz a verificacao ao fim de cada atividade
		//Caso queira seguir para a proxima, digite '1'

		inteiro opcao = 0

		enquanto(opcao != 1 e opcao != 2){

			escreva("DESEJA PROSSEGUIR PARA A PROXIMA ATIVIDADE?\n")
			escreva("1) SIM\n")
			escreva("2) NAO\n")
			escreva("ESCOLHA SUA OPCAO: ")
			leia(opcao)

			se(opcao != 1 e opcao != 2){
				limpa()
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

	funcao chamar_fatorial(){

		//Criei essa funcao pra ser um link pra funcao fatorial
		//Declarei tudo necessario aqui nessa funcao pra chamar ela na funcao inicio sem necessariamente declarar as variaveis la

		logico continuar = verdadeiro

		enquanto(continuar){
			inteiro num = 0
			inteiro resultado = fatorial(num)

			escreva("ATIVIDADE 01")		//Cabecalho
			escreva("\nCALCULAR O FATORIAL DE UM NUMERO\n\n")

			escreva("Digite um numero: ")
			leia(num)
			resultado = fatorial(num)

			escreva("\nO fatorial de ", num, " e ", resultado, "\n")

			u.aguarde(2000)
			limpa()

			continuar = verificacao()
			limpa()
		
		}

	}
	
	
	funcao inteiro fatorial(inteiro n){

		se(n == 0 ou n == 1){
			retorne 1
		}
		senao{
			retorne n * fatorial(n - 1)
		}
			
	}

	funcao chamar_soma(){

		logico continuar = verdadeiro

		enquanto(continuar){

			inteiro num
			inteiro n
			inteiro resultado = 0
			inteiro passo = 1

			escreva("ATIVIDADE 02")		//Cabecalho
			escreva("\nEXIBIR A SOMA DE 1 ATE N\n\n")
			
			escreva("Digite um numero: ")
			leia(num)

			n = soma(num)

			se(num == 1){
				escreva("A soma e 1 !")
				u.aguarde(1000)
			}

			faca{
				resultado = passo + passo
				escreva(passo, " + ", passo, " = ", resultado, "\n")
				passo = passo + 1
			}enquanto(passo <= num)
			
			se(num >= 10){
			u.aguarde(5000)
			limpa()
			}
			senao{
			u.aguarde(3000)
			limpa()
			verificacao()
			limpa()
			}
		}
	}
	
	funcao inteiro soma(inteiro n){
			
		se(n == 1){	
			retorne 1
		}
		senao{
			retorne n
		}
		
	}

	funcao chamar_fibonacci(){

		logico continuar = verdadeiro
		
		enquanto(continuar){
			
			inteiro num = 0
			inteiro resultado = fibonacci(num)
			inteiro n1 = 0
			inteiro n2 = 1

			escreva("ATIVIDADE 03")		//Cabecalho
			escreva("\nSEQUENCIA DE FIBONACCI\n\n")
			
			escreva("Digite um numero: ")
			leia(num)

			resultado = fibonacci(num)

			escreva("\nFibonacci (", n1, ")\n")
			escreva("Fibonacci (", n2, ")\n")

			para(inteiro passo = 3; passo <= num; passo++){
			
				inteiro proximo = n1 + n2
			
				escreva("Fibonacci (", proximo, ")\n")

				n1 = n2
				n2 = proximo
			}

			se(num >= 10){
				u.aguarde(5000)
			}
			senao{
				u.aguarde(3000)
			}

			limpa()
			continuar = verificacao()
			limpa()
		}
		
	}
	
	funcao inteiro fibonacci(inteiro n){
		
		se(n == 1){
			retorne 1
		}
		senao{
			retorne n
		}
	}

	funcao chamar_contagem_regressiva(){

		logico continuar = verdadeiro
		
		enquanto(continuar){
			inteiro num = 0
			inteiro resultado = contagem_regressiva(num)

			escreva("ATIVIDADE 04")
			escreva("\nCONTAGEM REGRESSIVA\n\n")
			escreva("Digite um numero: ")
			leia(num)
			resultado = contagem_regressiva(num)

			enquanto(num > 0){
				escreva("\nDetonacao em ", num)
				u.aguarde(800)
				num--
			}
			limpa()
			escreva("BOOOOOOOOOOOOOOOOOOOOM")
			u.aguarde(2000)
			limpa()

			continuar = verificacao()
			limpa()

		}

	}
	
	funcao inteiro contagem_regressiva(inteiro n){

		se(n == 0){
			retorne 0
		}
		senao{
			retorne n
		}

	}

	funcao chamar_inverter_string(){

		caracter texto[20]
		inteiro tamanho = 0
		caracter letra

		escreva("Digite a letra: ")

		faca{
			leia(letra)
			se(letra != '.'){
				texto[tamanho] = letra
				tamanho = tamanho + 1
			}
		}enquanto(letra != '.' e tamanho < 20)

		se(tamanho > 0){
			inteiro i = tamanho - 1
			faca{
				escreva(texto[i])
				i = i - 1
			}enquanto(i >= 0)
		}
		
		

		
	}
	
	funcao inverter_string(cadeia texto){
		se(texto == ""){
			texto = texto
		}
		senao se(texto == " "){
			texto = texto
		}
		
		
	}
		
	
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 65; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
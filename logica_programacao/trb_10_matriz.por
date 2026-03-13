programa
{
	//Para o programa funcionar, retire as funcoes de dentro do comentario
	//Caso queira visualizar o preenchimento da matriz na area de variaveis, e preciso que apenas a funcao que vai chamar esteja fora do comentario
	inclua biblioteca Util --> u
	inclua biblioteca Tipos --> t
	
	funcao inicio(){

		escreva("EXERCICIOS DE MATRIZ\n")
		escreva("ALUNO: WALLACE DE OLIVEIRA ILDEFONSO")
		u.aguarde(5000)
		limpa()
		menu()
			
	}
	funcao menu(){
		caracter opcao
		logico opcao_valida = falso
		
		limpa()
		escreva("ESCOLHA A ATIVIDADE QUE DESEJA VERIFICAR: ")
		escreva("\n\n1) ATIVIDADE 1\n")
		escreva("2) ATIVIDADE 2\n")
		escreva("3) ATIVIDADE 3\n")
		escreva("4) ATIVIDADE 4\n")
		escreva("5) ATIVIDADE 5\n")
		escreva("\nESCOLHA: ")
		leia(opcao)
		
		faca{
			escolha(opcao){
		
			caso '1':
				limpa()
				atividade_01()
				opcao_valida = verdadeiro
				pare
				
			caso '2':
				limpa()
				atividade_02()
				opcao_valida = verdadeiro
				pare
				
			caso '3':
				limpa()
				atividade_03()
				opcao_valida = verdadeiro
				pare
				
			caso '4':
				limpa()
				atividade_04()
				opcao_valida = verdadeiro
				pare
				
			caso '5':
				limpa()
				atividade_05()
				opcao_valida = verdadeiro
				pare
				
			caso contrario:
				limpa()
				escreva("OPCAO INVALIDA\n")
				escreva("ESCOLHA UMA DAS OPCOES DISPONIVEIS\n")
				escreva("\n1) ATIVIDADE 1\n")
				escreva("2) ATIVIDADE 2\n")
				escreva("3) ATIVIDADE 3\n")
				escreva("4) ATIVIDADE 4\n")
				escreva("5) ATIVIDADE 5\n")
				leia(opcao)
				opcao_valida = falso
			}
		}enquanto(opcao_valida == falso)
	}		
	
	funcao atividade_01()
	{	
		//Criar uma matrix 3 x 3
		//Pedir o valor ao usuario
		//Exibir a matriz formatada
		
		const inteiro num_linhas = 3
		const inteiro num_colunas = 3
		inteiro matriz01[num_linhas][num_colunas]
		cadeia texto = "Digite um valor: "
		logico repetir = verdadeiro

		escreva("ATIVIDADE 01")
		escreva("\nARMAZENAR NUMEROS EM UMA MATRIZ E EXIBI-LA\n\n")
		
		
		faca{
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){
					
					inteiro valor
				
					escreva(texto)
					leia(valor)
					matriz01[cont_linhas][cont_colunas] = valor
				
					se(cont_linhas == num_linhas - 1 e cont_colunas == num_colunas - 2){
						texto = "Digite o ultimo valor: "
					}
					senao{
					texto = "Digite o proximo valor: "
					}
				}
			}

			escreva("\n")
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){			
					escreva(matriz01[cont_linhas][cont_colunas], "\t")
				}
			}
			caracter prosseguir
			escreva("\n\nPROSSEGUIR ? ")
			escreva("\n1) SIM - PROSSEGUIR PARA O MENU")
			escreva("\n2) NAO - RODAR A ATIVIDADE ATUAL NOVAMENTE")
			escreva("\nESCOLHA SUA OPCAO: ")
			leia(prosseguir)
		
			se(prosseguir == '1'){
				repetir = falso
			}
			limpa()
			texto = "Digite um valor: "
			escreva("ATIVIDADE 01")
			escreva("\nARMAZENAR NUMEROS EM UMA MATRIZ E EXIBI-LA\n\n")
		}enquanto(repetir == verdadeiro)
		menu()
	}
	
	funcao atividade_02(){

		//Criar uma matriz 5x5
		//Pedir os valores ao usuario
		//Calcular a soma de todos os elementos e exibir o resultado
		
		const inteiro num_linhas = 5
		const inteiro num_colunas = 5
		inteiro matriz02[num_linhas][num_colunas]
		inteiro resultado = 0
		logico repetir = verdadeiro
		cadeia texto = "Digite um valor: "

		escreva("ATIVIDADE 02")
		escreva("\nSOMAR ELEMENTOS DE UMA MATRIZ 5x5\n\n")
		
		faca{
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){
					inteiro valor
					
					escreva(texto)
					leia(valor)
					resultado = resultado + valor

					matriz02[cont_linhas][cont_colunas] = valor
					
					se(cont_linhas == num_linhas - 1 e cont_colunas == num_colunas - 2){
						texto = "Digite o ultimo valor: "
					}
					senao{
					texto = "Digite o proximo valor: "
					}
				}
			}
			escreva("\nA soma de todos os elementos no vetor e igual a: ", resultado,"\n")

			caracter prosseguir
			escreva("\nPROSSEGUIR ? ")
			escreva("\n1) SIM - PROSSEGUIR PARA O MENU")
			escreva("\n2) NAO - RODAR A ATIVIDADE ATUAL NOVAMENTE")
			escreva("\nESCOLHA SUA OPCAO: ")
			leia(prosseguir)
		
			se(prosseguir == '1'){
					repetir = falso
			}
			limpa()
			texto = "Digite um valor: "
			escreva("ATIVIDADE 02")
			escreva("\nSOMAR ELEMENTOS DE UMA MATRIZ 5x5\n\n")
			resultado = 0
		} enquanto(repetir == verdadeiro)		
		menu()
	}
	
	funcao atividade_03(){

		//Criar uma matriz 3x3
		//Pedir os valores ao usuario
		//Descobrir e exibir o maior numero da matriz

		const inteiro num_linhas = 3
		const inteiro num_colunas = 3
		inteiro matriz03[num_linhas][num_colunas]
		inteiro num_maior = 0
		cadeia texto = "Digite um valor: "
		logico repetir = verdadeiro

		escreva("ATIVIDADE 03")
		escreva("\nEXIBIR O MAIOR ELEMENTO NA MATRIZ\n\n")

		faca{
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){

					inteiro valor
					escreva(texto)
					leia(valor)
				
					matriz03[cont_linhas][cont_colunas] = valor

					se(cont_linhas == num_linhas - 1 e cont_colunas == num_colunas - 2){
						texto = "Digite o ultimo valor: "
					}
					senao{
					texto = "Digite o proximo valor: "
					}

					se(valor > num_maior){
						num_maior = valor
					}
				}
			}
			escreva("\nO maior numero digitado e: ", num_maior,"\n")

			caracter prosseguir
			escreva("\nPROSSEGUIR ? ")
			escreva("\n1) SIM - PROSSEGUIR PARA O MENU")
			escreva("\n2) NAO - RODAR A ATIVIDADE ATUAL NOVAMENTE")
			escreva("\nESCOLHA SUA OPCAO: ")
			leia(prosseguir)
		
			se(prosseguir == '1'){
				repetir = falso
			}
			limpa()
			texto = "Digite um valor: "
			escreva("ATIVIDADE 03")
			escreva("\nEXIBIR O MAIOR ELEMENTO NA MATRIZ\n\n")
		} enquanto(repetir == verdadeiro)
		menu()
	}
	
	funcao atividade_04(){

		//Criar uma matriz 3x3
		//Pedir ao usuario os valores
		//Somar os elementos da diagonal principal e exibir o resultado

		const inteiro num_linhas = 3
		const inteiro num_colunas = 3
		inteiro matriz04[num_linhas][num_colunas]
		inteiro resultado = 0
		cadeia texto = "Digite um valor: "
		logico repetir = verdadeiro
		
		escreva("ATIVIDADE 04")
		escreva("\nSOMAR ELEMENTOS NA DIAGONAL PRINCIPAL\n\n")
		
		faca{
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){

					inteiro valor
					escreva(texto)
					leia(valor)
					matriz04[cont_linhas][cont_colunas] = valor

					se(cont_linhas == num_linhas - 1 e cont_colunas == num_colunas - 2){
						texto = "Digite o ultimo valor: "
					}
					senao{
					texto = "Digite o proximo valor: "
					}
					
					se(cont_linhas == cont_colunas){
						resultado = resultado + valor
					}			
				}
			}
		
			escreva("\nA soma dos valores na diagonal principal e: ", resultado,"\n\n")
		
			caracter prosseguir
					escreva("PROSSEGUIR ? ")
					escreva("\n1) SIM - PROSSEGUIR PARA O MENU")
					escreva("\n2) NAO - RODAR A ATIVIDADE ATUAL NOVAMENTE")
					escreva("\nESCOLHA SUA OPCAO: ")
					leia(prosseguir)
		
					se(prosseguir == '1'){
						repetir = falso
					}
			limpa()
			resultado = 0
			texto = "Digite um valor: "
			escreva("ATIVIDADE 04")
			escreva("\nSOMAR ELEMENTOS NA DIAGONAL PRINCIPAL\n\n")
		} enquanto(repetir == verdadeiro)
		menu()
	}
	
	funcao atividade_05(){

		//Criar uma matriz 3 x 3 de numeros inteiros
		//Pedir os valores ao usuario
		//Pedir um numero para multiplicar cada elemento da matriz
		//Exibir a matriz resultante

		const inteiro num_linhas = 3
		const inteiro num_colunas = 3
		inteiro matriz05[num_linhas][num_colunas]
		inteiro multiplicador = 0
		cadeia texto = "Digite um valor: "
		logico repetir = verdadeiro

		escreva("ATIVIDADE 05")
		escreva("\nMULTIPLICAR UMA MATRIZ POR UM NUMERO\n\n")

		faca{
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){

					inteiro valor
					escreva(texto)
					leia(valor)
					matriz05[cont_linhas][cont_colunas] = valor

					se(cont_linhas == num_linhas - 1 e cont_colunas == num_colunas - 2){
						texto = "Digite o ultimo valor: "
					}
					senao{
						texto = "Digite o proximo valor: "
					}
				}
			}
			limpa()
			
			escreva("NUMEROS DIGITADOS\n\n")
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){
			
					escreva(matriz05[cont_linhas][cont_colunas], "\t")
				}
			}
		
			escreva("\n\nDigite o multiplicador: ")
			leia(multiplicador)
			escreva("\n")
		
			para(inteiro cont_linhas = 0; cont_linhas < num_linhas; cont_linhas++){
				para(inteiro cont_colunas = 0; cont_colunas < num_colunas; cont_colunas++){
					inteiro resultado
		
					escreva((matriz05[cont_linhas][cont_colunas]) * multiplicador, "\t")
				}
			}
			escreva("\n")
			
			caracter prosseguir
				escreva("\nPROSSEGUIR ? ")
				escreva("\n1) SIM - PROSSEGUIR PARA O MENU")
				escreva("\n2) NAO - RODAR A ATIVIDADE ATUAL NOVAMENTE")
				escreva("\nESCOLHA SUA OPCAO: ")
				leia(prosseguir)
		
				se(prosseguir == '1'){
					repetir = falso
				}
			limpa()
			texto = "Digite um valor: "
			escreva("ATIVIDADE 05")
			escreva("\nMULTIPLICAR UMA MATRIZ POR UM NUMERO\n\n")
		} enquanto(repetir == verdadeiro)
		menu()
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 4588; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
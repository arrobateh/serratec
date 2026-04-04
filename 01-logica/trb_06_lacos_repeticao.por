programa{

	inclua biblioteca Util --> u

	funcao inicio(){
		
		atividade01()
		atividade02()
		atividade03()
		atividade04()
		atividade05()

		u.aguarde(2000)
		limpa()
		escreva("FIM DAS ATIVIDADES")
		u.aguarde(2000)
		limpa()
	}

	
	funcao atividade01(){

		//Contar de 1 a 10
		
		escreva("ATIVIDADE 01 \n")
		escreva("CONTAGEM PROGRESSIVA\n")
		u.aguarde(2000)
		
		para(inteiro cont = 1; cont < 11; cont ++){
			escreva("\n", cont)
			u.aguarde(800)
			
		}

		escreva("\nFIM")
		u.aguarde(2000)
		limpa()
	}

	funcao atividade02(){

		//Somar os numeros de 1 a N

		inteiro passo = 1 		//Contador
		inteiro num			//Entrada do usuario
		inteiro total = 0		//Para aparecer na mensagem
		inteiro soma			//Soma dos passos

		escreva("ESTAMOS NA ATIVIDADE 02 \n")
		escreva("SOMAR OS NUMEROS DE 1 A N \n")
		
		escreva("\nDigite um numero: ")
		leia(num)

		enquanto(passo <= num){
			soma = passo + passo			
			total = total + soma
			
			escreva(passo, " + ", passo, " = ", total, " ", "\n")		
			u.aguarde(1000)

			passo = passo + 1
			total = 0
			
		}

		escreva("FIM")
		u.aguarde(2000)
		limpa()
		
	}

	funcao atividade03(){

		//Contagem regressiva usando 'para'

		escreva("ATIVIDADE 03")
		escreva("\nCONTAGEM REGRESSIVA\n\n")
		u.aguarde(2000)

		para(inteiro clock = 10; clock > 0; clock--){
			escreva("Detonacao em ", clock, "\n")
			u.aguarde(800)
		}
		limpa()
		escreva("ETAAA MISERAA")
		escreva("\nBOOOOOM")
		u.aguarde(2000)
		limpa()
		escreva("GAME OVER")
		u.aguarde(2000)
		limpa()
	}

	funcao atividade04(){

		//Tabuada de um numero 'n' de 1 a 10

		escreva("ATIVIDADE 04 \n")
		escreva("TABUADA \n")
		
		inteiro num
		inteiro resultado
		
		escreva("\nDigite um numero: ")
		leia(num)

		para(inteiro contador = 1; contador <= 10; contador++){
			resultado = num * contador

			escreva(num, " * ", contador, " = ", resultado, "\n")
			u.aguarde(800)
		}
		u.aguarde(2000)
		limpa()
		escreva("FIM")
		u.aguarde(2000)
		limpa()
	}

	funcao atividade05(){

		//Pedir senha ate acertar

		escreva("ATIVIDADE 05")
		escreva("\nPEDIR SENHA ATE ACERTAR\n\n")

		inteiro senha = 1234
		cadeia usuario
		inteiro usr_senha
		cadeia texto = "Digite seu nome de usuario: "
		
		faca{			
			escreva(texto)
			leia(usuario)

			escreva("Digite sua senha: ")
			leia(usr_senha)

			escreva("\nVERIFICANDO.")
			u.aguarde(800)
			escreva(".")
			u.aguarde(800)
			escreva(".\n")
			u.aguarde(800)
			limpa()
			se(usr_senha == senha){
				escreva("ACESSO PERMITIDO")
			}
			senao{
				escreva("ACESSO NEGADO!\n\n")
				texto = "Digite novamente: "
			}
		}enquanto(usr_senha != senha)
				
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 920; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
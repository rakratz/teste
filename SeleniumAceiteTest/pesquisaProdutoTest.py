from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.keys import Keys
import time

def pesquisar_produto_inexistente(produto_pesquisado):
    # Passo 2: Identificar elemento que será testado (search)
    elemento = navegador.find_element(By.ID, "woocommerce-product-search-field-0")
    elemento.click()
    elemento.send_keys(produto_pesquisado + Keys.ENTER)
    time.sleep(2)
    # Passo 3: Verificar se o produto pesquisado está na página de resultados
    mensagem_resultado = navegador.find_elements(By.XPATH, '//*[@id="main"]/p')
    if mensagem_resultado:
        nao_encontrou_produto = True
        assert nao_encontrou_produto, f"Produto '{produto_pesquisado}' foi encontrado nos resultados da pesquisa."
    else:
        nao_encontrou_produto = False

    print(cont_pass, nao_encontrou_produto)
    # Passo 4: Verificar se o produto foi pesquisado com sucesso
    if nao_encontrou_produto:
        print(f"Resultado do teste de não encontrar Produto: Pass - Produto não foi encontrado")
    else:
        print(f"Resultado do teste de não encontrar Produto: Fail - Produto encontrado")
    return nao_encontrou_produto


def pesquisar_produto_existente(produto_pesquisado):
    # Passo 2: Identificar elemento que será testado (search)
    # Encontrando o elemento dee pesquisa By ID (olhar inspecionar no navegador)
    elemento = navegador.find_element(By.ID, "woocommerce-product-search-field-0")
    # Limpa o campo
    elemento.clear()
    # Clicar no elemento
    elemento.click()
    # Inserir a palavra "Album + Enter"
    elemento.send_keys(produto_pesquisado + Keys.ENTER)

    # Esperar um pouco para carregar os resultados da pesquisa
    time.sleep(2)

    # Passo 3: Verificar se o produto pesquisado está na página de resultados
    resultado_pesquisa = navegador.find_elements(By.XPATH, '//*[@id="product-24"]/div[2]/h1')

    # Verificar se o resultado da pesquisa contém o nome do produto pesquisado
    if resultado_pesquisa:
        encontrou_produto = True
        assert encontrou_produto, f"Produto '{produto_pesquisado}' encontrado nos resultados da pesquisa."
    else:
        encontrou_produto = False

    # Passo 4: Verificar se o produto foi pesquisado com sucesso
    if encontrou_produto:
        print(f"Resultado do teste de encontrar Produto: Pass - Produto encontrado")
    else:
        print(f"Resultado do teste de encontrar Produto: Fail - Produto não foi encontrado")
    return encontrou_produto


if __name__ == "__main__":
    # Inicialização do navegador
    servico = Service(ChromeDriverManager().install())
    navegador = webdriver.Chrome(service=servico)

    # Passo 1: Acessar a página do sistema de teste
    navegador.get("http://demostore.supersqa.com/")

    cont_total = 0
    cont_pass = 0

    # Executar o primeiro caso de teste
    if pesquisar_produto_inexistente("Produto Inexistente"):
        cont_pass += 1
    cont_total += 1

    # Executar o segundo caso de teste
    if pesquisar_produto_existente("Album"):
        cont_pass += 1
    cont_total += 1

    # Fechar o navegador após o teste
    navegador.quit()

    # Relatório
    if cont_pass == cont_total:
        cor = "\033[42;30m"
    else:
        cor = "\033[41m"

    print(cor + f"Pass = {cont_pass} de {cont_total} - {(cont_pass / cont_total) * 100:.2f} %" + "\033[0m")


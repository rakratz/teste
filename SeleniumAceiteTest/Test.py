from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.keys import Keys
import time

def pesquisar_produto_inexistente(produto_pesquisado):
    elemento = navegador.find_element(By.ID, "woocommerce-product-search-field-0")
    elemento.click()
    elemento.send_keys(produto_pesquisado + Keys.ENTER)
    time.sleep(2)
    mensagem_resultado = navegador.find_elements(By.XPATH, '//*[@id="main"]/p')
    nao_encontrou_produto = bool(mensagem_resultado)
    return nao_encontrou_produto


def pesquisar_produto_existente(produto_pesquisado):
    elemento = navegador.find_element(By.ID, "woocommerce-product-search-field-0")
    elemento.clear()
    elemento.click()
    elemento.send_keys(produto_pesquisado + Keys.ENTER)
    time.sleep(2)
    resultado_pesquisa = navegador.find_elements(By.XPATH, '//*[@id="product-24"]/div[2]/h1')
    encontrou_produto = bool(resultado_pesquisa)
    return encontrou_produto

if __name__ == "__main__":
    start_time = time.time()
    servico = Service(ChromeDriverManager().install())
    navegador = webdriver.Chrome(service=servico)
    navegador.get("http://demostore.supersqa.com/")
    cont_total = 0
    cont_pass = 0
    resultado_teste1 = pesquisar_produto_inexistente("Produto Inexistente")
    try:
        assert resultado_teste1, "Teste de Produto Inexistente não foi encontrado nos resultados da pesquisa."
        print(f"Pass - Teste de Produto Inexistente não foi encontrado nos resultados da pesquisa.")
    except AssertionError as e:
        print(f"Fail - {e}")
    if resultado_teste1:
        cont_pass += 1
    cont_total += 1
    resultado_teste2 = pesquisar_produto_existente("Album")
    try:
        assert resultado_teste2, "Teste de Produto informado foi encontrado nos resultados da pesquisa."
        print(f"Pass - Teste de Produto informado não foi encontrado nos resultados da pesquisa.")
    except AssertionError as e:
        print(f"Fail - {e}")
    if resultado_teste2:
        cont_pass += 1
    cont_total += 1
    # Relatório
    if cont_pass == cont_total:
        cor = "\033[42;30m"
    else:
        cor = "\033[41m"
    print(cor + f"Pass = {cont_pass} de {cont_total} - {(cont_pass / cont_total) * 100:.2f} %" + "\033[0m")
    end_time = time.time()
    tempo_execucao = end_time - start_time
    # Imprimir tempo de execução do teste
    print(f"Tempo de execução do teste: {tempo_execucao:.2f} segundos")
    navegador.quit()

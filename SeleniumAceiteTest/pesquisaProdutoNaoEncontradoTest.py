from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.keys import Keys
import time
servico = Service(ChromeDriverManager().install())
navegador = webdriver.Chrome(service=servico)
# Passo 1: Sistema do Teste
navegador.get("http://demostore.supersqa.com/")
# Passo 2: Identificar elemento que será testado (search)
elemento = navegador.find_element(By.ID, "woocommerce-product-search-field-0")
elemento.click()
produto_pesquisado = "Produto Inexistente"
elemento.send_keys(produto_pesquisado + Keys.ENTER)
time.sleep(2)
# Passo 3: Verificar se o produto pesquisado está na página de resultados
cont_pass = 0
cont_total = 1
mensagem_resultado = navegador.find_elements(By.XPATH, '//*[@id="main"]/p')
if mensagem_resultado:
    nao_encontrou_produto = True
    cont_pass += 1
    cor = "\033[42;30m"
    assert nao_encontrou_produto, f"Produto '{produto_pesquisado}' foi encontrado nos resultados da pesquisa."
else:
    nao_encontrou_produto = False
    cor = "\033[41m"
print(cont_pass, nao_encontrou_produto)
# Passo 4: Verificar se o produto foi pesquisado com sucesso
print(f"Resultado do teste: {'Pass - Produto não encontrado' if nao_encontrou_produto else 'Fail: Produto foi encontrado'}")
print(cor+ f"Pass = {cont_pass} de {cont_total} - {(cont_pass/cont_total)*100:.2f} %" + "\033[0m")
# Fechar o navegador após o teste
navegador.quit()
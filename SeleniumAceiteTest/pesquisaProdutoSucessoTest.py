# O Selenium WebDriver é a parte central da biblioteca Selenium que permite a automação de navegadores da web.
from selenium import webdriver

# O pacote "webdriver_manager" é uma biblioteca auxiliar do Selenium que permite gerenciar automaticamente
# os drivers do navegador, incluindo o ChromeDriver, Firefox ou Edge, para que você não precise baixá-los e
# instalá-los manualmente.
from webdriver_manager.chrome import ChromeDriverManager

# A classe By é usada para identificar elementos na página da web durante a automação de testes com o Selenium WebDriver
from selenium.webdriver.common.by import By

# O objeto Service é usado para configurar e controlar o serviço do driver do navegador, como o ChromeDriver,
# durante a execução de um teste automatizado.
from selenium.webdriver.chrome.service import Service

# A importação do módulo Keys permite o acesso às teclas especiais do teclado, como Enter, Tab, Setas, Backspace, etc.
from selenium.webdriver.common.keys import Keys

# A importação do módulo time permite a utilização de funções relacionadas ao controle de tempo.
import time

# é usada para instalar o ChromeDriver necessário utomaticamente, de acordo com a versão do Google Chrome
# instalada no seu sistema.
servico = Service(ChromeDriverManager().install())
# é utilizada para criar uma instância do navegador Google Chrome.
navegador = webdriver.Chrome(service=servico)

# Passo 1: Sistema do Teste
navegador.get("http://demostore.supersqa.com/")

# Passo 2: Identificar elemento que será testado (search)
# Encontrando o elemento dee pesquisa By ID (olhar inspecionar no navegador)
elemento = navegador.find_element(By.ID, "woocommerce-product-search-field-0")
# Clicar no elemento
elemento.click()
# Inserir a palavra "Album + Enter"
produto_pesquisado = "Album"
elemento.send_keys(produto_pesquisado + Keys.ENTER)

# Esperar um pouco para carregar os resultados da pesquisa
time.sleep(2)

# Passo 3: Verificar se o produto pesquisado está na página de resultados
resultado_pesquisa = navegador.find_elements(By.XPATH, '//*[@id="product-24"]/div[2]/h1')

# Contadores e testes e testes que passaram
cont_pass = 0
cont_total = 1

# Verificar se o resultado da pesquisa contém o nome do produto pesquisado
if resultado_pesquisa:
    encontrou_produto = True
    cont_pass += 1
    cor = "\033[42;30m"
    assert encontrou_produto, f"Produto '{produto_pesquisado}' encontrado nos resultados da pesquisa."
else:
    encontrou_produto = False
    cor = "\033[41m"


# Passo 4: Verificar se o produto foi pesquisado com sucesso
print(f"Resultado do teste: {'Produto encontrado' if encontrou_produto else 'Produto não encontrado'}")
# print(f"Pass = {cont_pass} de {cont_total} - {(cont_pass/cont_total)*100} %")
print(cor + f"Pass = {cont_pass} de {cont_total} - {(cont_pass/cont_total)*100:.2f} %" + "\033[0m")

# Fechar o navegador após o teste
navegador.quit()
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

servico = Service(ChromeDriverManager().install())
navegador = webdriver.Chrome(service=servico)
navegador.get("http://demostore.supersqa.com/")

titulo = navegador.title
print(f"Sistema em Teste: {titulo}")
if titulo != 'Demo Store – Practice Automation The Right Way':
    raise Exception("Fail - Não estamos no sistema correto")

contPass = 0
contTests = 0
cor = "\033[42;30m"

def run_assert(test_name, assert_statement):
    global contPass, contTests, cor
    try:
        assert assert_statement
        print(f'Pass - {test_name}')
        contPass += 1
    except AssertionError as e:
        print(f'Fail - {test_name}')
        cor = "\033[41m"
    finally:
        contTests += 1

def run_test(test_name, element, expected_url):
    alvo = navegador.find_element(By.XPATH, element)
    alvo.click()
    url = navegador.current_url
    run_assert(test_name, url == expected_url)

# Inicio contagem de Tempo
start_time = time.time()
# Acessar o primeiro link “Home”.
run_test('Acessar o primeiro link “Home”','//*[@id="site-navigation"]/div[1]/ul/li[1]/a', 'http://demostore.supersqa.com/')
# Acessar o segundo link “Cart”.
run_test('Acessar o segundo link “Cart”','//*[@id="site-navigation"]/div[1]/ul/li[2]', 'http://demostore.supersqa.com/cart/')
# Acessar o terceiro link “Checkout”.
run_test('Acessar o terceiro link “Checkout”','//*[@id="site-navigation"]/div[1]/ul/li[3]', 'http://demostore.supersqa.com/cart/')
# Acessar o primeiro link “My account”.
run_test('Acessar o primeiro link “My account”.','//*[@id="site-navigation"]/div[1]/ul/li[4]', 'http://demostore.supersqa.com/my-account/')
# Acessar o primeiro link “Sample Page”.
run_test('Acessar o primeiro link “Sample Page”.','//*[@id="site-navigation"]/div[1]/ul/li[5]', 'http://demostore.supersqa.com/sample-page/1')
# Resultado
print(cor + f'Pass = {contPass} de {contTests} - {(contPass/contTests)*100} %'+ "\033[0m")
# Fim contagem de tempo
end_time = time.time()
tempo_execucao = end_time - start_time
# Imprimir tempo de execução do teste
print(f"Tempo de execução do teste: {tempo_execucao:.2f} segundos")
navegador.quit()

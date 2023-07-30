from datetime import time

from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
servico = Service(ChromeDriverManager().install())
navegador = webdriver.Chrome(service=servico)
navegador.get("http://demostore.supersqa.com/")
# Teste de Validar Links

#Extra, verificar se estamos no site/sistema certo conferindo o título
titulo = navegador.title
print(f"Sistema em Teste: {titulo}")
if titulo != 'Demo Store – Practice Automation The Right Way':
    raise Exception("Fail - Não estamos no sistema correto")

contPass = 0
contTests = 0

# Acessar o primeiro link “Home”.
Home = navegador.find_element(By.XPATH,'//*[@id="site-navigation"]/div[1]/ul/li[1]/a')
Home.click()
url = navegador.current_url # Garantir que entrou no link pelo URL
esperado = 'http://demostore.supersqa.com/'
assert url == esperado, f'Fail - Acessar o primeiro link “Home”'
print('Pass - Acessar o primeiro link “Home”')
contPass += 1
contTests += 1

# Acessar o segundo link “Cart”.
Cart = navegador.find_element(By.XPATH,'//*[@id="site-navigation"]/div[1]/ul/li[2]')
Cart.click()
url = navegador.current_url # Garantir qu entrou no link pelo URL
esperado = 'http://demostore.supersqa.com/cart/'
assert url == esperado, f'Fail - Acessar o segundo link “Cart”'
print('Pass - Acessar o segundo link “Cart”')
contPass += 1
contTests += 1

# Acessar o terceiro link “Checkout”.
Checkout = navegador.find_element(By.XPATH,'//*[@id="site-navigation"]/div[1]/ul/li[3]')
Checkout.click()
url = navegador.current_url # Garantir qu entrou no link pelo URL
esperado = 'http://demostore.supersqa.com/cart/'
assert url == esperado, f'Acessar o terceiro link “Checkout”'
print('Pass - Acessar o terceiro link “Checkout”')
contPass += 1
contTests += 1

# Acessar o primeiro link “My account”.
myAccount = navegador.find_element(By.XPATH,'//*[@id="site-navigation"]/div[1]/ul/li[4]')
myAccount.click()
url = navegador.current_url # Garantir qu entrou no link pelo URL
esperado = 'http://demostore.supersqa.com/my-account/'
assert url == esperado, f'Acessar o primeiro link “My account”'
print('Pass - Acessar o primeiro link “My account”')
contPass += 1
contTests += 1

# Acessar o primeiro link “Sample Page”.
samplePage = navegador.find_element(By.XPATH,'//*[@id="site-navigation"]/div[1]/ul/li[5]')
samplePage.click()
url = navegador.current_url # Garantir qu entrou no link pelo URL
esperado = 'http://demostore.supersqa.com/sample-page/'
try:
    assert url == esperado, f'Acessar o primeiro link “Sample Page”'
    contPass += 1
except AssertionError as e:
    print(f'Fail - Acessar o primeiro link “Sample Page')
finally:
    contTests += 1

print('Relatório de Teste')
print(f'Pass = {contPass} de {contTests} - {(contPass/contTests)*100} %')
#input("Pressione Enter para sair...")
navegador.quit()

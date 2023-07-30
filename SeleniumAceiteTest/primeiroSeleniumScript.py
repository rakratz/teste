# O Selenium WebDriver permite a automação de navegadores da web.
from selenium import webdriver
# "webdriver_manager" é uma biblioteca que permite gerenciar automaticamente os drivers do navegador
from webdriver_manager.chrome import ChromeDriverManager
# Service é usado para configurar e controlar o serviço do driver do navegador
from selenium.webdriver.chrome.service import Service
# A classe By é usada para identificar elementos na página da web
from selenium.webdriver.common.by import By
# A importação do módulo Keys como Enter, Tab, Setas, Backspace, etc.
from selenium.webdriver.common.keys import Keys
#Ferramenta de depuração interativa.
import pdb
# Instalando o ChromeDriver necessário automaticamente
servico = Service(ChromeDriverManager().install())
# Instância do navegador Google Chrome.
navegador = webdriver.Chrome(service=servico)
# Buscando/Abrindo o navegador
navegador.get("http://demostore.supersqa.com/")

print(navegador.title)

# By.ID
carrinho = navegador.find_element(By.ID, 'site-header-cart')
print(carrinho)
print(type(carrinho))
carrinho_texto = carrinho.text
print(carrinho_texto)

#By.ID
campo_pesquisa = navegador.find_element(By.ID, 'woocommerce-product-search-field-0')
campo_pesquisa.send_keys('Hoodie')
campo_pesquisa.send_keys(Keys.ENTER)

# brakpoint (c para continuar)
pdb.set_trace()


# By.CSS_SELECTOR
minha_conta = navegador.find_element(By.CSS_SELECTOR, '#site-navigation > div:nth-child(2) > ul > li.page_item.page-item-9')
minha_conta.click()

# By.XPATH
minha_conta = navegador.find_element(By.XPATH, '//*[@id="site-navigation"]/div[1]/ul/li[4]')
minha_conta.click()

navegador.implicitly_wait(10)

input("Pressione Enter para sair...")
navegador.quit()

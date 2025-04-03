Feature: Pesquisar no Bing

  Scenario: Pesquisa básica no Bing
    Given que estou na página do Bing
    When eu pesquiso por "Selenium WebDriver"
    Then os resultados devem ser exibidos

  Scenario: Pesquisa sem resultados no Bing
    Given que estou na página do Bing
    When eu pesquiso por "ajshdjakshdkashdkajshd"
    Then os resultados devem ser exibidos

  Scenario: Pesquisa por uma palavra-chave exata
    Given que estou na página do Bing
    When eu pesquiso por '"Selenium WebDriver"'
    Then os resultados devem ser exibidos

  Scenario: Pesquisa por imagens no Bing
    Given que estou na página do Bing
    And eu pesquiso por "Selenium WebDriver"
    When eu seleciono a aba "Imagens"
    Then os resultados de "Imagens" devem ser exibidos

  Scenario: Pesquisa por vídeos no Bing
    Given que estou na página do Bing
    And eu pesquiso por "Selenium WebDriver tutorial"
    When eu seleciono a aba "Vídeos"
    Then os resultados de "Vídeos" devem ser exibidos

  Scenario: Sugestões de pesquisa no Bing
    Given que estou na página do Bing
    When eu começo a digitar "Selenium Web"
    Then sugestões de pesquisa devem ser exibidas

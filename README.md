# HarryPotterApp - Estrutura de Arquivos

HarryPotterApp é um aplicativo desenvolvido em Kotlin que consome a API [HP API](https://hp-api.onrender.com/). O projeto segue o padrão **MVVM (Model-View-ViewModel)**

<img src="hpapp.gif" alt="Descrição do GIF" width="200"/>


## Estrutura principal

```
./app/src/main/java/com/example/harrypotterapp

data/
├── model/             # classes que representam os modelos de dados
├── network/           # implementação de chamadas de API e serviços de rede
└── repository/        # gerencia a lógica de obtenção de dados, combinando rede e armazenamento local

ui/
├── Main/              # tela principal do aplicativo
├── CharactersInAHouse/ # telas que exibem personagens por casa
├── CharactersDetails/  # telas com detalhes de cada personagem pelo ID
└── HogwartsStaff/      # telas que listam os professores de Hogwarts
```



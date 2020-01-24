# desafio-android-franklin-gaspar

Desafio feito para vaga de dev Android

Este projeto utiliza a API [MARVEL API](http://developer.marvel.com/).

### Desafio proposto ###

 1. Listagem de personagens:

* Faça o consumo da API de listagem de personagens: "/v1/public/characters"; 
* Exiba o nome e foto de cada personagem;
* Ao selecionar o personagem, deverá direcionar para a tela de detalhes.

2. Detalhes do Personagem:

* Exiba a imagem do personagem, o nome, a descrição e um botão de direcionamento para a uma tela que mostre qual a HQ mais cara daquele personagem.


3. Detalhe da HQ mais cara do personagem:

* Faça o consumo da API de listagem de HQs por personagem: "/v1/public/characters/{characterId}/comics";
* Exiba na tela somente a revista mais cara daquele personagem com imagem, título, descrição e o preço.

### Regras ###

* Escolha um pattern de arquitetura que achar mais adequada para um projeto de grande porte;
* Faça o tratamento dos possíveis erros das APIs;
* Aplique testes unitários;
* Faça a paginação limitandio a 20 itens por página;
* Os campos de texto devem ter no máximo 3 linhas.


### Quais dependencias são utlizadas neses projeto? ###

    def lifecycle_version = "2.1.0"
    def nav_version = "2.1.0"
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.google.code.gson:gson:2.8.5'
    implementation "com.squareup.okhttp3:okhttp:4.3.1"
    implementation 'com.squareup.okhttp3:logging-interceptor:3.10.0'
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
    implementation "androidx.navigation:navigation-fragment:$nav_version"
    implementation "androidx.navigation:navigation-ui:$nav_version"
    implementation 'com.squareup.picasso:picasso:2.5.2'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.2.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
